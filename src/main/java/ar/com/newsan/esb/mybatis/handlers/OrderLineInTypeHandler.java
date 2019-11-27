package ar.com.newsan.esb.mybatis.handlers;

import ar.com.newsan.esb.model.ebs.OrderLineIn;

@Deprecated
public class OrderLineInTypeHandler extends BasicArrayTypeHandler<OrderLineIn> {

    public OrderLineInTypeHandler(){
        super("XX_LINE_TBL_TYPE","XX_LINE_REC_TYPE");
    }

    @Override
    public OrderLineIn createNewObject() {
        return new OrderLineIn();
    }

    @Override
    public Class<OrderLineIn> getClazz() {
        return OrderLineIn.class;
    }
}
