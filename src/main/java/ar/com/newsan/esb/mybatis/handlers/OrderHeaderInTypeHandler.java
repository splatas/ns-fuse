package ar.com.newsan.esb.mybatis.handlers;

import ar.com.newsan.esb.model.ebs.OrderHeaderIn;

@Deprecated
public class OrderHeaderInTypeHandler extends BasicTypeHandler<OrderHeaderIn> {

    public OrderHeaderInTypeHandler() {
        super("XX_HEADER_REC_TYPE");
    }

    @Override
    public OrderHeaderIn createNewObject() {
        return new OrderHeaderIn();
    }

    @Override
    public Class<OrderHeaderIn> getClazz() {
        return OrderHeaderIn.class;
    }
}
