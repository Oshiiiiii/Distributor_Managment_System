package com.fmcg.route_management.shared.dto;

import java.io.Serializable;

public class PurchaseReturnLinesDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer productReturnQty;
	private Long productId;
	private Long purchaseReturnId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getProductReturnQty() {
		return productReturnQty;
	}

	public void setProductReturnQty(Integer productReturnQty) {
		this.productReturnQty = productReturnQty;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getPurchaseReturnId() {
		return purchaseReturnId;
	}

	public void setPurchaseReturnId(Long purchaseReturnId) {
		this.purchaseReturnId = purchaseReturnId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof PurchaseReturnLinesDTO)) {
			return false;
		}

		return id != null && id.equals(((PurchaseReturnLinesDTO) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "PurchaseReturnLinesDTO{" + "id=" + getId() + ", productReturnQty=" + getProductReturnQty()
				+ ", productId=" + getProductId() + ", purchaseReturnId=" + getPurchaseReturnId() + "}";
	}
}
