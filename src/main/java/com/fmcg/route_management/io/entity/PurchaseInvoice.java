package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A PurchaseInvoice.
 */
@Entity
@Table(name = "purchase_invoice")
public class PurchaseInvoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 15)
    @Column(name = "pi_number", length = 15, nullable = false)
    private String piNumber;

    @NotNull
    @Column(name = "pi_date", nullable = false)
    private LocalDate piDate;

    @NotNull
    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate;

    @NotNull
    @Column(name = "total_value_excluded", nullable = false)
    private Double totalValueExcluded;

    @NotNull
    @Column(name = "total_value_included", nullable = false)
    private Double totalValueIncluded;

    @Size(max = 150)
    @Column(name = "remarks", length = 150)
    private String remarks;

    @NotNull
    @Size(max = 10)
    @Column(name = "status", length = 10, nullable = false)
    private String status;

    @OneToOne
    @JoinColumn(unique = true)
    private PurchaseOrder purchaseOrder;

    @OneToMany(mappedBy = "purchaseInvoice")
    private Set<PurchaseInvoiceLines> purchaseInvoiceLines = new HashSet<>();

    @OneToMany(mappedBy = "purchaseInvoice")
    private Set<PurchaseReturn> purchaseReturns = new HashSet<>();

    @OneToOne(mappedBy = "purchaseInvoice")
    @JsonIgnore
    private GoodReceivedNote goodReceivedNote;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPiNumber() {
        return piNumber;
    }

    public PurchaseInvoice piNumber(String piNumber) {
        this.piNumber = piNumber;
        return this;
    }

    public void setPiNumber(String piNumber) {
        this.piNumber = piNumber;
    }

    public LocalDate getPiDate() {
        return piDate;
    }

    public PurchaseInvoice piDate(LocalDate piDate) {
        this.piDate = piDate;
        return this;
    }

    public void setPiDate(LocalDate piDate) {
        this.piDate = piDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public PurchaseInvoice deliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Double getTotalValueExcluded() {
        return totalValueExcluded;
    }

    public PurchaseInvoice totalValueExcluded(Double totalValueExcluded) {
        this.totalValueExcluded = totalValueExcluded;
        return this;
    }

    public void setTotalValueExcluded(Double totalValueExcluded) {
        this.totalValueExcluded = totalValueExcluded;
    }

    public Double getTotalValueIncluded() {
        return totalValueIncluded;
    }

    public PurchaseInvoice totalValueIncluded(Double totalValueIncluded) {
        this.totalValueIncluded = totalValueIncluded;
        return this;
    }

    public void setTotalValueIncluded(Double totalValueIncluded) {
        this.totalValueIncluded = totalValueIncluded;
    }

    public String getRemarks() {
        return remarks;
    }

    public PurchaseInvoice remarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public PurchaseInvoice status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PurchaseOrder getPurcaseOrder() {
        return purchaseOrder;
    }

    public PurchaseInvoice purcaseOrder(PurchaseOrder purcaseOrder) {
        this.purchaseOrder = purcaseOrder;
        return this;
    }

    public void setPurcaseOrder(PurchaseOrder purcaseOrder) {
        this.purchaseOrder = purcaseOrder;
    }

    public Set<PurchaseInvoiceLines> getPurchaseInvoiceLines() {
        return purchaseInvoiceLines;
    }

    public PurchaseInvoice purchaseInvoiceLines(Set<PurchaseInvoiceLines> purchaseInvoiceLines) {
        this.purchaseInvoiceLines = purchaseInvoiceLines;
        return this;
    }

    public PurchaseInvoice addPurchaseInvoiceLines(PurchaseInvoiceLines purchaseInvoiceLines) {
        this.purchaseInvoiceLines.add(purchaseInvoiceLines);
        purchaseInvoiceLines.setPurchaseInvoice(this);
        return this;
    }

    public PurchaseInvoice removePurchaseInvoiceLines(PurchaseInvoiceLines purchaseInvoiceLines) {
        this.purchaseInvoiceLines.remove(purchaseInvoiceLines);
        purchaseInvoiceLines.setPurchaseInvoice(null);
        return this;
    }

    public void setPurchaseInvoiceLines(Set<PurchaseInvoiceLines> purchaseInvoiceLines) {
        this.purchaseInvoiceLines = purchaseInvoiceLines;
    }

    public Set<PurchaseReturn> getPurchaseReturns() {
        return purchaseReturns;
    }

    public PurchaseInvoice purchaseReturns(Set<PurchaseReturn> purchaseReturns) {
        this.purchaseReturns = purchaseReturns;
        return this;
    }

    public PurchaseInvoice addPurchaseReturn(PurchaseReturn purchaseReturn) {
        this.purchaseReturns.add(purchaseReturn);
        purchaseReturn.setPurchaseInvoice(this);
        return this;
    }

    public PurchaseInvoice removePurchaseReturn(PurchaseReturn purchaseReturn) {
        this.purchaseReturns.remove(purchaseReturn);
        purchaseReturn.setPurchaseInvoice(null);
        return this;
    }

    public void setPurchaseReturns(Set<PurchaseReturn> purchaseReturns) {
        this.purchaseReturns = purchaseReturns;
    }

    public GoodReceivedNote getGoodReceivedNote() {
        return goodReceivedNote;
    }

    public PurchaseInvoice goodReceivedNote(GoodReceivedNote goodReceivedNote) {
        this.goodReceivedNote = goodReceivedNote;
        return this;
    }

    public void setGoodReceivedNote(GoodReceivedNote goodReceivedNote) {
        this.goodReceivedNote = goodReceivedNote;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PurchaseInvoice)) {
            return false;
        }
        return id != null && id.equals(((PurchaseInvoice) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PurchaseInvoice{" +
            "id=" + getId() +
            ", piNumber='" + getPiNumber() + "'" +
            ", piDate='" + getPiDate() + "'" +
            ", deliveryDate='" + getDeliveryDate() + "'" +
            ", totalValueExcluded=" + getTotalValueExcluded() +
            ", totalValueIncluded=" + getTotalValueIncluded() +
            ", remarks='" + getRemarks() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
