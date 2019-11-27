package ar.com.newsan.esb.mybatis.handlers;

import ar.com.newsan.esb.model.ebs.OrderHeaderOut;
import oracle.sql.STRUCT;

import java.sql.SQLException;

public class OrderHeaderOutTypeHandler extends BasicTypeHandler<OrderHeaderOut> {

    public OrderHeaderOutTypeHandler() {
        super("XX_HEADER_REC_TYPE");
    }

    @Override
    public OrderHeaderOut createNewObject() {
        return new OrderHeaderOut();
    }

    @Override
    public Class<OrderHeaderOut> getClazz() {
        return OrderHeaderOut.class;
    }

    //If no results found on callable statement
    @Override
    protected OrderHeaderOut createInstance(STRUCT mystruct) throws SQLException {
        return mystruct==null?null:super.createInstance(mystruct);
    }
}
