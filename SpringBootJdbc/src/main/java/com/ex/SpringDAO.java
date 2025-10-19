package com.ex;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class SpringDAO extends JdbcDaoSupport {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	public void initialize() {
		setDataSource(dataSource);
	}

	public void insert() {
		getJdbcTemplate().execute("insert into dup_patient values(8,'Ben',65,'Texas')");
		System.out.println("record inserted");
	}

	public void update() {
		getJdbcTemplate().execute("update dup_patient set p_age=56 where pid=8");
		System.out.println("record updated");
	}

	public void delete() {
		getJdbcTemplate().execute("delete from dup_patient where pid=8");
		System.out.println("record deleted");
	}

	public void select() {
		List<Map<String, Object>> li = getJdbcTemplate().queryForList("select * from dup_patient");

		Iterator<Map<String, Object>> i = li.iterator();

		while (i.hasNext()) {
			Map<String, Object> rec = i.next();
			System.out.println(rec);
		}

	}

}
