package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;

public class SalesPersonRest implements Serializable {

	private static final long serialVersionUID = 1440913853604895696L;
	private Long id;
    private String salesmanName;
    private Integer contactNo;
    private String email;
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
        return "SalespersonDTO{" +
            "id=" + getId() +
            ", salesmanName='" + getSalesmanName() + "'" +
            ", contactNo=" + getContactNo() +
            ", email='" + getEmail() + "'" +
            ", status=" + getStatus() +
            ", distributorId=" + getDistributorId() +
            "}";
    }
}
