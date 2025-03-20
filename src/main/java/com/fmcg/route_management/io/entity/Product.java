package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Product.
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 15)
    @Column(name = "product_code", length = 15, nullable = false)
    private String productCode;

    @NotNull
    @Size(max = 25)
    @Column(name = "product_name", length = 25, nullable = false)
    private String productName;

    @NotNull
    @Column(name = "tax_value", nullable = false)
    private Double taxValue;

    @Size(max = 250)
    @Column(name = "description", length = 250)
    private String description;

    @NotNull
    @Column(name = "primary_price", nullable = false)
    private Double primaryPrice;

    @NotNull
    @Column(name = "retailer_price", nullable = false)
    private Double retailerPrice;

    @NotNull
    @Column(name = "consumer_price", nullable = false)
    private Double consumerPrice;

    @NotNull
    @Min(value = 0)
    @Max(value = 1)
    @Column(name = "status", nullable = false)
    private Integer status;

    @OneToMany(mappedBy = "product")
    private Set<Inventory> inventories = new HashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<PurchaseOrderLines> purchaseOrderLines = new HashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<PurchaseInvoiceLines> purchaseInvoiceLines = new HashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<PurchaseReturnLines> purchaseReturnLines = new HashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<GoodReceivedNoteLines> goodReceivedNoteLines = new HashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<SalesOrderLines> salesOrderLines = new HashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<SalesInvoiceLines> salesInvoiceLines = new HashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<SalesReturnLines> salesReturnLines = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "products", allowSetters = true)
    private Tax tax;

    @ManyToOne
    @JsonIgnoreProperties(value = "products", allowSetters = true)
    private ProductCategoery productCategoery;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public Product productCode(String productCode) {
        this.productCode = productCode;
        return this;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public Product productName(String productName) {
        this.productName = productName;
        return this;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getTaxValue() {
        return taxValue;
    }

    public Product taxValue(Double taxValue) {
        this.taxValue = taxValue;
        return this;
    }

    public void setTaxValue(Double taxValue) {
        this.taxValue = taxValue;
    }

    public String getDescription() {
        return description;
    }

    public Product description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrimaryPrice() {
        return primaryPrice;
    }

    public Product primaryPrice(Double primaryPrice) {
        this.primaryPrice = primaryPrice;
        return this;
    }

    public void setPrimaryPrice(Double primaryPrice) {
        this.primaryPrice = primaryPrice;
    }

    public Double getRetailerPrice() {
        return retailerPrice;
    }

    public Product retailerPrice(Double retailerPrice) {
        this.retailerPrice = retailerPrice;
        return this;
    }

    public void setRetailerPrice(Double retailerPrice) {
        this.retailerPrice = retailerPrice;
    }

    public Double getConsumerPrice() {
        return consumerPrice;
    }

    public Product consumerPrice(Double consumerPrice) {
        this.consumerPrice = consumerPrice;
        return this;
    }

    public void setConsumerPrice(Double consumerPrice) {
        this.consumerPrice = consumerPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public Product status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<Inventory> getInventories() {
        return inventories;
    }

    public Product inventories(Set<Inventory> inventories) {
        this.inventories = inventories;
        return this;
    }

    public Product addInventory(Inventory inventory) {
        this.inventories.add(inventory);
        inventory.setProduct(this);
        return this;
    }

    public Product removeInventory(Inventory inventory) {
        this.inventories.remove(inventory);
        inventory.setProduct(null);
        return this;
    }

    public void setInventories(Set<Inventory> inventories) {
        this.inventories = inventories;
    }

    public Set<PurchaseOrderLines> getPurchaseOrderLines() {
        return purchaseOrderLines;
    }

    public Product purchaseOrderLines(Set<PurchaseOrderLines> purchaseOrderLines) {
        this.purchaseOrderLines = purchaseOrderLines;
        return this;
    }

    public Product addPurchaseOrderLine(PurchaseOrderLines purchaseOrderLine) {
        this.purchaseOrderLines.add(purchaseOrderLine);
        purchaseOrderLine.setProduct(this);
        return this;
    }

    public Product removePurchaseOrderLine(PurchaseOrderLines purchaseOrderLine) {
        this.purchaseOrderLines.remove(purchaseOrderLine);
        purchaseOrderLine.setProduct(null);
        return this;
    }

    public void setPurchaseOrderLines(Set<PurchaseOrderLines> purchaseOrderLines) {
        this.purchaseOrderLines = purchaseOrderLines;
    }

    public Set<PurchaseInvoiceLines> getPurchaseInvoiceLines() {
        return purchaseInvoiceLines;
    }

    public Product purchaseInvoiceLines(Set<PurchaseInvoiceLines> purchaseInvoiceLines) {
        this.purchaseInvoiceLines = purchaseInvoiceLines;
        return this;
    }

    public Product addPurchaseInvoiceLines(PurchaseInvoiceLines purchaseInvoiceLines) {
        this.purchaseInvoiceLines.add(purchaseInvoiceLines);
        purchaseInvoiceLines.setProduct(this);
        return this;
    }

    public Product removePurchaseInvoiceLines(PurchaseInvoiceLines purchaseInvoiceLines) {
        this.purchaseInvoiceLines.remove(purchaseInvoiceLines);
        purchaseInvoiceLines.setProduct(null);
        return this;
    }

    public void setPurchaseInvoiceLines(Set<PurchaseInvoiceLines> purchaseInvoiceLines) {
        this.purchaseInvoiceLines = purchaseInvoiceLines;
    }

    public Set<PurchaseReturnLines> getPurchaseReturnLines() {
        return purchaseReturnLines;
    }

    public Product purchaseReturnLines(Set<PurchaseReturnLines> purchaseReturnLines) {
        this.purchaseReturnLines = purchaseReturnLines;
        return this;
    }

    public Product addPurchaseReturnLines(PurchaseReturnLines purchaseReturnLines) {
        this.purchaseReturnLines.add(purchaseReturnLines);
        purchaseReturnLines.setProduct(this);
        return this;
    }

    public Product removePurchaseReturnLines(PurchaseReturnLines purchaseReturnLines) {
        this.purchaseReturnLines.remove(purchaseReturnLines);
        purchaseReturnLines.setProduct(null);
        return this;
    }

    public void setPurchaseReturnLines(Set<PurchaseReturnLines> purchaseReturnLines) {
        this.purchaseReturnLines = purchaseReturnLines;
    }

    public Set<GoodReceivedNoteLines> getGoodReceivedNoteLines() {
        return goodReceivedNoteLines;
    }

    public Product goodReceivedNoteLines(Set<GoodReceivedNoteLines> goodReceivedNoteLines) {
        this.goodReceivedNoteLines = goodReceivedNoteLines;
        return this;
    }

    public Product addGoodReceivedNoteLines(GoodReceivedNoteLines goodReceivedNoteLines) {
        this.goodReceivedNoteLines.add(goodReceivedNoteLines);
        goodReceivedNoteLines.setProduct(this);
        return this;
    }

    public Product removeGoodReceivedNoteLines(GoodReceivedNoteLines goodReceivedNoteLines) {
        this.goodReceivedNoteLines.remove(goodReceivedNoteLines);
        goodReceivedNoteLines.setProduct(null);
        return this;
    }

    public void setGoodReceivedNoteLines(Set<GoodReceivedNoteLines> goodReceivedNoteLines) {
        this.goodReceivedNoteLines = goodReceivedNoteLines;
    }

    public Set<SalesOrderLines> getSalesOrderLines() {
        return salesOrderLines;
    }

    public Product salesOrderLines(Set<SalesOrderLines> salesOrderLines) {
        this.salesOrderLines = salesOrderLines;
        return this;
    }

    public Product addSalesOrderLines(SalesOrderLines salesOrderLines) {
        this.salesOrderLines.add(salesOrderLines);
        salesOrderLines.setProduct(this);
        return this;
    }

    public Product removeSalesOrderLines(SalesOrderLines salesOrderLines) {
        this.salesOrderLines.remove(salesOrderLines);
        salesOrderLines.setProduct(null);
        return this;
    }

    public void setSalesOrderLines(Set<SalesOrderLines> salesOrderLines) {
        this.salesOrderLines = salesOrderLines;
    }

    public Set<SalesInvoiceLines> getSalesInvoiceLines() {
        return salesInvoiceLines;
    }

    public Product salesInvoiceLines(Set<SalesInvoiceLines> salesInvoiceLines) {
        this.salesInvoiceLines = salesInvoiceLines;
        return this;
    }

    public Product addSalesInvoiceLines(SalesInvoiceLines salesInvoiceLines) {
        this.salesInvoiceLines.add(salesInvoiceLines);
        salesInvoiceLines.setProduct(this);
        return this;
    }

    public Product removeSalesInvoiceLines(SalesInvoiceLines salesInvoiceLines) {
        this.salesInvoiceLines.remove(salesInvoiceLines);
        salesInvoiceLines.setProduct(null);
        return this;
    }

    public void setSalesInvoiceLines(Set<SalesInvoiceLines> salesInvoiceLines) {
        this.salesInvoiceLines = salesInvoiceLines;
    }

    public Set<SalesReturnLines> getSalesReturnLines() {
        return salesReturnLines;
    }

    public Product salesReturnLines(Set<SalesReturnLines> salesReturnLines) {
        this.salesReturnLines = salesReturnLines;
        return this;
    }

    public Product addSalesReturnLines(SalesReturnLines salesReturnLines) {
        this.salesReturnLines.add(salesReturnLines);
        salesReturnLines.setProduct(this);
        return this;
    }

    public Product removeSalesReturnLines(SalesReturnLines salesReturnLines) {
        this.salesReturnLines.remove(salesReturnLines);
        salesReturnLines.setProduct(null);
        return this;
    }

    public void setSalesReturnLines(Set<SalesReturnLines> salesReturnLines) {
        this.salesReturnLines = salesReturnLines;
    }

    public Tax getTax() {
        return tax;
    }

    public Product tax(Tax tax) {
        this.tax = tax;
        return this;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public ProductCategoery getProductCategoery() {
        return productCategoery;
    }

    public Product productCategoery(ProductCategoery productCategoery) {
        this.productCategoery = productCategoery;
        return this;
    }

    public void setProductCategoery(ProductCategoery productCategoery) {
        this.productCategoery = productCategoery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        return id != null && id.equals(((Product) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Product{" +
            "id=" + getId() +
            ", productCode='" + getProductCode() + "'" +
            ", productName='" + getProductName() + "'" +
            ", taxValue=" + getTaxValue() +
            ", description='" + getDescription() + "'" +
            ", primaryPrice=" + getPrimaryPrice() +
            ", retailerPrice=" + getRetailerPrice() +
            ", consumerPrice=" + getConsumerPrice() +
            ", status=" + getStatus() +
            "}";
    }
}
