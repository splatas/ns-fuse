package ar.com.newsan.esb.model.ebs;

import com.fasterxml.jackson.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({ "order_number", "header_id", "lines" })
public class OrderHeaderOut {

    @JsonProperty(value = "headerId") private BigDecimal header_id;
    @JsonProperty(value = "orderNumber") private BigDecimal order_number;
    private List<OrderLineOut> lines;

    public OrderHeaderOut() {
        this.lines = new ArrayList<>();
    }

    //Setters & Getters

    public BigDecimal getHeader_id() {
        return header_id;
    }

    public void setHeader_id(BigDecimal header_id) {
        this.header_id = header_id;
    }

    public BigDecimal getOrder_number() {
        return order_number;
    }

    public void setOrder_number(BigDecimal order_number) {
        this.order_number = order_number;
    }

    public List<OrderLineOut> getLines() {
        return lines;
    }

    public void setLines(List<OrderLineOut> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "OrderHeaderOut{" +
                "header_id=" + header_id +
                ", order_number=" + order_number +
                '}';
    }
}
