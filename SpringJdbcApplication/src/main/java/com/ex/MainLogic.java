package com.ex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainLogic {

	public static void main(String[] args) {

		ApplicationContext ct = new AnnotationConfigApplicationContext(SpringUtil.class);

		SpringDAO dao = (SpringDAO) ct.getBean("jdbc");
		dao.insert();

	}

}
