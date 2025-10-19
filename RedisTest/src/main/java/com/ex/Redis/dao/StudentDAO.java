package com.ex.Redis.dao;

import java.util.Map;

import com.ex.Redis.Student;

public interface StudentDAO {

	void addStudent(Student s);
	void updateStudent(Student s);
	Student getStudent(Integer id);
	Map<Integer, Student> getAllStudents();
	void deleteStudent(Integer id);
}
