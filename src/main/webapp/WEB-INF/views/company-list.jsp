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
                <th>Company Name</th>
                <th>Edit</th>
                <th>Delete</th>

            </tr>

            <tr>
                <c:forEach var="company" items="${companyList}">
                    <td>${company.id}</td>
                    <td>${company.companyName}</td>
                    <td>
                        <a href="${SITE_URL}/company/edit/${company.id}" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                    <td> <a href="${SITE_URL}/company/delete/${company.id}" class="btn btn-danger"><span class="glyphicon glyphicon-trash" onclick="return confirm('Are you sure?')"></span></a></td>
                    </br>

                     </tr>
                </c:forEach>


           


        </table>



        <i>${message}</i>

</body>
</html>
