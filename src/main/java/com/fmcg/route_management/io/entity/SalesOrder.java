package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A SalesOrder.
 */
@Entity
@Table(name = "sales_order")
public class SalesOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 15)
    @Column(name = "so_number", length = 15, nullable = false)
    private String soNumber;

    @NotNull
    @Column(name = "so_date", nullable = false)
    private LocalDate soDate;

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

    @OneToOne
    @JoinColumn(unique = true)
    private SalesInvoice salesInvoice;

    // Corrected mappedBy attribute here:
    @OneToMany(mappedBy = "salesOrder")
    private Set<SalesOrderLines> salesOrderLines = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "SalesOrders", allowSetters = true)
    private Retailer retailer;

    @ManyToOne
    @JsonIgnoreProperties(value = "salesOrder", allowSetters = true)
    private SalesPerson salesPerson;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoNumber() {
        return soNumber;
    }

    public SalesOrder soNumber(String soNumber) {
        this.soNumber = soNumber;
        return this;
    }

    public void setSoNumber(String soNumber) {
        this.soNumber = soNumber;
    }

    public LocalDate getSoDate() {
        return soDate;
    }

    public SalesOrder soDate(LocalDate soDate) {
        this.soDate = soDate;
        return this;
    }

    public void setSoDate(LocalDate soDate) {
        this.soDate = soDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public SalesOrder deliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Double getTotalValueExluded() {
        return totalValueExluded;
    }

    public SalesOrder totalValueExluded(Double totalValueExluded) {
        this.totalValueExluded = totalValueExluded;
        return this;
    }

    public void setTotalValueExluded(Double totalValueExluded) {
        this.totalValueExluded = totalValueExluded;
    }

    public Double getTotalValueIncluded() {
        return totalValueIncluded;
    }

    public SalesOrder totalValueIncluded(Double totalValueIncluded) {
        this.totalValueIncluded = totalValueIncluded;
        return this;
    }

    public void setTotalValueIncluded(Double totalValueIncluded) {
        this.totalValueIncluded = totalValueIncluded;
    }

    public String getRemarks() {
        return remarks;
    }

    public SalesOrder remarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public SalesOrder status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SalesInvoice getSalesInvoice() {
        return salesInvoice;
    }

    public SalesOrder salesInvoice(SalesInvoice salesInvoice) {
        this.salesInvoice = salesInvoice;
        return this;
    }

    public void setSalesInvoice(SalesInvoice salesInvoice) {
        this.salesInvoice = salesInvoice;
    }

    public Set<SalesOrderLines> getSalesOrderLines() {
        return salesOrderLines;
    }

    public SalesOrder salesOrderLines(Set<SalesOrderLines> salesOrderLines) {
        this.salesOrderLines = salesOrderLines;
        return this;
    }

    public SalesOrder addSalesOrderLines(SalesOrderLines salesOrderLines) {
        this.salesOrderLines.add(salesOrderLines);
        salesOrderLines.setSalesOrder(this);
        return this;
    }

    public SalesOrder removeSalesOrderLines(SalesOrderLines salesOrderLines) {
        this.salesOrderLines.remove(salesOrderLines);
        salesOrderLines.setSalesOrder(null);
        return this;
    }

    public void setSalesOrderLines(Set<SalesOrderLines> salesOrderLines) {
        this.salesOrderLines = salesOrderLines;
    }

    public Retailer getRetailer() {
        return retailer;
    }

    public SalesOrder retailer(Retailer retailer) {
        this.retailer = retailer;
        return this;
    }

    public void setRetailer(Retailer retailer) {
        this.retailer = retailer;
    }

    public SalesPerson getSalesPerson() {
        return salesPerson;
    }

    public SalesOrder salesPerson(SalesPerson salesPerson) {
        this.salesPerson = salesPerson;
        return this;
    }

    public void setSalesPerson(SalesPerson salesPerson) {
        this.salesPerson = salesPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SalesOrder)) {
            return false;
        }
        return id != null && id.equals(((SalesOrder) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "SalesOrder{" +
                "id=" + getId() +
                ", soNumber='" + getSoNumber() + "'" +
                ", soDate='" + getSoDate() + "'" +
                ", deliveryDate='" + getDeliveryDate() + "'" +
                ", totalValueExluded=" + getTotalValueExluded() +
                ", totalValueIncluded=" + getTotalValueIncluded() +
                ", remarks='" + getRemarks() + "'" +
                ", status='" + getStatus() + "'" +
                "}";
    }
}
