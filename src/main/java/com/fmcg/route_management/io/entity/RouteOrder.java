package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A RouteOrder.
 */
@Entity
@Table(name = "route_order")
public class RouteOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "order_no", nullable = false)
    private Integer orderNo;

    @ManyToOne
    @JsonIgnoreProperties(value = "routeOrders", allowSetters = true)
    private PickList pickList;

    @ManyToOne
    @JsonIgnoreProperties(value = "routeOrders", allowSetters = true)
    private Retailer retailer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public RouteOrder orderNo(Integer orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public PickList getPickList() {
        return pickList;
    }

    public RouteOrder pickList(PickList pickList) {
        this.pickList = pickList;
        return this;
    }

    public void setPickList(PickList pickList) {
        this.pickList = pickList;
    }

    public Retailer getRetailer() {
        return retailer;
    }

    public RouteOrder retailer(Retailer retailer) {
        this.retailer = retailer;
        return this;
    }

    public void setRetailer(Retailer retailer) {
        this.retailer = retailer;
    }
  

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RouteOrder)) {
            return false;
        }
        return id != null && id.equals(((RouteOrder) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RouteOrder{" +
            "id=" + getId() +
            ", orderNo=" + getOrderNo() +
            "}";
    }
}
