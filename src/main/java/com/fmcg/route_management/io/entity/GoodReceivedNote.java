package com.fmcg.route_management.io.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A GoodReceivedNote.
 */
@Entity
@Table(name = "good_received_note")
public class GoodReceivedNote implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 15)
    @Column(name = "grn_number", length = 15, nullable = false)
    private String grnNumber;

    @NotNull
    @Column(name = "grn_date", nullable = false)
    private LocalDate grnDate;

    @NotNull
    @Column(name = "total_value_exluded", nullable = false)
    private Double totalValueExluded;

    @NotNull
    @Column(name = "total_value_included", nullable = false)
    private Double totalValueIncluded;

    @Size(max = 150)
    @Column(name = "remarks", length = 150)
    private String remarks;

    @NotNull
    @Size(max = 10)
    @Column(name = "status", length = 10, nullable = false)
    private String status;

    @OneToOne
    @JoinColumn(unique = true)
    private PurchaseInvoice purchaseInvoice;

    @OneToMany(mappedBy = "goodReceivedNote")
    private Set<GoodReceivedNoteLines> goodReceivedNoteLines = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrnNumber() {
        return grnNumber;
    }

    public GoodReceivedNote grnNumber(String grnNumber) {
        this.grnNumber = grnNumber;
        return this;
    }

    public void setGrnNumber(String grnNumber) {
        this.grnNumber = grnNumber;
    }

    public LocalDate getGrnDate() {
        return grnDate;
    }

    public GoodReceivedNote grnDate(LocalDate grnDate) {
        this.grnDate = grnDate;
        return this;
    }

    public void setGrnDate(LocalDate grnDate) {
        this.grnDate = grnDate;
    }

    public Double getTotalValueExluded() {
        return totalValueExluded;
    }

    public GoodReceivedNote totalValueExluded(Double totalValueExluded) {
        this.totalValueExluded = totalValueExluded;
        return this;
    }

    public void setTotalValueExluded(Double totalValueExluded) {
        this.totalValueExluded = totalValueExluded;
    }

    public Double getTotalValueIncluded() {
        return totalValueIncluded;
    }

    public GoodReceivedNote totalValueIncluded(Double totalValueIncluded) {
        this.totalValueIncluded = totalValueIncluded;
        return this;
    }

    public void setTotalValueIncluded(Double totalValueIncluded) {
        this.totalValueIncluded = totalValueIncluded;
    }

    public String getRemarks() {
        return remarks;
    }

    public GoodReceivedNote remarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public GoodReceivedNote status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PurchaseInvoice getPurchaseInvoice() {
        return purchaseInvoice;
    }

    public GoodReceivedNote purchaseInvoice(PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice;
        return this;
    }

    public void setPurchaseInvoice(PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice;
    }

    public Set<GoodReceivedNoteLines> getGoodReceivedNoteLines() {
        return goodReceivedNoteLines;
    }

    public GoodReceivedNote goodReceivedNoteLines(Set<GoodReceivedNoteLines> goodReceivedNoteLines) {
        this.goodReceivedNoteLines = goodReceivedNoteLines;
        return this;
    }

    public GoodReceivedNote addGoodReceivedNoteLines(GoodReceivedNoteLines goodReceivedNoteLines) {
        this.goodReceivedNoteLines.add(goodReceivedNoteLines);
        goodReceivedNoteLines.setGoodReceivedNote(this);
        return this;
    }

    public GoodReceivedNote removeGoodReceivedNoteLines(GoodReceivedNoteLines goodReceivedNoteLines) {
        this.goodReceivedNoteLines.remove(goodReceivedNoteLines);
        goodReceivedNoteLines.setGoodReceivedNote(null);
        return this;
    }

    public void setGoodReceivedNoteLines(Set<GoodReceivedNoteLines> goodReceivedNoteLines) {
        this.goodReceivedNoteLines = goodReceivedNoteLines;
    }
 

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GoodReceivedNote)) {
            return false;
        }
        return id != null && id.equals(((GoodReceivedNote) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GoodReceivedNote{" +
            "id=" + getId() +
            ", grnNumber='" + getGrnNumber() + "'" +
            ", grnDate='" + getGrnDate() + "'" +
            ", totalValueExluded=" + getTotalValueExluded() +
            ", totalValueIncluded=" + getTotalValueIncluded() +
            ", remarks='" + getRemarks() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
