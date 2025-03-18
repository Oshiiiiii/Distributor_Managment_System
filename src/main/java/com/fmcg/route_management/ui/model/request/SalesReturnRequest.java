package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A DTO for the {@link com.unique.dms.domain.SalesReturn} entity.
 */
public class SalesReturnRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	@Size(max = 15)
	private String srNumber;

	@NotNull
	private LocalDate srDate;

	@NotNull
	private Double totalReturnValueExluded;

	@NotNull
	private Double totalReturnValueIncluded;

	@Size(max = 150)
	private String remarks;

	@NotNull
	@Size(max = 10)
	private String status;

	private Long salesInvoiceId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSrNumber() {
		return srNumber;
	}

	public void setSrNumber(String srNumber) {
		this.srNumber = srNumber;
	}

	public LocalDate getSrDate() {
		return srDate;
	}

	public void setSrDate(LocalDate srDate) {
		this.srDate = srDate;
	}

	public Double getTotalReturnValueExluded() {
		return totalReturnValueExluded;
	}

	public void setTotalReturnValueExluded(Double totalReturnValueExluded) {
		this.totalReturnValueExluded = totalReturnValueExluded;
	}

	public Double getTotalReturnValueIncluded() {
		return totalReturnValueIncluded;
	}

	public void setTotalReturnValueIncluded(Double totalReturnValueIncluded) {
		this.totalReturnValueIncluded = totalReturnValueIncluded;
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

	public Long getSalesInvoiceId() {
		return salesInvoiceId;
	}

	public void setSalesInvoiceId(Long salesInvoiceId) {
		this.salesInvoiceId = salesInvoiceId;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "SalesReturnDTO{" + "id=" + getId() + ", srNumber='" + getSrNumber() + "'" + ", srDate='" + getSrDate()
				+ "'" + ", totalReturnValueExluded=" + getTotalReturnValueExluded() + ", totalReturnValueIncluded="
				+ getTotalReturnValueIncluded() + ", remarks='" + getRemarks() + "'" + ", status='" + getStatus() + "'"
				+ ", salesInvoiceId=" + getSalesInvoiceId() + "}";
	}
}
