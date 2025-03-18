package com.fmcg.route_management.shared.dto;


import java.io.Serializable;

public class RetailerDTO implements Serializable {

	private static final long serialVersionUID = -1577416113252354737L;

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
    private Long distributorId;
    private Long salespersonId;
    
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

    public Long getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Long distributorId) {
        this.distributorId = distributorId;
    }

    public Long getSalespersonId() {
        return salespersonId;
    }

    public void setSalespersonId(Long salespersonId) {
        this.salespersonId = salespersonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RetailerDTO)) {
            return false;
        }

        return id != null && id.equals(((RetailerDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RetailerDTO{" +
            "id=" + getId() +
            ", retailerCode='" + getRetailerCode() + "'" +
            ", retailerName='" + getRetailerName() + "'" +
            ", address='" + getAddress() + "'" +
            ", contactNo=" + getContactNo() +
            ", vatStatus=" + getVatStatus() +
            ", vatNumber='" + getVatNumber() + "'" +
            ", lattitude='" + getLattitude() + "'" +
            ", longitude='" + getLongitude() + "'" +
            ", status=" + getStatus() +
            ", distributorId=" + getDistributorId() +
            ", salespersonId=" + getSalespersonId() +
            "}";
    }
}
