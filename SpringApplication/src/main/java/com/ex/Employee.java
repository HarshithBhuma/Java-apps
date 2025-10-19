package com.ex;

import java.util.Map;
import java.util.Set;

public class Employee {

	private int empId;
	private String empName;
	private int empAge;
//	private Set location;

	private Map<Integer, String> location;

//	public Employee(int empId, String empName, int empAge) {
//		super();
//		this.empId = empId;
//		this.empName = empName;
//		this.empAge = empAge;
//
//	}

//	void show() {
//		System.out.println(empId + " " + empName + " " + empAge);
//	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public Map<Integer, String> getLocation() {
		return location;
	}

	public void setLocation(Map<Integer, String> location) {
		this.location = location;
	}

}
