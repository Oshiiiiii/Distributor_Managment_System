package com.fmcg.route_management.shared.dto;

import java.io.Serializable;


public class SalesOrderLinesDTO implements Serializable {

	private static final long serialVersionUID = 1376643835425696543L;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof SalesOrderLinesDTO)) {
			return false;
		}

		return id != null && id.equals(((SalesOrderLinesDTO) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "SalesOrderLinesDTO{" + "id=" + getId() + ", productQty=" + getProductQty() + ", productId="
				+ getProductId() + ", salesOrderId=" + getSalesOrderId() + "}";
	}
}
