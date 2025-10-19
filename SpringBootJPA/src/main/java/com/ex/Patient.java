package com.ex;

import javax.persistence.*;

@Entity
@Table(name = "dup_patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "pid")
	private int pid;

	@Column(name = "pname")
	private String name;

	@Column(name = "p_age")
	private int age;

	@Column(name = "location")
	private String location;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
