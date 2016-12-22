package com.zeedle.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.zeedle.model.Job;
import com.zeedle.model.JobApplication;
import com.zeedle.service.JobService;

@RestController
public class JobController {
	
	@Autowired(required=true)
	 private JobService jobService;
	
	@Autowired(required=true)
	JobApplication jobApplication;
	
	// To get all jobs
	
	
		@RequestMapping(value= "/job", method = RequestMethod.GET)
			public ResponseEntity<List<Job>> getAllJobs() {
			List<Job> job = jobService.getAllJobs();
			return new ResponseEntity<List<Job>>(job, HttpStatus.OK);
		}
		
		// To Post job
		
		@RequestMapping(value= "/job", method = RequestMethod.POST)
		public ResponseEntity<Void> postJob(@RequestBody Job job, UriComponentsBuilder builder) {
			job.setStatus('V'); //1. V-vacant, 2.F-Filled, 3. P-pending
	        boolean flag = jobService.postJob(job);
	               if (flag == false) {
	        	  return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	               }
	               HttpHeaders headers = new HttpHeaders();
	               headers.setLocation(builder.path("/postJob/{id}").buildAndExpand(job.getId()).toUri());
	               return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		
		
		// To Update Job
		
			@RequestMapping(value="/job/{id}", method = RequestMethod.PUT )
			public ResponseEntity<Job> updateJob(@RequestBody Job job) {
				jobService.updateJob(job);
				return new ResponseEntity<Job>(job, HttpStatus.OK);
			}

			// To get All vacant Job
			
			@RequestMapping(value= "/jobAllVacant", method = RequestMethod.GET)
			public ResponseEntity<List<Job>> getAllVacantJobs() {
				List<Job> job = jobService.getAllVacantJobs();
				return new ResponseEntity<List<Job>>(job, HttpStatus.OK);
			}

			// To apply Job
			
			@RequestMapping(value="/getMyAppliedJobs",method=RequestMethod.GET)
			public ResponseEntity<List<JobApplication>> getMyAppliedJobs(HttpSession httpSession)
			{
				String loggedInUserID=(String) httpSession.getAttribute("loggedInUserID");
				List<JobApplication> jobs=jobService.getMyAppliedJobs(loggedInUserID);
				return new ResponseEntity<List<JobApplication>>(jobs,HttpStatus.OK);
			}




}
