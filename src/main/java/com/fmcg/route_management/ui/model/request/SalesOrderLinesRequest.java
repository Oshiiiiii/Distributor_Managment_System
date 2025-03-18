package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;


/**
 * A DTO for the {@link com.unique.dms.domain.ProductCategoery} entity.
 */
public class SalesOrderLinesRequest implements Serializable {

	private static final long serialVersionUID = 1642124567407092434L;
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
