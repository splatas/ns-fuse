package ar.com.newsan.esb.model.ebs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class OrderLineOut {

    @JsonProperty(value = "lineId") private BigDecimal line_id;
    @JsonProperty(value = "lineNumber") private BigDecimal line_number;

    //Setters & Getters

    public BigDecimal getLine_id() {
        return line_id;
    }

    public void setLine_id(BigDecimal line_id) {
        this.line_id = line_id;
    }

    public BigDecimal getLine_number() {
        return line_number;
    }

    public void setLine_number(BigDecimal line_number) {
        this.line_number = line_number;
    }

    @Override
    public String toString() {
        return "OrderLineOut{" +
                "line_id=" + line_id +
                ", line_number=" + line_number +
                '}';
    }
}
