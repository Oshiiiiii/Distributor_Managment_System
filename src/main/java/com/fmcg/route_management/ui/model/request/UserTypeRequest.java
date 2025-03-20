package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



/**
 * A DTO for the {@link com.unique.dms.domain.ProductCategoery} entity.
 */
public class UserTypeRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	@Size(max = 50)
	private String userTypeName;

	@NotNull
	@Min(value = 0)
	@Max(value = 1)
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
