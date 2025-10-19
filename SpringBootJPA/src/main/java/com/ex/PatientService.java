package com.ex;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

	@Autowired
	PatientRepository pr;

	public void insert(Patient p) {
		pr.save(p);
//		System.out.println("Record inserted");
	}

	public void delete(int id) {
		pr.deleteById(id);
//		System.out.println("Record deleted");
	}

	public List<Patient> select() {
		List<Patient> li = pr.findAll();
		return li;
	}

	public void update(int age, int id) {
		pr.update(age, id);
//		System.out.println("Record updated");
	}

}
