<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@include file ="../../header.jsp" %>


<h1 class="text-center"> Department </h1>
<form method="post" class="form-horizontal" action="${SITE_URL}/company/department/create">
    
    <div class="form-group">
        <label class="col-sm-3 control-label">Department Name</label>
        <div class="col-sm-8">
            
        <input name="departmentName" class="form-control">
        </div>
    </div>
    
    <div class ="form-group">
        <label for="Department Type"class="col-sm-3 control-label ">Department Type </label>
    <div class ="col-sm-8">
        <input name ="departmentType" class="form-control">
    </div>
    </div>
    
    <div class="clearfix">&nbsp;</div>
<div class="col-sm-12 text-center">
<button type="submit" class="btn btn-primary btn-md"><span
class="glyphicon glyphicon-send"></span>&nbsp;Submit</button>
</div>
    
    
</form>

<%@include file="../../footer.jsp" %>
