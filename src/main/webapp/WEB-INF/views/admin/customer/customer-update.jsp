<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@include file = "../../header.jsp" %>


<h1 class="text-center">  Customer Details </h1>
<br/>
<form class="form-horizontal" method="POST" action="${SITE_URL}/customer/edit/${customer.id}">

    <div class="form-group">
        <label  class="col-sm-3 control-label">First Name</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                   placeholder="FirstName" name="firstName" value="${customer.firstName}">
        </div>
    </div>

    <div class="form-group">
        <label for="Last Name" class="col-sm-3 control-label">Last Name</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                   placeholder="Last Name"  name="lastName" value="${customer.lastName}">
        </div>
    </div>

   
    
     <div class="form-group">
        <label  class="col-sm-3 control-label">JOB POSITION</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                    name="jobPosition" value="${customer.jobPosition}">
        </div>
    </div>


    <div class="form-group">
        <label for="Company Name" class="col-sm-3 control-label">Company Name</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                    name="companyName" value="${customer.companyName}">
        </div>
    </div>
    <br/>
    
    
    <div class="form-group">
        <label for="Contact Number" class="col-sm-3 control-label">Contact Number</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                    name="contactNumber" value="${customer.contactNumber}">
        </div>
    </div>
    <br/>




    <div class="clearfix">&nbsp;</div>
    <div class="col-sm-12 text-center">
        <button type="submit" class="btn btn-primary btn-md"><span
                class="glyphicon glyphicon-send"></span>&nbsp;Submit</button>
    </div>






</form>        

<%@include file = "../../footer.jsp" %>