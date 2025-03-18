package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A DTO for the {@link com.unique.dms.domain.ProductCategoery} entity.
 */
public class TaxRequest implements Serializable {

	private static final long serialVersionUID = 1491319731823773108L;

	@NotNull
	@Size(max = 100)
	private String taxDescription;

	@NotNull
	@Size(max = 10)
	private String taxValue;

	@NotNull
	@Min(value = 0)
	@Max(value = 1)
	private Integer status;

	public String getTaxDescription() {
		return taxDescription;
	}

	public void setTaxDescription(String taxDescription) {
		this.taxDescription = taxDescription;
	}

	public String getTaxValue() {
		return taxValue;
	}

	public void setTaxValue(String taxValue) {
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
		return "TaxDTO{taxDescription='" + getTaxDescription() + "'" + ", taxValue=" + getTaxValue() + ", status="
				+ getStatus() + "}";
	}
}
