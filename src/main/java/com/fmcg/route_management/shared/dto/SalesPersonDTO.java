package com.fmcg.route_management.shared.dto;


import java.io.Serializable;


public class SalesPersonDTO implements Serializable {

	private static final long serialVersionUID = -8056595427033348178L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SalesPersonDTO)) {
            return false;
        }

        return id != null && id.equals(((SalesPersonDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
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
