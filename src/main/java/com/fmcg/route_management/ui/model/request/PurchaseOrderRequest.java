package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



/**
 * A DTO for the {@link com.unique.dms.domain.ProductCategoery} entity.
 */
public class PurchaseOrderRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;

	@NotNull
	@Size(max = 15)
	private String poNumber;

	@NotNull
	private LocalDate poDate;

	@NotNull
	private LocalDate deliveryDate;

	@NotNull
	private Double totalValueExcluded;

	@NotNull
	private Double totalValueIncluded;

	@NotNull
	@Size(max = 150)
	private String remarks;

	@NotNull
	@Min(value = 0)
	@Max(value = 1)
	private Integer status;

	private Long distributorId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public LocalDate getPoDate() {
		return poDate;
	}

	public void setPoDate(LocalDate poDate) {
		this.poDate = poDate;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "PurcaseOrderDTO{" + "id=" + getId() + ", poNumber='" + getPoNumber() + "'" + ", poDate='" + getPoDate()
				+ "'" + ", deliveryDate='" + getDeliveryDate() + "'" + ", totalValueExcluded=" + getTotalValueExcluded()
				+ ", totalValueIncluded=" + getTotalValueIncluded() + ", remarks='" + getRemarks() + "'" + ", status="
				+ getStatus() + ", distributorId=" + getDistributorId() + "}";
	}
}
