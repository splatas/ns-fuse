package ar.com.newsan.esb.mybatis.handlers;

import ar.com.newsan.esb.model.ebs.OrderLineOut;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderLineOutTypeHandler extends BasicArrayTypeHandler<OrderLineOut> {

    public OrderLineOutTypeHandler(){
        super("XX_LINE_TBL_TYPE","XX_LINE_REC_TYPE");
    }

    @Override
    public OrderLineOut createNewObject() {
        return new OrderLineOut();
    }

    @Override
    public Class<OrderLineOut> getClazz() {
        return OrderLineOut.class;
    }

    @Override
    public List<OrderLineOut> getResult(CallableStatement cs, int columnIndex) throws SQLException {

        return cs.getArray(columnIndex)==null?null:super.getResult(cs, columnIndex);
    }
}

