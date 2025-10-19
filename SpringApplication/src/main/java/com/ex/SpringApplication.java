package com.ex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Employee emp = context.getBean(Employee.class);

		System.out.println(emp.getEmpId() + " " + emp.getEmpAge() + " " + emp.getEmpName());

		for (String loc : emp.getLocation().values()) {
			System.out.println(loc);
		}

	}
}
