package cn.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.CustomerDao;
import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;
import cn.itcast.entity.PageBean;


@Transactional
public class CustomerService {

	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}

	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.add(customer);
		
	}

	public Customer findOne(int cid) {
		// TODO Auto-generated method stub
		return customerDao.get(cid);
	}

	public void delete(Customer c) {
		// TODO Auto-generated method stub
		customerDao.delete(c);
	}

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.update(customer);
	}

	public PageBean listPage(Integer currentPage) {
		// TODO Auto-generated method stub
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		int totalCount = customerDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		
		int totalPage = 0;
		if(totalCount%pageSize==0){
			totalPage = totalCount/pageSize;
		}else{
			totalPage = totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		
		int begin = (currentPage-1)*3;
		
		List<Customer> list = customerDao.findPage(begin,pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	public List<Customer> findCondition(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.findCondition(customer);
	}

	public List<Customer> moreCondition(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.moreCondition(customer);
	}

	public List<Dict> findAllDictLevel() {
		// TODO Auto-generated method stub
		return customerDao.findAllDictLevel();
	}

	public List findCountSource() {
		// TODO Auto-generated method stub
		return customerDao.findCountSource();
	}

	public List findCountLevel() {
		// TODO Auto-generated method stub
		return customerDao.findCountLevel();
	}
	
}
