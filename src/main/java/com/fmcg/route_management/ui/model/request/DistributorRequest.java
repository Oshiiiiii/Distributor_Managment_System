package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



/**
 * A DTO for the {@link com.unique.dms.domain.ProductCategoery} entity.
 */
public class DistributorRequest implements Serializable {

	private static final long serialVersionUID = 3920798186550667044L;
	private Long id;

	@NotNull
	@Size(max = 15)
	private String distributorCode;

	@NotNull
	@Size(max = 25)
	private String distributorName;

	@NotNull
	@Size(max = 50)
	private String address;

	private Integer contactNumber;

	@NotNull
	@Min(value = 0)
	@Max(value = 1)
	private Integer taxStatus;

	private String vatNumber;

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
		return "DistributorDTO{" + "id=" + getId() + ", distributorCode='" + getDistributorCode() + "'"
				+ ", distributorName='" + getDistributorName() + "'" + ", address='" + getAddress() + "'"
				+ ", contactNumber=" + getContactNumber() + ", taxStatus=" + getTaxStatus() + ", vatNumber='"
				+ getVatNumber() + "'" + ", status=" + getStatus() + "}";
	}
}
