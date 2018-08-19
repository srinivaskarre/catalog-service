package com.skarre.inventory.service.impl;

import com.skarre.inventory.catalogservice.CatalogServiceApplication;
import com.skarre.inventory.model.Inventory;
import com.skarre.inventory.persistence.impl.InventoryDataAccessor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.validation.constraints.AssertTrue;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = CatalogServiceApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class InventoryServiceIntegrationTest
{

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private InventoryDataAccessor inventoryDataAccessor;

    @Autowired
    private InventoryService inventoryService;


    @Test
    public void getAllInventory() {
        Inventory inv1=new Inventory();
        inv1.setSku("sku1");
        inventoryService.addSkuToStock(inv1);

        List<Inventory> inventoryList=inventoryService.getAllInventory();

        System.out.println(inventoryList.size());

    }

    @Test
    public void getInventoryByInventoryId() {
    }

    @Test
    public void addSkuToStock() {
    }

    @Test
    public void addBulkSkusToStock() {
    }
}