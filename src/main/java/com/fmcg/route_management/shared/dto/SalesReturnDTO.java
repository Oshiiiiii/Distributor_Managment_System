package com.fmcg.route_management.shared.dto;

import java.time.LocalDate;
import java.io.Serializable;


public class SalesReturnDTO implements Serializable {
    
 static final long serialVersionUID = 1290535317549770113L;

	private Long id;
    private String srNumber;
    private LocalDate srDate;
    private Double totalReturnValueExluded;
    private Double totalReturnValueIncluded;
    private String remarks;
    private String status;
    private Long salesInvoiceId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSrNumber() {
        return srNumber;
    }

    public void setSrNumber(String srNumber) {
        this.srNumber = srNumber;
    }

    public LocalDate getSrDate() {
        return srDate;
    }

    public void setSrDate(LocalDate srDate) {
        this.srDate = srDate;
    }

    public Double getTotalReturnValueExluded() {
        return totalReturnValueExluded;
    }

    public void setTotalReturnValueExluded(Double totalReturnValueExluded) {
        this.totalReturnValueExluded = totalReturnValueExluded;
    }

    public Double getTotalReturnValueIncluded() {
        return totalReturnValueIncluded;
    }

    public void setTotalReturnValueIncluded(Double totalReturnValueIncluded) {
        this.totalReturnValueIncluded = totalReturnValueIncluded;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SalesReturnDTO)) {
            return false;
        }

        return id != null && id.equals(((SalesReturnDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SalesReturnDTO{" +
            "id=" + getId() +
            ", srNumber='" + getSrNumber() + "'" +
            ", srDate='" + getSrDate() + "'" +
            ", totalReturnValueExluded=" + getTotalReturnValueExluded() +
            ", totalReturnValueIncluded=" + getTotalReturnValueIncluded() +
            ", remarks='" + getRemarks() + "'" +
            ", status='" + getStatus() + "'" +
            ", salesInvoiceId=" + getSalesInvoiceId() +
            "}";
    }
}
