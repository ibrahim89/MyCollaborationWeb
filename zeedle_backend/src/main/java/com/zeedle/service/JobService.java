package com.zeedle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeedle.daoimpl.JobDAOImpl;
import com.zeedle.model.Job;
import com.zeedle.model.JobApplication;

@Transactional
@Service
public class JobService {
	@Autowired (required=true)
	JobDAOImpl jobDAO;
	
	
	public boolean postJob(Job job) {
		return jobDAO.postJob(job);
	}
	
	public boolean updateJob(Job job) {
		return jobDAO.updateJob(job);
	}
	
	public List<Job> getAllVacantJobs() {
		return jobDAO.getAllVacantJobs();
	}
	
	public List<Job> getAllJobs() {
		return jobDAO.getAllJobs();
	}
	
	public boolean applyForJob(JobApplication jobApplication) {
		return jobDAO.applyForJob(jobApplication);
	}
	
	public boolean updateJobApplication(JobApplication jobApplication) {
		
		return jobDAO.updateJobApplication(jobApplication);
	}
	
	public JobApplication get(String userId, String jobId) {
		return jobDAO.get(userId, jobId);
	}
	
	public List<JobApplication> getMyAppliedJobs(String userId) {
		return jobDAO.getMyAppliedJobs(userId);
	}

}
