package com.skarre.inventory.persistence.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.skarre.inventory.model.BaseEntity;
import com.skarre.inventory.model.Inventory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernatePersistenceLayer 
{
	private static final Logger logger= LoggerFactory.getLogger("HibernatePersistenceLayer");
	@Autowired
	private SessionFactory sessionFactory;
	
	public List listentities(String queryString)
	{
		Session session= sessionFactory.getCurrentSession();
		Query query=session.createQuery(queryString);
		return query.list();
	}

	public BaseEntity getEntity(String queryString, Long inventoryId) {
		/*BaseEntity be= (BaseEntity) sessionFactory.getCurrentSession().load(entityClass,inventoryId);
		be.getCreatedByUser();*/
		Session session= sessionFactory.getCurrentSession();
		Query query=session.createQuery(queryString);
		query.setParameter(0,inventoryId);
		query.setMaxResults(1);
		List list=query.list();
		logger.error("inv is--"+list);
		if(list!=null && list.size()>0) return (BaseEntity) list.get(0);
		return null;
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
