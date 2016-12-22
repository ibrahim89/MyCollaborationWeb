package com.zeedle.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zeedle.dao.UserDAO;
import com.zeedle.model.UserDetail;


@Repository
public class UserDAOImpl implements UserDAO{

	
	public UserDAOImpl() {
		}
	@Autowired
	private SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	public List<UserDetail> getAllUser() {
		@SuppressWarnings("unchecked")
		List<UserDetail> listUser = (List<UserDetail>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(UserDetail.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listUser;
		
	}
	public UserDetail getUserById(int id) {
		//select *from UserDetail where id='101'
				String hql = "from UserDetail where id=" + "'"+ id +"'";
				Query query = sessionFactory.getCurrentSession().createQuery(hql);
				
				@SuppressWarnings("unchecked")
				List<UserDetail> listUser = (List<UserDetail>) query.list();
				
				if (listUser != null && !listUser.isEmpty()) {
					return listUser.get(0);
				}
				return null;
			
	}
	public boolean addUser(UserDetail user) {
		sessionFactory.getCurrentSession().save(user);
		return false;
	}
	public void updateUser(UserDetail user) {
		sessionFactory.getCurrentSession().update(user);
		
	}
	public void deleteUser(int id) {
		UserDetail UserToDelete = new UserDetail();
		UserToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(UserToDelete);
		
	}
	public UserDetail authenticate(String name,String password) {
		String hql="from UserDetail where name='"+name+"' and "+"password='"+password+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<UserDetail> list=(List<UserDetail>)query.list();
		if(list!=null && !list.isEmpty())
		{
			return list.get(0);
		}
		
		return null;
	}
	public UserDetail getByName(String name) {
		// select *from UserDetail where name=''
		String hql ="from UserDetail where name =" + "'"+ name +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<UserDetail> listUserDetail = (List<UserDetail>) query.list();
		
		if (listUserDetail != null && !listUserDetail.isEmpty()) {
			return listUserDetail.get(0);
		}
		return null;


		
	}
	public void setOnline(int id) {
		String hql="UPDATE Friend SET isOnline='Y' where id='"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
		}
		
	
	public void setOffLine(int id) {
		String hql="UPDATE Friend SET isOnline='N' where id='"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
		
	}
	



}
