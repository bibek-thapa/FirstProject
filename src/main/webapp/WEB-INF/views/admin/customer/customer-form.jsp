<%@include file = "../../header.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center">  Customer </h1>
<br/>
<form:form class="form-horizontal" modelAttribute="customerForm" method="POST" action="${SITE_URL}/customer/create">
    <form:errors path="*"  cssClass="errors" class="form-control"/>
    <div class="form-group">
        <label for="FirstName" class="col-sm-3 control-label">First Name</label>
        <div class="col-sm-8">
            <form:input type="text" class="form-control" 
                        placeholder="FirstName" path="firstName"/>
        </div>
        <div class="has-error">
            <form:errors path="firstName"></form:errors>
        </div>
    </div>

    <div class="form-group">
        <label  class="col-sm-3 control-label">Last Name</label>
        <div class="col-sm-8">
            <form:input type="text" class="form-control" 
                        placeholder="Last Name"  path="lastName"/>
        </div>
        <div class="has-error">
            <form:errors path="lastName"></form:errors>
        </div>
    </div>
    <div class="form-group">
        <label  class="col-sm-3 control-label"> Address</label>
        <div class="col-sm-8">
            <form:input type="text" class="form-control" 
                        placeholder="Enter the Address"  path="address"/>
        </div>
        <div class="has-error">
            <form:errors path="address"></form:errors>
        </div>
    </div>    

    <div class="form-group">
        <label  class="col-sm-3 control-label">Email Address</label>
        <div class="col-sm-8">
            <form:input type="text" class="form-control" 
                        placeholder="Enter the email Address"  path="emailAddress"/>
        </div>
        <div class="has-error">
            <form:errors path="emailAddress"></form:errors>
        </div>
    </div>



    <div class="form-group">
        <label for="COMPANY" class="col-sm-3 control-label">COMPANY</label>
        <div class="col-sm-8">
            <form:input type="text" class="form-control" 
                        placeholder="COMPANY" path="companyName"/>
        </div>
        <div class="has-error">
            <form:errors path="companyName"></form:errors>
        </div>
    </div>


    <div class="form-group">
        <label  class="col-sm-3 control-label">JOB POSITION</label>
        <div class="col-sm-8">
            <form:input type="text" class="form-control" 
                        placeholder="JOB POSITION" path="jobPosition"/>
        </div>
        <div class="has-error">
            <form:errors path="jobPosition"></form:errors>
        </div>
    </div>


    <div class="form-group">
        <label  class="col-sm-3 control-label">Contact Number</label>
        <div class="col-sm-8">
            <form:input type="number" class="form-control" 
                        placeholder="Enter the Contact Number" path="contactNumber"/>
        </div>
        <div class="has-error">
            <form:errors path="contactNumber"></form:errors>
        </div>
    </div>
    <br/>
    <div class="clearfix">&nbsp;</div>
    <div class="col-sm-12 text-center">
        <button type="submit" class="btn btn-primary btn-md"><span
                class="glyphicon glyphicon-send"></span>&nbsp;Submit</button>
    </div>

</form:form>        

<%@include file = "../../footer.jsp" %>
