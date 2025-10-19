package com.ex;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PatientController {

	@Autowired
	PatientRepository pr;

	@RequestMapping("/")
	public String home(Model m) {
		return "index";
	}

	@RequestMapping("/add")
	public String addForm(Model m) {
		m.addAttribute("patient", new Patient());
		return "add";
	}

	@RequestMapping("/addPatient")
	public ModelAndView addPatient(@ModelAttribute Patient patient) {
		pr.savePatient(patient);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/display")
	public String viewPatient(Model m) {
		List li = pr.getPatient();
		m.addAttribute("list", li);
		return "display";
	}

	

	@RequestMapping("/update/{id}")
	public String updateForm(Model m, @PathVariable("id") String id) {
		Patient p = pr.getPatient(Integer.parseInt(id));
		m.addAttribute("patient",p);
		return "redirect:/update";
	}
	
	@RequestMapping("/update")
	public String update(Model m) {
//		m.addAttribute("updatedPatient",new Patient());
		return "update";
	}

//	@RequestMapping("/updatePatient")
//	public String updatePatient(@ModelAttribute("updatedPatient") Patient p) {
//		pr.updatePatient(p);
//		return "redirect:/display";
//	}

	@RequestMapping("/delete/{id}")
	public String deleteForm(@PathVariable("id") String id) {
		pr.deletePatient(Integer.parseInt(id));
		return "redirect:/display";
	}

}
