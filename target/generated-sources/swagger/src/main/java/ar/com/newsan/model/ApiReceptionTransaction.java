package ar.com.newsan.model;

import javax.validation.constraints.*;
import javax.validation.Valid;


import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ApiReceptionTransaction   {
  

public enum ProcessingModeEnum {

    ONLINE(String.valueOf("ONLINE")), INMEDIATE(String.valueOf("INMEDIATE")), BATCH(String.valueOf("BATCH"));


    private String value;

    ProcessingModeEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static ProcessingModeEnum fromValue(String v) {
        for (ProcessingModeEnum b : ProcessingModeEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}

  private @Valid ProcessingModeEnum processingMode = ProcessingModeEnum.BATCH;
  private @Valid Integer purchaseOrder = null;
  private @Valid String company = null;
  private @Valid String sku = null;
  private @Valid Float quantity = null;
  private @Valid String uom = null;

  /**
   **/
  public ApiReceptionTransaction processingMode(ProcessingModeEnum processingMode) {
    this.processingMode = processingMode;
    return this;
  }

  
  @ApiModelProperty(value = "")
  @JsonProperty("processingMode")
  public ProcessingModeEnum getProcessingMode() {
    return processingMode;
  }
  public void setProcessingMode(ProcessingModeEnum processingMode) {
    this.processingMode = processingMode;
  }

  /**
   * Identificador orden de compra
   * minimum: 1
   **/
  public ApiReceptionTransaction purchaseOrder(Integer purchaseOrder) {
    this.purchaseOrder = purchaseOrder;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Identificador orden de compra")
  @JsonProperty("purchaseOrder")
  @NotNull
 @Min(1)  public Integer getPurchaseOrder() {
    return purchaseOrder;
  }
  public void setPurchaseOrder(Integer purchaseOrder) {
    this.purchaseOrder = purchaseOrder;
  }

  /**
   * Empresa donde se realiza la orden de compra
   **/
  public ApiReceptionTransaction company(String company) {
    this.company = company;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Empresa donde se realiza la orden de compra")
  @JsonProperty("company")
  @NotNull
  public String getCompany() {
    return company;
  }
  public void setCompany(String company) {
    this.company = company;
  }

  /**
   * Identificador del sku
   **/
  public ApiReceptionTransaction sku(String sku) {
    this.sku = sku;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Identificador del sku")
  @JsonProperty("sku")
  @NotNull
  public String getSku() {
    return sku;
  }
  public void setSku(String sku) {
    this.sku = sku;
  }

  /**
   * Cantidad de servicios a facturar
   * minimum: 1
   **/
  public ApiReceptionTransaction quantity(Float quantity) {
    this.quantity = quantity;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Cantidad de servicios a facturar")
  @JsonProperty("quantity")
  @NotNull
 @DecimalMin("1")  public Float getQuantity() {
    return quantity;
  }
  public void setQuantity(Float quantity) {
    this.quantity = quantity;
  }

  /**
   * Unidad de medida
   **/
  public ApiReceptionTransaction uom(String uom) {
    this.uom = uom;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Unidad de medida")
  @JsonProperty("uom")
  @NotNull
  public String getUom() {
    return uom;
  }
  public void setUom(String uom) {
    this.uom = uom;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiReceptionTransaction apiReceptionTransaction = (ApiReceptionTransaction) o;
    return Objects.equals(processingMode, apiReceptionTransaction.processingMode) &&
        Objects.equals(purchaseOrder, apiReceptionTransaction.purchaseOrder) &&
        Objects.equals(company, apiReceptionTransaction.company) &&
        Objects.equals(sku, apiReceptionTransaction.sku) &&
        Objects.equals(quantity, apiReceptionTransaction.quantity) &&
        Objects.equals(uom, apiReceptionTransaction.uom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(processingMode, purchaseOrder, company, sku, quantity, uom);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiReceptionTransaction {\n");
    
    sb.append("    processingMode: ").append(toIndentedString(processingMode)).append("\n");
    sb.append("    purchaseOrder: ").append(toIndentedString(purchaseOrder)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    uom: ").append(toIndentedString(uom)).append("\n");
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

