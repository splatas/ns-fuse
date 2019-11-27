package ar.com.newsan.model;

import javax.validation.constraints.*;
import javax.validation.Valid;


import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ApiOrderLine   {
  
  private @Valid String sku = null;
  private @Valid String type = null;
  private @Valid Float unitPrice = null;
  private @Valid String scheduleShipDate = null;
  private @Valid Integer ordered = null;
  private @Valid String calculatePriceFlag = "Y";
  private @Valid String customerPO = null;
  private @Valid String packingInstructions = null;
  private @Valid Integer paymentTerm = null;
  private @Valid Integer lineMIB = null;
  private @Valid String shippingMethodCode = null;
  private @Valid Float newPrice = null;
  private @Valid Float unitListPrice = null;
  private @Valid String reasonCode = null;
  private @Valid String context = null;
  private @Valid String relatedTo = null;
  private @Valid String priceListName = null;

  /**
   * Id de SKU
   **/
  public ApiOrderLine sku(String sku) {
    this.sku = sku;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Id de SKU")
  @JsonProperty("sku")
  @NotNull
  public String getSku() {
    return sku;
  }
  public void setSku(String sku) {
    this.sku = sku;
  }

  /**
   * Descripción de tipo de línea
   **/
  public ApiOrderLine type(String type) {
    this.type = type;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Descripción de tipo de línea")
  @JsonProperty("type")
  @NotNull
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Precio unitario del producto
   * minimum: 1
   **/
  public ApiOrderLine unitPrice(Float unitPrice) {
    this.unitPrice = unitPrice;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Precio unitario del producto")
  @JsonProperty("unitPrice")
  @NotNull
 @DecimalMin("1")  public Float getUnitPrice() {
    return unitPrice;
  }
  public void setUnitPrice(Float unitPrice) {
    this.unitPrice = unitPrice;
  }

  /**
   * Fecha programada de envío
   **/
  public ApiOrderLine scheduleShipDate(String scheduleShipDate) {
    this.scheduleShipDate = scheduleShipDate;
    return this;
  }

  
  @ApiModelProperty(value = "Fecha programada de envío")
  @JsonProperty("scheduleShipDate")
 @Pattern(regexp="\\d{4}-\\d{2}-\\d{2}")  public String getScheduleShipDate() {
    return scheduleShipDate;
  }
  public void setScheduleShipDate(String scheduleShipDate) {
    this.scheduleShipDate = scheduleShipDate;
  }

  /**
   * Cantidad solicitada por el cliente
   * minimum: 1
   **/
  public ApiOrderLine ordered(Integer ordered) {
    this.ordered = ordered;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Cantidad solicitada por el cliente")
  @JsonProperty("ordered")
  @NotNull
 @Min(1)  public Integer getOrdered() {
    return ordered;
  }
  public void setOrdered(Integer ordered) {
    this.ordered = ordered;
  }

  /**
   * Calcula el precio en función a la lista de precios seleccionada para la cabecera del pedido.
   **/
  public ApiOrderLine calculatePriceFlag(String calculatePriceFlag) {
    this.calculatePriceFlag = calculatePriceFlag;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Calcula el precio en función a la lista de precios seleccionada para la cabecera del pedido.")
  @JsonProperty("calculatePriceFlag")
  @NotNull
 @Size(max=1)  public String getCalculatePriceFlag() {
    return calculatePriceFlag;
  }
  public void setCalculatePriceFlag(String calculatePriceFlag) {
    this.calculatePriceFlag = calculatePriceFlag;
  }

  /**
   * Corresponde al número de OC del Cliente (el STA)
   **/
  public ApiOrderLine customerPO(String customerPO) {
    this.customerPO = customerPO;
    return this;
  }

  
  @ApiModelProperty(value = "Corresponde al número de OC del Cliente (el STA)")
  @JsonProperty("customerPO")
  public String getCustomerPO() {
    return customerPO;
  }
  public void setCustomerPO(String customerPO) {
    this.customerPO = customerPO;
  }

  /**
   * Corresponde a las instrucciones de empaquetado del pedido
   **/
  public ApiOrderLine packingInstructions(String packingInstructions) {
    this.packingInstructions = packingInstructions;
    return this;
  }

  
  @ApiModelProperty(value = "Corresponde a las instrucciones de empaquetado del pedido")
  @JsonProperty("packingInstructions")
  public String getPackingInstructions() {
    return packingInstructions;
  }
  public void setPackingInstructions(String packingInstructions) {
    this.packingInstructions = packingInstructions;
  }

  /**
   * Corresponde al término de pago del cliente
   * minimum: 1
   **/
  public ApiOrderLine paymentTerm(Integer paymentTerm) {
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
   * Id de la linea del pedido generado por Salesforce
   * minimum: 1
   **/
  public ApiOrderLine lineMIB(Integer lineMIB) {
    this.lineMIB = lineMIB;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Id de la linea del pedido generado por Salesforce")
  @JsonProperty("lineMIB")
  @NotNull
 @Min(1)  public Integer getLineMIB() {
    return lineMIB;
  }
  public void setLineMIB(Integer lineMIB) {
    this.lineMIB = lineMIB;
  }

  /**
   * Código de método de envio
   **/
  public ApiOrderLine shippingMethodCode(String shippingMethodCode) {
    this.shippingMethodCode = shippingMethodCode;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Código de método de envio")
  @JsonProperty("shippingMethodCode")
  @NotNull
  public String getShippingMethodCode() {
    return shippingMethodCode;
  }
  public void setShippingMethodCode(String shippingMethodCode) {
    this.shippingMethodCode = shippingMethodCode;
  }

  /**
   * Nuevo precio con descuentos aplicados
   * minimum: 1
   **/
  public ApiOrderLine newPrice(Float newPrice) {
    this.newPrice = newPrice;
    return this;
  }

  
  @ApiModelProperty(value = "Nuevo precio con descuentos aplicados")
  @JsonProperty("newPrice")
 @DecimalMin("1")  public Float getNewPrice() {
    return newPrice;
  }
  public void setNewPrice(Float newPrice) {
    this.newPrice = newPrice;
  }

  /**
   * Precio del artículo de la lista de precios
   * minimum: 1
   **/
  public ApiOrderLine unitListPrice(Float unitListPrice) {
    this.unitListPrice = unitListPrice;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Precio del artículo de la lista de precios")
  @JsonProperty("unitListPrice")
  @NotNull
 @DecimalMin("1")  public Float getUnitListPrice() {
    return unitListPrice;
  }
  public void setUnitListPrice(Float unitListPrice) {
    this.unitListPrice = unitListPrice;
  }

  /**
   **/
  public ApiOrderLine reasonCode(String reasonCode) {
    this.reasonCode = reasonCode;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("reasonCode")
  public String getReasonCode() {
    return reasonCode;
  }
  public void setReasonCode(String reasonCode) {
    this.reasonCode = reasonCode;
  }

  /**
   **/
  public ApiOrderLine context(String context) {
    this.context = context;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("context")
  public String getContext() {
    return context;
  }
  public void setContext(String context) {
    this.context = context;
  }

  /**
   * Utilizado para relacionar líneas sujetas al cumplimiento de otras
   **/
  public ApiOrderLine relatedTo(String relatedTo) {
    this.relatedTo = relatedTo;
    return this;
  }

  
  @ApiModelProperty(value = "Utilizado para relacionar líneas sujetas al cumplimiento de otras")
  @JsonProperty("relatedTo")
  public String getRelatedTo() {
    return relatedTo;
  }
  public void setRelatedTo(String relatedTo) {
    this.relatedTo = relatedTo;
  }

  /**
   **/
  public ApiOrderLine priceListName(String priceListName) {
    this.priceListName = priceListName;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("priceListName")
  public String getPriceListName() {
    return priceListName;
  }
  public void setPriceListName(String priceListName) {
    this.priceListName = priceListName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiOrderLine apiOrderLine = (ApiOrderLine) o;
    return Objects.equals(sku, apiOrderLine.sku) &&
        Objects.equals(type, apiOrderLine.type) &&
        Objects.equals(unitPrice, apiOrderLine.unitPrice) &&
        Objects.equals(scheduleShipDate, apiOrderLine.scheduleShipDate) &&
        Objects.equals(ordered, apiOrderLine.ordered) &&
        Objects.equals(calculatePriceFlag, apiOrderLine.calculatePriceFlag) &&
        Objects.equals(customerPO, apiOrderLine.customerPO) &&
        Objects.equals(packingInstructions, apiOrderLine.packingInstructions) &&
        Objects.equals(paymentTerm, apiOrderLine.paymentTerm) &&
        Objects.equals(lineMIB, apiOrderLine.lineMIB) &&
        Objects.equals(shippingMethodCode, apiOrderLine.shippingMethodCode) &&
        Objects.equals(newPrice, apiOrderLine.newPrice) &&
        Objects.equals(unitListPrice, apiOrderLine.unitListPrice) &&
        Objects.equals(reasonCode, apiOrderLine.reasonCode) &&
        Objects.equals(context, apiOrderLine.context) &&
        Objects.equals(relatedTo, apiOrderLine.relatedTo) &&
        Objects.equals(priceListName, apiOrderLine.priceListName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sku, type, unitPrice, scheduleShipDate, ordered, calculatePriceFlag, customerPO, packingInstructions, paymentTerm, lineMIB, shippingMethodCode, newPrice, unitListPrice, reasonCode, context, relatedTo, priceListName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiOrderLine {\n");
    
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
    sb.append("    scheduleShipDate: ").append(toIndentedString(scheduleShipDate)).append("\n");
    sb.append("    ordered: ").append(toIndentedString(ordered)).append("\n");
    sb.append("    calculatePriceFlag: ").append(toIndentedString(calculatePriceFlag)).append("\n");
    sb.append("    customerPO: ").append(toIndentedString(customerPO)).append("\n");
    sb.append("    packingInstructions: ").append(toIndentedString(packingInstructions)).append("\n");
    sb.append("    paymentTerm: ").append(toIndentedString(paymentTerm)).append("\n");
    sb.append("    lineMIB: ").append(toIndentedString(lineMIB)).append("\n");
    sb.append("    shippingMethodCode: ").append(toIndentedString(shippingMethodCode)).append("\n");
    sb.append("    newPrice: ").append(toIndentedString(newPrice)).append("\n");
    sb.append("    unitListPrice: ").append(toIndentedString(unitListPrice)).append("\n");
    sb.append("    reasonCode: ").append(toIndentedString(reasonCode)).append("\n");
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
    sb.append("    relatedTo: ").append(toIndentedString(relatedTo)).append("\n");
    sb.append("    priceListName: ").append(toIndentedString(priceListName)).append("\n");
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

