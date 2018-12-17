/**
 * 
 */
package com.herokuapp.autoportaria.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Tiago Ferezin Data: 17/12/2018
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.herokuapp.autoportaria.model.repositories")
public class ConfiguracaoDB {

	@Bean
	public DataSource dataSource() throws IllegalStateException,
			PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();

		String driverClassPostgreSQL = "org.postgresql.Driver";
		String driverClassMySql = "com.mysql.jdbc.Driver";

		String herokuPostgreURI = "postgres://nszktokuubyrqe:63a66db736cc616aa143702f4944d121cd397b8b04d4b44b4249ce30e245e654@ec2-54-225-100-12.compute-1.amazonaws.com:5432/d2kpno4fi4rbqf";

		String userHeroku = "nszktokuubyrqe";
		String pass = "63a66db736cc616aa143702f4944d121cd397b8b04d4b44b4249ce30e245e654";
		dataSource.setDriverClass(driverClassPostgreSQL);
		// dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:" + herokuPostgreURI
				+ "?useTimezone=true&serverTimezone=UTC");
		dataSource.setUser(userHeroku);
		dataSource.setPassword(pass);
		return dataSource;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() throws Exception {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory()
				.getObject());
		return transactionManager;
	}

	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
			throws Exception {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean
				.setPackagesToScan("com.herokuapp.autoportaria.model.entity");
		entityManagerFactoryBean
				.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setJpaDialect(new HibernateJpaDialect());

		Properties jpaProterties = new Properties();
		jpaProterties.put("hibernate.dialect",
				"org.hibernate.dialect.PostgreSQLDialect");
		jpaProterties.put("hibernate.hbm2ddl.auto", "update");
		jpaProterties.put("hibernate.show_sql", "true");
		jpaProterties.put("hibernate.format_sql", "true");

		// jpaProterties.put("hibernate.c3p0.min_size", "5");
		// jpaProterties.put("hibernate.c3p0.max_size", "10");
		// jpaProterties.put("hibernate.c3p0.timeout", "1800");
		// jpaProterties.put("hibernate.c3p0.max_statements", "50");

		entityManagerFactoryBean.setJpaProperties(jpaProterties);
		return entityManagerFactoryBean;
	}

}
