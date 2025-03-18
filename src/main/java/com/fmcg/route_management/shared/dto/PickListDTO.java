package com.fmcg.route_management.shared.dto;

import javax.validation.constraints.*;
import java.io.Serializable;


public class PickListDTO implements Serializable {
    
	private static final long serialVersionUID = -1503425603868765658L;

	private Long id;

    @NotNull
    @Size(max = 25)
    private String picklistNumber;

    @NotNull
    @Size(max = 10)
    private String status;


    private Long vanId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicklistNumber() {
        return picklistNumber;
    }

    public void setPicklistNumber(String picklistNumber) {
        this.picklistNumber = picklistNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getVanId() {
        return vanId;
    }

    public void setVanId(Long vanId) {
        this.vanId = vanId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PickListDTO)) {
            return false;
        }

        return id != null && id.equals(((PickListDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PickListDTO{" +
            "id=" + getId() +
            ", picklistNumber='" + getPicklistNumber() + "'" +
            ", status='" + getStatus() + "'" +
            ", vanId=" + getVanId() +
            "}";
    }
}
