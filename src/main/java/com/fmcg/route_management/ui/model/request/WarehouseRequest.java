package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



/**
 * A DTO for the {@link com.unique.dms.domain.Warehouse} entity.
 */
public class WarehouseRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	@Size(max = 15)
	private String warehouseCode;

	@NotNull
	@Size(max = 25)
	private String warehouseName;

	@Size(max = 250)
	private String description;

	@NotNull
	@Size(max = 50)
	private String address;

	@NotNull
	@Min(value = 0)
	@Max(value = 1)
	private Integer status;

	private Long warehouseTypeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getWarehouseTypeId() {
		return warehouseTypeId;
	}

	public void setWarehouseTypeId(Long warehouseTypeId) {
		this.warehouseTypeId = warehouseTypeId;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "WarehouseDTO{" + "id=" + getId() + ", warehouseCode='" + getWarehouseCode() + "'" + ", warehouseName='"
				+ getWarehouseName() + "'" + ", description='" + getDescription() + "'" + ", address='" + getAddress()
				+ "'" + ", status=" + getStatus() + ", warehouseTypeId=" + getWarehouseTypeId() + "}";
	}
}
