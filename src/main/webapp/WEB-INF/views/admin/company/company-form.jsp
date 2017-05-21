<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@include file = "../../header.jsp" %>

<h1 class="text-center">  Add Company </h1>
<br/>
<form class="form-horizontal" method="POST" action="${SITE_URL}/company/create">

    <div class="form-group">
        <label  class="col-sm-3 control-label">Company Name</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                   placeholder="Company Name" name="companyName">
        </div>
    </div>




    <div class="clearfix">&nbsp;</div>
    <div class="col-sm-12 text-center">
        <button type="submit" class="btn btn-primary btn-md"><span
                class="glyphicon glyphicon-send"></span>&nbsp;Submit</button>
    </div>






</form>        

<%@include file = "../../footer.jsp" %>
