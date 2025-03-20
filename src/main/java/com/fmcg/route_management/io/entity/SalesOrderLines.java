package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;

/**
 * A SalesOrderLines.
 */
@Entity
@Table(name = "sales_order_lines")
public class SalesOrderLines implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_qty")
    private Integer productQty;

    @ManyToOne
    @JsonIgnoreProperties(value = "salesOrderLines", allowSetters = true)
    private Product product;

    @ManyToOne
    @JsonIgnoreProperties(value = "SalesOrder", allowSetters = true)
    private SalesOrder salesOrder;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductQty() {
        return productQty;
    }

    public SalesOrderLines productQty(Integer productQty) {
        this.productQty = productQty;
        return this;
    }

    public void setProductQty(Integer productQty) {
        this.productQty = productQty;
    }

    public Product getProduct() {
        return product;
    }

    public SalesOrderLines product(Product product) {
        this.product = product;
        return this;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public SalesOrderLines salesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
        return this;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesOrderLines)) return false;
        return id != null && id.equals(((SalesOrderLines) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "SalesOrderLines{" +
                "id=" + getId() +
                ", productQty=" + getProductQty() +
                "}";
    }
}
