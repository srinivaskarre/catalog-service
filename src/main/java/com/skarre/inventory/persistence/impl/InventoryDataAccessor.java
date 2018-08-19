package com.skarre.inventory.persistence.impl;

import java.util.List;

import com.skarre.inventory.persistence.IInventoryDataAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skarre.inventory.model.Inventory;
import com.skarre.inventory.persistence.query.IInventoryQuery;
import org.springframework.stereotype.Repository;

@Component
@Repository
public class InventoryDataAccessor implements IInventoryDataAccessor
{
	@Autowired
	private HibernatePersistenceLayer hibLayer;
	@Override
	public List<Inventory> getAllInventory()
	{
		return (List<Inventory>)hibLayer.listentities(IInventoryQuery.GET_ALL_INVENTORY);
	}

	@Override
	public Inventory getInventoryByInventoryId(Long inventoryId) {
		return (Inventory) hibLayer.getEntity(Inventory.class,inventoryId);
	}

	@Override
	public Inventory addSkuToStock(Inventory inventory) {
		return (Inventory) hibLayer.persistentity(inventory);
	}

	@Override
	public List<Inventory> addBulkSkusToStock(List inventoryList) {
		return hibLayer.persistentities(inventoryList);
	}

}
