package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;

public class WarehouseTypeRest implements Serializable {

	private static final long serialVersionUID = 4482587116127175279L;
	private Long id;
	private String typeDescription;
	private String typeName;
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeDescription() {
		return typeDescription;
	}

	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "WarehouseTypeDTO{" + ", typeDescription='" + getTypeDescription() + "'" + ", typeName='" + getTypeName()
				+ "'" + ", status=" + getStatus() + "}";
	}
}
