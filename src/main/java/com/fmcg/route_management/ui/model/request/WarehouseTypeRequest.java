package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A DTO for the {@link com.unique.dms.domain.ProductCategoery} entity.
 */
public class WarehouseTypeRequest implements Serializable {
	private static final long serialVersionUID = -5404033106869437258L;

	@NotNull
	@Size(max = 100)
	private String TypeDescription;

	@NotNull
	@Size(max = 15)
	private String TypeName;

	@NotNull
	@Min(value = 0)
	@Max(value = 1)
	private Integer status;

	public String getTypeDescription() {
		return TypeDescription;
	}

	public void setTypeDescription(String typeDescription) {
		TypeDescription = typeDescription;
	}

	public String getTypeName() {
		return TypeName;
	}

	public void setTypeName(String typeName) {
		TypeName = typeName;
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
