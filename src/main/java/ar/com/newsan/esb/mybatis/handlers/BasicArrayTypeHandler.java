package ar.com.newsan.esb.mybatis.handlers;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rubenghio on 11/22/16.
 */
public abstract class BasicArrayTypeHandler<T> extends BaseTypeHandler<List<T>, T> {
    private String collectionName;

    public BasicArrayTypeHandler(String collectionName, String recordName) {
        super(recordName);
        this.collectionName = collectionName;
    }

    @Override
    public void setParameter(PreparedStatement ps, int i,
                             List<T> parameter, JdbcType jdbcType) throws SQLException {
        StructDescriptor structDescriptor = StructDescriptor.createDescriptor(recordName, ps.getConnection());
        STRUCT[] structs = new STRUCT[parameter.size()];
        for (int index = 0; index < parameter.size(); index++) {
            T line = parameter.get(index);
            Object[] params = createObjectArray(structDescriptor, line);

            STRUCT struct = new STRUCT(structDescriptor, ps.getConnection(), params);
            structs[index] = struct;
        }
        ArrayDescriptor desc = ArrayDescriptor.createDescriptor(collectionName, ps.getConnection());
        ARRAY oracleArray = new ARRAY(desc, ps.getConnection(), structs);
        ps.setArray(i, oracleArray);
    }

    @Override
    public List<T> getResult(ResultSet rs, String columnName)
            throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> getResult(ResultSet rs, int columnIndex)
            throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> getResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        List<T> orderLines = new ArrayList<>();
        Object[] structArray = (Object[]) cs.getArray(columnIndex).getArray();
        for (Object structObj : structArray) {
            STRUCT mystruct = (oracle.sql.STRUCT) structObj;
            orderLines.add(createInstance(mystruct));
        }
        return orderLines;
    }
}
