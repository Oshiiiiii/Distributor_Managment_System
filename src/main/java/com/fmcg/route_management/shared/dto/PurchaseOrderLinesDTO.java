package com.fmcg.route_management.shared.dto;


import java.io.Serializable;


public class PurchaseOrderLinesDTO implements Serializable {
    
	private static final long serialVersionUID = 6162334281867114044L;

	private Long id;
    private Integer productQty;
    private Double primaryPrice;
    private Long productId;
    private Long purcaseOrderId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductQty() {
        return productQty;
    }

    public void setProductQty(Integer productQty) {
        this.productQty = productQty;
    }

    public Double getPrimaryPrice() {
        return primaryPrice;
    }

    public void setPrimaryPrice(Double primaryPrice) {
        this.primaryPrice = primaryPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPurcaseOrderId() {
        return purcaseOrderId;
    }

    public void setPurcaseOrderId(Long purcaseOrderId) {
        this.purcaseOrderId = purcaseOrderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PurchaseOrderLinesDTO)) {
            return false;
        }

        return id != null && id.equals(((PurchaseOrderLinesDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PurchaseOrderLineDTO{" +
            "id=" + getId() +
            ", productQty=" + getProductQty() +
            ", primaryPrice=" + getPrimaryPrice() +
            ", productId=" + getProductId() +
            ", purcaseOrderId=" + getPurcaseOrderId() +
            "}";
    }
}
