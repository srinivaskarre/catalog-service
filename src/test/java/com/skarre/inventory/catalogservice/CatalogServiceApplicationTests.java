package com.skarre.inventory.catalogservice;

import com.skarre.inventory.resource.InventoryResourceTest;
import com.skarre.inventory.service.impl.InventoryServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@Suite.SuiteClasses({InventoryResourceTest.class, InventoryServiceTest.class})
@SpringBootTest
public class CatalogServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
