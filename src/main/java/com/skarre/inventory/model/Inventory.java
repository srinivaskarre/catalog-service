package com.skarre.inventory.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="INVENTORY")
public class Inventory implements BaseEntity
{
	/*
	 * props
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="inventoryId")
	private Long inventoryId;
	
	@Column(name="sku")
	private String sku;
	
	@Column(name="skuid")
	private Long skuid;
	
	@Column(name="quantity")
	private Long quantity;
	
	@Column(name="description")
	private String description;

	@Column(name="created_source")
	private String createdByUser;

	@Column(name="lastUpdated_source")
	private String lastUpdatedByUser;

	@Column(name="created_timestanp")
	private String createdTimestanp;

	@Column(name="lastupdated_timestamp")
	private String lastUpdatedTimestamp;

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.sku.equalsIgnoreCase(((Inventory)obj).getSku());
	}

	public Inventory()
	{

	}

	public Inventory(String sku, Long skuid, Long quantity, String description, String createdByUser, String lastUpdatedByUser, String createdTimestanp, String lastUpdatedTimestamp) {
		this.sku = sku;
		this.skuid = skuid;
		this.quantity = quantity;
		this.description = description;
		this.createdByUser = createdByUser;
		this.lastUpdatedByUser = lastUpdatedByUser;
		this.createdTimestanp = createdTimestanp;
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
	}
	/*
	 * getters and setters
	 * 
	 */

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Long getSkuid() {
		return skuid;
	}

	public void setSkuid(Long skuid) {
		this.skuid = skuid;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	
	/*
	 * toString
	 */
	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", sku=" + sku + ", skuid=" + skuid + ", quantity=" + quantity
				+ ", description=" + description + "]";
	}


	@Override
	public String getLastUpdatedTimestamp() {
		return lastUpdatedTimestamp;
	}

	public void setLastUpdatedTimestamp(String lastUpdatedTimestamp) {
		this.lastUpdatedTimestamp = lastUpdatedTimestamp;
	}

	public String getCreatedTimestanp() {
		return createdTimestanp;
	}

	public void setCreatedTimestanp(String createdTimestanp) {
		this.createdTimestanp = createdTimestanp;
	}

	public String getLastUpdatedByUser() {
		return lastUpdatedByUser;
	}

	public void setLastUpdatedByUser(String lastUpdatedByUser) {
		this.lastUpdatedByUser = lastUpdatedByUser;
	}

	public String getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}
}
