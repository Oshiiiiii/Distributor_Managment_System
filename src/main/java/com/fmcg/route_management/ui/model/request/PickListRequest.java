package com.fmcg.route_management.ui.model.request;

import java.io.Serializable;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A DTO for the {@link com.unique.dms.domain.ProductCategoery} entity.
 */
public class PickListRequest implements Serializable {

	private static final long serialVersionUID = -3286218683729768009L;

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
