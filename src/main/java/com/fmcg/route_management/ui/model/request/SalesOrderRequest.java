package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;
import java.time.LocalDate;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * A DTO for the {@link com.unique.dms.domain.ProductCategoery} entity.
 */
public class SalesOrderRequest implements Serializable {

	private static final long serialVersionUID = 5573949050272226662L;

	private Long id;

	@NotNull
	@Size(max = 15)
	private String soNumber;

	@NotNull
	private LocalDate soDate;

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

	private Long salesInvoiceId;

	private Long retailerId;

	private Long salespersonId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSoNumber() {
		return soNumber;
	}

	public void setSoNumber(String soNumber) {
		this.soNumber = soNumber;
	}

	public LocalDate getSoDate() {
		return soDate;
	}

	public void setSoDate(LocalDate soDate) {
		this.soDate = soDate;
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

	public Long getSalesInvoiceId() {
		return salesInvoiceId;
	}

	public void setSalesInvoiceId(Long salesInvoiceId) {
		this.salesInvoiceId = salesInvoiceId;
	}

	public Long getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(Long retailerId) {
		this.retailerId = retailerId;
	}

	public Long getSalespersonId() {
		return salespersonId;
	}

	public void setSalespersonId(Long salespersonId) {
		this.salespersonId = salespersonId;
	}

	@Override
	public String toString() {
		return "SalesOrderDTO{" + "id=" + getId() + ", soNumber='" + getSoNumber() + "'" + ", soDate='" + getSoDate()
				+ "'" + ", deliveryDate='" + getDeliveryDate() + "'" + ", totalValueExluded=" + getTotalValueExluded()
				+ ", totalValueIncluded=" + getTotalValueIncluded() + ", remarks='" + getRemarks() + "'" + ", status='"
				+ getStatus() + "'" + ", salesInvoiceId=" + getSalesInvoiceId() + ", retailerId=" + getRetailerId()
				+ ", salespersonId=" + getSalespersonId() + "}";
	}
}
