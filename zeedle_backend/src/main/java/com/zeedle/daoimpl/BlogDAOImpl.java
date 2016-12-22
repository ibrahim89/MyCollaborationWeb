package com.zeedle.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zeedle.dao.BlogDAO;
import com.zeedle.model.Blog;
@Repository
public class BlogDAOImpl implements BlogDAO{

	public BlogDAOImpl() {
		
		}
	@Autowired
	private SessionFactory sessionFactory;
	public BlogDAOImpl(SessionFactory sessionFactory) {
	
		this.sessionFactory = sessionFactory;
	}
	public List<Blog> getAllBlog() {
		@SuppressWarnings("unchecked")
		List<Blog> listBlog = (List<Blog>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Blog.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listBlog;
		

	}
	public Blog getBlogById(int blogId) {
		//select *from Blog where id='101'
				String hql = "from Blog where blogId=" + "'"+ blogId +"'";
				Query query = sessionFactory.getCurrentSession().createQuery(hql);
				
				@SuppressWarnings("unchecked")
				List<Blog> listBlog = (List<Blog>) query.list();
				
				if (listBlog != null && !listBlog.isEmpty()) {
					return listBlog.get(0);
				}
				return null;

	}
	public boolean addBlog(Blog blog) {
		sessionFactory.getCurrentSession().save(blog);
		return false;

	}
	public void updateBlog(Blog blog) {
		sessionFactory.getCurrentSession().update(blog);
		
	}
	public void deleteBlog(int blogId) {
		Blog BlogToDelete = new Blog();
		BlogToDelete.setBlogId(blogId);
		sessionFactory.getCurrentSession().delete(BlogToDelete);
		
		
	}
	public Blog getView(int blogId) {
		 //select *from Blog where id='101';
		String hql = "from Blog where blogId=" + "'"+ blogId +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Blog> listBlog = (List<Blog>) query.list();
		
		if (listBlog != null && !listBlog.isEmpty()) {
			return listBlog.get(0);
		}
		
		return null;


	}
	
	
	

}
