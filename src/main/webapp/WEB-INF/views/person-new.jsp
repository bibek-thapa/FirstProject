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

<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>

  </form>




    </body>
</html>