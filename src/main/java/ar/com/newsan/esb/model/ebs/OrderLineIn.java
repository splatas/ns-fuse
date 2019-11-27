package ar.com.newsan.esb.model.ebs;

import java.math.BigDecimal;

@Deprecated
public class OrderLineIn {

    private String segment1;
    private Integer line_type_id;
    private BigDecimal unit_selling_price;
    private BigDecimal unit_list_price;
    private BigDecimal ordered_quantity;
    private String calculate_price_flag;
    private String cust_po_number;
    private String packing_instructions;
    private Integer payment_term_id;
    private String orig_sys_line_ref;
    private String orig_sys_document_ref;
    private String shipping_method_code;
    private String schedule_ship_date;
    private String operation;

    //Getters & Setters

    public String getSegment1() {
        return segment1;
    }

    private void setSegment1(String segment1) {
        this.segment1 = segment1;
    }

    public Integer getLine_type_id() {
        return line_type_id;
    }

    private void setLine_type_id(Integer line_type_id) {
        this.line_type_id = line_type_id;
    }

    public BigDecimal getUnit_selling_price() {
        return unit_selling_price;
    }

    private void setUnit_selling_price(BigDecimal unit_selling_price) {
        this.unit_selling_price = unit_selling_price;
    }

    public BigDecimal getUnit_list_price() {
        return unit_list_price;
    }

    private void setUnit_list_price(BigDecimal unit_list_price) {
        this.unit_list_price = unit_list_price;
    }

    public BigDecimal getOrdered_quantity() {
        return ordered_quantity;
    }

    private void setOrdered_quantity(BigDecimal ordered_quantity) {
        this.ordered_quantity = ordered_quantity;
    }

    public String getCalculate_price_flag() {
        return calculate_price_flag;
    }

    private void setCalculate_price_flag(String calculate_price_flag) {
        this.calculate_price_flag = calculate_price_flag;
    }

    public String getCust_po_number() {
        return cust_po_number;
    }

    private void setCust_po_number(String cust_po_number) {
        this.cust_po_number = cust_po_number;
    }

    public String getPacking_instructions() {
        return packing_instructions;
    }

    private void setPacking_instructions(String packing_instructions) {
        this.packing_instructions = packing_instructions;
    }

    public Integer getPayment_term_id() {
        return payment_term_id;
    }

    private void setPayment_term_id(Integer payment_term_id) {
        this.payment_term_id = payment_term_id;
    }

    public String getOrig_sys_line_ref() {
        return orig_sys_line_ref;
    }

    private void setOrig_sys_line_ref(String orig_sys_line_ref) {
        this.orig_sys_line_ref = orig_sys_line_ref;
    }

    public String getOrig_sys_document_ref() {
        return orig_sys_document_ref;
    }

    private void setOrig_sys_document_ref(String orig_sys_document_ref) {
        this.orig_sys_document_ref = orig_sys_document_ref;
    }

    public String getShipping_method_code() {
        return shipping_method_code;
    }

    private void setShipping_method_code(String shipping_method_code) {
        this.shipping_method_code = shipping_method_code;
    }

    public String getSchedule_ship_date() {
        return schedule_ship_date;
    }

    private void setSchedule_ship_date(String schedule_ship_date) {
        this.schedule_ship_date = schedule_ship_date;
    }

    public String getOperation() {
        return operation;
    }

    private void setOperation(String operation) {
        this.operation = operation;
    }

    // Public accessors to build object easily

    public OrderLineIn sku(String skuId) {
        this.setSegment1(skuId);
        return this;
    }

    public OrderLineIn type(Integer type) {
        this.setLine_type_id(type);
        return this;
    }

    public OrderLineIn unitPrice(BigDecimal price) {
        this.setUnit_selling_price(price);
        return this;
    }

    public OrderLineIn quantity(BigDecimal amount) {
        this.setOrdered_quantity(amount);
        return this;
    }

    public OrderLineIn calculateFlag(String flag) {
        this.setCalculate_price_flag(flag);
        return this;
    }

    public OrderLineIn customerNumber(String poNumber) {
        this.setCust_po_number(poNumber);
        return this;
    }

    public OrderLineIn packingInstructions(String instructions) {
        this.setPacking_instructions(instructions);
        return this;
    }

    public OrderLineIn paymentTerm(Integer term) {
        this.setPayment_term_id(term);
        return this;
    }

    public OrderLineIn salesforceLineId(String lineId) {
        this.setOrig_sys_line_ref(lineId);
        return this;
    }

    public OrderLineIn salesforceOrderId(String orderId) {
        this.setOrig_sys_document_ref(orderId);
        return this;
    }

    public OrderLineIn shippingMethod(String method) {
        this.setShipping_method_code(method);
        return this;
    }

    public OrderLineIn shipDate(String shipDate) {
        this.setSchedule_ship_date(shipDate);
        return this;
    }

    public OrderLineIn operation(String operation) {
        this.setOperation(operation);
        return this;
    }

    public OrderLineIn unitListPrice(BigDecimal unitListPrice) {
        this.setUnit_list_price(unitListPrice);
        return this;
    }

    @Override
    public String toString() {
        return "OrderLineIn{" +
                "segment1='" + segment1 + '\'' +
                ", unit_selling_price=" + unit_selling_price +
                ", unit_list_price=" + unit_list_price +
                ", ordered_quantity=" + ordered_quantity +
                ", calculate_price_flag='" + calculate_price_flag + '\'' +
                ", cust_po_number='" + cust_po_number + '\'' +
                ", packing_instructions='" + packing_instructions + '\'' +
                ", payment_term_id=" + payment_term_id +
                ", orig_sys_line_ref='" + orig_sys_line_ref + '\'' +
                ", orig_sys_document_ref='" + orig_sys_document_ref + '\'' +
                ", shipping_method_code='" + shipping_method_code + '\'' +
                ", schedule_ship_date=" + schedule_ship_date +
                ", operation='" + operation + '\'' +
                '}';
    }
}
