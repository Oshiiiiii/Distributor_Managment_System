package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "sales_invoice")
public class SalesInvoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 15)
    @Column(name = "si_number", length = 15, nullable = false)
    private String siNumber;

    @NotNull
    @Column(name = "si_date", nullable = false)
    private LocalDate siDate;

    @NotNull
    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate;

    @NotNull
    @Column(name = "total_value_exluded", nullable = false)
    private Double totalValueExluded;

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

    @Column(name = "pick_list_reference")
    private Integer pickListReference;

    @OneToMany(mappedBy = "salesInvoice")
    private Set<SalesInvoiceLines> salesInvoiceLines = new HashSet<>();

    @OneToMany(mappedBy = "salesInvoice")
    private Set<SalesReturn> salesReturns = new HashSet<>();

    @OneToOne(mappedBy = "salesInvoice")
    @JsonIgnore
    private SalesOrder salesOrder;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSiNumber() {
        return siNumber;
    }

    public SalesInvoice siNumber(String siNumber) {
        this.siNumber = siNumber;
        return this;
    }

    public void setSiNumber(String siNumber) {
        this.siNumber = siNumber;
    }

    public LocalDate getSiDate() {
        return siDate;
    }

    public SalesInvoice siDate(LocalDate siDate) {
        this.siDate = siDate;
        return this;
    }

    public void setSiDate(LocalDate siDate) {
        this.siDate = siDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public SalesInvoice deliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Double getTotalValueExluded() {
        return totalValueExluded;
    }

    public SalesInvoice totalValueExluded(Double totalValueExluded) {
        this.totalValueExluded = totalValueExluded;
        return this;
    }

    public void setTotalValueExluded(Double totalValueExluded) {
        this.totalValueExluded = totalValueExluded;
    }

    public Double getTotalValueIncluded() {
        return totalValueIncluded;
    }

    public SalesInvoice totalValueIncluded(Double totalValueIncluded) {
        this.totalValueIncluded = totalValueIncluded;
        return this;
    }

    public void setTotalValueIncluded(Double totalValueIncluded) {
        this.totalValueIncluded = totalValueIncluded;
    }

    public String getRemarks() {
        return remarks;
    }

    public SalesInvoice remarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public SalesInvoice status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPickListReference() {
        return pickListReference;
    }

    public SalesInvoice pickListReference(Integer pickListReference) {
        this.pickListReference = pickListReference;
        return this;
    }

    public void setPickListReference(Integer pickListReference) {
        this.pickListReference = pickListReference;
    }

    public Set<SalesInvoiceLines> getSalesInvoiceLines() {
        return salesInvoiceLines;
    }

    public SalesInvoice salesInvoiceLines(Set<SalesInvoiceLines> salesInvoiceLines) {
        this.salesInvoiceLines = salesInvoiceLines;
        return this;
    }

    public SalesInvoice addSalesInvoiceLines(SalesInvoiceLines salesInvoiceLines) {
        this.salesInvoiceLines.add(salesInvoiceLines);
        salesInvoiceLines.setSalesInvoice(this);
        return this;
    }

    public SalesInvoice removeSalesInvoiceLines(SalesInvoiceLines salesInvoiceLines) {
        this.salesInvoiceLines.remove(salesInvoiceLines);
        salesInvoiceLines.setSalesInvoice(null);
        return this;
    }

    public void setSalesInvoiceLines(Set<SalesInvoiceLines> salesInvoiceLines) {
        this.salesInvoiceLines = salesInvoiceLines;
    }

    public Set<SalesReturn> getSalesReturns() {
        return salesReturns;
    }

    public SalesInvoice salesReturns(Set<SalesReturn> salesReturns) {
        this.salesReturns = salesReturns;
        return this;
    }

    public SalesInvoice addSalesReturn(SalesReturn salesReturn) {
        this.salesReturns.add(salesReturn);
        salesReturn.setSalesInvoice(this);
        return this;
    }

    public SalesInvoice removeSalesReturn(SalesReturn salesReturn) {
        this.salesReturns.remove(salesReturn);
        salesReturn.setSalesInvoice(null);
        return this;
    }

    public void setSalesReturns(Set<SalesReturn> salesReturns) {
        this.salesReturns = salesReturns;
    }

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public SalesInvoice salesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
        return this;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }
  
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SalesInvoice)) {
            return false;
        }
        return id != null && id.equals(((SalesInvoice) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SalesInvoice{" +
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
