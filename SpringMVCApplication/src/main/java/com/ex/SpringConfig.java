package com.ex;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.user.User;
import com.user.UserRepository;

@Configuration
@EnableWebMvc
//@ComponentScan("com.ex")
@ComponentScans({ @ComponentScan("com.ex"), @ComponentScan("com.user") })
public class SpringConfig {

	@Bean
	public InternalResourceViewResolver getviewResolver() {
		InternalResourceViewResolver ir = new InternalResourceViewResolver();
		ir.setPrefix("WEB-INF/jsp/");
		ir.setSuffix(".jsp");
		return ir;
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/hospital");
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
		ls.setHibernateProperties(pr);
		ls.setAnnotatedClasses(Patient.class, User.class);

		return ls;
	}

	@Bean
	public PatientRepository getPatientRepository() {
		PatientRepository pr = new PatientRepository();
		return pr;
	}

	@Bean
	public UserRepository getUserRepository() {
		UserRepository ur = new UserRepository();
		return ur;
	}

}
