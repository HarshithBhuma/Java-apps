package com.ex;

import org.springframework.jdbc.core.JdbcTemplate;

public class SpringDAO {

	JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public void insert() {
		jt.execute("insert into player(player_name,age,runs) values('Rohit',32,7503)");
		System.out.println("record added");
	}

}
