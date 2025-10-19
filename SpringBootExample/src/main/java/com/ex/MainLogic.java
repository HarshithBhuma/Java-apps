package com.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainLogic {

	public static void main(String args[]) {
		ConfigurableApplicationContext ct = SpringApplication.run(MainLogic.class, args);

		Patient p = ct.getBean(Patient.class);

		p.setPid(1);
		p.setName("Chris");
		p.setAge(22);
		p.setLocation("Tx");

		System.out.println(p.getPid() + " " + p.getAge() + " " + p.getName() + " " + p.getLocation());

	}
}
