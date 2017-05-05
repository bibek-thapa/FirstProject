<%-- 
    Document   : index
    Created on : Apr 22, 2017, 9:40:18 PM
    Author     : Dell
--%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
  <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/person/create">
<
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Name</label>
    <div class="col-sm-6">
      <input  class="form-control" id="inputPassword3" placeholder="Person Name" name="firstName">
    </div>
    <br/>
    
    
    <div class="col-sm-6">
            <label  class="col-sm-2 control-label">Company</label>
            <select  name="company.id" class="form-control">
                
                <c:forEach var="company" items="${companyList}">
                    
                <option class="form-control" value="${company.id}">${company.companyName}</option>
               
                </c:forEach>
                  
            </select>
        </div>
  </div>


<!--  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
    </div>
  </div>-->
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
</form>

  <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/company/create">
<!--  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-6">
      <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
    </div>
  </div>-->
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Name</label>
    <div class="col-sm-6">
      <input  class="form-control" id="inputPassword3" placeholder="Company Name" name="companyName">
    </div>
  </div>
<!--  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
    </div>
  </div>-->
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
</form>



        
        <h1>Welcome to the Home page</h1>
        <p>
            Welcome to the Person Application </br>
            <i>${message}</i> </br>
            <a href ="${pageContext.request.contextPath}/person/create">Create a new person</a></br>
                        <a href ="${pageContext.request.contextPath}/person/list">List all persons</a></br>
                        <a href ="${pageContext.request.contextPath}/company/list">List all companies</a></br>

            
            
        </p>
        
        
        
    </body>
</html>
