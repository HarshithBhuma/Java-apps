package com.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJdbc {

	public static void main(String[] args) {

		ConfigurableApplicationContext ct = SpringApplication.run(SpringJdbc.class, args);

		SpringDAO dao = ct.getBean(SpringDAO.class);

//		dao.insert();

//		dao.update();

//		dao.delete();

		dao.select();

	}

}
