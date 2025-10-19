package com.ex;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	UserRepo ur;

	@GetMapping("/login")
	public String loginForm(@ModelAttribute("user") User user) {
		return "login";
	}

	@PostMapping("login")
	public String loginUser(@ModelAttribute("user") User user, Model m) {
		List li = ur.getUser(user.getEmail(), user.getPassword());
		Iterator i = li.iterator();
		if (i.hasNext()) {
			return "redirect:/patient/viewPatient";
		} else
			return "redirect:/patient/addPatient";
	}

}
