<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@include file = "../../header.jsp" %>

<h1 class="text-center">  Employee Details </h1>
<br/>
<form class="form-horizontal" method="POST" action="${SITE_URL}/employee/edit/${employee.id}">

    <div class="form-group">
        <label for="FirstName" class="col-sm-3 control-label">First Name</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                    name="firstName" value="${employee.firstName}" >
        </div>
    </div>

    <div class="form-group">
        <label for="Last Name" class="col-sm-3 control-label">Last Name</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                     name="lastName"  value="${employee.lastName}">
        </div>
    </div>

   
    
     <div class="form-group">
        <label for="ADDRESS" class="col-sm-3 control-label">ADDRESS</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                    name="address"  value="${employee.address}">
        </div>
    </div>


    <div class="form-group">
        <label for="Contact Number" class="col-sm-3 control-label">Contact Number</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                  value="${employee.contactNumber}" name="contactNumber">
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