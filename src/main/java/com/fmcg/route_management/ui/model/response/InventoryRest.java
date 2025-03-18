package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;

public class InventoryRest implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer availableQty;
	private Double productValueExcluded;
	private Double productValueIncluded;
	private Long productId;
	private Long warehouseId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(Integer availableQty) {
		this.availableQty = availableQty;
	}

	public Double getProductValueExcluded() {
		return productValueExcluded;
	}

	public void setProductValueExcluded(Double productValueExcluded) {
		this.productValueExcluded = productValueExcluded;
	}

	public Double getProductValueIncluded() {
		return productValueIncluded;
	}

	public void setProductValueIncluded(Double productValueIncluded) {
		this.productValueIncluded = productValueIncluded;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "InventoryDTO{" + "id=" + getId() + ", availableQty=" + getAvailableQty() + ", productValueExcluded="
				+ getProductValueExcluded() + ", productValueIncluded=" + getProductValueIncluded() + ", productId="
				+ getProductId() + ", warehouseId=" + getWarehouseId() + "}";
	}
}
