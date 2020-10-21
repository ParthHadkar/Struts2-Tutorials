package mypack;

import javax.naming.AuthenticationException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.After;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.validator.ValidationException;

/*@Results({
	@Result(name = "success",type = "dispacher",location = "/myResults/login-success.jsp"),
	@Result(name = "error",location = "/myResults/login-error.jsp")
})*/
public class Login extends ActionSupport{
	private String username,password;

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
	/*@After
	public void isValid() throws ValidationException {
	      // validate model object, throw exception if failed
		System.out.println("@After");
	   }
	 @BeforeResult
	   public void isValids() throws ValidationException {
	    // validate model object, throw exception if failed
		 System.out.println("@BeforeResult");
	   }
	@Before
	   public void isAuthorized() throws AuthenticationException {
	      // authorize request, throw exception if failed
		System.out.println("@Before");
	   }*/
	//@Action(value = "/check")
	@Action(value="/logins",
			results={
				@Result(name = "success",type = "dispatcher",location = "/myResults/login-success.jsp"),
				@Result(name = "error",location = "/myResults/login-error.jsp")
			})
	public String execute() {
		System.out.println("execute");
		String result = "";
		if(username.equals("Admin") && password.equals("Admin")) {
			result ="success";
		}
		else {
			result ="error";
		}
		return result;
	}
}
