package com.ex;

public class Alice implements Apollo {

	int age;
	String name;

	public void bookedAppointment() {

		System.out.println("Appointment booked at Apollo");
		System.out.println("Name is " + name);
		System.out.println("Age is " + age);

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
