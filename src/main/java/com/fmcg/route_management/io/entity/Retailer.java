package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Retailer.
 */
@Entity
@Table(name = "retailer")
public class Retailer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 15)
    @Column(name = "retailer_code", length = 15, nullable = false)
    private String retailerCode;

    @NotNull
    @Size(max = 15)
    @Column(name = "retailer_name", length = 15, nullable = false)
    private String retailerName;

    @Size(max = 50)
    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "contact_no")
    private Integer contactNo;

    @NotNull
    @Min(value = 0)
    @Max(value = 1)
    @Column(name = "vat_status", nullable = false)
    private Integer vatStatus;

    @Size(max = 20)
    @Column(name = "vat_number", length = 20)
    private String vatNumber;

    @NotNull
    @Size(max = 50)
    @Column(name = "lattitude", length = 50, nullable = false)
    private String lattitude;

    @NotNull
    @Size(max = 50)
    @Column(name = "longitude", length = 50, nullable = false)
    private String longitude;

    @NotNull
    @Min(value = 0)
    @Max(value = 1)
    @Column(name = "status", nullable = false)
    private Integer status;

    @OneToMany(mappedBy = "retailer")
    private Set<RouteOrder> routeOrders = new HashSet<>();

    @OneToMany(mappedBy = "retailer")
    private Set<SalesOrder> salesOrders = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "retailer", allowSetters = true)
    private Distributor distributor;

    @ManyToOne
    @JsonIgnoreProperties(value = "retailer", allowSetters = true)
    private SalesPerson SalesPerson;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRetailerCode() {
        return retailerCode;
    }

    public Retailer retailerCode(String retailerCode) {
        this.retailerCode = retailerCode;
        return this;
    }

    public void setRetailerCode(String retailerCode) {
        this.retailerCode = retailerCode;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public Retailer retailerName(String retailerName) {
        this.retailerName = retailerName;
        return this;
    }

    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }

    public String getAddress() {
        return address;
    }

    public Retailer address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getContactNo() {
        return contactNo;
    }

    public Retailer contactNo(Integer contactNo) {
        this.contactNo = contactNo;
        return this;
    }

    public void setContactNo(Integer contactNo) {
        this.contactNo = contactNo;
    }

    public Integer getVatStatus() {
        return vatStatus;
    }

    public Retailer vatStatus(Integer vatStatus) {
        this.vatStatus = vatStatus;
        return this;
    }

    public void setVatStatus(Integer vatStatus) {
        this.vatStatus = vatStatus;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public Retailer vatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
        return this;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getLattitude() {
        return lattitude;
    }

    public Retailer lattitude(String lattitude) {
        this.lattitude = lattitude;
        return this;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public Retailer longitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getStatus() {
        return status;
    }

    public Retailer status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<RouteOrder> getRouteOrders() {
        return routeOrders;
    }

    public Retailer routeOrders(Set<RouteOrder> routeOrders) {
        this.routeOrders = routeOrders;
        return this;
    }

    public Retailer addRouteOrder(RouteOrder routeOrder) {
        this.routeOrders.add(routeOrder);
        routeOrder.setRetailer(this);
        return this;
    }

    public Retailer removeRouteOrder(RouteOrder routeOrder) {
        this.routeOrders.remove(routeOrder);
        routeOrder.setRetailer(null);
        return this;
    }

    public void setRouteOrders(Set<RouteOrder> routeOrders) {
        this.routeOrders = routeOrders;
    }

    public Set<SalesOrder> getSalesOrders() {
        return salesOrders;
    }

    public Retailer salesOrders(Set<SalesOrder> salesOrders) {
        this.salesOrders = salesOrders;
        return this;
    }

    public Retailer addSalesOrder(SalesOrder salesOrder) {
        this.salesOrders.add(salesOrder);
        salesOrder.setRetailer(this);
        return this;
    }

    public Retailer removeSalesOrder(SalesOrder salesOrder) {
        this.salesOrders.remove(salesOrder);
        salesOrder.setRetailer(null);
        return this;
    }

    public void setSalesOrders(Set<SalesOrder> salesOrders) {
        this.salesOrders = salesOrders;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public Retailer distributor(Distributor distributor) {
        this.distributor = distributor;
        return this;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    public SalesPerson getSalesPerson() {
        return SalesPerson;
    }

    public Retailer SalesPerson(SalesPerson SalesPerson) {
        this.SalesPerson = SalesPerson;
        return this;
    }

    public void setSalesPerson(SalesPerson SalesPerson) {
        this.SalesPerson = SalesPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Retailer)) {
            return false;
        }
        return id != null && id.equals(((Retailer) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Retailer{" +
            "id=" + getId() +
            ", retailerCode='" + getRetailerCode() + "'" +
            ", retailerName='" + getRetailerName() + "'" +
            ", address='" + getAddress() + "'" +
            ", contactNo=" + getContactNo() +
            ", vatStatus=" + getVatStatus() +
            ", vatNumber='" + getVatNumber() + "'" +
            ", lattitude='" + getLattitude() + "'" +
            ", longitude='" + getLongitude() + "'" +
            ", status=" + getStatus() +
            "}";
    }
}
