package com.vetClinic.admin;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vetClinic.todo.Todo;

@Controller 
@SessionAttributes("name")
public class AdminController {
	
	@Autowired
	AdminService service;

	@RequestMapping(value="/admin", method = RequestMethod.GET) 
	public String listActions () {
		return "admin";
	}
	
	@RequestMapping(value="/add-user", method = RequestMethod.GET) 
	public String showAddUserPage (ModelMap model) {
		model.addAttribute("user", new UserMaintainer());
		return "user-add";
	}
	
	@RequestMapping(value="/add-user", method = RequestMethod.POST) 
	public String addUser(ModelMap model, @Valid UserMaintainer maintainer, BindingResult result) {
		if(result.hasErrors()) {
			return "user-add";
		}
		service.addUser(maintainer);
		model.clear();
		return "redirect:admin";
	}
	
	
}
