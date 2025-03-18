package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * A DTO for the {@link com.unique.dms.domain.ProductCategoery} entity.
 */
public class RouteOrderRequest implements Serializable {

	private static final long serialVersionUID = 129899742043500154L;

	private Long id;

	@NotNull
	private Integer orderNo;

	private Long pickListId;

	private Long retailerId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Long getPickListId() {
		return pickListId;
	}

	public void setPickListId(Long pickListId) {
		this.pickListId = pickListId;
	}

	public Long getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(Long retailerId) {
		this.retailerId = retailerId;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "RouteOrderDTO{" + "id=" + getId() + ", orderNo=" + getOrderNo() + ", pickListId=" + getPickListId()
				+ ", retailerId=" + getRetailerId() + "}";
	}
}
