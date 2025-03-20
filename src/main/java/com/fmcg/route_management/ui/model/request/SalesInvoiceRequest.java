package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.validation.constraints.*;


/**
 * A DTO for the {@link com.unique.dms.domain.ProductCategoery} entity.
 */
public class SalesInvoiceRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	@Size(max = 15)
	private String siNumber;

	@NotNull
	private LocalDate siDate;

	@NotNull
	private LocalDate deliveryDate;

	@NotNull
	private Double totalValueExluded;

	@NotNull
	private Double totalValueIncluded;

	@Size(max = 150)
	private String remarks;

	@NotNull
	@Size(max = 10)
	private String status;

	private Integer pickListReference;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSiNumber() {
		return siNumber;
	}

	public void setSiNumber(String siNumber) {
		this.siNumber = siNumber;
	}

	public LocalDate getSiDate() {
		return siDate;
	}

	public void setSiDate(LocalDate siDate) {
		this.siDate = siDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
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

	public Integer getPickListReference() {
		return pickListReference;
	}

	public void setPickListReference(Integer pickListReference) {
		this.pickListReference = pickListReference;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "SalesInvoiceDTO{" + "id=" + getId() + ", siNumber='" + getSiNumber() + "'" + ", siDate='" + getSiDate()
				+ "'" + ", deliveryDate='" + getDeliveryDate() + "'" + ", totalValueExluded=" + getTotalValueExluded()
				+ ", totalValueIncluded=" + getTotalValueIncluded() + ", remarks='" + getRemarks() + "'" + ", status='"
				+ getStatus() + "'" + ", pickListReference=" + getPickListReference() + "}";
	}
}
