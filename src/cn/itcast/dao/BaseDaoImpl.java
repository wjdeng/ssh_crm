package cn.itcast.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {


	
	private Class clazzType;

	public BaseDaoImpl() {
		Class clazz = this.getClass();
		
		Type type = clazz.getGenericSuperclass();
		
		ParameterizedType ptype = (ParameterizedType) type;
		
		Type[] types = ptype.getActualTypeArguments();
		
		Class classParameter = (Class) types[0];
		
		this.clazzType = classParameter;
	}



	@Override
	public void add(Object t) {
		
		this.getHibernateTemplate().save(t);
		
	}

	@Override
	public void update(Object t) {
		this.getHibernateTemplate().update(t);
		
	}

	@Override
	public void delete(Object t) {
		
		this.getHibernateTemplate().delete(t);
		
	}

	@Override
	public T get(int id) {
		// TODO Auto-generated method stub
		return (T) this.getHibernateTemplate().get(clazzType, id);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return (List<T>) this.getHibernateTemplate().find("from "+clazzType.getSimpleName());
	}

}
