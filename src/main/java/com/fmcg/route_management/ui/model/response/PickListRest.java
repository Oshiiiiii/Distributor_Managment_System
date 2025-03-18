package com.fmcg.route_management.ui.model.response;

import java.io.Serializable;

public class PickListRest implements Serializable {

	private static final long serialVersionUID = -8558756602040942355L;
	private Long id;
	private String picklistNumber;
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
        return "PickListDTO{ picklistNumber='" + getPicklistNumber() + "'" +
            ", status='" + getStatus() + "'" +
            ", vanId=" + getVanId() +
            "}";
    }
}
