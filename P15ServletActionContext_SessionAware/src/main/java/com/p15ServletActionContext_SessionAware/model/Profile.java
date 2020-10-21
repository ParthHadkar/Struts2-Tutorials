package com.p15ServletActionContext_SessionAware.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.ValidationAware;

public class Profile extends ActionSupport implements Interceptor{
	public String execute() {
		System.out.println("session ");
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(false);
		System.out.println("session "+(session == null) +"\n"+ (session.getAttribute("login") == null));
		if(session == null || session.getAttribute("login") == null) {
			addActionError("You must Login First");
			result = INPUT;
		}
		else {
			result = SUCCESS;
		}
		return result;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unused")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(false);//invocation.getInvocationContext().getSession();
		System.out.println("session "+(session == null) +"\n"+ (session.getAttribute("login") == null));
		if((session.getAttribute("login") == null)) {
			addActionError("You must Login First");
			 Object action = invocation.getAction ();
			 if (action instanceof ValidationAware) {
			 ((ValidationAware) action).addActionError("You must Login First");
			 }
			System.out.println("session if");
			//return INPUT;
			return invocation.invoke();
		}
		else {
			System.out.println("session else");
			return invocation.invoke();
		}
	}
}
