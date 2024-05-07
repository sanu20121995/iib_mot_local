package com.iib.gov.config.newmotorconfig;

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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "db2EntityManagerFactory", transactionManagerRef = "db2TransactionManager",
basePackages = {"com.iib.gov.repo.vcvhsrepo2"})
public class NewMotorConfig {

      //get datasource properties
	@Bean
	@ConfigurationProperties(prefix = "db2.datasource")
	public DataSource db2DataSource() {
		
		return DataSourceBuilder.create().build();
	}
	
	//get entity manager factory bean
	@Bean
	public LocalContainerEntityManagerFactoryBean db2EntityManagerFactory(EntityManagerFactoryBuilder builder) {
		
	HashMap<String,Object> properties= new HashMap<>();
	properties.put("hibernate.hbm2ddl.auto", "update");
	properties.put("hibernate.dialect","org.hibernate.dialect.SQLServerDialect");
		return builder.dataSource(db2DataSource())
				.packages("com.iib.gov.entity.vcvhsentity2")
				.properties(properties)
				.build();
		
	}
	
	//get TXTmanager bean
	@Bean
	public PlatformTransactionManager db2TransactionManager(@Qualifier("db2EntityManagerFactory") EntityManagerFactory factory) {
		
		return new JpaTransactionManager(factory);
	}


}
