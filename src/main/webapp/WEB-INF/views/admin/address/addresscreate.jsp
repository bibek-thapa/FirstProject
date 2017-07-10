

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@include file = "../../header.jsp" %>

<h1 class="text-center">  Address  </h1>
<br/>
<form class="form-horizontal" method="POST" action="${SITE_URL}/address/create">

    <div class="form-group">
        <label for="Zone" class="col-sm-3 control-label">Zone</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                   placeholder="Zone" name="zone">
        </div>
    </div>

    <div class="form-group">
        <label for="District" class="col-sm-3 control-label">District</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                   placeholder="District"  name="district">
        </div>
    </div>

    <div class="form-group">
        <label for="TEMP_ADDRESS" class="col-sm-3 control-label">TEMPORARY ADDRESS</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                   placeholder="TEMP_ADDRESS" name="tempAddress">
        </div>
    </div>


    <div class="form-group">
        <label for="PERMANENT_ADDRESS" class="col-sm-3 control-label">PERMANENT ADDRESS</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" 
                   placeholder="PERMANENT_ADDRESS" name="permanentAddress">
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

