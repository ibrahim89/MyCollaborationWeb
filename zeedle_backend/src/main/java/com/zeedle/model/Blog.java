package com.zeedle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Blog {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogId;
	private String blogTitle;
	private String blogDesc;
	private int id; // userId
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogDesc() {
		return blogDesc;
	}
	public void setBlogDesc(String blogDesc) {
		this.blogDesc = blogDesc;
	}
	public String toString()
	{
		
		return "{blogId: '" + blogId+ "'," + "blogTitle : '" + blogTitle +"', "+"blogDesc : '" + blogDesc + "'," + "id :'" + id + "'}";
		
	}
	
		
}
