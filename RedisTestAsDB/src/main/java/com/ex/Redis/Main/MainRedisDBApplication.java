package com.ex.Redis.Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.ex.Redis.Student;
import com.ex.Redis.dao.StudentDAO;

@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan("com.ex.Redis.*")
@ComponentScan("Config")
@SpringBootApplication
public class MainRedisDBApplication implements CommandLineRunner {

	@Autowired
	private StudentDAO dao;

	public static void main(String[] args) {

		SpringApplication.run(MainRedisDBApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dao.addStudent(new Student(101, "Kevin", 400.26));
		dao.addStudent(new Student(102, "Chris", 100.45));
		dao.addStudent(new Student(103, "John", 30.25));

		dao.getAllStudents().forEach((k, v) -> System.out.println(k + " --> " + v));
		
//		System.out.println(dao.getAllStudents());

	}

}
