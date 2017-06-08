<%-- 
    Document   : sessiontest
    Created on : Jun 6, 2017, 11:35:33 PM
    Author     : Dell
--%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>

<p></p>
<p></p>
        <div class="container">
            <h1>In sessions ${thought}</h1>
            <c:if test ="${empty thought}">No values</c:if>
        <form method="POST" action="${SITE_URL}/cart/sessiontestpost">
            
            <input type="text" name="personName"> 
            <button type="submit">Submit</button>
                
        </form>
        </div>
    
<%@include file="footer.jsp" %>
