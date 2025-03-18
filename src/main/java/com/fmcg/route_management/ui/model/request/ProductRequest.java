package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A DTO for the {@link com.unique.dms.domain.ProductCategoery} entity.
 */
public class ProductRequest implements Serializable {

	private static final long serialVersionUID = 8433410343413731558L;

	private Long id;

	@NotNull
	@Size(max = 15)
	private String productCode;

	@NotNull
	@Size(max = 25)
	private String productName;

	@NotNull
	private Double taxValue;

	@Size(max = 250)
	private String description;

	@NotNull
	private Double primaryPrice;

	@NotNull
	private Double retailerPrice;

	@NotNull
	private Double consumerPrice;

	@NotNull
	@Min(value = 0)
	@Max(value = 1)
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

	// prettier-ignore
	@Override
	public String toString() {
		return "ProductDTO{" + "id=" + getId() + ", productCode='" + getProductCode() + "'" + ", productName='"
				+ getProductName() + "'" + ", taxValue=" + getTaxValue() + ", description='" + getDescription() + "'"
				+ ", primaryPrice=" + getPrimaryPrice() + ", retailerPrice=" + getRetailerPrice() + ", consumerPrice="
				+ getConsumerPrice() + ", status=" + getStatus() + ", taxId=" + getTaxId() + ", productCategoeryId="
				+ getProductCategoeryId() + "}";
	}
}
