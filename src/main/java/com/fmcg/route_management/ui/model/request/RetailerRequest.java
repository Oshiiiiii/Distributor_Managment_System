package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * A DTO for the {@link com.unique.dms.domain.Retailer} entity.
 */
public class RetailerRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	@Size(max = 15)
	private String retailerCode;

	@NotNull
	@Size(max = 15)
	private String retailerName;

	@Size(max = 50)
	private String address;

	private Integer contactNo;

	@NotNull
	@Min(value = 0)
	@Max(value = 1)
	private Integer vatStatus;

	@Size(max = 20)
	private String vatNumber;

	@NotNull
	@Size(max = 50)
	private String lattitude;

	@NotNull
	@Size(max = 50)
	private String longitude;

	@NotNull
	@Min(value = 0)
	@Max(value = 1)
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
