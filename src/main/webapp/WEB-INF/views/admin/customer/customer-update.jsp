<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "../../header.jsp" %>


<h1 class="text-center">  Customer Details </h1>
<br/>
<form:form class="form-horizontal" method="POST" modelAttribute="customerForm" action="${SITE_URL}/customer/edit/${id}">

    <form:input type="hidden" path="id"/>
    <div class="form-group">
        <label for="FirstName" class="col-sm-3 control-label">First Name</label>
        <div class="col-sm-8">
            <form:input type="text" class="form-control" 
                        placeholder="FirstName" path="firstName" />
        </div>

    </div>

    <div class="form-group">
        <label  class="col-sm-3 control-label">Last Name</label>
        <div class="col-sm-8">
            <form:input type="text" class="form-control" 
                        placeholder="Last Name"  path="lastName" value="${customer.lastName}"/>
        </div>

    </div>
    <div class="form-group">
        <label  class="col-sm-3 control-label"> Address</label>
        <div class="col-sm-8">
            <form:input type="text" class="form-control" 
                        placeholder="Enter the Address"  path="address" value="${customer.address}"/>
        </div>

    </div>    

    <div class="form-group">
        <label  class="col-sm-3 control-label">Email Address</label>
        <div class="col-sm-8">
            <form:input type="text" class="form-control" 
                        placeholder="Enter the email Address"  path="emailAddress" value="${customer.emailAddress}"/>
        </div>

    </div>



    <div class="form-group">
        <label for="COMPANY" class="col-sm-3 control-label">COMPANY</label>
        <div class="col-sm-8">
            <form:input type="text" class="form-control" 
                        placeholder="COMPANY" path="companyName" value="${customer.companyName}"/>
        </div>

    </div>


    <div class="form-group">
        <label  class="col-sm-3 control-label">JOB POSITION</label>
        <div class="col-sm-8">
            <form:input type="text" class="form-control" 
                        placeholder="JOB POSITION" path="jobPosition" value="${customer.jobPosition}"/>
        </div>

    </div>


    <div class="form-group">
        <label  class="col-sm-3 control-label">Contact Number</label>
        <div class="col-sm-8">
            <form:input type="number" class="form-control" 
                        placeholder="Enter the Contact Number" path="contactNumber" value="${customer.contactNumber}"/>
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