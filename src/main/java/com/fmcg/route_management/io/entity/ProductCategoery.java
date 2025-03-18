package com.fmcg.route_management.io.entity;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A ProductCategoery.
 */
@Entity
@Table(name = "product_categoery")
public class ProductCategoery implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 20)
    @Column(name = "product_category_code", length = 20, nullable = false)
    private String productCategoryCode;

    @NotNull
    @Size(max = 25)
    @Column(name = "product_category_name", length = 25, nullable = false)
    private String productCategoryName;

    @NotNull
    @Size(max = 250)
    @Column(name = "description", length = 250, nullable = false)
    private String description;

    @NotNull
    @Min(value = 0)
    @Max(value = 1)
    @Column(name = "status", nullable = false)
    private Integer status;

    @OneToMany(mappedBy = "productCategoery")
    private Set<Product> products = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCategoryCode() {
        return productCategoryCode;
    }

    public ProductCategoery productCategoryCode(String productCategoryCode) {
        this.productCategoryCode = productCategoryCode;
        return this;
    }

    public void setProductCategoryCode(String productCategoryCode) {
        this.productCategoryCode = productCategoryCode;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public ProductCategoery productCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
        return this;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getDescription() {
        return description;
    }

    public ProductCategoery description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public ProductCategoery status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public ProductCategoery products(Set<Product> products) {
        this.products = products;
        return this;
    }

    public ProductCategoery addProduct(Product product) {
        this.products.add(product);
        product.setProductCategoery(this);
        return this;
    }

    public ProductCategoery removeProduct(Product product) {
        this.products.remove(product);
        product.setProductCategoery(null);
        return this;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductCategoery)) {
            return false;
        }
        return id != null && id.equals(((ProductCategoery) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductCategoery{" +
            "id=" + getId() +
            ", productCategoryCode='" + getProductCategoryCode() + "'" +
            ", productCategoryName='" + getProductCategoryName() + "'" +
            ", description='" + getDescription() + "'" +
            ", status=" + getStatus() +
            "}";
    }
}
