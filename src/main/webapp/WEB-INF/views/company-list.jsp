<%-- 
    Document   : List
    Created on : May 1, 2017, 10:51:50 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@include file ="header.jsp" %>
<!DOCTYPE html>

        
      

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
                        <a href="${SITE_URL}/person/edit/${company.id}" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                    <td> <a href="${SITE_URL}/person/delete/${company.id}" class="btn btn-danger"><span class="glyphicon glyphicon-trash" onclick="return confirm('Are you sure?')"></span></a></td>
                    </br>

                     </tr>
                </c:forEach>


           


        </table>



        <i>${message}</i>

 <%@include file = "footer.jsp"%>
