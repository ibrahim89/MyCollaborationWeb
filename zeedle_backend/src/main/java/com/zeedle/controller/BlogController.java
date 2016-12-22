package com.zeedle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.zeedle.model.Blog;
import com.zeedle.service.BlogService;

@RestController
public class BlogController {
	@Autowired (required=true)
	private BlogService blogService;
	
	// For getting blog id
		@RequestMapping(value="/blogs/{blogId}", method = RequestMethod.GET )
		public ResponseEntity<Blog> getBlogById(@PathVariable("blogId") Integer blogId) {
			Blog blog = blogService.getBlogById(blogId);
			return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		}
		
		// For getting all blogs
		@RequestMapping(value= "/blogs", method = RequestMethod.GET)
		public ResponseEntity<List<Blog>> getAllBlog() {
			List<Blog> list = blogService.getAllBlog();
			return new ResponseEntity<List<Blog>>(list, HttpStatus.OK);
		}
		/*//
		@RequestMapping(value="/blog/{blogId}", method=RequestMethod.GET)
		public ResponseEntity<Blog> getBlog(@PathVariable("blogId") int blogId)
		{
			Blog blog=blogService.getBlogById(blogId);
			if(blog==null)
			{
				blog=new Blog();
				return new ResponseEntity<Blog>(blog,HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		}*/
	//For add blog.... 
		@RequestMapping(value= "/blogs", method = RequestMethod.POST)
		public ResponseEntity<Void> addBlog(@RequestBody Blog blog, UriComponentsBuilder builder) {
	        boolean flag = blogService.addBlog(blog);
	               if (flag == false) {
	        	  return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	               }
	               HttpHeaders headers = new HttpHeaders();
	               headers.setLocation(builder.path("/blog/{blogId}").buildAndExpand(blog.getBlogId()).toUri());
	               return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		
	
	//For update blog
	@RequestMapping(value="/blogs/{blogId}", method = RequestMethod.PUT )
	public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog) {
		blogService.updateBlog(blog);
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	
	// For delete blog
	@RequestMapping(value="/blogs/{blogId}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> deleteBlog(@PathVariable("blogId") Integer blogId) {
		blogService.deleteBlog(blogId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	} 
}
