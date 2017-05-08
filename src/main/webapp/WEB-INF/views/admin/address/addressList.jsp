<%-- 
    Document   : addressList
    Created on : May 8, 2017, 8:12:34 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@include file = "../../header.jsp" %>


<table class ="table table-hover">
    
    <tr class = "info">
        <th>Id</th>
         <th>Zone</th>
          <th>District</th>
           <th>Temporary Address</th>
            <th>Permanent Address</th> 
            
    </tr>
    
    
        
        <c:forEach var="address" items="${addressList}">
    <tr class = "success">
        <td>${address.id}</td>
        <td>${address.zone}</td>
        <td>${address.district}</td>
        <td>${address.tempAddress}</td>
        <td>${address.permanentAddress}</td>
       
        
        
    </tr>
     </c:forEach>
    
    
    
    
</table>


<%@include file = "../../footer.jsp" %>
