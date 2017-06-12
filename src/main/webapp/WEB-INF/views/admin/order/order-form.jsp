<%@include file="../../header.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>




<h2 class="text-center">Add Order Data</h2>
<div class="container">
    <form:form class="form-horizontal" method="POST" action="${SITE_URL}/order/create"  modelAttribute="orderForm" >




        <div class="form-group">
            <label class="col-sm-3 control-label">Customer</label>
            <div class="col-sm-8">
                <form:select path="customer.id" class="form-control">
                    <form:option value="" label="--Please Select"/>
                    <form:options items="${customerList}" itemValue="id" itemLabel="firstName"/>
                </form:select>

                <div class="has-error">
                    <form:errors path="customer.id" cssClass="error"/>
                </div> 
            </div>   
        </div>



        <div class="clearfix">&nbsp;</div>

        <div class="col-sm-12 text-center" >
            <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-send"></span>Send</button>

        </div>
    </div>

</form:form>
<%@include file="../../footer.jsp" %>








