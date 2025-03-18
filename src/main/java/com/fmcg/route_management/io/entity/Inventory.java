package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A Inventory.
 */
@Entity
@Table(name = "inventory")
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "available_qty", nullable = false)
    private Integer availableQty;

    @NotNull
    @Column(name = "product_value_excluded", nullable = false)
    private Double productValueExcluded;

    @NotNull
    @Column(name = "product_value_included", nullable = false)
    private Double productValueIncluded;

    @ManyToOne
    @JsonIgnoreProperties(value = "inventories", allowSetters = true)
    private Product product;

    @ManyToOne
    @JsonIgnoreProperties(value = "inventories", allowSetters = true)
    private Warehouse warehouse;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAvailableQty() {
        return availableQty;
    }

    public Inventory availableQty(Integer availableQty) {
        this.availableQty = availableQty;
        return this;
    }

    public void setAvailableQty(Integer availableQty) {
        this.availableQty = availableQty;
    }

    public Double getProductValueExcluded() {
        return productValueExcluded;
    }

    public Inventory productValueExcluded(Double productValueExcluded) {
        this.productValueExcluded = productValueExcluded;
        return this;
    }

    public void setProductValueExcluded(Double productValueExcluded) {
        this.productValueExcluded = productValueExcluded;
    }

    public Double getProductValueIncluded() {
        return productValueIncluded;
    }

    public Inventory productValueIncluded(Double productValueIncluded) {
        this.productValueIncluded = productValueIncluded;
        return this;
    }

    public void setProductValueIncluded(Double productValueIncluded) {
        this.productValueIncluded = productValueIncluded;
    }

    public Product getProduct() {
        return product;
    }

    public Inventory product(Product product) {
        this.product = product;
        return this;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Inventory warehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
        return this;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Inventory)) {
            return false;
        }
        return id != null && id.equals(((Inventory) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Inventory{" +
            "id=" + getId() +
            ", availableQty=" + getAvailableQty() +
            ", productValueExcluded=" + getProductValueExcluded() +
            ", productValueIncluded=" + getProductValueIncluded() +
            "}";
    }
}
