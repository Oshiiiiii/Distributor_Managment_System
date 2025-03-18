package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;

public class UserTypeRest implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String userTypeName;
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "UserTypeDTO{" + "id=" + getId() + ", userTypeName='" + getUserTypeName() + "'" + ", status="
				+ getStatus() + "}";
	}
}
