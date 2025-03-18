package com.fmcg.route_management.shared.dto;


import java.io.Serializable;


public class WarehouseTypeDTO implements Serializable {
    
	private static final long serialVersionUID = -820732225879682900L;

	private Long id;
    private String typeName;
    private String typeDescription;
    private Integer status;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WarehouseTypeDTO)) {
            return false;
        }

        return id != null && id.equals(((WarehouseTypeDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "WarehouseTypeDTO{" +
            "id=" + getId() +
            ", typeName='" + getTypeName() + "'" +
            ", typeDescription='" + getTypeDescription() + "'" +
            ", status=" + getStatus() +
            "}";
    }
}
