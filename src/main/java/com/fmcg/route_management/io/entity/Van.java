package com.fmcg.route_management.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Van.
 */
@Entity
@Table(name = "van")
public class Van implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 15)
    @Column(name = "van_code", length = 15, nullable = false)
    private String vanCode;

    @NotNull
    @Size(max = 25)
    @Column(name = "van_name", length = 25, nullable = false)
    private String vanName;

    @NotNull
    @Min(value = 0)
    @Max(value = 1)
    @Column(name = "status", nullable = false)
    private Integer status;

    @OneToMany(mappedBy = "van")
    private Set<PickList> pickLists = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "vans", allowSetters = true)
    private Distributor distributor;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVanCode() {
        return vanCode;
    }

    public Van vanCode(String vanCode) {
        this.vanCode = vanCode;
        return this;
    }

    public void setVanCode(String vanCode) {
        this.vanCode = vanCode;
    }

    public String getVanName() {
        return vanName;
    }

    public Van vanName(String vanName) {
        this.vanName = vanName;
        return this;
    }

    public void setVanName(String vanName) {
        this.vanName = vanName;
    }

    public Integer getStatus() {
        return status;
    }

    public Van status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<PickList> getPickLists() {
        return pickLists;
    }

    public Van pickLists(Set<PickList> pickLists) {
        this.pickLists = pickLists;
        return this;
    }

    public Van addPickList(PickList pickList) {
        this.pickLists.add(pickList);
        pickList.setVan(this);
        return this;
    }

    public Van removePickList(PickList pickList) {
        this.pickLists.remove(pickList);
        pickList.setVan(null);
        return this;
    }

    public void setPickLists(Set<PickList> pickLists) {
        this.pickLists = pickLists;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public Van distributor(Distributor distributor) {
        this.distributor = distributor;
        return this;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Van)) {
            return false;
        }
        return id != null && id.equals(((Van) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Van{" +
            "id=" + getId() +
            ", vanCode='" + getVanCode() + "'" +
            ", vanName='" + getVanName() + "'" +
            ", status=" + getStatus() +
            "}";
    }
}
