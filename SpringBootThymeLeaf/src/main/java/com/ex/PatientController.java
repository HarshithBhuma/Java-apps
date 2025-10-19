package com.ex;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patient/")
public class PatientController {

	@Autowired
	private PatientRepository pr;

	@GetMapping("/addPatient")
	public String addForm(@ModelAttribute("patient") Patient patient) {
		return "addPatient";
	}

	@PostMapping("add")
	public String addPatient(@ModelAttribute("patient") Patient patient, Model m) {
		pr.save(patient);
		return "redirect:viewPatient";
	}

	@GetMapping("/viewPatient")
	public String viewPatient(Model m) {
		m.addAttribute("patient", pr.findAll());
		return "viewPatient";
	}

	@GetMapping("/deletePatient/{id}")
	public String delete(@PathVariable("id") String id, Model m) {
		pr.deleteById(Integer.parseInt(id));
		m.addAttribute("patient", pr.findAll());
		return "viewPatient";
	}

	@GetMapping("/updatePatient/{id}")
	public String updateForm(@PathVariable("id") String id, Model m) {
		m.addAttribute("updatePatient", pr.findById(Integer.parseInt(id)).get());
		return "updatePatient";
	}

	@PostMapping("update")
	public String updatePatient(@ModelAttribute("updatePatient") Patient updatedPatient, Model m) {
		Patient p = pr.findById(updatedPatient.getPid()).get();

		p.setName(updatedPatient.getName());
		p.setAge(updatedPatient.getAge());
		p.setLocation(updatedPatient.getLocation());

		pr.save(p);
		m.addAttribute("patient", pr.findAll());
		return "viewPatient";
	}
}
