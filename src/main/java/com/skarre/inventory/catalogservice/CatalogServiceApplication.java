package com.skarre.inventory.catalogservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
		JpaRepositoriesAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@ComponentScan("com.skarre.*")
public class CatalogServiceApplication {

	private static final Logger logger= LoggerFactory.getLogger(CatalogServiceApplication.class);

	public static void main(String[] args) {
		logger.debug("After start up");
		SpringApplication.run(CatalogServiceApplication.class, args);
	}
}
