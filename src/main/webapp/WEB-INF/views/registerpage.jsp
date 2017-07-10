<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p> 
<body onload='document.f.firstName.focus();'>

<div class="container">

    <form:form name="f" method="POST" class="form-horizontal" modelAttribute="userForm">
        <div class="col-md-12">

            <div class="form-group">
                <label class="col-md-4 control-label" for="name">First Name</label>  
                <div class="col-md-4">
                    <form:input id="name" path="firstName" type="text" placeholder="Enter your First Name" class="form-control input-md" required=""/>
                </div>
                    <div class="has-error">
                        <form:errors path="firstName"></form:errors>
                    </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Last Name</label>  
                <div class="col-md-4">
                    <form:input  path="lastName" type="text" placeholder="Enter your Last Name" class="form-control input-md" required=""/>
                </div>
                <div class="has-error">
                    <form:errors path="lastName"></form:errors>
                </div>
            </div>  

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="userName">User Name</label>  
                <div class="col-md-4">
                    <form:input  path="userName" type="text" placeholder="Enter your User Name" class="form-control input-md" required=""/>
                 </div>
                 <div class="has-error">
                    <form:errors path="userName"></form:errors>
                </div>
            </div>    

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Password</label>
                <div class="col-md-4">
                    <form:input id="password" path="password" type="password" placeholder="Enter a password" class="form-control input-md" required=""/>
                </div>
                <div class="has-error">
                    <form:errors path="password"></form:errors>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Email</label>  
                <div class="col-md-4">
                    <form:input id="email" path="emailAddress" type="text" placeholder="Enter your email id" class="form-control input-md" required=""/>
                 </div>
                 <div class="has-error">
                    <form:errors path="emailAddress"></form:errors>
                </div>
            </div>



            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="signup"></label>
                <div class="col-md-4">
                    <button id="signup" name="signup" class="btn btn-info" type="submit">Sign Up</button>
                </div>
            </div>
            <span> ${message}</span>
            <div class="form-group">
                
                    <label class="control-label col-md-8">    </label>
            
            </div>

        </div>
    </div>
</form:form>



<%@include file="footer.jsp" %>


