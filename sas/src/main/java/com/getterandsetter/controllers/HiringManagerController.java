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

import com.getterandsetter.beans.Sas_Application;
import com.getterandsetter.beans.Sas_Application_Status;
import com.getterandsetter.beans.Sas_Application_Type;
import com.getterandsetter.beans.Sas_Users;
import com.getterandsetter.dao.HiringManagerDAOImpl;
import com.getterandsetter.obsolete.ApplicantDAOImpl;


@Controller
@RequestMapping(value = "hmanager")
public class HiringManagerController {
	
	private HiringManagerDAOImpl d = new HiringManagerDAOImpl();
	private Sas_Application a = new Sas_Application();
	private List<Sas_Application_Type> apptype = new ArrayList<>();
	private List<Sas_Application> app = new ArrayList<>();
	// jobs = new ApplicantDAOImpl().findAllJobs();

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String spa() {
		return "applicant.html";

	}
	
	@RequestMapping(value="createpost", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody //write directly to response body.. no redirection
	
	public ResponseEntity<String> add(@Valid @RequestBody Sas_Application_Type apptype){
		System.out.println("Add Post: " + apptype);
		// d.postJob(d.findManager(1), desiredSkills, job);                              
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}
	
	
	
	
	
	@RequestMapping(value = "recom", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Sas_Application>> Reommended(){
		app = d.getRecommendedApps(d.returnJob(1));
		return new ResponseEntity<List<Sas_Application>>(app, HttpStatus.OK);
	}

	@RequestMapping(value = "appupdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> add(@Valid @RequestBody Sas_Application app) {
		// System.out.println("Client msg: " + req.getParameter("hello"));
		//d.findManager(1);
		
		Sas_Application_Status stat = new Sas_Application_Status();
		stat.setSas_status_id(2);
		app.setSas_status_id(stat);
		a =  d.approveDeny(d.findManager(1),app);
		return new ResponseEntity<String>("Success!", HttpStatus.OK);
	}

	
	
	@RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Sas_Application>> findAll() {
		app = new ApplicantDAOImpl().findAllApps();	

		return new ResponseEntity<List<Sas_Application>>(app, HttpStatus.OK);

	}
	
	
	
	
	
	
}
