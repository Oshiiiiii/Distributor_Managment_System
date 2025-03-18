package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;

public class DistributorRest implements Serializable {

	private static final long serialVersionUID = 2414004608757290775L;
	private Long id;
	private String distributorCode;
	private String distributorName;
	private String address;
	private Integer contactNumber;
	private Integer taxStatus;
	private String vatNumber;
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDistributorCode() {
		return distributorCode;
	}

	public void setDistributorCode(String distributorCode) {
		this.distributorCode = distributorCode;
	}

	public String getDistributorName() {
		return distributorName;
	}

	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Integer getTaxStatus() {
		return taxStatus;
	}

	public void setTaxStatus(Integer taxStatus) {
		this.taxStatus = taxStatus;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "DistributorDTO{distributorCode='" + getDistributorCode() + "'" + ", distributorName='"
				+ getDistributorName() + "'" + ", address='" + getAddress() + "'" + ", contactNumber="
				+ getContactNumber() + ", taxStatus=" + getTaxStatus() + ", vatNumber='" + getVatNumber() + "'"
				+ ", status=" + getStatus() + "}";
	}
}
