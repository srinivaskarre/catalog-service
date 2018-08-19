package com.skarre.inventory.service.impl;

import java.util.List;

import com.skarre.inventory.persistence.IInventoryDataAccessor;
import com.skarre.inventory.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skarre.inventory.model.Inventory;

import javax.transaction.Transactional;
//import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InventoryService  implements IInventoryService
{
	@Autowired
	private IInventoryDataAccessor inventoryDataService;

	@Override
	public List<Inventory> getAllInventory() 
	{

		return inventoryDataService.getAllInventory();
	}

	@Override
	public Inventory getInventoryByInventoryId(Long inventoryId) {
		return inventoryDataService.getInventoryByInventoryId(inventoryId);
	}

	@Override
	public Inventory addSkuToStock(Inventory inventory) {
		return inventoryDataService.addSkuToStock(inventory);
	}

	@Override
	public List<Inventory> addBulkSkusToStock(List<Inventory> inventoryList) {
		return inventoryDataService.addBulkSkusToStock(inventoryList);
	}

}
