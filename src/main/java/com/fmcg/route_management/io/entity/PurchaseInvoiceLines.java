package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;


@Entity
@Table(name = "purchase_invoice_lines")
public class PurchaseInvoiceLines implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "product_invoice_qty", nullable = false)
    private Integer productInvoiceQty;

    @ManyToOne
    @JsonIgnoreProperties(value = "purchaseInvoiceLines", allowSetters = true)
    private Product product;

    @ManyToOne
    @JsonIgnoreProperties(value = "purchaseInvoiceLines", allowSetters = true)
    private PurchaseInvoice purchaseInvoice;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductInvoiceQty() {
        return productInvoiceQty;
    }

    public PurchaseInvoiceLines productInvoiceQty(Integer productInvoiceQty) {
        this.productInvoiceQty = productInvoiceQty;
        return this;
    }

    public void setProductInvoiceQty(Integer productInvoiceQty) {
        this.productInvoiceQty = productInvoiceQty;
    }

    public Product getProduct() {
        return product;
    }

    public PurchaseInvoiceLines product(Product product) {
        this.product = product;
        return this;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PurchaseInvoice getPurchaseInvoice() {
        return purchaseInvoice;
    }

    public PurchaseInvoiceLines purchaseInvoice(PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice;
        return this;
    }

    public void setPurchaseInvoice(PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice;
    }
  

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PurchaseInvoiceLines)) {
            return false;
        }
        return id != null && id.equals(((PurchaseInvoiceLines) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PurchaseInvoiceLines{" +
            "id=" + getId() +
            ", productInvoiceQty=" + getProductInvoiceQty() +
            "}";
    }
}
