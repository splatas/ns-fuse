package ar.com.newsan.esb.mybatis.handlers;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;

public abstract class BasicTypeHandler<T> extends BaseTypeHandler<T, T> {
    public BasicTypeHandler(String recordName) {
        super(recordName);
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, T parameter,
                             JdbcType jdbcType) throws SQLException {
        Connection conn = ps.getConnection();
        StructDescriptor desc = StructDescriptor.createDescriptor(recordName, conn);
        Object[] objArray = createObjectArray(desc, parameter);
        STRUCT record = new STRUCT(desc, conn, objArray);
        ((OraclePreparedStatement) ps).setSTRUCT(i, record);
    }

    @Override
    public T getResult(ResultSet rs, String columnName)
            throws SQLException {
        STRUCT result = ((OracleResultSet) rs).getSTRUCT(columnName);
        return createInstance(result);
    }

    @Override
    public T getResult(ResultSet rs, int columnIndex)
            throws SQLException {
        STRUCT result = ((OracleResultSet) rs).getSTRUCT(columnIndex);
        return createInstance(result);
    }

    @Override
    public T getResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        STRUCT result = ((OracleCallableStatement) cs).getSTRUCT(columnIndex);
        return createInstance(result);
    }
}
