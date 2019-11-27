package ar.com.newsan.model;

import ar.com.newsan.model.ApiReceptionTransaction;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;


import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ApiReception   {
  
  private @Valid String vendor = null;
  private @Valid Integer createdBy = -1;
  private @Valid Integer lastUpdatedBy = -1;
  private @Valid List<ApiReceptionTransaction> transactions = new ArrayList<>();

  /**
   * Identificación del proveedor
   **/
  public ApiReception vendor(String vendor) {
    this.vendor = vendor;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Identificación del proveedor")
  @JsonProperty("vendor")
  @NotNull
  public String getVendor() {
    return vendor;
  }
  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  /**
   * Usuario de creación
   * minimum: -1
   **/
  public ApiReception createdBy(Integer createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Usuario de creación")
  @JsonProperty("createdBy")
  @NotNull
 @Min(-1)  public Integer getCreatedBy() {
    return createdBy;
  }
  public void setCreatedBy(Integer createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * Usuario de última actualización
   * minimum: -1
   **/
  public ApiReception lastUpdatedBy(Integer lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Usuario de última actualización")
  @JsonProperty("lastUpdatedBy")
  @NotNull
 @Min(-1)  public Integer getLastUpdatedBy() {
    return lastUpdatedBy;
  }
  public void setLastUpdatedBy(Integer lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
  }

  /**
   **/
  public ApiReception transactions(List<ApiReceptionTransaction> transactions) {
    this.transactions = transactions;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("transactions")
  @NotNull
  public List<ApiReceptionTransaction> getTransactions() {
    return transactions;
  }
  public void setTransactions(List<ApiReceptionTransaction> transactions) {
    this.transactions = transactions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiReception apiReception = (ApiReception) o;
    return Objects.equals(vendor, apiReception.vendor) &&
        Objects.equals(createdBy, apiReception.createdBy) &&
        Objects.equals(lastUpdatedBy, apiReception.lastUpdatedBy) &&
        Objects.equals(transactions, apiReception.transactions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vendor, createdBy, lastUpdatedBy, transactions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiReception {\n");
    
    sb.append("    vendor: ").append(toIndentedString(vendor)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    lastUpdatedBy: ").append(toIndentedString(lastUpdatedBy)).append("\n");
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
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

