package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;

public class VanRest implements Serializable {

	private static final long serialVersionUID = 1483469380107221701L;
	private Long id;
	private String vanCode;
	private String vanName;
	private Integer status;
	private Long distributorId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		return "VanDTO{" + "id=" + getId() + ", vanCode='" + getVanCode() + "'" + ", vanName='" + getVanName() + "'"
				+ ", status=" + getStatus() + ", distributorId=" + getDistributorId() + "}";
	}
}
