package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;


/**
 * A DTO for the {@link com.unique.dms.domain.ProductCategoery} entity.
 */
public class SalesInvoiceLinesRequest implements Serializable {

	private static final long serialVersionUID = -1094875058596584380L;
	private Long id;

	@NotNull
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
