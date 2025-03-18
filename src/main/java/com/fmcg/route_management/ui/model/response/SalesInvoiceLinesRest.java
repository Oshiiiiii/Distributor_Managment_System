package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;

public class SalesInvoiceLinesRest implements Serializable {

	private static final long serialVersionUID = -7229114389947500720L;
	private Long id;

	private Integer productInvoiceQty;

	private Long productId;

	private Long salesInvoiceId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getProductInvoiceQty() {
		return productInvoiceQty;
	}

	public void setProductInvoiceQty(Integer productInvoiceQty) {
		this.productInvoiceQty = productInvoiceQty;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getSalesInvoiceId() {
		return salesInvoiceId;
	}

	public void setSalesInvoiceId(Long salesInvoiceId) {
		this.salesInvoiceId = salesInvoiceId;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "SalesInvoiceLinesDTO{" + "id=" + getId() + ", productInvoiceQty=" + getProductInvoiceQty()
				+ ", productId=" + getProductId() + ", salesInvoiceId=" + getSalesInvoiceId() + "}";
	}
}
