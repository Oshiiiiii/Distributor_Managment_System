package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;
import java.time.LocalDate;

public class PurchaseInvoiceRest implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String piNumber;
	private LocalDate piDate;
	private LocalDate deliveryDate;
	private Double totalValueExcluded;
	private Double totalValueIncluded;
	private String remarks;
	private String status;
	private Long purcaseOrderId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPiNumber() {
		return piNumber;
	}

	public void setPiNumber(String piNumber) {
		this.piNumber = piNumber;
	}

	public LocalDate getPiDate() {
		return piDate;
	}

	public void setPiDate(LocalDate piDate) {
		this.piDate = piDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Double getTotalValueExcluded() {
		return totalValueExcluded;
	}

	public void setTotalValueExcluded(Double totalValueExcluded) {
		this.totalValueExcluded = totalValueExcluded;
	}

	public Double getTotalValueIncluded() {
		return totalValueIncluded;
	}

	public void setTotalValueIncluded(Double totalValueIncluded) {
		this.totalValueIncluded = totalValueIncluded;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		return "PurchaseInvoiceDTO{" + "id=" + getId() + ", piNumber='" + getPiNumber() + "'" + ", piDate='"
				+ getPiDate() + "'" + ", deliveryDate='" + getDeliveryDate() + "'" + ", totalValueExcluded="
				+ getTotalValueExcluded() + ", totalValueIncluded=" + getTotalValueIncluded() + ", remarks='"
				+ getRemarks() + "'" + ", status='" + getStatus() + "'" + ", purcaseOrderId=" + getPurcaseOrderId()
				+ "}";
	}
}
