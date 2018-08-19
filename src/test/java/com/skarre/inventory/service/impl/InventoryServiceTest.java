package com.skarre.inventory.service.impl;

import com.skarre.inventory.model.Inventory;
import com.skarre.inventory.persistence.impl.InventoryDataAccessor;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.persistence.EntityManager;
import javax.validation.constraints.AssertTrue;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class InventoryServiceTest
{
    /*@Autowired
    private EntityManager entityManager;*/
    @Mock
    private InventoryDataAccessor inventoryDataAccessor;

    @InjectMocks
    private InventoryService inventoryService;

    private MockMvc mockMvc;
    @Before
    public void setUp() throws Exception
    {
        mockMvc=MockMvcBuilders.standaloneSetup(inventoryService).build();
    }

    @Test
    public void getAllInventory() {
      /*  *//*
            Adding two objects h2 db
         *//*
        Inventory i1=new Inventory();Inventory i2=new Inventory();
        i1.setSku("sku1");i2.setSku("sku2");
        i1.setInventoryId(1L); i2.setInventoryId(2L);
        entityManager.persist(i1);
        entityManager.persist(i2);
        entityManager.flush(); */
        Mockito.when(inventoryService.getAllInventory()).thenReturn(Collections.emptyList());

        List<Inventory> invList=inventoryService.getAllInventory();

        assertTrue(invList.size()==0);

        Mockito.verify(inventoryDataAccessor).getAllInventory();
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