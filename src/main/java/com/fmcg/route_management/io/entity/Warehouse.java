package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Wharehouse.
 */
@Entity
@Table(name = "Wharehouse")
public class Warehouse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(max = 15)
	@Column(name = "warehouse_code", length = 15, nullable = false)
	private String warehouseCode;

	@NotNull
	@Size(max = 25)
	@Column(name = "warehouse_name", length = 25, nullable = false)
	private String warehouseName;

	@Size(max = 250)
	@Column(name = "description", length = 250)
	private String description;

	@NotNull
	@Size(max = 50)
	@Column(name = "address", length = 50, nullable = false)
	private String address;

	@NotNull
	@Min(value = 0)
	@Max(value = 1)
	@Column(name = "status", nullable = false)
	private Integer status;

	@OneToMany(mappedBy = "warehouse")
	private Set<Inventory> inventories = new HashSet<>();

	@ManyToOne
	@JsonIgnoreProperties(value = "warehouses", allowSetters = true)
	private WarehouseType warehouseType;

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

	public Set<Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(Set<Inventory> inventories) {
		this.inventories = inventories;
	}

	public WarehouseType getWarehouseType() {
		return warehouseType;
	}

	public void setWarehouseType(WarehouseType warehouseType) {
		this.warehouseType = warehouseType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Warehouse)) {
			return false;
		}
		return id != null && id.equals(((Warehouse) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "Warehouse{" + "id=" + getId() + ", warehouseCode='" + getWarehouseCode() + "'" + ", warehouseName='"
				+ getWarehouseName() + "'" + ", description='" + getDescription() + "'" + ", address='" + getAddress()
				+ "'" + ", status=" + getStatus() + "}";
	}
}
