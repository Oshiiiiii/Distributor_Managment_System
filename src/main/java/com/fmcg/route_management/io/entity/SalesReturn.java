package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A SalesReturn.
 */
@Entity
@Table(name = "sales_return")
public class SalesReturn implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(max = 15)
	@Column(name = "sr_number", length = 15, nullable = false)
	private String srNumber;

	@NotNull
	@Column(name = "sr_date", nullable = false)
	private LocalDate srDate;

	@NotNull
	@Column(name = "total_return_value_exluded", nullable = false)
	private Double totalReturnValueExluded;

	@NotNull
	@Column(name = "total_return_value_included", nullable = false)
	private Double totalReturnValueIncluded;

	@Size(max = 150)
	@Column(name = "remarks", length = 150)
	private String remarks;

	@NotNull
	@Size(max = 10)
	@Column(name = "status", length = 10, nullable = false)
	private String status;

	@OneToMany(mappedBy = "salesReturn")
	private Set<SalesReturnLines> salesReturnLines = new HashSet<>();

	@ManyToOne
	@JsonIgnoreProperties(value = "salesReturns", allowSetters = true)
	private SalesInvoice salesInvoice;

	// jhipster-needle-entity-add-field - JHipster will add fields here
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSrNumber() {
		return srNumber;
	}

	public SalesReturn srNumber(String srNumber) {
		this.srNumber = srNumber;
		return this;
	}

	public void setSrNumber(String srNumber) {
		this.srNumber = srNumber;
	}

	public LocalDate getSrDate() {
		return srDate;
	}

	public SalesReturn srDate(LocalDate srDate) {
		this.srDate = srDate;
		return this;
	}

	public void setSrDate(LocalDate srDate) {
		this.srDate = srDate;
	}

	public Double getTotalReturnValueExluded() {
		return totalReturnValueExluded;
	}

	public SalesReturn totalReturnValueExluded(Double totalReturnValueExluded) {
		this.totalReturnValueExluded = totalReturnValueExluded;
		return this;
	}

	public void setTotalReturnValueExluded(Double totalReturnValueExluded) {
		this.totalReturnValueExluded = totalReturnValueExluded;
	}

	public Double getTotalReturnValueIncluded() {
		return totalReturnValueIncluded;
	}

	public SalesReturn totalReturnValueIncluded(Double totalReturnValueIncluded) {
		this.totalReturnValueIncluded = totalReturnValueIncluded;
		return this;
	}

	public void setTotalReturnValueIncluded(Double totalReturnValueIncluded) {
		this.totalReturnValueIncluded = totalReturnValueIncluded;
	}

	public String getRemarks() {
		return remarks;
	}

	public SalesReturn remarks(String remarks) {
		this.remarks = remarks;
		return this;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		return status;
	}

	public SalesReturn status(String status) {
		this.status = status;
		return this;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<SalesReturnLines> getSalesReturnLines() {
		return salesReturnLines;
	}

	public SalesReturn salesReturnLines(Set<SalesReturnLines> salesReturnLines) {
		this.salesReturnLines = salesReturnLines;
		return this;
	}

	public SalesReturn addSalesReturnLines(SalesReturnLines salesReturnLines) {
		this.salesReturnLines.add(salesReturnLines);
		salesReturnLines.setSalesReturn(this);
		return this;
	}

	public SalesReturn removeSalesReturnLines(SalesReturnLines salesReturnLines) {
		this.salesReturnLines.remove(salesReturnLines);
		salesReturnLines.setSalesReturn(null);
		return this;
	}

	public void setSalesReturnLines(Set<SalesReturnLines> salesReturnLines) {
		this.salesReturnLines = salesReturnLines;
	}

	public SalesInvoice getSalesInvoice() {
		return salesInvoice;
	}

	public SalesReturn salesInvoice(SalesInvoice salesInvoice) {
		this.salesInvoice = salesInvoice;
		return this;
	}

	public void setSalesInvoice(SalesInvoice salesInvoice) {
		this.salesInvoice = salesInvoice;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof SalesReturn)) {
			return false;
		}
		return id != null && id.equals(((SalesReturn) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "SalesReturn{" + "id=" + getId() + ", srNumber='" + getSrNumber() + "'" + ", srDate='" + getSrDate()
				+ "'" + ", totalReturnValueExluded=" + getTotalReturnValueExluded() + ", totalReturnValueIncluded="
				+ getTotalReturnValueIncluded() + ", remarks='" + getRemarks() + "'" + ", status='" + getStatus() + "'"
				+ "}";
	}
}
