package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "salesPerson")
public class SalesPerson implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 25)
    @Column(name = "salesman_name", length = 25, nullable = false)
    private String salesmanName;

    @Column(name = "contact_no")
    private Integer contactNo;

    @Size(max = 30)
    @Column(name = "email", length = 30)
    private String email;

    @NotNull
    @Min(value = 0)
    @Max(value = 1)
    @Column(name = "status", nullable = false)
    private Integer status;

    @OneToMany(mappedBy = "SalesPerson")
    private Set<Retailer> retailer = new HashSet<>();

    @OneToMany(mappedBy = "SalesPerson")
    private Set<SalesOrder> salesOrder = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "salespeople", allowSetters = true)
    private Distributor distributor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public SalesPerson salesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
        return this;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public Integer getContactNo() {
        return contactNo;
    }

    public SalesPerson contactNo(Integer contactNo) {
        this.contactNo = contactNo;
        return this;
    }

    public void setContactNo(Integer contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public SalesPerson email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public SalesPerson status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<Retailer> getRetailers() {
        return retailer;
    }

    public SalesPerson retailers(Set<Retailer> retailers) {
        this.retailer = retailers;
        return this;
    }

    public SalesPerson addRetailer(Retailer retailer) {
        this.retailer.add(retailer);
        retailer.setSalesPerson(this);
        return this;
    }

    public SalesPerson removeRetailer(Retailer retailer) {
        this.retailer.remove(retailer);
        retailer.setSalesPerson(null);
        return this;
    }

    public void setRetailers(Set<Retailer> retailers) {
        this.retailer = retailers;
    }

    public Set<SalesOrder> getSalesOrders() {
        return salesOrder;
    }

    public SalesPerson salesOrders(Set<SalesOrder> salesOrder) {
        this.salesOrder = salesOrder;
        return this;
    }

    public SalesPerson addSalesOrder(SalesOrder salesOrder) {
        this.salesOrder.add(salesOrder);
        salesOrder.setSalesPerson(this);
        return this;
    }

    public SalesPerson removeSalesOrder(SalesOrder salesOrder) {
        this.salesOrder.remove(salesOrder);
        salesOrder.setSalesPerson(null);
        return this;
    }

    public void setSalesOrders(Set<SalesOrder> salesOrder) {
        this.salesOrder = salesOrder;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public SalesPerson distributor(Distributor distributor) {
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
        if (!(o instanceof SalesPerson)) {
            return false;
        }
        return id != null && id.equals(((SalesPerson) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Salesperson{" +
            "id=" + getId() +
            ", salesmanName='" + getSalesmanName() + "'" +
            ", contactNo=" + getContactNo() +
            ", email='" + getEmail() + "'" +
            ", status=" + getStatus() +
            "}";
    }
}
