package com.skarre.inventory.persistence;

import com.skarre.inventory.model.Inventory;

import java.util.List;

public interface IInventoryDataAccessor
{
    public List<Inventory> getAllInventory();

    Inventory getInventoryByInventoryId(Long inventoryId);

    Inventory addSkuToStock(Inventory inventory);

    List<Inventory> addBulkSkusToStock(List<Inventory> inventoryList);
}
