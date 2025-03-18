package com.fmcg.route_management.shared.dto;


import java.io.Serializable;


public class PurchaseInvoiceLinesDTO implements Serializable {

	private static final long serialVersionUID = -3073430222261327721L;

	private Long id;
    private Integer productInvoiceQty;
    private Long productId;
    private Long purchaseInvoiceId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductInvoiceQty() {
        return productInvoiceQty;
    }

    public void setProductInvoiceQty(Integer productInvoiceQty) {
        this.productInvoiceQty = productInvoiceQty;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPurchaseInvoiceId() {
        return purchaseInvoiceId;
    }

    public void setPurchaseInvoiceId(Long purchaseInvoiceId) {
        this.purchaseInvoiceId = purchaseInvoiceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PurchaseInvoiceLinesDTO)) {
            return false;
        }

        return id != null && id.equals(((PurchaseInvoiceLinesDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PurchaseInvoiceLinesDTO{" +
            "id=" + getId() +
            ", productInvoiceQty=" + getProductInvoiceQty() +
            ", productId=" + getProductId() +
            ", purchaseInvoiceId=" + getPurchaseInvoiceId() +
            "}";
    }
}
