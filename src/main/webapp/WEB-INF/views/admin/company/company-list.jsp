<%@page contentType="text/html" pageEncoding="windows-1252"%>

<%@include file="../../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2 class="text-center" >
    
   Company Details
</h2>

<table class="table table-hover table-striped">
    <tr>
        <th>Id</th>
        <th>Company Name</th>
        <th></th>
        <th></th>
        <th>Edit</th>
        <th>Delete</th>    
    </tr>
    
   
        <c:forEach var="company" items="${companyList}">
        <tr>
        <td>${company.id}</td>    
        <td>${company.companyName}</td>
         <td></td>
         <td></td>
         <td>
                        <a href="${SITE_URL}/company/edit/${company.id}" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                    <td> <a href="${SITE_URL}/company/delete/${company.id}" class="btn btn-danger"><span class="glyphicon glyphicon-trash" onclick="return confirm('Are you sure?')"></span></a></td>
        
   
         </tr>
    </c:forEach>
   
    
    
</table>




<%@include file="../../footer.jsp" %>