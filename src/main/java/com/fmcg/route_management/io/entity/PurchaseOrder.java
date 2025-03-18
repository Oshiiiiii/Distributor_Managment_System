package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A purchaseOrder.
 */
@Entity
@Table(name = "purcase_order")
public class PurchaseOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 15)
    @Column(name = "po_number", length = 15, nullable = false)
    private String poNumber;

    @NotNull
    @Column(name = "po_date", nullable = false)
    private LocalDate poDate;

    @NotNull
    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate;

    @NotNull
    @Column(name = "total_value_excluded", nullable = false)
    private Double totalValueExcluded;

    @NotNull
    @Column(name = "total_value_included", nullable = false)
    private Double totalValueIncluded;

    @NotNull
    @Size(max = 150)
    @Column(name = "remarks", length = 150, nullable = false)
    private String remarks;

    @NotNull
    @Min(value = 0)
    @Max(value = 1)
    @Column(name = "status", nullable = false)
    private Integer status;

    @OneToMany(mappedBy = "purchaseOrder")
    private Set<PurchaseOrderLines> purchaseOrderLines = new HashSet<>();

    @OneToOne(mappedBy = "purchaseOrder")
    @JsonIgnore
    private PurchaseInvoice purchaseInvoice;

    @ManyToOne
    @JsonIgnoreProperties(value = "purchaseOrders", allowSetters = true)
    private Distributor distributor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public PurchaseOrder poNumber(String poNumber) {
        this.poNumber = poNumber;
        return this;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public LocalDate getPoDate() {
        return poDate;
    }

    public PurchaseOrder poDate(LocalDate poDate) {
        this.poDate = poDate;
        return this;
    }

    public void setPoDate(LocalDate poDate) {
        this.poDate = poDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public PurchaseOrder deliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Double getTotalValueExcluded() {
        return totalValueExcluded;
    }

    public PurchaseOrder totalValueExcluded(Double totalValueExcluded) {
        this.totalValueExcluded = totalValueExcluded;
        return this;
    }

    public void setTotalValueExcluded(Double totalValueExcluded) {
        this.totalValueExcluded = totalValueExcluded;
    }

    public Double getTotalValueIncluded() {
        return totalValueIncluded;
    }

    public PurchaseOrder totalValueIncluded(Double totalValueIncluded) {
        this.totalValueIncluded = totalValueIncluded;
        return this;
    }

    public void setTotalValueIncluded(Double totalValueIncluded) {
        this.totalValueIncluded = totalValueIncluded;
    }

    public String getRemarks() {
        return remarks;
    }

    public PurchaseOrder remarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getStatus() {
        return status;
    }

    public PurchaseOrder status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<PurchaseOrderLines> getPurchaseOrderLines() {
        return purchaseOrderLines;
    }

    public PurchaseOrder purchaseOrderLines(Set<PurchaseOrderLines> purchaseOrderLines) {
        this.purchaseOrderLines = purchaseOrderLines;
        return this;
    }

    public PurchaseOrder addPurchaseOrderLine(PurchaseOrderLines purchaseOrderLine) {
        this.purchaseOrderLines.add(purchaseOrderLine);
        purchaseOrderLine.setpurchaseOrder(this);
        return this;
    }

    public PurchaseOrder removePurchaseOrderLine(PurchaseOrderLines purchaseOrderLine) {
        this.purchaseOrderLines.remove(purchaseOrderLine);
        purchaseOrderLine.setpurchaseOrder(null);
        return this;
    }

    public void setPurchaseOrderLines(Set<PurchaseOrderLines> purchaseOrderLines) {
        this.purchaseOrderLines = purchaseOrderLines;
    }

    public PurchaseInvoice getPurchaseInvoice() {
        return purchaseInvoice;
    }

    public PurchaseOrder purchaseInvoice(PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice;
        return this;
    }

    public void setPurchaseInvoice(PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public PurchaseOrder distributor(Distributor distributor) {
        this.distributor = distributor;
        return this;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PurchaseOrder)) {
            return false;
        }
        return id != null && id.equals(((PurchaseOrder) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "purchaseOrder{" +
            "id=" + getId() +
            ", poNumber='" + getPoNumber() + "'" +
            ", poDate='" + getPoDate() + "'" +
            ", deliveryDate='" + getDeliveryDate() + "'" +
            ", totalValueExcluded=" + getTotalValueExcluded() +
            ", totalValueIncluded=" + getTotalValueIncluded() +
            ", remarks='" + getRemarks() + "'" +
            ", status=" + getStatus() +
            "}";
    }
}
