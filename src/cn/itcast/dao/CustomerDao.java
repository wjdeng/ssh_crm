package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;

 public interface CustomerDao extends BaseDao<Customer>{

//	public List<Customer> findAll();

//	public void addCustomer(Customer customer);

//	public Customer findOne(int cid);

//	public void delete(Customer c);
//
//	public void updateCustomer(Customer customer);

	public int findCount();

	public List<Customer> findPage(int begin, int pageSize);

	public List<Customer> findCondition(Customer customer);

	public List<Customer> moreCondition(Customer customer);

	public List<Dict> findAllDictLevel();

	public List findCountSource();

	public List findCountLevel();


}
