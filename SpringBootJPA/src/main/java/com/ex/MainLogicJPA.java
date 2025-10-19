package com.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainLogicJPA {

	public static void main(String[] args) {
		ConfigurableApplicationContext ct = SpringApplication.run(MainLogicJPA.class, args);
//		PatientService ps = ct.getBean(PatientService.class);
//
//		Patient p = new Patient();
//		
//		p.setName("Rio");
//		p.setAge(67);
//		p.setLocation("Tx");

//		ps.insert(p);
		
//		ps.select();
		
//		ps.delete(14);
		
//		ps.update(5, 33);

	}

}
