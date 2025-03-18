package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * A DTO for the {@link com.unique.dms.domain.ProductCategoery} entity.
 */
public class GoodReceivedNoteLinesRequest implements Serializable {


	private static final long serialVersionUID = 1L;

	private Long id;

    @NotNull
    private Integer productGrnQty;

    private Integer productDifferenceQty;

    @Size(max = 10)
    private String reason;


    private Long productId;

    private Long goodReceivedNoteId;

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getProductGrnQty() {
		return productGrnQty;
	}


	public void setProductGrnQty(Integer productGrnQty) {
		this.productGrnQty = productGrnQty;
	}


	public Integer getProductDifferenceQty() {
		return productDifferenceQty;
	}


	public void setProductDifferenceQty(Integer productDifferenceQty) {
		this.productDifferenceQty = productDifferenceQty;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public Long getGoodReceivedNoteId() {
		return goodReceivedNoteId;
	}


	public void setGoodReceivedNoteId(Long goodReceivedNoteId) {
		this.goodReceivedNoteId = goodReceivedNoteId;
	}


    // prettier-ignore
    @Override
    public String toString() {
        return "GoodReceivedNoteLinesDTO{" +
            "id=" + getId() +
            ", productGrnQty=" + getProductGrnQty() +
            ", productDifferenceQty=" + getProductDifferenceQty() +
            ", reason='" + getReason() + "'" +
            ", productId=" + getProductId() +
            ", goodReceivedNoteId=" + getGoodReceivedNoteId() +
            "}";
    }}

