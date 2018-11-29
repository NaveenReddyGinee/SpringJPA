package com.accenture.resources;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configurable
@EnableTransactionManagement //---> <tx:annotation-driven transaction-manager="txManager" />
@EnableJpaRepositories("com.accenture.lkm.dao")
public class DBConfig {
	 @Bean
	  public DataSource dataSource() {
		 BasicDataSource dataSource = new BasicDataSource();
		 dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		 dataSource.setUrl("jdbc:mysql://localhost:3306/springbootdemos");
		 dataSource.setUsername("root");
		 dataSource.setPassword("root");
		 return dataSource;
	    
	  }

	  @Bean
	  public EntityManagerFactory entityManagerFactory(DataSource dataSource) { //ManagedDataSource

	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);
	    vendorAdapter.setShowSql(true);
	    vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");

	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("com.accenture.entity");
	    factory.setDataSource(dataSource);
	    factory.afterPropertiesSet();

	    return factory.getObject();
	  }
	  @Bean
	  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {//managed Object EntityManagerFactory
	    JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory);
	    return txManager;
	  }

}
