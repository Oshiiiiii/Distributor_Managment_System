package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A PickList.
 */
@Entity
@Table(name = "pick_list")
public class PickList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 25)
    @Column(name = "picklist_number", length = 25, nullable = false)
    private String picklistNumber;

    @NotNull
    @Size(max = 10)
    @Column(name = "status", length = 10, nullable = false)
    private String status;

    @OneToMany(mappedBy = "pickList")
    private Set<RouteOrder> routeOrders = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "pickLists", allowSetters = true)
    private Van van;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicklistNumber() {
        return picklistNumber;
    }

    public PickList picklistNumber(String picklistNumber) {
        this.picklistNumber = picklistNumber;
        return this;
    }

    public void setPicklistNumber(String picklistNumber) {
        this.picklistNumber = picklistNumber;
    }

    public String getStatus() {
        return status;
    }

    public PickList status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<RouteOrder> getRouteOrders() {
        return routeOrders;
    }

    public PickList routeOrders(Set<RouteOrder> routeOrders) {
        this.routeOrders = routeOrders;
        return this;
    }

    public PickList addRouteOrder(RouteOrder routeOrder) {
        this.routeOrders.add(routeOrder);
        routeOrder.setPickList(this);
        return this;
    }

    public PickList removeRouteOrder(RouteOrder routeOrder) {
        this.routeOrders.remove(routeOrder);
        routeOrder.setPickList(null);
        return this;
    }

    public void setRouteOrders(Set<RouteOrder> routeOrders) {
        this.routeOrders = routeOrders;
    }

    public Van getVan() {
        return van;
    }

    public PickList van(Van van) {
        this.van = van;
        return this;
    }

    public void setVan(Van van) {
        this.van = van;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PickList)) {
            return false;
        }
        return id != null && id.equals(((PickList) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PickList{" +
            "id=" + getId() +
            ", picklistNumber='" + getPicklistNumber() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
