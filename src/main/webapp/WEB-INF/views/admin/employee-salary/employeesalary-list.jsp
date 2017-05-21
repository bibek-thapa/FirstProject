<%-- 
    Document   : employeesalary-list
    Created on : May 20, 2017, 11:20:47 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>

<%@include file="../../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2 class="text-center" >
    
    Employee Salary Details
</h2>

<table class="table table-hover table-striped">
    <tr>
        <th>Id</th>
        <th>Position</th>
        <th>Pay Rate</th>
        <th>Bonus</th>
        <th>Edit</th>
        <th>Delete</th>    
    </tr>
    
   
        <c:forEach var="employeeSalary" items="${employeeSalaryList}">
        <tr>
        <td>${employeeSalary.id}</td>    
        <td>${employeeSalary.employeePosition}</td>
         <td>${employeeSalary.payRate}</td>
         <td>${employeeSalary.bonus}</td>
         <td>
                        <a href="${SITE_URL}/employeeSalary/edit/${employeeSalary.id}" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                    <td> <a href="${SITE_URL}/employeeSalary/delete/${employeeSalary.id}" class="btn btn-danger"><span class="glyphicon glyphicon-trash" onclick="return confirm('Are you sure?')"></span></a></td>
        
   
         </tr>
    </c:forEach>
   
    
    
</table>




<%@include file="../../footer.jsp" %>