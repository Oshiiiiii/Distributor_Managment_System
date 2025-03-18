package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;

public class SalesOrderLinesRest implements Serializable {

	private static final long serialVersionUID = 4917165192828274895L;
	private Long id;
	private Integer productQty;
	private Long productId;
	private Long salesOrderId;

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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(Long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	  // prettier-ignore
    @Override
    public String toString() {
        return "SalesOrderLinesDTO{" +
            "id=" + getId() +
            ", productQty=" + getProductQty() +
            ", productId=" + getProductId() +
            ", salesOrderId=" + getSalesOrderId() +
            "}";
    }
}
