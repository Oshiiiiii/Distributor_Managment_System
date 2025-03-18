package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;

public class RetailerRest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String retailerCode;
	private String retailerName;
	private String address;
	private Integer contactNo;
	private Integer vatStatus;
	private String vatNumber;
	private String lattitude;
	private String longitude;
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRetailerCode() {
		return retailerCode;
	}

	public void setRetailerCode(String retailerCode) {
		this.retailerCode = retailerCode;
	}

	public String getRetailerName() {
		return retailerName;
	}

	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getContactNo() {
		return contactNo;
	}

	public void setContactNo(Integer contactNo) {
		this.contactNo = contactNo;
	}

	public Integer getVatStatus() {
		return vatStatus;
	}

	public void setVatStatus(Integer vatStatus) {
		this.vatStatus = vatStatus;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
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
		return "Retailer{" + "id=" + getId() + ", retailerCode='" + getRetailerCode() + "'" + ", retailerName='"
				+ getRetailerName() + "'" + ", address='" + getAddress() + "'" + ", contactNo=" + getContactNo()
				+ ", vatStatus=" + getVatStatus() + ", vatNumber='" + getVatNumber() + "'" + ", lattitude='"
				+ getLattitude() + "'" + ", longitude='" + getLongitude() + "'" + ", status=" + getStatus() + "}";
	}
}
