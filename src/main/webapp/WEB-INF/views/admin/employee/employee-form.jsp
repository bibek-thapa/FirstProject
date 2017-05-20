<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@include file = "../../header.jsp" %>

<h1 class="text-center">  Employee Details </h1>
<br/>
<form class="form-horizontal" method="POST" action="${SITE_URL}/employee/create">

    <div class="form-group">
        <label for="FirstName" class="col-sm-3 control-label">First Name</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                   placeholder="FirstName" name="firstName">
        </div>
    </div>

    <div class="form-group">
        <label for="Last Name" class="col-sm-3 control-label">Last Name</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                   placeholder="Last Name"  name="lastName">
        </div>
    </div>

   
    
     <div class="form-group">
        <label for="ADDRESS" class="col-sm-3 control-label">ADDRESS</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                   placeholder="ADDRESS" name="address">
        </div>
    </div>


    <div class="form-group">
        <label for="Contact Number" class="col-sm-3 control-label">Contact Number</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                   placeholder="Enter the Contact Number" name="contactNumber">
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
