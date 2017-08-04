package cn.itcast.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.classfile.Field;

import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;
import cn.itcast.service.CustomerService;
import cn.itcast.service.LinkManService;
import cn.itcast.service.UserService;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{

	private LinkManService linkManService;
		
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	
	private CustomerService customerService;
			
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	private LinkMan linkMan = new LinkMan();
	
	public void setLinkman(LinkMan linkman) {
		this.linkMan = linkman;
	}


	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkMan;
	}



	public String toAddPage(){
		List<Customer> listCustomer = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		return "toAddPage";
	}
	
	
	private File upload;
	private String uploadFileName;
	
	public File getUpload() {
		return upload;
	}


	public void setUpload(File upload) {
		this.upload = upload;
	}


	public String getUploadFileName() {
		return uploadFileName;
	}


	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}


	public String addLinkMan() throws IOException{
		
		if(upload!=null){
			File serviceFile = new File("D:\\sshfile"+"/"+uploadFileName);
			FileUtils.copyFile(upload, serviceFile);
		}
		
		linkManService.addLinkMan(linkMan);
		return "addLinkMan";
	}


	public String list(){
		List<LinkMan> list = linkManService.findAll();
		
		ServletActionContext.getRequest().setAttribute("list", list);
		
		return "list";
	}
	
	public String showLinkMan(){
		
		int linkid = linkMan.getLinkid();
		LinkMan linkman = linkManService.findOne(linkid);
		List<Customer> listCustomer = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		ServletActionContext.getRequest().setAttribute("linkman", linkman);
		
		
		
		return "showLinkMan";
	}
	
	public String updateLinkMan(){
		
		linkManService.updateLinkMan(linkMan);
		
		return "updateLinkMan";
	}
	
	public String deleteLinkMan(){
		
		linkManService.deleteLinkMan(linkMan);
		return "deleteLinkMan";
	}


	//到联系人查询页面
	public String toSelectPage(){
		
		List<Customer> list = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		
		return "toSelectPage";
	}
	
	//多条件查询联系人
	public String findMoreCondition(){
		
		List<LinkMan> list = linkManService.findMoreCondition(linkMan);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "findMoreCondition";
	}
	

}
