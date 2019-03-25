package com.chainsys.realestate.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="RL_EST_LAND")
public class Land {

	@Id
	@Column(name="land_id",nullable=false,updatable=false)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="land_id_seq")
	private int id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private Users user;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="property_id")
	private Property property;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="bhk")
	private int bhk;
	
	@Column(name="building_name")
	private String buildingName;
	
	@Column(name="land_size")
	private int size;
	
	@Column(name="transaction_type")
	private String transactionType;
	
	@Column(name="purchasetype")
	private String purchaseType;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="location_id")	
	private Location location;
	
	@Column(name="discount")
	private int discount;
	
	@Column(name="description")
	private String description;
	
	@JoinColumn(name="user_id")
	@Column(name = "created_by")
	private long createdBy;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@JoinColumn(name="user_id")
	@Column(name = "modified_by")
	private long modifiedBy;
	
	@Column(name = "modified_date")
	private LocalDateTime modifiedDate;
	
	@Column(name = "status")
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getBhk() {
		return bhk;
	}

	public void setBhk(int bhk) {
		this.bhk = bhk;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Land [id=" + id + ", user=" + user + ", property=" + property
				+ ", price=" + price + ", bhk=" + bhk + ", buildingName="
				+ buildingName + ", size=" + size + ", transactionType="
				+ transactionType + ", purchaseType=" + purchaseType
				+ ", location=" + location + ", discount=" + discount
				+ ", description=" + description + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy
				+ ", modifiedDate=" + modifiedDate + ", status=" + status + "]";
	}

	
	
}

