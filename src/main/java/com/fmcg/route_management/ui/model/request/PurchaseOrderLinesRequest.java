package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;




/**
 * A DTO for the {@link com.unique.dms.domain.PurchaseOrderLines} entity.
 */
public class PurchaseOrderLinesRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@NotNull
	private Integer productQty;
	@NotNull
	private Double primaryPrice;
	private Long productId;
	private Long purcaseOrderId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getProductQty() {
		return productQty;
	}

	public void setProductQty(Integer productQty) {
		this.productQty = productQty;
	}

	public Double getPrimaryPrice() {
		return primaryPrice;
	}

	public void setPrimaryPrice(Double primaryPrice) {
		this.primaryPrice = primaryPrice;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getPurcaseOrderId() {
		return purcaseOrderId;
	}

	public void setPurcaseOrderId(Long purcaseOrderId) {
		this.purcaseOrderId = purcaseOrderId;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "PurchaseOrderLineDTO{" + "id=" + getId() + ", productQty=" + getProductQty() + ", primaryPrice="
				+ getPrimaryPrice() + ", productId=" + getProductId() + ", purcaseOrderId=" + getPurcaseOrderId() + "}";
	}
}
