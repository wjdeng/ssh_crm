package cn.itcast.entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	//客户id
	private Integer cid;
	//客户名称
	private String custName;
	//客户级别
//	private String custLevel;
	//客户来源
	private String custSource;
	
	private String custLinkman;
	
	//联系电话  010-45634
	private String custPhone;
	//手机  013425176891
	private String custMobile;
	
	private String custAddress;
	
	//邮政编码
	private String custZip;
	
	//客户传真
	private String custFax;
	
	//客户网址
	private String custWebsite;
	
	private Dict dictCustLevel;
	
	

	
	public Dict getDictCustLevel() {
		return dictCustLevel;
	}

	public void setDictCustLevel(Dict dictCustLevel) {
		this.dictCustLevel = dictCustLevel;
	}

	private Set<LinkMan> setLinkMan = new HashSet<LinkMan>();
	
	private Set<Visit> setCustomerVisit = new HashSet<Visit>();
	
	public Set<Visit> getSetCustomerVisit() {
		return setCustomerVisit;
	}

	public void setSetCustomerVisit(Set<Visit> setCustomerVisit) {
		this.setCustomerVisit = setCustomerVisit;
	}

	public Set<LinkMan> getSetLinkMan() {
		return setLinkMan;
	}

	public void setSetLinkMan(Set<LinkMan> setLinkMan) {
		this.setLinkMan = setLinkMan;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}



	public String getCustSource() {
		return custSource;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	public String getCustLinkman() {
		return custLinkman;
	}

	public void setCustLinkman(String custLinkman) {
		this.custLinkman = custLinkman;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustZip() {
		return custZip;
	}

	public void setCustZip(String custZip) {
		this.custZip = custZip;
	}

	public String getCustFax() {
		return custFax;
	}

	public void setCustFax(String custFax) {
		this.custFax = custFax;
	}

	public String getCustWebsite() {
		return custWebsite;
	}

	public void setCustWebsite(String custWebsite) {
		this.custWebsite = custWebsite;
	}
	
	
	
	
}
