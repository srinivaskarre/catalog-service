package com.skarre.inventory.resource;

import java.util.List;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.skarre.inventory.model.Inventory;
import com.skarre.inventory.service.IInventoryService;

@RestController
public class InventoryResource 
{

	private static final Logger logger= LoggerFactory.getLogger("InventoryResource");
	@Autowired
	private IInventoryService inventoryService;
	
	@GetMapping(value = "/allInventory",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Inventory> getAllInventory() {
		logger.info("[InventoryResource-getAllInventory] Entry--> ");
		List<Inventory> invList= inventoryService.getAllInventory();
		logger.info("[InventoryResource-getAllInventory] Exit--> invList is"+invList);
		return invList;
	}

	@GetMapping(value = "/getInventory/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public  Inventory getInventory(@PathVariable(value = "id") final Long inventoryId) {
		logger.info("[InventoryResource-getInventory] Entry--> ");
		Inventory inv= inventoryService.getInventoryByInventoryId(inventoryId);
		logger.info("[InventoryResource-getInventory] Exit--> "+inv);
		return inv;
	}

	@PutMapping(value="/saveInventory", produces = MediaType.APPLICATION_JSON_VALUE)
	public Inventory createSupply(@RequestBody final Inventory inventory){
		logger.info("[InventoryResource-createSupply] Entry--> ");
		Inventory inv= inventoryService.addSkuToStock(inventory);
		logger.info("[InventoryResource-createSupply] Exit--> inv="+inv);
		return inv;
	}

	@PutMapping(value="/saveBulkInventory", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Inventory> createBulkSupply(@RequestBody final List<Inventory> inventoryList){
		logger.info("[InventoryResource-createBulkSupply] Entry--> ");
		List<Inventory> invList=inventoryService.addBulkSkusToStock(inventoryList);
		logger.info("[InventoryResource-createBulkSupply] Exit--> Bulk inv="+invList);
		return invList;
	}

	@PutMapping(value = "/testRequest")
	public String testRequestBody(@RequestBody final String req)
	{
		logger.info("[InventoryResource-testRequestBody] JSONString is ["+req);
		return new Gson().toJson(req);
		//return req;
	}
	
}
