package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;

public class GoodReceivedNoteLinesRest implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer productGrnQty;
	private Integer productDifferenceQty;
	private String reason;
	private Long productId;
	private Long goodReceivedNoteId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getProductGrnQty() {
		return productGrnQty;
	}

	public void setProductGrnQty(Integer productGrnQty) {
		this.productGrnQty = productGrnQty;
	}

	public Integer getProductDifferenceQty() {
		return productDifferenceQty;
	}

	public void setProductDifferenceQty(Integer productDifferenceQty) {
		this.productDifferenceQty = productDifferenceQty;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getGoodReceivedNoteId() {
		return goodReceivedNoteId;
	}

	public void setGoodReceivedNoteId(Long goodReceivedNoteId) {
		this.goodReceivedNoteId = goodReceivedNoteId;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "GoodReceivedNoteLinesDTO{" + "id=" + getId() + ", productGrnQty=" + getProductGrnQty()
				+ ", productDifferenceQty=" + getProductDifferenceQty() + ", reason='" + getReason() + "'"
				+ ", productId=" + getProductId() + ", goodReceivedNoteId=" + getGoodReceivedNoteId() + "}";
	}
}
