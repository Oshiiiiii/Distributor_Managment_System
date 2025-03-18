package com.fmcg.route_management.shared.dto;


import java.io.Serializable;


public class ProductCategoeryDTO implements Serializable {

	private static final long serialVersionUID = -5404033106869437258L;

	private Long id;
	private String productCategoryCode;
	private String productCategoryName;
	private String description;
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ProductCategoeryDTO)) {
			return false;
		}

		return id != null && id.equals(((ProductCategoeryDTO) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "ProductCategoeryDTO{" + "id=" + getId() + ", productCategoryCode='" + getProductCategoryCode() + "'"
				+ ", productCategoryName='" + getProductCategoryName() + "'" + ", description='" + getDescription()
				+ "'" + ", status=" + getStatus() + "}";
	}
}
