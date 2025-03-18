package com.fmcg.route_management.shared.dto;


import java.io.Serializable;


public class TaxDTO implements Serializable {

	private static final long serialVersionUID = -7840282424494133797L;

	private Long id;
    private String taxDescription;
    private Double taxValue;
    private Integer status;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaxDescription() {
        return taxDescription;
    }

    public void setTaxDescription(String taxDescription) {
        this.taxDescription = taxDescription;
    }

    public Double getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(Double taxValue) {
        this.taxValue = taxValue;
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
        if (!(o instanceof TaxDTO)) {
            return false;
        }

        return id != null && id.equals(((TaxDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TaxDTO{" +
            "id=" + getId() +
            ", taxDescription='" + getTaxDescription() + "'" +
            ", taxValue=" + getTaxValue() +
            ", status=" + getStatus() +
            "}";
    }
}
