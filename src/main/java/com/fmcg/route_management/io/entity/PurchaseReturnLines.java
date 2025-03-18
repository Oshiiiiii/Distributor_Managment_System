package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A PurchaseReturnLines.
 */
@Entity
@Table(name = "purchase_return_lines")
public class PurchaseReturnLines implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "product_return_qty", nullable = false)
    private Integer productReturnQty;

    @ManyToOne
    @JsonIgnoreProperties(value = "purchaseReturnLines", allowSetters = true)
    private Product product;

    @ManyToOne
    @JsonIgnoreProperties(value = "purchaseReturnLines", allowSetters = true)
    private PurchaseReturn purchaseReturn;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductReturnQty() {
        return productReturnQty;
    }

    public PurchaseReturnLines productReturnQty(Integer productReturnQty) {
        this.productReturnQty = productReturnQty;
        return this;
    }

    public void setProductReturnQty(Integer productReturnQty) {
        this.productReturnQty = productReturnQty;
    }

    public Product getProduct() {
        return product;
    }

    public PurchaseReturnLines product(Product product) {
        this.product = product;
        return this;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PurchaseReturn getPurchaseReturn() {
        return purchaseReturn;
    }

    public PurchaseReturnLines purchaseReturn(PurchaseReturn purchaseReturn) {
        this.purchaseReturn = purchaseReturn;
        return this;
    }

    public void setPurchaseReturn(PurchaseReturn purchaseReturn) {
        this.purchaseReturn = purchaseReturn;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PurchaseReturnLines)) {
            return false;
        }
        return id != null && id.equals(((PurchaseReturnLines) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PurchaseReturnLines{" +
            "id=" + getId() +
            ", productReturnQty=" + getProductReturnQty() +
            "}";
    }
}
