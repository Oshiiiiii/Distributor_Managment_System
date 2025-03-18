package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;

public class TaxRest implements Serializable {

	private static final long serialVersionUID = -7247887950744379125L;
	private Long id;
	private String taxDescription;
	private Double taxValue;
	private Integer status;

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public String getTaxDescription() {
		return taxDescription;
	}



	public void setTaxDescription(String taxDescription) {
		this.taxDescription = taxDescription;
	}



	public Double getTaxValue() {
		return taxValue;
	}



	public void setTaxValue(Double taxValue) {
		this.taxValue = taxValue;
	}



	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "TaxDTO{" + "id=" + getId() + "'"
				+ ", taxDescription='" + getTaxDescription() + "'" + ", taxValue='" + getTaxValue()
				+ "'" + ", status=" + getStatus() + "}";
	}
}
