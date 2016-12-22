package com.zeedle.dao;

import java.util.List;

import com.zeedle.model.Job;
import com.zeedle.model.JobApplication;





public interface JobDAO {
	
	public boolean postJob(Job job);
	
	public boolean updateJob(Job job);
	
	public List<Job> getAllVacantJobs();
	
	public List<Job> getAllJobs();
	
	
	public boolean applyForJob(JobApplication jobApplication);
	
	public boolean updateJobApplication(JobApplication jobApplication);
	
	public JobApplication get(String userId, String jobId);
	
	public List<JobApplication> getMyAppliedJobs(String userId);
	

}
