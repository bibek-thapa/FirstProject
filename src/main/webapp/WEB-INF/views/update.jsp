<%-- 
    Document   : update
    Created on : May 1, 2017, 10:16:01 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/person/edit/${person.id}">

  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Name</label>
    <div class="col-sm-6">
      <input  class="form-control" id="inputPassword3" value="${person.firstName}" name="firstName">
    </div>
  </div>
    <div class="col-sm-6">
            <label  class="col-sm-2 control-label">Company</label>
            <select  name="company1" class="form-control" v>
                
                <c:forEach var="company" items="${companyList}">
                    
                <option class="form-control"  >${company.companyName}</option>
               
                </c:forEach>
                  
            </select>
        </div>

  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Update</button>
    </div>
  </div>
</form>
    </body>
</html>
