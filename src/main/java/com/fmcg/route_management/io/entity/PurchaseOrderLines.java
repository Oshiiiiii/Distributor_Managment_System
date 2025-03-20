package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;

/**
 * A PurchaseOrderLine.
 */
@Entity
@Table(name = "purchase_order_line")
public class PurchaseOrderLines implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "product_qty", nullable = false)
    private Integer productQty;

    @NotNull
    @Column(name = "primary_price", nullable = false)
    private Double primaryPrice;

    @ManyToOne
    @JsonIgnoreProperties(value = "purchaseOrderLines", allowSetters = true)
    private Product product;

    @ManyToOne
    @JsonIgnoreProperties(value = "purchaseOrderLines", allowSetters = true)
    private PurchaseOrder purchaseOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductQty() {
        return productQty;
    }

    public PurchaseOrderLines productQty(Integer productQty) {
        this.productQty = productQty;
        return this;
    }

    public void setProductQty(Integer productQty) {
        this.productQty = productQty;
    }

    public Double getPrimaryPrice() {
        return primaryPrice;
    }

    public PurchaseOrderLines primaryPrice(Double primaryPrice) {
        this.primaryPrice = primaryPrice;
        return this;
    }

    public void setPrimaryPrice(Double primaryPrice) {
        this.primaryPrice = primaryPrice;
    }

    public Product getProduct() {
        return product;
    }

    public PurchaseOrderLines product(Product product) {
        this.product = product;
        return this;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PurchaseOrder getpurchaseOrder() {
        return purchaseOrder;
    }

    public PurchaseOrderLines purchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
        return this;
    }

    public void setpurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
   

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PurchaseOrderLines)) {
            return false;
        }
        return id != null && id.equals(((PurchaseOrderLines) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PurchaseOrderLine{" +
            "id=" + getId() +
            ", productQty=" + getProductQty() +
            ", primaryPrice=" + getPrimaryPrice() +
            "}";
    }
}
