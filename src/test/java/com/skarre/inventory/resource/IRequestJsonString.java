package com.skarre.inventory.resource;

import com.skarre.inventory.model.Inventory;

public class IRequestJsonString
{
    public static final String invJson="{\n" +
            "        \"sku\": \"test sku1\",\n" +
            "        \"skuid\": 123,\n" +
            "        \"quantity\": 10,\n" +
            "        \"description\": \"dummy sku\",\n" +
            "        \"createdByUser\": \"seed_data\",\n" +
            "        \"lastUpdatedByUser\": \"seed_Data\",\n" +
            "        \"createdTimestanp\": \"2018-08-19 10:18:10\",\n" +
            "        \"lastUpdatedTimestamp\": \"2018-08-19 10:18:10\"\n" +
            "    }";

    public static final String invListJson="\\\"{\\n        \\\\\"sku\\\\\": \\\\\"test sku1\\\\\",\\n        \\\\\"skuid\\\\\": 123,\\n        \\\\\"quantity\\\\\": 10,\\n        \\\\\"description\\\\\": \\\\\"dummy sku\\\\\",\\n        \\\\\"createdByUser\\\\\": \\\\\"seed_data\\\\\",\\n        \\\\\"lastUpdatedByUser\\\\\": \\\\\"seed_Data\\\\\",\\n        \\\\\"createdTimestanp\\\\\": \\\\\"\\\\\",\\n        \\\\\"lastUpdatedTimestamp\\\\\": \\\\\"\\\\\"\\n    }\\\"";

    public static final Inventory staticInventory = getStaticInventory();


    public static Inventory getStaticInventory() {
        Inventory staticInventory= new Inventory("test sku1",123L,10L, "dummy sku",
                "seed_data","seed_data","2018-08-19 10:18:10","2018-08-19 10:18:10");
        return staticInventory;
    }
}
