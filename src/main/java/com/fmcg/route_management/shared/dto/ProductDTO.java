package com.fmcg.route_management.shared.dto;


import java.io.Serializable;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 3975558456162156381L;

	private Long id;
    private String productCode;
    private String productName;
    private Double taxValue;
    private String description;
    private Double primaryPrice;
    private Double retailerPrice;
    private Double consumerPrice;
    private Integer status;
    private Long taxId;
    private Long productCategoeryId;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(Double taxValue) {
        this.taxValue = taxValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrimaryPrice() {
        return primaryPrice;
    }

    public void setPrimaryPrice(Double primaryPrice) {
        this.primaryPrice = primaryPrice;
    }

    public Double getRetailerPrice() {
        return retailerPrice;
    }

    public void setRetailerPrice(Double retailerPrice) {
        this.retailerPrice = retailerPrice;
    }

    public Double getConsumerPrice() {
        return consumerPrice;
    }

    public void setConsumerPrice(Double consumerPrice) {
        this.consumerPrice = consumerPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTaxId() {
        return taxId;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }

    public Long getProductCategoeryId() {
        return productCategoeryId;
    }

    public void setProductCategoeryId(Long productCategoeryId) {
        this.productCategoeryId = productCategoeryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductDTO)) {
            return false;
        }

        return id != null && id.equals(((ProductDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductDTO{" +
            "id=" + getId() +
            ", productCode='" + getProductCode() + "'" +
            ", productName='" + getProductName() + "'" +
            ", taxValue=" + getTaxValue() +
            ", description='" + getDescription() + "'" +
            ", primaryPrice=" + getPrimaryPrice() +
            ", retailerPrice=" + getRetailerPrice() +
            ", consumerPrice=" + getConsumerPrice() +
            ", status=" + getStatus() +
            ", taxId=" + getTaxId() +
            ", productCategoeryId=" + getProductCategoeryId() +
            "}";
    }
}
