package com.fmcg.route_management.shared.dto;


import java.io.Serializable;

/**
 * A DTO for the {@link com.unique.dms.domain.Distributor} entity.
 */
public class DistributorDTO implements Serializable {
    
	private static final long serialVersionUID = 4739529213214579195L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DistributorDTO)) {
            return false;
        }

        return id != null && id.equals(((DistributorDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DistributorDTO{" +
            "id=" + getId() +
            ", distributorCode='" + getDistributorCode() + "'" +
            ", distributorName='" + getDistributorName() + "'" +
            ", address='" + getAddress() + "'" +
            ", contactNumber=" + getContactNumber() +
            ", taxStatus=" + getTaxStatus() +
            ", vatNumber='" + getVatNumber() + "'" +
            ", status=" + getStatus() +
            "}";
    }
}
