package com.fmcg.route_management.shared.dto;


import java.io.Serializable;

public class SalesInvoiceLinesDTO implements Serializable {

	private static final long serialVersionUID = -1657264920032209670L;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof SalesInvoiceLinesDTO)) {
			return false;
		}

		return id != null && id.equals(((SalesInvoiceLinesDTO) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "SalesInvoiceLinesDTO{" + "id=" + getId() + ", productInvoiceQty=" + getProductInvoiceQty()
				+ ", productId=" + getProductId() + ", salesInvoiceId=" + getSalesInvoiceId() + "}";
	}
}
