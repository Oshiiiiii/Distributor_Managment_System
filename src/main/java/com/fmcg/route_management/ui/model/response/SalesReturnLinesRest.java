package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;

public class SalesReturnLinesRest implements Serializable {

	private static final long serialVersionUID = -5444116653095339258L;
	private Long id;
	private Integer productReturnQty;
	private Long productId;
	private Long salesReturnId;

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

	public Long getSalesReturnId() {
		return salesReturnId;
	}

	public void setSalesReturnId(Long salesReturnId) {
		this.salesReturnId = salesReturnId;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "SalesReturnLinesDTO{" + "id=" + getId() + ", productReturnQty=" + getProductReturnQty() + ", productId="
				+ getProductId() + ", salesReturnId=" + getSalesReturnId() + "}";
	}
}
