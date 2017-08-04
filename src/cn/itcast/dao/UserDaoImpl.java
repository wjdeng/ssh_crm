package cn.itcast.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.itcast.entity.User;

public class UserDaoImpl implements UserDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("all")
	@Override
	public User loginForUser(User user) {
		
		List<User> list = (List<User>) hibernateTemplate.
				find("from User where username=? and password=?", user.getUsername(),user.getPassword());
		
		if(list != null && list.size()!=0){
			User u = list.get(0);
			return u;
		}
		
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) hibernateTemplate.find("from User");
	}
	
	
}
