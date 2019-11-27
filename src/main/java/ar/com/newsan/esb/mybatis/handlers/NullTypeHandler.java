package ar.com.newsan.esb.mybatis.handlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class NullTypeHandler extends BaseTypeHandler<Object> {

    private Map<Integer, String> params;

    public NullTypeHandler() {
        params = new HashMap<>();
        params.put(8, "XX_HEADER_VAL_REC_TYPE");
        params.put(9, "XX_HEADER_ADJ_TBL_TYPE");
        params.put(10, "XX_HEADER_ADJ_VAL_TBL_TYPE");
        params.put(11, "XX_HEADER_PRICE_ATT_TBL_TYPE");
        params.put(12, "XX_HEADER_ADJ_ATT_TBL_TYPE");
        params.put(13, "XX_HEADER_ADJ_ASSOC_TBL_TYPE");
        params.put(14, "XX_HEADER_SCREDIT_TBL_TYPE");
        params.put(15, "XX_HEADER_SCREDIT_VAL_TBL_TYPE");
        params.put(17, "XX_LINE_VAL_TBL_TYPE");
        params.put(18, "XX_LINE_ADJ_TBL_TYPE");
        params.put(19, "XX_LINE_ADJ_VAL_TBL_TYPE");
        params.put(20, "XX_LINE_PRICE_ATT_TBL_TYPE");
        params.put(21, "XX_LINE_ADJ_ATT_TBL_TYPE");
        params.put(22, "XX_LINE_ADJ_ASSOC_TBL_TYPE");
        params.put(23, "XX_LINE_SCREDIT_TBL_TYPE");
        params.put(24, "XX_LINE_SCREDIT_VAL_TBL_TYPE");
        params.put(25, "XX_LOT_SERIAL_TBL_TYPE");
        params.put(26, "XX_LOT_SERIAL_VAL_TBL_TYPE");
        params.put(27, "XX_REQUEST_TBL_TYPE");
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        ps.setNull(i, jdbcType.TYPE_CODE, params.get(i));
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {}

    @Override
    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }

}
