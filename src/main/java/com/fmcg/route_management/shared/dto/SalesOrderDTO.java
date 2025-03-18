package com.fmcg.route_management.shared.dto;

import java.time.LocalDate;
import java.io.Serializable;

public class SalesOrderDTO implements Serializable {

	private static final long serialVersionUID = 8350803421066984172L;

	private Long id;
    private String soNumber;
    private LocalDate soDate;
    private LocalDate deliveryDate;
    private Double totalValueExluded;
    private Double totalValueIncluded;
    private String remarks;
    private String status;


    private Long salesInvoiceId;

    private Long retailerId;

    private Long salespersonId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoNumber() {
        return soNumber;
    }

    public void setSoNumber(String soNumber) {
        this.soNumber = soNumber;
    }

    public LocalDate getSoDate() {
        return soDate;
    }

    public void setSoDate(LocalDate soDate) {
        this.soDate = soDate;
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

    public Long getSalesInvoiceId() {
        return salesInvoiceId;
    }

    public void setSalesInvoiceId(Long salesInvoiceId) {
        this.salesInvoiceId = salesInvoiceId;
    }

    public Long getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(Long retailerId) {
        this.retailerId = retailerId;
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
        if (!(o instanceof SalesOrderDTO)) {
            return false;
        }

        return id != null && id.equals(((SalesOrderDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SalesOrderDTO{" +
            "id=" + getId() +
            ", soNumber='" + getSoNumber() + "'" +
            ", soDate='" + getSoDate() + "'" +
            ", deliveryDate='" + getDeliveryDate() + "'" +
            ", totalValueExluded=" + getTotalValueExluded() +
            ", totalValueIncluded=" + getTotalValueIncluded() +
            ", remarks='" + getRemarks() + "'" +
            ", status='" + getStatus() + "'" +
            ", salesInvoiceId=" + getSalesInvoiceId() +
            ", retailerId=" + getRetailerId() +
            ", salespersonId=" + getSalespersonId() +
            "}";
    }
}
