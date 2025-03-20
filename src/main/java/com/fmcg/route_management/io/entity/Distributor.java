package com.fmcg.route_management.io.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "distributor")
public class Distributor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(max = 15)
	@Column(name = "distributor_code", length = 15, nullable = false)
	private String distributorCode;

	@NotNull
	@Size(max = 25)
	@Column(name = "distributor_name", length = 25, nullable = false)
	private String distributorName;

	@NotNull
	@Size(max = 50)
	@Column(name = "address", length = 50, nullable = false)
	private String address;

	@Column(name = "contact_number")
	private Integer contactNumber;

	@NotNull
	@Min(value = 0)
	@Max(value = 1)
	@Column(name = "tax_status", nullable = false)
	private Integer taxStatus;

	@Column(name = "vat_number")
	private String vatNumber;

	@NotNull
	@Min(value = 0)
	@Max(value = 1)
	@Column(name = "status", nullable = false)
	private Integer status;

	@OneToMany(mappedBy = "distributor")
	private Set<User> users = new HashSet<>();

	@OneToMany(mappedBy = "distributor")
	private Set<SalesPerson> salespeople = new HashSet<>();

	@OneToMany(mappedBy = "distributor")
	private Set<Van> vans = new HashSet<>();

	@OneToMany(mappedBy = "distributor")
	private Set<Retailer> retailers = new HashSet<>();

	@OneToMany(mappedBy = "distributor")
	private Set<PurchaseOrder> PurchaseOrders = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDistributorCode() {
		return distributorCode;
	}

	public Distributor distributorCode(String distributorCode) {
		this.distributorCode = distributorCode;
		return this;
	}

	public void setDistributorCode(String distributorCode) {
		this.distributorCode = distributorCode;
	}

	public String getDistributorName() {
		return distributorName;
	}

	public Distributor distributorName(String distributorName) {
		this.distributorName = distributorName;
		return this;
	}

	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}

	public String getAddress() {
		return address;
	}

	public Distributor address(String address) {
		this.address = address;
		return this;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getContactNumber() {
		return contactNumber;
	}

	public Distributor contactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
		return this;
	}

	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Integer getTaxStatus() {
		return taxStatus;
	}

	public Distributor taxStatus(Integer taxStatus) {
		this.taxStatus = taxStatus;
		return this;
	}

	public void setTaxStatus(Integer taxStatus) {
		this.taxStatus = taxStatus;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public Distributor vatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
		return this;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public Integer getStatus() {
		return status;
	}

	public Distributor status(Integer status) {
		this.status = status;
		return this;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set<User> getUsers() {
		return users;
	}

	public Distributor users(Set<User> users) {
		this.users = users;
		return this;
	}

	public Distributor addUser(User user) {
		this.users.add(user);
		user.setDistributor(this);
		return this;
	}

	public Distributor removeUser(User user) {
		this.users.remove(user);
		user.setDistributor(null);
		return this;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<SalesPerson> getSalespeople() {
		return salespeople;
	}

	public Distributor salespeople(Set<SalesPerson> salespeople) {
		this.salespeople = salespeople;
		return this;
	}

	public Distributor addSalesPerson(SalesPerson SalesPerson) {
		this.salespeople.add(SalesPerson);
		SalesPerson.setDistributor(this);
		return this;
	}

	public Distributor removeSalesPerson(SalesPerson SalesPerson) {
		this.salespeople.remove(SalesPerson);
		SalesPerson.setDistributor(null);
		return this;
	}

	public void setSalespeople(Set<SalesPerson> salespeople) {
		this.salespeople = salespeople;
	}

	public Set<Van> getVans() {
		return vans;
	}

	public Distributor vans(Set<Van> vans) {
		this.vans = vans;
		return this;
	}

	public Distributor addVan(Van van) {
		this.vans.add(van);
		van.setDistributor(this);
		return this;
	}

	public Distributor removeVan(Van van) {
		this.vans.remove(van);
		van.setDistributor(null);
		return this;
	}

	public void setVans(Set<Van> vans) {
		this.vans = vans;
	}

	public Set<Retailer> getRetailers() {
		return retailers;
	}

	public Distributor retailers(Set<Retailer> retailers) {
		this.retailers = retailers;
		return this;
	}

	public Distributor addRetailer(Retailer retailer) {
		this.retailers.add(retailer);
		retailer.setDistributor(this);
		return this;
	}

	public Distributor removeRetailer(Retailer retailer) {
		this.retailers.remove(retailer);
		retailer.setDistributor(null);
		return this;
	}

	public void setRetailers(Set<Retailer> retailers) {
		this.retailers = retailers;
	}

	public Set<PurchaseOrder> getPurchaseOrders() {
		return PurchaseOrders;
	}

	public Distributor PurchaseOrders(Set<PurchaseOrder> PurchaseOrders) {
		this.PurchaseOrders = PurchaseOrders;
		return this;
	}

	public Distributor addPurchaseOrder(PurchaseOrder PurchaseOrder) {
		this.PurchaseOrders.add(PurchaseOrder);
		PurchaseOrder.setDistributor(this);
		return this;
	}

	public Distributor removePurchaseOrder(PurchaseOrder PurchaseOrder) {
		this.PurchaseOrders.remove(PurchaseOrder);
		PurchaseOrder.setDistributor(null);
		return this;
	}

	public void setPurchaseOrders(Set<PurchaseOrder> PurchaseOrders) {
		this.PurchaseOrders = PurchaseOrders;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Distributor)) {
			return false;
		}
		return id != null && id.equals(((Distributor) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "Distributor{" + "id=" + getId() + ", distributorCode='" + getDistributorCode() + "'"
				+ ", distributorName='" + getDistributorName() + "'" + ", address='" + getAddress() + "'"
				+ ", contactNumber=" + getContactNumber() + ", taxStatus=" + getTaxStatus() + ", vatNumber='"
				+ getVatNumber() + "'" + ", status=" + getStatus() + "}";
	}
}
