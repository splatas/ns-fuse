package ar.com.newsan.esb.mybatis.handlers;

import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rubenghio on 11/22/16.
 */
public abstract class BaseTypeHandler<T, S> implements TypeHandler<T> {
    protected String recordName;

    public BaseTypeHandler(String recordName) {
        this.recordName = recordName;
    }

    public abstract void setParameter(PreparedStatement preparedStatement, int i, T t, JdbcType jdbcType) throws SQLException;

    public abstract T getResult(ResultSet resultSet, String s) throws SQLException;

    public abstract T getResult(ResultSet resultSet, int i) throws SQLException;

    public abstract T getResult(CallableStatement callableStatement, int i) throws SQLException;

    protected S createInstance(STRUCT mystruct) throws SQLException {
        S instance = createNewObject();
        try {
            Map<String, Object> propMap = new HashMap<String, Object>();
            ResultSetMetaData md = mystruct.getDescriptor().getMetaData();
            int numAttrs = mystruct.getDescriptor().getLength();
            Object[] structAttributes = mystruct.getAttributes();
            String attr_name;

            for (int i = 0; i < numAttrs; i++) {
                attr_name = md.getColumnName(i + 1);
                propMap.put(attr_name.toUpperCase(), structAttributes[i]);
            }
            BeanInfo beanInfo;
            beanInfo = Introspector.getBeanInfo(getClazz());
            for (PropertyDescriptor propertyDesc : beanInfo.getPropertyDescriptors()) {
                if (propertyDesc.getWriteMethod() == null)
                    continue;
                String attribute = propertyDesc.getName().toUpperCase();
                Object o = propMap.get(attribute);
                propertyDesc.getWriteMethod().invoke(instance, new Object[]{o});
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return instance;
    }

    protected Object[] createObjectArray(StructDescriptor desc, S parameter) throws SQLException {
        Object[] params = null;
        try {
            Map<String, Object> propMap = new HashMap<String, Object>();
            BeanInfo beanInfo;
            beanInfo = Introspector.getBeanInfo(getClazz());
            for (PropertyDescriptor propertyDesc : beanInfo.getPropertyDescriptors()) {
                Object value = propertyDesc.getReadMethod().invoke(parameter);
                propMap.put(propertyDesc.getName().toUpperCase(), value);
            }

            ResultSetMetaData md = desc.getMetaData();
            int numAttrs = desc.getLength();
            String attr_name;

            params = new Object[numAttrs];
            for (int i = 0; i < numAttrs; i++) {
                attr_name = md.getColumnName(i + 1);
                params[i] = propMap.get(attr_name.toUpperCase());
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return params;
    }

    public abstract S createNewObject();

    public abstract Class<S> getClazz();
}
