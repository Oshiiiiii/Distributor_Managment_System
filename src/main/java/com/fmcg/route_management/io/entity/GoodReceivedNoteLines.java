package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;

/**
 * A GoodReceivedNoteLines.
 */
@Entity
@Table(name = "good_received_note_lines")
public class GoodReceivedNoteLines implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "product_grn_qty", nullable = false)
    private Integer productGrnQty;

    @Column(name = "product_difference_qty")
    private Integer productDifferenceQty;

    @Size(max = 10)
    @Column(name = "reason", length = 10)
    private String reason;

    @ManyToOne
    @JsonIgnoreProperties(value = "goodReceivedNoteLines", allowSetters = true)
    private Product product;

    @ManyToOne
    @JsonIgnoreProperties(value = "goodReceivedNoteLines", allowSetters = true)
    private GoodReceivedNote goodReceivedNote;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductGrnQty() {
        return productGrnQty;
    }

    public GoodReceivedNoteLines productGrnQty(Integer productGrnQty) {
        this.productGrnQty = productGrnQty;
        return this;
    }

    public void setProductGrnQty(Integer productGrnQty) {
        this.productGrnQty = productGrnQty;
    }

    public Integer getProductDifferenceQty() {
        return productDifferenceQty;
    }

    public GoodReceivedNoteLines productDifferenceQty(Integer productDifferenceQty) {
        this.productDifferenceQty = productDifferenceQty;
        return this;
    }

    public void setProductDifferenceQty(Integer productDifferenceQty) {
        this.productDifferenceQty = productDifferenceQty;
    }

    public String getReason() {
        return reason;
    }

    public GoodReceivedNoteLines reason(String reason) {
        this.reason = reason;
        return this;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Product getProduct() {
        return product;
    }

    public GoodReceivedNoteLines product(Product product) {
        this.product = product;
        return this;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public GoodReceivedNote getGoodReceivedNote() {
        return goodReceivedNote;
    }

    public GoodReceivedNoteLines goodReceivedNote(GoodReceivedNote goodReceivedNote) {
        this.goodReceivedNote = goodReceivedNote;
        return this;
    }

    public void setGoodReceivedNote(GoodReceivedNote goodReceivedNote) {
        this.goodReceivedNote = goodReceivedNote;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GoodReceivedNoteLines)) {
            return false;
        }
        return id != null && id.equals(((GoodReceivedNoteLines) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GoodReceivedNoteLines{" +
            "id=" + getId() +
            ", productGrnQty=" + getProductGrnQty() +
            ", productDifferenceQty=" + getProductDifferenceQty() +
            ", reason='" + getReason() + "'" +
            "}";
    }
}
