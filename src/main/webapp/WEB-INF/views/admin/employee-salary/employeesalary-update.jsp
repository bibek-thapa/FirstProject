<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@include file = "../../header.jsp" %>

<h1 class="text-center">  Employee Salary Details </h1>
<br/>
<form class="form-horizontal" method="post" action="${SITE_URL}/employeeSalary/edit/${employeeSalary.id}">

    <input type="hidden" name="id" value="${employeeSalary.id}">
    
    <div class="form-group">
        <label for="EmployeePosition" class="col-sm-3 control-label">Employee Position</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                   value="${employeeSalary.employeePosition}" name="employeePosition">
        </div>
    </div>

    <div class="form-group">
        <label for="Pay Rate" class="col-sm-3 control-label">Pay Rate</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                   value="${employeeSalary.payRate}"  name="payRate">
        </div>
    </div>

   
<!--    
     <div class="form-group">
        <label for="BONUS" class="col-sm-3 control-label">BONUS</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                   placeholder="BONUS" name="bonus">
        </div>
    </div>-->


    




    <div class="clearfix">&nbsp;</div>
    <div class="col-sm-12 text-center">
        <button type="submit" class="btn btn-primary btn-md"><span
                class="glyphicon glyphicon-send"></span>&nbsp;Submit</button>
    </div>
</form>        
<%@include file = "../../footer.jsp" %>