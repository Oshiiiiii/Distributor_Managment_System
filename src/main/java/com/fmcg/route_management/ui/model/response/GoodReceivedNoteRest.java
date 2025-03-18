package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;
import java.time.LocalDate;

public class GoodReceivedNoteRest implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String grnNumber;
	private LocalDate grnDate;
	private Double totalValueExluded;
	private Double totalValueIncluded;
	private String remarks;
	private String status;
	private Long purchaseInvoiceId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGrnNumber() {
		return grnNumber;
	}

	public void setGrnNumber(String grnNumber) {
		this.grnNumber = grnNumber;
	}

	public LocalDate getGrnDate() {
		return grnDate;
	}

	public void setGrnDate(LocalDate grnDate) {
		this.grnDate = grnDate;
	}

	public Double getTotalValueExluded() {
		return totalValueExluded;
	}

	public void setTotalValueExluded(Double totalValueExluded) {
		this.totalValueExluded = totalValueExluded;
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

	public Long getPurchaseInvoiceId() {
		return purchaseInvoiceId;
	}

	public void setPurchaseInvoiceId(Long purchaseInvoiceId) {
		this.purchaseInvoiceId = purchaseInvoiceId;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "GoodReceivedNoteDTO{" + "id=" + getId() + ", grnNumber='" + getGrnNumber() + "'" + ", grnDate='"
				+ getGrnDate() + "'" + ", totalValueExluded=" + getTotalValueExluded() + ", totalValueIncluded="
				+ getTotalValueIncluded() + ", remarks='" + getRemarks() + "'" + ", status='" + getStatus() + "'"
				+ ", purchaseInvoiceId=" + getPurchaseInvoiceId() + "}";
	}
}
