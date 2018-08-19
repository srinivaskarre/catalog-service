package com.skarre.inventory.model;

import java.sql.Date;

public interface BaseEntity {
    public String getLastUpdatedTimestamp() ;

    public void setLastUpdatedTimestamp(String lastUpdatedTimestamp) ;
    public String getCreatedTimestanp();

    public void setCreatedTimestanp(String createdTimestanp);

    public String getLastUpdatedByUser();

    public void setLastUpdatedByUser(String lastUpdatedByUser);

    public String getCreatedByUser();

    public void setCreatedByUser(String createdByUser);
}
