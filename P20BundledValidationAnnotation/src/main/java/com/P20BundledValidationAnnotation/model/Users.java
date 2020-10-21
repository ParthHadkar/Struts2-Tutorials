package com.P20BundledValidationAnnotation.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.P20BundledValidationAnnotation.dao.UsersDao;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.DoubleRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.UrlValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

public class Users extends ActionSupport {//implements Action
	//ActionSupport Uses Action, Validateable, ValidationAware, TextProvider, LocaleProvider, Serializable 
	private String username,emailId,gender,url,password,cPassword;
	private Date dob;
	private long mobileNo;
	private int age;
	private double height;
	
	public Users() {}

	public Users(String username, String emailId, String gender, String url, Date dob, String password,
			String cPassword, long mobileNo, int age, double height) {
		this.username = username;
		this.emailId = emailId;
		this.gender = gender;
		this.url = url;
		this.dob = dob;
		this.password = password;
		this.cPassword = cPassword;
		this.mobileNo = mobileNo;
		this.age = age;
		this.height = height;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getGender() {
		return gender;
	}
	
	@RequiredFieldValidator(type = ValidatorType.SIMPLE,fieldName = "gender",
			message = "Gender Are Required" )
	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getUrl() {
		return url;
	}
	
	@RequiredStringValidator(type = ValidatorType.FIELD,fieldName = "url",
			trim = true,message = "URL can't be empty")
	@UrlValidator(type = ValidatorType.FIELD,fieldName = "url",
			message = "URL must be correct e.g. http://www.google.com ")
	public void setUrl(String url) {
		this.url = url;
	}



	public Date getDob() {
		return dob;
	}
	
	@RequiredFieldValidator(type = ValidatorType.FIELD,fieldName = "dob",
			message = "Dob can't be empty" )
	@DateRangeFieldValidator(type = ValidatorType.FIELD,fieldName = "dob",dateFormat = "dd/MM/yyyy",
	min = "01/01/1980",max = "01/01/2030",message = "Dob must be between ${min} to ${max}")
	public void setDob(Date dob) {
		this.dob = dob;
	}



	public String getPassword() {
		return password;
	}
	
	@RequiredStringValidator(type = ValidatorType.FIELD,fieldName = "password",
			trim = true,message = "Password can't be empty")
	@StringLengthFieldValidator(type = ValidatorType.FIELD,fieldName = "password",trim = true,
	minLength = "8",maxLength = "32",message = "Password must be between ${minLength} to ${maxLength}")
	public void setPassword(String password) {
		this.password = password;
	}


	
	public String getcPassword() {
		return cPassword;
	}
	
	@RequiredStringValidator(type = ValidatorType.FIELD,fieldName = "cPassword",
			trim = true,message = "Confirm Password can't be empty")
	@StringLengthFieldValidator(type = ValidatorType.FIELD,fieldName = "cPassword",trim = true,
	minLength = "8",maxLength = "32",message = "Confirm Password must be between ${minLength} to ${maxLength}")
	@FieldExpressionValidator(fieldName = "cPassword",expression = "(Password == cPassword)",
	message = "Password and Confirm password must be same")
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}



	public long getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}



	public int getAge() {
		return age;
	}
	
	@IntRangeFieldValidator(type = ValidatorType.FIELD,fieldName = "Age",min = "18",
			max="60",message = "Age must be between ${min} to ${max}")
	public void setAge(int age) {
		this.age = age;
	}



	public double getHeight() {
		return height;
	}
	
	@DoubleRangeFieldValidator(type = ValidatorType.FIELD,fieldName = "height",minInclusive = "4.0",
			maxExclusive = "10.0",message = "Height must be between ${minInclusive} to ${maxExclusive}")
	public void setHeight(double height) {
		this.height = height;
	}


	@Validations(
	requiredStrings = {
			@RequiredStringValidator(type = ValidatorType.SIMPLE,fieldName = "username",
					trim = true,message = "Username can't be empty"),
			@RequiredStringValidator(type = ValidatorType.SIMPLE,fieldName = "emailId",
			trim = true,message = "EmailId can't be empty")
	},
    regexFields = {
    		@RegexFieldValidator(type = ValidatorType.SIMPLE,fieldName = "mobileNo",
    				regexExpression = "<![CDATA[[0-9]{10}]]>",trim = true,
    				caseSensitive = true,message = "MobileNo must be 10 digits"),
    		@RegexFieldValidator(type = ValidatorType.SIMPLE,fieldName = "emailId",
			regexExpression = "[a-z0-9A-Z]{5,32}[@][a-zA-Z]{5,10}[.][a-z]{3}",trim = true,
			message = "EmailId must be valid")
    }		
			)
	public String execute() {
		String result = ERROR;
		Users user = new Users(username, emailId, gender, url, dob, password, cPassword, mobileNo, age, height);
		System.out.println("user "+user.toString());
		if(UsersDao.checkUser(mobileNo, emailId)) {
			result = INPUT;
		}
		else if(UsersDao.addUser(user)>0){
			result = SUCCESS;
		}
		return result;
	}
}
