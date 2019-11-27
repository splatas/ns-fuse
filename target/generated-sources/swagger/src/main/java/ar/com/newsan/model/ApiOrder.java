package ar.com.newsan.model;

import ar.com.newsan.model.ApiOrderLine;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;


import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ApiOrder   {
  
  private @Valid String typeName = null;
  private @Valid String clientAccount = null;
  private @Valid String clientShipRef = null;
  private @Valid String clientBillRef = null;
  private @Valid Integer source = null;
  private @Valid String bookedFlag = "N";
  private @Valid String priceListName = null;
  private @Valid String flowStatusCode = "BOOKED";
  private @Valid String organizationCode = null;
  private @Valid String salesRep = null;
  private @Valid String currencyCode = "ARS";
  private @Valid String orderMIB = null;
  private @Valid String shipFrom = null;
  private @Valid String ocExpirationDate = null;
  private @Valid Integer paymentTerm = null;
  private @Valid String shippingInstructions = null;
  private @Valid List<ApiOrderLine> lines = new ArrayList<>();

  /**
   * Tipo de pedido
   **/
  public ApiOrder typeName(String typeName) {
    this.typeName = typeName;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Tipo de pedido")
  @JsonProperty("typeName")
  @NotNull
  public String getTypeName() {
    return typeName;
  }
  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  /**
   * Id de cliente
   **/
  public ApiOrder clientAccount(String clientAccount) {
    this.clientAccount = clientAccount;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Id de cliente")
  @JsonProperty("clientAccount")
  @NotNull
  public String getClientAccount() {
    return clientAccount;
  }
  public void setClientAccount(String clientAccount) {
    this.clientAccount = clientAccount;
  }

  /**
   * Identificador de referencia de envio del cliente
   **/
  public ApiOrder clientShipRef(String clientShipRef) {
    this.clientShipRef = clientShipRef;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Identificador de referencia de envio del cliente")
  @JsonProperty("clientShipRef")
  @NotNull
  public String getClientShipRef() {
    return clientShipRef;
  }
  public void setClientShipRef(String clientShipRef) {
    this.clientShipRef = clientShipRef;
  }

  /**
   * Identificador de referencia de facturacion del cliente
   **/
  public ApiOrder clientBillRef(String clientBillRef) {
    this.clientBillRef = clientBillRef;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Identificador de referencia de facturacion del cliente")
  @JsonProperty("clientBillRef")
  @NotNull
  public String getClientBillRef() {
    return clientBillRef;
  }
  public void setClientBillRef(String clientBillRef) {
    this.clientBillRef = clientBillRef;
  }

  /**
   * Id de origen del pedido
   * minimum: 1
   **/
  public ApiOrder source(Integer source) {
    this.source = source;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Id de origen del pedido")
  @JsonProperty("source")
  @NotNull
 @Min(1)  public Integer getSource() {
    return source;
  }
  public void setSource(Integer source) {
    this.source = source;
  }

  /**
   * Código de estado de inicio del pedido
   **/
  public ApiOrder bookedFlag(String bookedFlag) {
    this.bookedFlag = bookedFlag;
    return this;
  }

  
  @ApiModelProperty(value = "Código de estado de inicio del pedido")
  @JsonProperty("bookedFlag")
  public String getBookedFlag() {
    return bookedFlag;
  }
  public void setBookedFlag(String bookedFlag) {
    this.bookedFlag = bookedFlag;
  }

  /**
   * Nombre de la lista de precios
   **/
  public ApiOrder priceListName(String priceListName) {
    this.priceListName = priceListName;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Nombre de la lista de precios")
  @JsonProperty("priceListName")
  @NotNull
  public String getPriceListName() {
    return priceListName;
  }
  public void setPriceListName(String priceListName) {
    this.priceListName = priceListName;
  }

  /**
   * Código del estado del pedido
   **/
  public ApiOrder flowStatusCode(String flowStatusCode) {
    this.flowStatusCode = flowStatusCode;
    return this;
  }

  
  @ApiModelProperty(value = "Código del estado del pedido")
  @JsonProperty("flowStatusCode")
  public String getFlowStatusCode() {
    return flowStatusCode;
  }
  public void setFlowStatusCode(String flowStatusCode) {
    this.flowStatusCode = flowStatusCode;
  }

  /**
   * Unidad operativa
   **/
  public ApiOrder organizationCode(String organizationCode) {
    this.organizationCode = organizationCode;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Unidad operativa")
  @JsonProperty("organizationCode")
  @NotNull
  public String getOrganizationCode() {
    return organizationCode;
  }
  public void setOrganizationCode(String organizationCode) {
    this.organizationCode = organizationCode;
  }

  /**
   * Corresponde al número del vendedor
   **/
  public ApiOrder salesRep(String salesRep) {
    this.salesRep = salesRep;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Corresponde al número del vendedor")
  @JsonProperty("salesRep")
  @NotNull
  public String getSalesRep() {
    return salesRep;
  }
  public void setSalesRep(String salesRep) {
    this.salesRep = salesRep;
  }

  /**
   * Corresponde al código de moneda utilizada
   **/
  public ApiOrder currencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

  
  @ApiModelProperty(value = "Corresponde al código de moneda utilizada")
  @JsonProperty("currencyCode")
 @Size(min=3,max=3)  public String getCurrencyCode() {
    return currencyCode;
  }
  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  /**
   * Id del pedido generado en Salesforce
   **/
  public ApiOrder orderMIB(String orderMIB) {
    this.orderMIB = orderMIB;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Id del pedido generado en Salesforce")
  @JsonProperty("orderMIB")
  @NotNull
  public String getOrderMIB() {
    return orderMIB;
  }
  public void setOrderMIB(String orderMIB) {
    this.orderMIB = orderMIB;
  }

  /**
   * Origen del envío del pedido
   **/
  public ApiOrder shipFrom(String shipFrom) {
    this.shipFrom = shipFrom;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Origen del envío del pedido")
  @JsonProperty("shipFrom")
  @NotNull
  public String getShipFrom() {
    return shipFrom;
  }
  public void setShipFrom(String shipFrom) {
    this.shipFrom = shipFrom;
  }

  /**
   * Fecha de vencimiento de la OC
   **/
  public ApiOrder ocExpirationDate(String ocExpirationDate) {
    this.ocExpirationDate = ocExpirationDate;
    return this;
  }

  
  @ApiModelProperty(value = "Fecha de vencimiento de la OC")
  @JsonProperty("ocExpirationDate")
 @Pattern(regexp="\\d{4}-\\d{2}-\\d{2}")  public String getOcExpirationDate() {
    return ocExpirationDate;
  }
  public void setOcExpirationDate(String ocExpirationDate) {
    this.ocExpirationDate = ocExpirationDate;
  }

  /**
   * Corresponde al término de pago del cliente
   * minimum: 1
   **/
  public ApiOrder paymentTerm(Integer paymentTerm) {
    this.paymentTerm = paymentTerm;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Corresponde al término de pago del cliente")
  @JsonProperty("paymentTerm")
  @NotNull
 @Min(1)  public Integer getPaymentTerm() {
    return paymentTerm;
  }
  public void setPaymentTerm(Integer paymentTerm) {
    this.paymentTerm = paymentTerm;
  }

  /**
   * Corresponde a las instrucciones de envío
   **/
  public ApiOrder shippingInstructions(String shippingInstructions) {
    this.shippingInstructions = shippingInstructions;
    return this;
  }

  
  @ApiModelProperty(value = "Corresponde a las instrucciones de envío")
  @JsonProperty("shippingInstructions")
  public String getShippingInstructions() {
    return shippingInstructions;
  }
  public void setShippingInstructions(String shippingInstructions) {
    this.shippingInstructions = shippingInstructions;
  }

  /**
   **/
  public ApiOrder lines(List<ApiOrderLine> lines) {
    this.lines = lines;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("lines")
  @NotNull
  public List<ApiOrderLine> getLines() {
    return lines;
  }
  public void setLines(List<ApiOrderLine> lines) {
    this.lines = lines;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiOrder apiOrder = (ApiOrder) o;
    return Objects.equals(typeName, apiOrder.typeName) &&
        Objects.equals(clientAccount, apiOrder.clientAccount) &&
        Objects.equals(clientShipRef, apiOrder.clientShipRef) &&
        Objects.equals(clientBillRef, apiOrder.clientBillRef) &&
        Objects.equals(source, apiOrder.source) &&
        Objects.equals(bookedFlag, apiOrder.bookedFlag) &&
        Objects.equals(priceListName, apiOrder.priceListName) &&
        Objects.equals(flowStatusCode, apiOrder.flowStatusCode) &&
        Objects.equals(organizationCode, apiOrder.organizationCode) &&
        Objects.equals(salesRep, apiOrder.salesRep) &&
        Objects.equals(currencyCode, apiOrder.currencyCode) &&
        Objects.equals(orderMIB, apiOrder.orderMIB) &&
        Objects.equals(shipFrom, apiOrder.shipFrom) &&
        Objects.equals(ocExpirationDate, apiOrder.ocExpirationDate) &&
        Objects.equals(paymentTerm, apiOrder.paymentTerm) &&
        Objects.equals(shippingInstructions, apiOrder.shippingInstructions) &&
        Objects.equals(lines, apiOrder.lines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(typeName, clientAccount, clientShipRef, clientBillRef, source, bookedFlag, priceListName, flowStatusCode, organizationCode, salesRep, currencyCode, orderMIB, shipFrom, ocExpirationDate, paymentTerm, shippingInstructions, lines);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiOrder {\n");
    
    sb.append("    typeName: ").append(toIndentedString(typeName)).append("\n");
    sb.append("    clientAccount: ").append(toIndentedString(clientAccount)).append("\n");
    sb.append("    clientShipRef: ").append(toIndentedString(clientShipRef)).append("\n");
    sb.append("    clientBillRef: ").append(toIndentedString(clientBillRef)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    bookedFlag: ").append(toIndentedString(bookedFlag)).append("\n");
    sb.append("    priceListName: ").append(toIndentedString(priceListName)).append("\n");
    sb.append("    flowStatusCode: ").append(toIndentedString(flowStatusCode)).append("\n");
    sb.append("    organizationCode: ").append(toIndentedString(organizationCode)).append("\n");
    sb.append("    salesRep: ").append(toIndentedString(salesRep)).append("\n");
    sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
    sb.append("    orderMIB: ").append(toIndentedString(orderMIB)).append("\n");
    sb.append("    shipFrom: ").append(toIndentedString(shipFrom)).append("\n");
    sb.append("    ocExpirationDate: ").append(toIndentedString(ocExpirationDate)).append("\n");
    sb.append("    paymentTerm: ").append(toIndentedString(paymentTerm)).append("\n");
    sb.append("    shippingInstructions: ").append(toIndentedString(shippingInstructions)).append("\n");
    sb.append("    lines: ").append(toIndentedString(lines)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

