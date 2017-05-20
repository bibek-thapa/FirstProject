<%-- 
    Document   : List
    Created on : May 1, 2017, 10:51:50 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@include file ="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>



        <table class="table table-hover  table-striped">

            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Company</th>
                <th>Job Position</th>
                <th>Contact No.</th>
                
                
                <th>Edit</th>
                <th>Delete</th>

            </tr>

            <tr>
                <c:forEach var="customer" items="${customerList}">
                    <td>${customer.id}</td>
                    <td>${customer.firstName} ${customer.lastName}</td>
                     <td>${customer.companyName}</td>
                   
                    <td>${customer.jobPosition}</td>
                    <td>${customer.contactNumber}</td>
                    <td>
                        <a href="${SITE_URL}/customer/edit/${customer.id}" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                    <td> <a href="${SITE_URL}/customer/delete/${customer.id}" class="btn btn-danger"><span class="glyphicon glyphicon-trash" onclick="return confirm('Are you sure?')"></span></a></td>
                    </br>

                </tr>
            </c:forEach>





        </table>



        <i>${message}</i>

    </body>
</html>
