package com.ex.Redis.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.ex.Redis.Student;
import com.ex.Redis.dao.StudentDAO;

@Repository
public class StudentDaoImpl implements StudentDAO {

	private final String KEY = "STUDENT";

	@Resource(name = "rt")
	private HashOperations<String, Integer, Student> opr;

	public void addStudent(Student s) {
		opr.putIfAbsent(KEY, s.getStdId(), s);
	}

	public void updateStudent(Student s) {
		opr.put(KEY, s.getStdId(), s);
	}

	public Student getStudent(Integer id) {
		return opr.get(KEY, id);
	}

	public Map<Integer, Student> getAllStudents() {
		return opr.entries(KEY);
	}

	public void deleteStudent(Integer id) {
		opr.delete(KEY, id);
	}

}
