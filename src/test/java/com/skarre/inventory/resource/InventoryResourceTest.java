package com.skarre.inventory.resource;

import com.skarre.inventory.model.Inventory;
import com.skarre.inventory.persistence.impl.InventoryDataAccessor;
import com.skarre.inventory.service.impl.InventoryService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static com.skarre.inventory.resource.IRequestJsonString.staticInventory;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class InventoryResourceTest {


    @InjectMocks
    private InventoryResource inventoryResource;

    @Mock
    private InventoryService inventoryService;

    @Mock
    private InventoryDataAccessor inventoryDataAccessor;

    private MockMvc mockMvc;

    @Before
    public void setUp()
    {
        mockMvc= MockMvcBuilders.standaloneSetup(inventoryResource,inventoryService).build();
    }

    @Test
    public void getAllInventory() throws Exception{
        Mockito.when(inventoryService.getAllInventory()).thenReturn(Collections.emptyList());
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/allInventory")).andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(inventoryService).getAllInventory();
    }

    @Test
    public void getInventory() throws Exception {
        Mockito.when(inventoryService.getInventoryByInventoryId(1L)).then(new Answer<Inventory>() {

            @Override
            public Inventory answer(InvocationOnMock invocationOnMock) throws Throwable
            {
                Inventory inventory=new Inventory();
                    inventory.setSku("getInventory_sku");
                return inventory;
            }

        });

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/getInventory/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.sku",Matchers.is("getInventory_sku")));
    }

    @Test
    public void createSupply() throws Exception {
        Mockito.when(inventoryService.addSkuToStock(staticInventory)).thenReturn(staticInventory);
        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/saveInventory")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(IRequestJsonString.invJson)
                .accept(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(9)));
        Mockito.verify(inventoryService).addSkuToStock(staticInventory);
    }

    @Test
    public void createBulkSupply()
    {

    }
}