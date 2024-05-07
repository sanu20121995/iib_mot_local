package com.iib.gov.config.motorconfig;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "db1EntityManagerFactory", transactionManagerRef = "db1TransactionManager",
basePackages = {"com.iib.gov.repo.vcvhsrepo"})
public class MotorConfig {

      //get datasource properties
	@Primary
	@Bean
	@ConfigurationProperties(prefix = "db1.datasource")
	public DataSource db1DataSource() {
		
		return DataSourceBuilder.create().build();
	}
	
	//get entity manager factory bean
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean db1EntityManagerFactory(EntityManagerFactoryBuilder builder) {
		
	HashMap<String,Object> properties= new HashMap<>();
	properties.put("hibernate.hbm2ddl.auto", "update");
	properties.put("hibernate.dialect","org.hibernate.dialect.SQLServerDialect");
		return builder.dataSource(db1DataSource())
				.packages("com.iib.gov.entity.vcvhsentity")
				.properties(properties)
				.build();
		
	}
	
	//get TXTmanager bean
	@Primary
	@Bean
	public PlatformTransactionManager db1TransactionManager(@Qualifier("db1EntityManagerFactory") EntityManagerFactory factory) {
		
		return new JpaTransactionManager(factory);
	}


}
