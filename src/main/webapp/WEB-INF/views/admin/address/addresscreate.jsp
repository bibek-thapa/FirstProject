

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@include file = "../../header.jsp" %>

<h1 class="text-center">  Address  </h1>
<br/>
<form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/address/create">
    
<div class="form-group">
<label for="Zone" class="col-sm-3 control-label">Zone</label>
<div class="col-sm-9">
<input type="text" class="form-control" 
placeholder="Zone" name="zone">
</div>
</div>
    
    <div class="form-group">
<label for="District" class="col-sm-3 control-label">District</label>
<div class="col-sm-9">
<input type="text" class="form-control" 
placeholder="District"  name="district">
</div>
</div>
    
    <div class="form-group">
<label for="TEMP_ADDRESS" class="col-sm-3 control-label">TEMP_ADDRESS</label>
<div class="col-sm-9">
<input type="text" class="form-control" 
placeholder="TEMP_ADDRESS" name="tempAddress">
</div>
</div>
    
    
    <div class="form-group">
<label for="PERMANENT_ADDRESS" class="col-sm-3 control-label">PERMANENT_ADDRESS</label>
<div class="col-sm-9">
<input type="text" class="form-control" 
placeholder="PERMANENT_ADDRESS" name="permanentAddress">
</div>
</div>
    <br/>
    
        
    
    
    
        <div class="col-md-8 text-center"> 
  <button id="button" name="button" class="btn btn-primary">Submit</button> 
</div>

    
    
 
    
    
</form>        
        
      <%@include file = "../../footer.jsp" %>
  
 