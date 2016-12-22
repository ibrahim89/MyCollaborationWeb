/*package com.zeedle.model;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.UUID;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class BlogComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int blogCommentId;
	private int id; // USER ID FOR REFERENCE
	private String blogCommentContent;
	
	private Timestamp commentedAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blogId", nullable = false)
	@JsonBackReference
	private Blog blog;

	public int getBlogCommentId() {
		return blogCommentId;
	}

	public void setBlogCommentId(int blogCommentId) {
		this.blogCommentId = blogCommentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBlogCommentContent() {
		return blogCommentContent;
	}

	public void setBlogCommentContent(String blogCommentContent) {
		this.blogCommentContent = blogCommentContent;
	}

	public Timestamp getCommentedAt() {
		return commentedAt;
	}

	public void setCommentedAt(Timestamp commentedAt) {
		this.commentedAt = commentedAt;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public BlogComment() {
		this.blogCommentId = "BLGCMT" + UUID.randomUUID().toString().substring(24).toUpperCase();
	}

	@Override
	public String toString() {
		return "BlogComment [blogCommentId=" + blogCommentId + ", id=" + id + ", blogCommentContent="
				+ blogCommentContent + ", commentedAt=" + commentedAt + ", blog=" + blog + "]";
	}
	

}
*/