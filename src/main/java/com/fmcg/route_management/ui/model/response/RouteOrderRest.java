package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;

public class RouteOrderRest implements Serializable {

	private static final long serialVersionUID = 7972780255071376780L;
	private Long id;
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
        return "RouteOrderDTO{" +
            "id=" + getId() +
            ", orderNo=" + getOrderNo() +
            ", pickListId=" + getPickListId() +
            ", retailerId=" + getRetailerId() +
            "}";
    }
}
