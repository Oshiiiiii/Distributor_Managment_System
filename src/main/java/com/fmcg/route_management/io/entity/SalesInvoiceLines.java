package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A SalesInvoiceLines.
 */
@Entity
@Table(name = "sales_invoice_lines")
public class SalesInvoiceLines implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "product_invoice_qty", nullable = false)
	private Integer productInvoiceQty;

	@ManyToOne
	@JsonIgnoreProperties(value = "salesInvoiceLines", allowSetters = true)
	private Product product;

	@ManyToOne
	@JsonIgnoreProperties(value = "salesInvoiceLines", allowSetters = true)
	private SalesInvoice salesInvoice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getProductInvoiceQty() {
		return productInvoiceQty;
	}

	public SalesInvoiceLines productInvoiceQty(Integer productInvoiceQty) {
		this.productInvoiceQty = productInvoiceQty;
		return this;
	}

	public void setProductInvoiceQty(Integer productInvoiceQty) {
		this.productInvoiceQty = productInvoiceQty;
	}

	public Product getProduct() {
		return product;
	}

	public SalesInvoiceLines product(Product product) {
		this.product = product;
		return this;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public SalesInvoice getSalesInvoice() {
		return salesInvoice;
	}

	public SalesInvoiceLines salesInvoice(SalesInvoice salesInvoice) {
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
		if (!(o instanceof SalesInvoiceLines)) {
			return false;
		}
		return id != null && id.equals(((SalesInvoiceLines) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "SalesInvoiceLines{" + "id=" + getId() + ", productInvoiceQty=" + getProductInvoiceQty() + "}";
	}
}
