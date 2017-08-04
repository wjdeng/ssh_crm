package cn.itcast.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;
import cn.itcast.entity.PageBean;
import cn.itcast.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	private Customer customer = new Customer();
	
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	
	public String listcondition(){
		
		if(customer.getCustName()!=null && !"".equals(customer.getCustName())){
			list = customerService.findCondition(customer);
			ServletActionContext.getRequest().setAttribute("list", list);
		}else{
			list = customerService.findAll();
		}
		return "listcondition";
	}
	
	
	
	
	
	
	
	public String toAddPage(){
		
		List<Dict> listDict = customerService.findAllDictLevel();
		ServletActionContext.getRequest().setAttribute("listDict", listDict);
		return "toAddPage";
	}
	
	public String add(){
		
		customerService.addCustomer(customer);		
		return "add";
	}
	
	private List<Customer> list;
	public List<Customer> getList() {
		return list;
	}
	
	public String list(){
		
		list = customerService.findAll();
		return "list";
	}

	
	@SuppressWarnings("unused")
	public String delete(){
		//使用模型驱动获取表单提交cid值
		int cid = customer.getCid();
		
		//删除规范写法:首先根据id查询，调用方法删除
		Customer c = customerService.findOne(cid);
		
		if(c!=null){
			customerService.delete(c);
		}
		
		return "delete";
	}
	
	public String showCustomer(){
		int cid = customer.getCid();
		Customer c = customerService.findOne(cid);
		
		ServletActionContext.getRequest().setAttribute("customer", c);
		
		return "showCustomer";
	}
	
	public String update(){
		
		customerService.updateCustomer(customer);
		return "update";
	}
	
	private Integer currentPage;
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	//分页的方法
	public String listPage(){
		
		PageBean pageBean = customerService.listPage(currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "listPage";
	}
	
	
	public String toSelectCustomerPage(){
		
		
		return "toSelectCustomerPage";
	}
	
	public String moreCondition(){
		
		
		List<Customer> list = customerService.moreCondition(customer);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "moreCondition";
	}

	public String findCountSource(){
		
		List list = customerService.findCountSource();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "findCountSource";
	}
	
	public String findCountLevel(){
		
		List list = customerService.findCountLevel();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "findCountLevel";
	}
	
	
}
