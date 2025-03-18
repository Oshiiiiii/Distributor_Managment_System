package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A SalesReturnLines.
 */
@Entity
@Table(name = "sales_return_lines")
public class SalesReturnLines implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_return_qty")
    private Integer productReturnQty;

    @ManyToOne
    @JsonIgnoreProperties(value = "salesReturnLines", allowSetters = true)
    private Product product;

    @ManyToOne
    @JsonIgnoreProperties(value = "salesReturnLines", allowSetters = true)
    private SalesReturn salesReturn;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductReturnQty() {
        return productReturnQty;
    }

    public SalesReturnLines productReturnQty(Integer productReturnQty) {
        this.productReturnQty = productReturnQty;
        return this;
    }

    public void setProductReturnQty(Integer productReturnQty) {
        this.productReturnQty = productReturnQty;
    }

    public Product getProduct() {
        return product;
    }

    public SalesReturnLines product(Product product) {
        this.product = product;
        return this;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SalesReturn getSalesReturn() {
        return salesReturn;
    }

    public SalesReturnLines salesReturn(SalesReturn salesReturn) {
        this.salesReturn = salesReturn;
        return this;
    }

    public void setSalesReturn(SalesReturn salesReturn) {
        this.salesReturn = salesReturn;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SalesReturnLines)) {
            return false;
        }
        return id != null && id.equals(((SalesReturnLines) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SalesReturnLines{" +
            "id=" + getId() +
            ", productReturnQty=" + getProductReturnQty() +
            "}";
    }
}
