package com.getterandsetter.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.getterandsetter.beans.Sas_Application;
import com.getterandsetter.obsolete.ApplicantDAOImpl;

@Controller
@RequestMapping(value = "hmanager")
public class HiringManagerController {

	private List<Sas_Application> app = new ArrayList<>();
	// jobs = new ApplicantDAOImpl().findAllJobs();

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String spa() {
		return "applicant.html";

	}

	@RequestMapping(value = "go", method = RequestMethod.POST)
	public String whatever(HttpServletRequest req, HttpServletResponse resp) {
		// System.out.println("Client msg: " + req.getParameter("hello"));
		return "redirect:applicant";

	}

	@RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Sas_Application>> findAll() {
		app = new ApplicantDAOImpl().findAllApps();

		return new ResponseEntity<List<Sas_Application>>(app, HttpStatus.OK);

	}
}
