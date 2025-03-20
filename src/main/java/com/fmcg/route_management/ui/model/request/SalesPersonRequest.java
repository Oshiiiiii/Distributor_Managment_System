package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * A DTO for the {@link com.unique.dms.domain.SalesPerson} entity.
 */
public class SalesPersonRequest implements Serializable {

	private static final long serialVersionUID = 8667856064255645853L;
	private Long id;

	@NotNull
	@Size(max = 25)
	private String salesmanName;

	private Integer contactNo;

	@Size(max = 30)
	private String email;

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

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

	public Integer getContactNo() {
		return contactNo;
	}

	public void setContactNo(Integer contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "SalespersonDTO{" + "id=" + getId() + ", salesmanName='" + getSalesmanName() + "'" + ", contactNo="
				+ getContactNo() + ", email='" + getEmail() + "'" + ", status=" + getStatus() + ", distributorId="
				+ getDistributorId() + "}";
	}
}
