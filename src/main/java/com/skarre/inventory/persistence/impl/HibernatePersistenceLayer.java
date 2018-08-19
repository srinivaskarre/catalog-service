package com.skarre.inventory.persistence.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.skarre.inventory.model.BaseEntity;
import com.skarre.inventory.model.Inventory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernatePersistenceLayer 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public List listentities(String queryString)
	{
		Session session= sessionFactory.getCurrentSession();
		Query query=session.createQuery(queryString);
		return query.list();
	}

	public BaseEntity getEntity(Class entityClass, Long inventoryId) {
		BaseEntity be= (BaseEntity) sessionFactory.getCurrentSession().load(entityClass,inventoryId);
		be.getCreatedByUser();
		return be;
	}

	public BaseEntity persistentity(BaseEntity inventory) {
		 sessionFactory.getCurrentSession().save(inventory);
		 return inventory;
	}

	public List<Inventory> persistentities(List<Inventory> inventoryList) {

		inventoryList.stream()
				.forEach(inventory -> persistentity(inventory));
		return inventoryList;
	}
}
