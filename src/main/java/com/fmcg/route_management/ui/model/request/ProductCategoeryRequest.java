package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A DTO for the {@link com.unique.dms.domain.ProductCategoery} entity.
 */
public class ProductCategoeryRequest implements Serializable {
	private static final long serialVersionUID = -5404033106869437258L;

	@NotNull
	@Size(max = 20)
	private String productCategoryCode;

	@NotNull
	@Size(max = 25)
	private String productCategoryName;

	@NotNull
	@Size(max = 250)
	private String description;

	@NotNull
	@Min(value = 0)
	@Max(value = 1)
	private Integer status;

	public String getProductCategoryCode() {
		return productCategoryCode;
	}

	public void setProductCategoryCode(String productCategoryCode) {
		this.productCategoryCode = productCategoryCode;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProductCategoeryDTO{" + ", productCategoryCode='" + getProductCategoryCode() + "'"
				+ ", productCategoryName='" + getProductCategoryName() + "'" + ", description='" + getDescription()
				+ "'" + ", status=" + getStatus() + "}";
	}
}
