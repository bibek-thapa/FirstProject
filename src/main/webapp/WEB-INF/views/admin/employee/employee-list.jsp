

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@include file="../../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h2 class="text-center"> EMPLOYEE LIST </h2>
<br/>

<table class="table table-hover  table-striped">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Address</th>
        <th>Contact Number</th>
        <th>Edit</th>
        <th>Delete</th>

    </tr>
    
    
    
     <c:forEach var="employee" items="${employeeList}">
    <tr>
        
        <td>${employee.id}</td>   
    <td>${employee.firstName} ${employee.lastName}</td>
    <td>${employee.address}</td>
    <td>${employee.contactNumber}</td>
    <td>
                        <a href="${SITE_URL}/employee/edit/${employee.id}" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                    <td> <a href="${SITE_URL}/employee/delete/${employee.id}" class="btn btn-danger"><span class="glyphicon glyphicon-trash" onclick="return confirm('Are you sure?')"></span></a></td>
        
   
        
        
    </tr>
     </c:forEach>





</table>
<%@include file="../../footer.jsp" %>
