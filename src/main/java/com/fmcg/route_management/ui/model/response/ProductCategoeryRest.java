package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;

public class ProductCategoeryRest implements Serializable {

	private static final long serialVersionUID = 3671312195264321957L;
	private Long id;
	private String productCategoryCode;
	private String productCategoryName;
	private String description;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProductCategoeryDTO{" + ", productCategoryCode='" + getProductCategoryCode() + "'"
				+ ", productCategoryName='" + getProductCategoryName() + "'" + ", description='" + getDescription()
				+ "'" + ", status=" + getStatus() + "}";
	}
}
