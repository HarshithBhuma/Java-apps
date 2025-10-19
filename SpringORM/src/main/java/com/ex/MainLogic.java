package com.ex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainLogic {

	public static void main(String[] args) {

		ApplicationContext ct = new AnnotationConfigApplicationContext(SpringHibernateUtil.class);
		SpringORM orm = (SpringORM) ct.getBean("orm");
		Player pl = new Player();
		pl.setId(9);
//		pl.setAge(32);
//		pl.setRuns(5056);
//		orm.insert(pl);

//		orm.select();

		orm.delete(pl);

	}

}
