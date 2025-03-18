package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;
import java.time.LocalDate;

public class PurchaseOrderRest implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String poNumber;
	private LocalDate poDate;
	private LocalDate deliveryDate;
	private Double totalValueExcluded;
	private Double totalValueIncluded;
	private String remarks;
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
