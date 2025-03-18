package com.fmcg.route_management.io.entity;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A WarehouseType.
 */
@Entity
@Table(name = "warehouse_type")
public class WarehouseType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 15)
    @Column(name = "type_name", length = 15, nullable = false)
    private String typeName;

    @Size(max = 100)
    @Column(name = "type_description", length = 100)
    private String typeDescription;

    @NotNull
    @Min(value = 0)
    @Max(value = 1)
    @Column(name = "status", nullable = false)
    private Integer status;

    @OneToMany(mappedBy = "warehouseType")
    private Set<Warehouse> warehouses = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public WarehouseType typeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public WarehouseType typeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
        return this;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public Integer getStatus() {
        return status;
    }

    public WarehouseType status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<Warehouse> getWarehouses() {
        return warehouses;
    }

    public WarehouseType warehouses(Set<Warehouse> warehouses) {
        this.warehouses = warehouses;
        return this;
    }

    public WarehouseType addWarehouse(Warehouse warehouse) {
        this.warehouses.add(warehouse);
        warehouse.setWarehouseType(this);
        return this;
    }

    public WarehouseType removeWarehouse(Warehouse warehouse) {
        this.warehouses.remove(warehouse);
        warehouse.setWarehouseType(null);
        return this;
    }

    public void setWarehouses(Set<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }
 

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WarehouseType)) {
            return false;
        }
        return id != null && id.equals(((WarehouseType) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "WarehouseType{" +
            "id=" + getId() +
            ", typeName='" + getTypeName() + "'" +
            ", typeDescription='" + getTypeDescription() + "'" +
            ", status=" + getStatus() +
            "}";
    }
}
