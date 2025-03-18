package com.fmcg.route_management.shared.dto;


import java.io.Serializable;


public class RouteOrderDTO implements Serializable {

	private static final long serialVersionUID = -7485052348112495432L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RouteOrderDTO)) {
            return false;
        }

        return id != null && id.equals(((RouteOrderDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
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
