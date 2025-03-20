package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;
import jakarta.validation.constraints.NotNull;


/**
 * A DTO for the {@link com.unique.dms.domain.PurchaseInvoiceLines} entity.
 */
public class PurchaseInvoiceLinesRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	private Integer productInvoiceQty;

	private Long productId;

	private Long purchaseInvoiceId;

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

	public Long getPurchaseInvoiceId() {
		return purchaseInvoiceId;
	}

	public void setPurchaseInvoiceId(Long purchaseInvoiceId) {
		this.purchaseInvoiceId = purchaseInvoiceId;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "PurchaseInvoiceLinesDTO{" + "id=" + getId() + ", productInvoiceQty=" + getProductInvoiceQty()
				+ ", productId=" + getProductId() + ", purchaseInvoiceId=" + getPurchaseInvoiceId() + "}";
	}
}
