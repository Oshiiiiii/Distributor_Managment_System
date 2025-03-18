package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A PurchaseReturn.
 */
@Entity
@Table(name = "purchase_return")
public class PurchaseReturn implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 15)
    @Column(name = "pr_number", length = 15, nullable = false)
    private String prNumber;

    @NotNull
    @Column(name = "pr_date", nullable = false)
    private LocalDate prDate;

    @NotNull
    @Column(name = "total_return_value_exluded", nullable = false)
    private Double totalReturnValueExluded;

    @NotNull
    @Column(name = "total_return_value_included", nullable = false)
    private Double totalReturnValueIncluded;

    @Size(max = 150)
    @Column(name = "remarks", length = 150)
    private String remarks;

    @NotNull
    @Size(max = 15)
    @Column(name = "status", length = 15, nullable = false)
    private String status;

    @OneToMany(mappedBy = "purchaseReturn")
    private Set<PurchaseReturnLines> purchaseReturnLines = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "purchaseReturns", allowSetters = true)
    private PurchaseInvoice purchaseInvoice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrNumber() {
        return prNumber;
    }

    public PurchaseReturn prNumber(String prNumber) {
        this.prNumber = prNumber;
        return this;
    }

    public void setPrNumber(String prNumber) {
        this.prNumber = prNumber;
    }

    public LocalDate getPrDate() {
        return prDate;
    }

    public PurchaseReturn prDate(LocalDate prDate) {
        this.prDate = prDate;
        return this;
    }

    public void setPrDate(LocalDate prDate) {
        this.prDate = prDate;
    }

    public Double getTotalReturnValueExluded() {
        return totalReturnValueExluded;
    }

    public PurchaseReturn totalReturnValueExluded(Double totalReturnValueExluded) {
        this.totalReturnValueExluded = totalReturnValueExluded;
        return this;
    }

    public void setTotalReturnValueExluded(Double totalReturnValueExluded) {
        this.totalReturnValueExluded = totalReturnValueExluded;
    }

    public Double getTotalReturnValueIncluded() {
        return totalReturnValueIncluded;
    }

    public PurchaseReturn totalReturnValueIncluded(Double totalReturnValueIncluded) {
        this.totalReturnValueIncluded = totalReturnValueIncluded;
        return this;
    }

    public void setTotalReturnValueIncluded(Double totalReturnValueIncluded) {
        this.totalReturnValueIncluded = totalReturnValueIncluded;
    }

    public String getRemarks() {
        return remarks;
    }

    public PurchaseReturn remarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public PurchaseReturn status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<PurchaseReturnLines> getPurchaseReturnLines() {
        return purchaseReturnLines;
    }

    public PurchaseReturn purchaseReturnLines(Set<PurchaseReturnLines> purchaseReturnLines) {
        this.purchaseReturnLines = purchaseReturnLines;
        return this;
    }

    public PurchaseReturn addPurchaseReturnLines(PurchaseReturnLines purchaseReturnLines) {
        this.purchaseReturnLines.add(purchaseReturnLines);
        purchaseReturnLines.setPurchaseReturn(this);
        return this;
    }

    public PurchaseReturn removePurchaseReturnLines(PurchaseReturnLines purchaseReturnLines) {
        this.purchaseReturnLines.remove(purchaseReturnLines);
        purchaseReturnLines.setPurchaseReturn(null);
        return this;
    }

    public void setPurchaseReturnLines(Set<PurchaseReturnLines> purchaseReturnLines) {
        this.purchaseReturnLines = purchaseReturnLines;
    }

    public PurchaseInvoice getPurchaseInvoice() {
        return purchaseInvoice;
    }

    public PurchaseReturn purchaseInvoice(PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice;
        return this;
    }

    public void setPurchaseInvoice(PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PurchaseReturn)) {
            return false;
        }
        return id != null && id.equals(((PurchaseReturn) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PurchaseReturn{" +
            "id=" + getId() +
            ", prNumber='" + getPrNumber() + "'" +
            ", prDate='" + getPrDate() + "'" +
            ", totalReturnValueExluded=" + getTotalReturnValueExluded() +
            ", totalReturnValueIncluded=" + getTotalReturnValueIncluded() +
            ", remarks='" + getRemarks() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
