<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<s:head/>
</head>
<body>
<h1>Non-Form UI Tags</h1>
 <s:actionerror />
      <s:actionmessage />
     <%--   <s:component template="/Error.jsp"/>
     <s:component template="/Error.jsp">
    <s:param name="key1" value="value1"/>
    <s:param name="key2" value="value2"/>
</s:component> --%>
<!-- example 1 -->
    <s:fielderror />

    <!-- example 2 -->
    <s:fielderror>
         <s:param>field1</s:param>
         <s:param>field2</s:param>
    </s:fielderror>
    <s:form >
       ....
    </s:form>

    OR

    <s:fielderror>
          <s:param value="%{'field1'}" />
          <s:param value="%{'field2'}" />
    </s:fielderror>
    <s:form >
       ....
    </s:form>

    OR

    <s:fielderror fieldName="field1" />
<h1>Form UI Tags</h1>    
	<div>Email Form</div>
      <s:text name = "Please fill in the form below:" />
      <s:form action = "Login" method = "post" enctype = "multipart/form-data">
         <s:hidden name = "secret" value = "abracadabra"/>
         <s:textfield key = "email.from" name = "from" />
         <s:password key = "email.password" name = "password" />
         <s:textfield key = "email.to" name = "to" />
         <s:textfield key = "email.subject" name = "subject" />
         <s:textarea key = "email.body" name = "email.body" cols="30" rows="8"/>
         <s:label for = "attachment" value = "Attachment"/>
         <s:file name = "attachment" accept = "text/html,text/plain" />
         
         <%-- <s:datetextfield format="dd-MM-yyyy"></s:datetextfield> --%>
         <s:token />
         <s:submit key = "submit" />
      </s:form>
<h1>Group UI Tags</h1>	
<s:form action = "Login">
         <s:radio label = "Gender" name = "gender" list="{'male','female'}" />
         <s:checkboxlist label = "Hobbies" name = "hobbies"
         list = "{'sports','tv','shopping'}" />
         <s:label for="checkboxField1" label="checkboxField1"/>
         <s:checkbox label="checkbox test" name="checkboxField1" id="checkboxField1" value="true" fieldValue="true"/>
         
         
      </s:form>
<h1>Select UI Tags</h1>	
 <s:form action = "Login" name="f3">
         <s:select name = "username" label = "Username"
            list = "{'Mike','John','Smith'}" />

         <s:select label = "Company Office" name = "mySelection"
            value = "%{'America'}" list="%{#{'America':'America'}}">
            <s:optgroup label = "Asia" 
               list = "%{#{'India':'India','China':'China'}}" />
            <s:optgroup label = "Europe"
               list="%{#{'UK':'UK','Sweden':'Sweden','Italy':'Italy'}}" />
         </s:select>

         <s:combobox label = "My Sign" name = "mySign"
            list = "#{'aries':'Aries','capricorn':'Capricorn'}"
             headerKey = "-1" headerValue = "--- Please Select ---"
              emptyOption = "true" value = "capricorn" /><%--value:key --%>
        
         <s:doubleselect label="Occupation" name="occupation"
          list="{'Technical','Other'}" doubleName="occupations2" 
          doubleList="top == 'Technical' ?  {'I.T', 'Hardware'} : {'Accounting', 'H.R'}" formName="f3"></s:doubleselect>
           
           <s:doubleselect label="doubleselect test1" name="menu1" 
           list="{'fruit','other'}" doubleName="dishes1"
           doubleList="top == 'fruit' ? {'apple', 'orange'} : {'monkey', 'chicken'}" formName="f3"/>
 
 <s:doubleselect label="doubleselect test2" name="menu2" 
 list="#{'kfruit':'Nice Fruits', 'kother':'Other Dishes'}" doubleName="dishes2" 
 doubleList="top == 'kfruit' ? {'apple', 'orange'} : {'monkey', 'chicken'}" formName="f3"/>
 
 <s:inputtransferselect list="#{'kfruit':'Nice Fruits', 'kother':'Other Dishes'}" label="flist" name="food"
 ></s:inputtransferselect>
 
 <!-- minimum configuration -->
 <s:optiontransferselect
      label="Favourite Cartoons Characters"
      name="leftSideCartoonCharacters1"
      list="{'Popeye', 'He-Man', 'Spiderman'}"
      doubleName="rightSideCartoonCharacters1"
      doubleList="{'Superman', 'Mickey Mouse', 'Donald Duck'}"
  />

  <!-- possible configuration -->
  <s:optiontransferselect
      label="Favourite Cartoons Characters"
      name="leftSideCartoonCharacters2"
      leftTitle="Left Title"
      rightTitle="Right Title"
      list="{'Popeye', 'He-Man', 'Spiderman'}"
      multiple="true"
      headerKey="headerKey"
      headerValue="--- Please Select ---"
      emptyOption="true"
      doubleList="{'Superman', 'Mickey Mouse', 'Donald Duck'}"
      doubleName="rightSideCartoonCharacters2"
      doubleHeaderKey="doubleHeaderKey"
      doubleHeaderValue="--- Please Select ---"
      doubleEmptyOption="true"
      doubleMultiple="true"
  />
  
   <!-- Example 1: simple example -->
 <s:updownselect
 list="#{'england':'England', 'america':'America', 'germany':'Germany'}"
 name="prioritisedFavouriteCountries"
 headerKey="-1"
 headerValue="--- Please Order Them Accordingly ---"
 emptyOption="true" />

 <!-- Example 2: more complex example -->
 <s:updownselect
 list="#{'england':'England', 'america':'America', 'germany':'Germany'}"
 name="prioritisedFavouriteCartoonCharacters"
 headerKey="-1"
 headerValue="--- Please Order ---"
 emptyOption="true"
 allowMoveUp="true"
 allowMoveDown="true"
 allowSelectAll="true"
 moveUpLabel="Move Up"
 moveDownLabel="Move Down"
 selectAllLabel="Select All" />
  <s:reset value="Reset" />
 <s:reset type="button" key="reset" value="Reset"/>
           <s:submit key = "submit" />
      </s:form>     
</body>
</html>