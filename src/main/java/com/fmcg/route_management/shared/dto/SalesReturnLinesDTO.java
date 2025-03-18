package com.fmcg.route_management.shared.dto;

import java.io.Serializable;

public class SalesReturnLinesDTO implements Serializable {

	private static final long serialVersionUID = 9192937727171473965L;

	private Long id;
    private Integer productReturnQty;
    private Long productId;
    private Long salesReturnId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductReturnQty() {
        return productReturnQty;
    }

    public void setProductReturnQty(Integer productReturnQty) {
        this.productReturnQty = productReturnQty;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSalesReturnId() {
        return salesReturnId;
    }

    public void setSalesReturnId(Long salesReturnId) {
        this.salesReturnId = salesReturnId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SalesReturnLinesDTO)) {
            return false;
        }

        return id != null && id.equals(((SalesReturnLinesDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SalesReturnLinesDTO{" +
            "id=" + getId() +
            ", productReturnQty=" + getProductReturnQty() +
            ", productId=" + getProductId() +
            ", salesReturnId=" + getSalesReturnId() +
            "}";
    }
}
