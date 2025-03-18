package com.fmcg.route_management.io.entity;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Tax.
 */
@Entity
@Table(name = "tax")
public class Tax implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "tax_description", length = 100, nullable = false)
    private String taxDescription;

    @NotNull
    @Column(name = "tax_value", nullable = false)
    private Double taxValue;

    @NotNull
    @Min(value = 0)
    @Max(value = 1)
    @Column(name = "status", nullable = false)
    private Integer status;

    @OneToMany(mappedBy = "tax")
    private Set<Product> products = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaxDescription() {
        return taxDescription;
    }

    public Tax taxDescription(String taxDescription) {
        this.taxDescription = taxDescription;
        return this;
    }

    public void setTaxDescription(String taxDescription) {
        this.taxDescription = taxDescription;
    }

    public Double getTaxValue() {
        return taxValue;
    }

    public Tax taxValue(Double taxValue) {
        this.taxValue = taxValue;
        return this;
    }

    public void setTaxValue(Double taxValue) {
        this.taxValue = taxValue;
    }

    public Integer getStatus() {
        return status;
    }

    public Tax status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Tax products(Set<Product> products) {
        this.products = products;
        return this;
    }

    public Tax addProduct(Product product) {
        this.products.add(product);
        product.setTax(this);
        return this;
    }

    public Tax removeProduct(Product product) {
        this.products.remove(product);
        product.setTax(null);
        return this;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tax)) {
            return false;
        }
        return id != null && id.equals(((Tax) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Tax{" +
            "id=" + getId() +
            ", taxDescription='" + getTaxDescription() + "'" +
            ", taxValue=" + getTaxValue() +
            ", status=" + getStatus() +
            "}";
    }
}
