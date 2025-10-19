package com.ex;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class SpringHibernateUtil {

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/cricket");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean ls = new LocalSessionFactoryBean();
		ls.setDataSource(getDataSource());

		Properties pr = new Properties();
		pr.put("hibernate.show_sql", true);
		pr.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		pr.put("hibernate.hbm2ddl.auto", "update");

		ls.setAnnotatedClasses(Player.class);
		ls.setHibernateProperties(pr);
		return ls;
	}

	@Bean(value = "orm")
	public SpringORM getSpringORM() {
		SpringORM sm = new SpringORM();
		sm.setSessionFactory(getSessionFactory().getObject());
		return sm;
	}

}
