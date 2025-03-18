package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;
import java.time.LocalDate;

public class SalesReturnRest implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String srNumber;
	private LocalDate srDate;
	private Double totalReturnValueExluded;
	private Double totalReturnValueIncluded;
	private String remarks;
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
