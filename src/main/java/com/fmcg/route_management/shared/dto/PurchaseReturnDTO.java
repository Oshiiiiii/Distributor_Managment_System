package com.fmcg.route_management.shared.dto;

import java.time.LocalDate;
import java.io.Serializable;


public class PurchaseReturnDTO implements Serializable {

	private static final long serialVersionUID = -1893619240338740095L;

	private Long id;
    private String prNumber;
    private LocalDate prDate;
    private Double totalReturnValueExluded;
    private Double totalReturnValueIncluded;
    private String remarks;
    private String status;
    private Long purchaseInvoiceId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrNumber() {
        return prNumber;
    }

    public void setPrNumber(String prNumber) {
        this.prNumber = prNumber;
    }

    public LocalDate getPrDate() {
        return prDate;
    }

    public void setPrDate(LocalDate prDate) {
        this.prDate = prDate;
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

    public Long getPurchaseInvoiceId() {
        return purchaseInvoiceId;
    }

    public void setPurchaseInvoiceId(Long purchaseInvoiceId) {
        this.purchaseInvoiceId = purchaseInvoiceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PurchaseReturnDTO)) {
            return false;
        }

        return id != null && id.equals(((PurchaseReturnDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PurchaseReturnDTO{" +
            "id=" + getId() +
            ", prNumber='" + getPrNumber() + "'" +
            ", prDate='" + getPrDate() + "'" +
            ", totalReturnValueExluded=" + getTotalReturnValueExluded() +
            ", totalReturnValueIncluded=" + getTotalReturnValueIncluded() +
            ", remarks='" + getRemarks() + "'" +
            ", status='" + getStatus() + "'" +
            ", purchaseInvoiceId=" + getPurchaseInvoiceId() +
            "}";
    }
}
