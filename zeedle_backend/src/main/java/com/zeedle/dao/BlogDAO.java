package com.zeedle.dao;

import java.util.List;

import com.zeedle.model.Blog;

public interface BlogDAO {
	 List<Blog> getAllBlog();
	 Blog getBlogById(int blogId);
	    boolean addBlog(Blog blog);
	    void updateBlog(Blog blog);
	    void deleteBlog(int blogId);
	    public Blog getView(int blogId);


}
