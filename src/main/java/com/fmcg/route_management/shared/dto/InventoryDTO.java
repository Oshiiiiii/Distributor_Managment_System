package com.fmcg.route_management.shared.dto;


import java.io.Serializable;

public class InventoryDTO implements Serializable {

	private static final long serialVersionUID = -5164684011004398255L;

	private Long id;
    private Integer availableQty;
    private Double productValueExcluded;
    private Double productValueIncluded;
    private Long productId;
    private Long warehouseId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(Integer availableQty) {
        this.availableQty = availableQty;
    }

    public Double getProductValueExcluded() {
        return productValueExcluded;
    }

    public void setProductValueExcluded(Double productValueExcluded) {
        this.productValueExcluded = productValueExcluded;
    }

    public Double getProductValueIncluded() {
        return productValueIncluded;
    }

    public void setProductValueIncluded(Double productValueIncluded) {
        this.productValueIncluded = productValueIncluded;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InventoryDTO)) {
            return false;
        }

        return id != null && id.equals(((InventoryDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "InventoryDTO{" +
            "id=" + getId() +
            ", availableQty=" + getAvailableQty() +
            ", productValueExcluded=" + getProductValueExcluded() +
            ", productValueIncluded=" + getProductValueIncluded() +
            ", productId=" + getProductId() +
            ", warehouseId=" + getWarehouseId() +
            "}";
    }
}
