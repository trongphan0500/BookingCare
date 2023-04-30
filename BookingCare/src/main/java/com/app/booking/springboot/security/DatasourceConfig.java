/**
 * 
 */
package com.app.booking.springboot.security;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
//@ComponentScan({ "com.app.booking.springboot" })
//@EnableTransactionManagement
//@EnableJpaRepositories({ "com.app.booking.springboot.dao" })
public class DatasourceConfig {

	@Autowired
	private Environment env;

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		System.out.println(dataSource.getUrl());
		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
		properties.put("current_session_context_class", //
				env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		// Package contain entity classes
		factoryBean.setPackagesToScan("com.app.booking.springboot.entity");
		factoryBean.setDataSource(dataSource);
		factoryBean.setHibernateProperties(properties);
		factoryBean.afterPropertiesSet();
		//
		SessionFactory sf = factoryBean.getObject();
		System.out.println("## getSessionFactory: " + sf);
		return sf;
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

//	@Autowired
//	private ApplicationProperties config;
//
//	@Autowired
//	private Environment environment;
//
//	@Bean
//	public DataSource dataSource() {
//		HikariConfig hikariConfig = this.initHikariPoolingConfig("hikari-pool");
//		hikariConfig.setJdbcUrl("com.mysql.jdbc.Driver");
//		hikariConfig.setJdbcUrl(config.getDatasourceUrl());
//		hikariConfig.setUsername(config.getDatasourceUsername());
//		hikariConfig.setPassword(config.getDatasourcePassword());
//
//		System.out.println(hikariConfig.getJdbcUrl());
//
//		HikariDataSource hikariPoolingDataSource = new HikariDataSource(hikariConfig);
//
//		return hikariPoolingDataSource;
//	}
//
//	@Bean
//	@Primary
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("dataSource") DataSource ds)
//			throws PropertyVetoException {
//		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//		entityManagerFactory.setDataSource(ds);
//		entityManagerFactory.setPackagesToScan(new String[] { "com.app.booking.springboot" });
//		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
//		return entityManagerFactory;
//	}
//
//	@Bean
//	public LocalSessionFactoryBean sessionFactory() {
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource());
//		sessionFactory.setPackagesToScan(new String[] { "com.app.booking.springboot.entity" });
//		sessionFactory.setHibernateProperties(hibernateProperties());
//		return sessionFactory;
//	}
//
//	private Properties hibernateProperties() {
//		Properties properties = new Properties();
////		properties.put(org.hibernate.cfg.Environment.DIALECT, environment.getRequiredProperty("hibernate.dialect"));
////		properties.put(org.hibernate.cfg.Environment.SHOW_SQL, environment.getRequiredProperty("hibernate.show_sql"));
////		properties.put(org.hibernate.cfg.Environment.FORMAT_SQL,
////				environment.getRequiredProperty("hibernate.format_sql"));
////		properties.put(org.hibernate.cfg.Environment.CURRENT_SESSION_CONTEXT_CLASS,
////				"org.springframework.orm.hibernate5.SpringSessionContext");
//		properties.put("hibernate.dialect", environment.getProperty("spring.jpa.properties.hibernate.dialect"));
//	    properties.put("hibernate.show_sql", environment.getProperty("spring.jpa.show-sql"));
//	    properties.put("current_session_context_class", //
//	    		environment.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
//		return properties;
//	}
//
//	@Bean
//	@Autowired
//	public HibernateTransactionManager transactionManager(SessionFactory s) {
//		HibernateTransactionManager txManager = new HibernateTransactionManager();
//		txManager.setSessionFactory(s);
//		return txManager;
//	}
//
//	private HikariConfig initHikariPoolingConfig(String poolName) {
//		HikariConfig hikariConfig = new HikariConfig();
//
//		hikariConfig.setPoolName(poolName);
//		hikariConfig.setDriverClassName(config.getDriverClassname());
//		hikariConfig.setConnectionTimeout(config.getHikariCP_ConnectionTimeout());
//		hikariConfig.setIdleTimeout(config.getHikariCP_IdleTimeout());
//		hikariConfig.setMaximumPoolSize(config.getHikariCP_MaximumPoolSize());
//		hikariConfig.setMinimumIdle(config.getHikariCP_MinimumIdle());
//		hikariConfig.setMaxLifetime(config.getHikariCP_MaxLifetime());
//		hikariConfig.setMaxLifetime(config.getHikariCP_MaxLifetime());
//		hikariConfig.setTransactionIsolation(String.valueOf(Connection.TRANSACTION_READ_COMMITTED));
//		hikariConfig.setTransactionIsolation(String.valueOf(Connection.TRANSACTION_READ_COMMITTED));
//
//		hikariConfig.addDataSourceProperty("cachePrepStmts", config.getHikariCP_CachePrepStmts());
//		hikariConfig.addDataSourceProperty("prepStmtCacheSize", config.getHikariCP_PrepStmtCacheSize());
//		hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", config.getHikariCP_PrepStmtCacheSqlLimit());
//
//		return hikariConfig;
//	}

}