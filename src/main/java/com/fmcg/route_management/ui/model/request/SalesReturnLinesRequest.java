package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;

/**
 * A DTO for the {@link com.unique.dms.domain.ProductCategoery} entity.
 */
public class SalesReturnLinesRequest implements Serializable {

	private static final long serialVersionUID = 4874549185616945462L;

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

	@Override
	public String toString() {
		return "SalesReturnLinesDTO{" + "id=" + getId() + ", productReturnQty=" + getProductReturnQty() + ", productId="
				+ getProductId() + ", salesReturnId=" + getSalesReturnId() + "}";
	}
}
