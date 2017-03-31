package com.getterandsetter.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.getterandsetter.beans.*;
import com.getterandsetter.dao.*;
import com.getterandsetter.obsolete.ApplicantDAOImpl;

@Controller
@RequestMapping(value = "applicant")
public class ApplicantController {

	private List<Sas_Application_Type> jobs = new ArrayList<Sas_Application_Type>();
	private List<Sas_Application> applications = new ArrayList<Sas_Application>();
	private Sas_Application a = new Sas_Application();
	
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
	public ResponseEntity<List<Sas_Application_Type>> findAll() {
		// jobs = new ApplicantDAO().findAllJobs();
		jobs = new ApplicantDAOImpl().findAllJobs();
		return new ResponseEntity<List<Sas_Application_Type>>(jobs, HttpStatus.OK);

	}

	/*@RequestMapping(value = "new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> add(@Valid @RequestBody Sas_Application app) {
		System.out.println("Applyying: " + app);
		applications.add(app);
		return new ResponseEntity<String>("Success!", HttpStatus.CREATED);
	}*/
	
	

	@RequestMapping(value = "new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> add(@Valid @RequestBody Sas_Application app) {
		System.out.println("Applying: " + app.getTemp_sas_job_id());
		Sas_Application_Type sas = new Sas_Application_Type();
		sas.setSas_job_type_id(app.getTemp_sas_job_id());
		app.setSas_job_type_id(sas);
		
		Sas_Users u = new Sas_Users();
		u.setSas_users_id(7);
		app.setSas_author(u);
		Sas_Application_Status stat = new Sas_Application_Status();
		stat.setSas_status_id(1);
		app.setSas_status_id(stat);
		
//		Sas_Skills sk = new Sas_Skills();
//		sk.setSkillName(app.get);
		a = new ApplicantDAOImpl().createSas_Application(app);
		
		return new ResponseEntity<String>("Success!", HttpStatus.CREATED);
	}


}
