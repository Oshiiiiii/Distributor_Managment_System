package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;
import javax.validation.constraints.NotNull;


/**
 * A DTO for the {@link com.unique.dms.domain.ProductCategoery} entity.
 */
public class PurchaseReturnLinesRequest implements Serializable {

	

	private static final long serialVersionUID = 1L;

	private Long id;

    @NotNull
    private Integer productReturnQty;


    private Long productId;

    private Long purchaseReturnId;

	
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


	public Long getPurchaseReturnId() {
		return purchaseReturnId;
	}


	public void setPurchaseReturnId(Long purchaseReturnId) {
		this.purchaseReturnId = purchaseReturnId;
	}


	   // prettier-ignore
    @Override
    public String toString() {
        return "PurchaseReturnLinesDTO{" +
            "id=" + getId() +
            ", productReturnQty=" + getProductReturnQty() +
            ", productId=" + getProductId() +
            ", purchaseReturnId=" + getPurchaseReturnId() +
            "}";
    }
}

