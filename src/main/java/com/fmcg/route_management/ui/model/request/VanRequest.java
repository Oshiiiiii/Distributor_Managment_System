package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * A DTO for the {@link com.unique.dms.domain.ProductCategoery} entity.
 */
public class VanRequest implements Serializable {

	private static final long serialVersionUID = 7948154667984382101L;

	@NotNull
	@Size(max = 15)
	private String vanCode;

	@NotNull
	@Size(max = 25)
	private String vanName;

	@NotNull
	@Min(value = 0)
	@Max(value = 1)
	private Integer status;

	private Long distributorId;

	public String getVanCode() {
		return vanCode;
	}

	public void setVanCode(String vanCode) {
		this.vanCode = vanCode;
	}

	public String getVanName() {
		return vanName;
	}

	public void setVanName(String vanName) {
		this.vanName = vanName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "VanDTO{vanCode='" + getVanCode() + "'" + ", vanName='" + getVanName() + "'" + ", status=" + getStatus()
				+ ", distributorId=" + getDistributorId() + "}";
	}
}
