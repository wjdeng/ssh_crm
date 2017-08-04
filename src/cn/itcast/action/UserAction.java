package cn.itcast.action;



import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.itcast.entity.User;
import cn.itcast.service.UserService;

public class UserAction {

	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private String username;
	private String password;
		
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@SuppressWarnings("unused")
	public String login(){
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		User u = userService.login(user);
		
		if(u!=null){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("user", user);
			return "loginsuccess";
		}
		return "login";
	}
}
