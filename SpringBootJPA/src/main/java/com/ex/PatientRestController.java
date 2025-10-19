package com.ex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientRestController {

	@Autowired
	PatientService ps;

	@RequestMapping(value = "/getPatient", method = RequestMethod.GET)
	public List<Patient> getPatient() {
		return ps.select();
	}

	@RequestMapping(value = "/addPatient", method = RequestMethod.POST)
	public void addPatient(@RequestBody Patient p) {
		ps.insert(p);
	}

	@RequestMapping(value = "/deletePatient/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		ps.delete(id);
	}

	@RequestMapping(value = "/updatePatient/{age}/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("age") int age, @PathVariable("id") int id) {
		ps.update(age, id);
	}

}
