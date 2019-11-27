package ar.com.newsan.esb.model.ebs;

/**
 *  Represent an order to create in EBS database API
 */
@Deprecated
public class OrderHeaderIn {

    private String order_type_name;
    private String account_number;
    private Integer party_site_use_id_ship;
    private Integer party_site_use_id_bill;
    private Integer order_source_id;
    private String booked_flag;
    private String price_list_name;
    private String pricing_date;
    private String flow_status_code;
    private String organization_code;
    private String salesrep_number;
    private String transactional_curr_code;
    private String operation;
    private String global_attribute16;
    private Integer payment_term_id;
    private String shipping_instructions;
    private String orig_sys_document_ref;


    public OrderHeaderIn() {
    }

    //Getters & Setters

    public String getOrder_type_name() {
        return order_type_name;
    }

    private void setOrder_type_name(String order_type_name) {
        this.order_type_name = order_type_name;
    }

    public String getAccount_number() {
        return account_number;
    }

    private void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public Integer getParty_site_use_id_ship() {
        return party_site_use_id_ship;
    }

    private void setParty_site_use_id_ship(Integer party_site_use_id_ship) {
        this.party_site_use_id_ship = party_site_use_id_ship;
    }

    public Integer getParty_site_use_id_bill() {
        return party_site_use_id_bill;
    }

    private void setParty_site_use_id_bill(Integer party_site_use_id_bill) {
        this.party_site_use_id_bill = party_site_use_id_bill;
    }

    public Integer getOrder_source_id() {
        return order_source_id;
    }

    private void setOrder_source_id(Integer order_source_id) {
        this.order_source_id = order_source_id;
    }

    public String getBooked_flag() {
        return booked_flag;
    }

    private void setBooked_flag(String booked_flag) {
        this.booked_flag = booked_flag;
    }

    public String getPrice_list_name() {
        return price_list_name;
    }

    private void setPrice_list_name(String price_list_name) {
        this.price_list_name = price_list_name;
    }

    public String getPricing_date() {
        return pricing_date;
    }

    private void setPricing_date(String pricing_date) {
        this.pricing_date = pricing_date;
    }

    public String getFlow_status_code() {
        return flow_status_code;
    }

    private void setFlow_status_code(String flow_status_code) {
        this.flow_status_code = flow_status_code;
    }

    public String getOrganization_code() {
        return organization_code;
    }

    private void setOrganization_code(String organization_code) {
        this.organization_code = organization_code;
    }

    public String getSalesrep_number() {
        return salesrep_number;
    }

    private void setSalesrep_number(String salesrep_number) {
        this.salesrep_number = salesrep_number;
    }

    public String getTransactional_curr_code() {
        return transactional_curr_code;
    }

    private void setTransactional_curr_code(String transactional_curr_code) {
        this.transactional_curr_code = transactional_curr_code;
    }

    public String getOperation() {
        return operation;
    }

    private void setOperation(String operation) {
        this.operation = operation;
    }

    public String getGlobal_attribute16() {
        return global_attribute16;
    }

    private void setGlobal_attribute16(String global_attribute16) {
        this.global_attribute16 = global_attribute16;
    }

    public Integer getPayment_term_id() {
        return payment_term_id;
    }

    private void setPayment_term_id(Integer payment_term_id) {
        this.payment_term_id = payment_term_id;
    }

    public String getShipping_instructions() {
        return shipping_instructions;
    }

    private void setShipping_instructions(String shipping_instructions) {
        this.shipping_instructions = shipping_instructions;
    }

    public String getOrig_sys_document_ref() {
        return orig_sys_document_ref;
    }

    private void setOrig_sys_document_ref(String orig_sys_document_ref) {
        this.orig_sys_document_ref = orig_sys_document_ref;
    }

    // Public accessors to build object easily

    public OrderHeaderIn orderTypeName(String orderTypeName) {
        this.setOrder_type_name(orderTypeName);
        return this;
    }

    public OrderHeaderIn accountNumber(String accNumber) {
        this.setAccount_number(accNumber);
        return this;
    }

    public OrderHeaderIn customerShipAddress(Integer shipAddr) {
        this.setParty_site_use_id_ship(shipAddr);
        return this;
    }

    public OrderHeaderIn customerBillAddress(Integer billAddr) {
        this.setParty_site_use_id_bill(billAddr);
        return this;
    }

    public OrderHeaderIn sourceId(Integer sourceId) {
        this.setOrder_source_id(sourceId);
        return this;
    }

    public OrderHeaderIn bookedFlag(String bookedFlag) {
        this.setBooked_flag(bookedFlag);
        return this;
    }

    public OrderHeaderIn priceListName(String priceListName) {
        this.setPrice_list_name(priceListName);
        return this;
    }

    public OrderHeaderIn pricingDate(String priceListDate) {
        this.setPricing_date(priceListDate);
        return this;
    }

    public OrderHeaderIn flowCode(String flowStatusCode) {
        this.setFlow_status_code(flowStatusCode);
        return this;
    }

    public OrderHeaderIn organizationCode(String orgCode) {
        this.setOrganization_code(orgCode);
        return this;
    }

    public OrderHeaderIn sellerNumber(String sellerId) {
        this.setSalesrep_number(sellerId);
        return this;
    }

    public OrderHeaderIn transactionCurrency(String currency) {
        this.setTransactional_curr_code(currency);
        return this;
    }

    public OrderHeaderIn salesforceId(String pedidoMib) {
        this.setOrig_sys_document_ref(pedidoMib);
        return this;
    }

    public OrderHeaderIn ocValidTo(String ocVto) {
        this.setGlobal_attribute16(ocVto);
        return this;
    }

    public OrderHeaderIn paymentTerm(Integer term) {
        this.setPayment_term_id(term);
        return this;
    }

    public OrderHeaderIn shippingInstructions(String instructions) {
        this.setShipping_instructions(instructions);
        return this;
    }

    public OrderHeaderIn operation(String operation) {
        this.setOperation(operation);
        return this;
    }

    @Override
    public String toString() {
        return "OrderHeaderIn{" +
                "order_type_name='" + order_type_name + '\'' +
                ", account_number='" + account_number + '\'' +
                ", party_site_use_id_ship=" + party_site_use_id_ship +
                ", party_site_use_id_bill=" + party_site_use_id_bill +
                ", order_source_id=" + order_source_id +
                ", booked_flag='" + booked_flag + '\'' +
                ", price_list_name='" + price_list_name + '\'' +
                ", pricing_date=" + pricing_date +
                ", flow_status_code='" + flow_status_code + '\'' +
                ", organization_code='" + organization_code + '\'' +
                ", salesrep_number='" + salesrep_number + '\'' +
                ", transactional_curr_code='" + transactional_curr_code + '\'' +
                ", operation='" + operation + '\'' +
                ", global_attribute16='" + global_attribute16 + '\'' +
                ", payment_term_id=" + payment_term_id +
                ", shipping_instructions='" + shipping_instructions + '\'' +
                ", orig_sys_document_ref='" + orig_sys_document_ref + '\'' +
                '}';
    }
}
