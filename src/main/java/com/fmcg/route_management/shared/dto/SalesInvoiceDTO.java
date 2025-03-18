package com.fmcg.route_management.shared.dto;

import java.time.LocalDate;
import java.io.Serializable;


public class SalesInvoiceDTO implements Serializable {

	private static final long serialVersionUID = 752280571644329006L;

	private Long id;
    private String siNumber;
    private LocalDate siDate;
    private LocalDate deliveryDate;
    private Double totalValueExluded;
    private Double totalValueIncluded;
    private String remarks;
    private String status;
    private Integer pickListReference;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiNumber() {
        return siNumber;
    }

    public void setSiNumber(String siNumber) {
        this.siNumber = siNumber;
    }

    public LocalDate getSiDate() {
        return siDate;
    }

    public void setSiDate(LocalDate siDate) {
        this.siDate = siDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Double getTotalValueExluded() {
        return totalValueExluded;
    }

    public void setTotalValueExluded(Double totalValueExluded) {
        this.totalValueExluded = totalValueExluded;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPickListReference() {
        return pickListReference;
    }

    public void setPickListReference(Integer pickListReference) {
        this.pickListReference = pickListReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SalesInvoiceDTO)) {
            return false;
        }

        return id != null && id.equals(((SalesInvoiceDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SalesInvoiceDTO{" +
            "id=" + getId() +
            ", siNumber='" + getSiNumber() + "'" +
            ", siDate='" + getSiDate() + "'" +
            ", deliveryDate='" + getDeliveryDate() + "'" +
            ", totalValueExluded=" + getTotalValueExluded() +
            ", totalValueIncluded=" + getTotalValueIncluded() +
            ", remarks='" + getRemarks() + "'" +
            ", status='" + getStatus() + "'" +
            ", pickListReference=" + getPickListReference() +
            "}";
    }
}
