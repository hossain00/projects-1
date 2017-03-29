package com.getterandsetter.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(value = "loginControl")
public class LoginController {

	@RequestMapping(value = "loginNow", method = RequestMethod.POST)
	public String pickle(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("Client msg: " + req.getParameter("signin-email"));
		return "redirect:mgr"; // redirect

	}
	@RequestMapping(value = "mgr", method = RequestMethod.GET)
	public String homepage() {
		return "HireManager.html"; // forward

	}
	
}
