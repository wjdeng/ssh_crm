package cn.itcast.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate5.HibernateTemplate;

import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {



//	@Override
//	public List<Customer> findAll() {
//		
//		List<Customer> list = (List<Customer>) hibernateTemplate.find("from Customer");
//		return list;
//	}

//	@Override
//	public void addCustomer(Customer customer) {
//		// TODO Auto-generated method stub
//		hibernateTemplate.save(customer);
//	}

//	@Override
//	public Customer findOne(int cid) {
//		// TODO Auto-generated method stub
//		return hibernateTemplate.get(Customer.class, cid);
//	}

//	@Override
//	public void delete(Customer c) {
//		// TODO Auto-generated method stub
//		hibernateTemplate.delete(c);
//	}

//	@Override
//	public void updateCustomer(Customer customer) {
//		// TODO Auto-generated method stub
//		hibernateTemplate.update(customer);
//	}

	
	@Override
	public int findCount() {
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Customer");
		if(list!=null&&list.size()!=0){
			Object obj =  list.get(0);
			Long lobj = (Long) obj;
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	@Override
	public List<Customer> findPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		
		/*SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = (Session) sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer");
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);*/
		
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
		
		return list;
	}

	@Override
	public List<Customer> findCondition(Customer customer) {
		
		
		/*第一种方式
		 * SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Customer where custName like ?");
		query.setParameter(0, "%"+customer.getCustName()+"%");*/
		
		
		//第二种方式
		/*List<Customer> list= (List<Customer>) hibernateTemplate.find("from Customer where custName like ?", "%"+customer.getCustName()+"%");
		return list;*/
		
		//第三种方式
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		detachedCriteria.add(Restrictions.like("custName", "%"+customer.getCustName()+"%"));
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		return list;
	}



	@Override
	public List<Customer> moreCondition(Customer customer) {
		// TODO Auto-generated method stub
		
		//这是通过拼接hql字符串的方法实现
//		String hql = "from Customer where 1=1 ";
//		
//		List<Object> p = new ArrayList<Object>();
//		
//		if(customer.getCustName()!=null && !"".equals(customer.getCustName())){
//			hql += " and custName=?";
//			p.add(customer.getCustName());
//		}
//		if(customer.getCustLevel()!=null&& !"".equals(customer.getCustLevel())){
//			hql += " and custLevel=?";
//			p.add(customer.getCustLevel());
//		}
//		if(customer.getCustSource()!=null&&!"".equals(customer.getCustSource())){
//			hql += " and custSource=?";
//			p.add(customer.getCustSource());
//		}
//		return (List<Customer>) this.getHibernateTemplate().find(hql, p.toArray());
		
		
		//接下来我是用detached离线对象来实现
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		
		if(customer.getCustName()!=null && !"".equals(customer.getCustName())){
			detachedCriteria.add(Restrictions.eq("custName", customer.getCustName()));
		}
//		if(customer.getCustLevel()!=null&& !"".equals(customer.getCustLevel())){
//			detachedCriteria.add(Restrictions.eq("custLevel", customer.getCustLevel()));
//		}
		if(customer.getCustSource()!=null&&!"".equals(customer.getCustSource())){
			detachedCriteria.add(Restrictions.eq("custSource", customer.getCustSource()));
		}
		
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		return list;
	}

	@Override
	public List<Dict> findAllDictLevel() {
		
		return (List<Dict>) this.getHibernateTemplate().find("from Dict");
	}



	@Override
	public List findCountSource() {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) AS num,t.custSource FROM t_customer t GROUP BY t.custSource";
		
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createSQLQuery(sql);
		
		
		query.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		
		List list = query.list();
					
		return list;
	}


	@Override
	public List findCountLevel() {
		// TODO Auto-generated method stub
		String sql = "SELECT a.num,d.dname FROM (SELECT COUNT(*) AS num,c.custLevel FROM t_customer c GROUP BY c.custLevel) a,t_dict d WHERE a.custLevel=d.did";
		
		Session session = this.getSessionFactory().getCurrentSession();
		
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		
		List list = sqlQuery.list();
		return list;
	}


}
