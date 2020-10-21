package com.p06customInterceptor.interceptors;

import java.util.Map;

import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.Parameter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class UppercaseInterceptor implements Interceptor{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ValueStack vs = invocation.getStack();
		String username = vs.findString("username");
		vs.set("username", username.toUpperCase());
		System.out.println(vs.findString("username")+" intercept username "+username);
		return invocation.invoke();
	}
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
