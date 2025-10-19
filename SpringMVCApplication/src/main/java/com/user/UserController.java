package com.user;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	UserRepository ur;

	@RequestMapping("/login")
	public String login(Model m) {
		m.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping("/loginUser")
	public ModelAndView userLogin(@ModelAttribute User user) {
		List li = ur.getUser(user.getEmail(), user.getPassword());
		ModelAndView mv = new ModelAndView();
		Iterator i = li.iterator();
		if (i.hasNext()) {
			mv.setViewName("index");
		} else
			mv.setViewName("register");
		return mv;
	}

	@RequestMapping("/register")
	public String register(Model m) {
		m.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping("/addUser")
	public ModelAndView addUser(@ModelAttribute User user) {
		ur.addUser(user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

}
