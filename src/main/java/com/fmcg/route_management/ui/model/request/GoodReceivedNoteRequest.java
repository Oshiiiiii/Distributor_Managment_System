package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;
import java.time.LocalDate;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * A DTO for the {@link com.unique.dms.domain.GoodReceivedNot} entity.
 */
public class GoodReceivedNoteRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	@Size(max = 15)
	private String grnNumber;

	@NotNull
	private LocalDate grnDate;

	@NotNull
	private Double totalValueExluded;

	@NotNull
	private Double totalValueIncluded;

	@Size(max = 150)
	private String remarks;

	@NotNull
	@Size(max = 10)
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
