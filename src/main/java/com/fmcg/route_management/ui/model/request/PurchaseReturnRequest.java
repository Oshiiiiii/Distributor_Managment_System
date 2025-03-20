package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;
import java.time.LocalDate;



import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * A DTO for the {@link com.unique.dms.domain.ProductCategoery} entity.
 */
public class PurchaseReturnRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	@Size(max = 15)
	private String prNumber;

	@NotNull
	private LocalDate prDate;

	@NotNull
	private Double totalReturnValueExluded;

	@NotNull
	private Double totalReturnValueIncluded;

	@Size(max = 150)
	private String remarks;

	@NotNull
	@Size(max = 15)
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrNumber() {
		return prNumber;
	}

	public void setPrNumber(String prNumber) {
		this.prNumber = prNumber;
	}

	public LocalDate getPrDate() {
		return prDate;
	}

	public void setPrDate(LocalDate prDate) {
		this.prDate = prDate;
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

	// prettier-ignore
	@Override
	public String toString() {
		return "PurchaseReturnDTO{" + "id=" + getId() + ", prNumber='" + getPrNumber() + "'" + ", prDate='"
				+ getPrDate() + "'" + ", totalReturnValueExluded=" + getTotalReturnValueExluded()
				+ ", totalReturnValueIncluded=" + getTotalReturnValueIncluded() + ", remarks='" + getRemarks() + "'"
				+ ", status='" + getStatus()+ "}";
	}
}
