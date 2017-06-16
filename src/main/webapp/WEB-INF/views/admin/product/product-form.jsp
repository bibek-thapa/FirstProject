<%@include file="../../header.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>

<h2 class="text-center">Product Details</h2> 

<form:form class="form-horizontal" method="POST" enctype="multipart/form-data" modelAttribute="productForm" action="${SITE_URL}/product/create">
    <div class ="form-group">

        <form:label class="col-sm-3 control-label"  path="productName">Product Name</form:label>
            <div class="col-sm-6">
            <form:input class="form-control" path="productName"/>
        </div>
        <div class="has-error">
            <form:errors path="productName" cssClass="error"/>
        </div>
    </div>

    <div class ="form-group">

        <form:label class="col-sm-3 control-label" path="pperUnit">Price Per Unit</form:label>
            <div class="col-sm-6">
            <form:input class="form-control" path="pperUnit"/>
        </div>
        <div class="has-error">
            <form:errors path="pperUnit" cssClass="error"/>
        </div>
    </div>


    <div class ="form-group">
        <form:label class="col-sm-3 control-label" path="productCode">Product Code</form:label>
            <div class="col-sm-6">
            <form:input class="form-control" path="productCode"/>
        </div>
        <div class="has-error">
            <form:errors path="productCode" cssClass="error"/>
        </div>
    </div>

    <div class ="form-group">
        <form:label class="col-sm-3 control-label" path="productFeatures.description">Product Description</form:label>
            <div class="col-sm-6">
            <form:textarea class="form-control" path="productFeatures.description"/>
        </div>
        <div class="has-error">
            <form:errors path="productFeatures.description" cssClass="error"/>
        </div>
    </div>
        
     <div class ="form-group">
        <form:label class="col-sm-3 control-label" path="productFeatures.features">Product Features</form:label>
            <div class="col-sm-6">
            <form:textarea class="form-control" path="productFeatures.features"/>
        </div>
        <div class="has-error">
            <form:errors path="productFeatures.features" cssClass="error"/>
        </div>
    </div> 
        
      <div class ="form-group">
        <form:label class="col-sm-3 control-label" path="productFeatures.notes">Product Notes</form:label>
            <div class="col-sm-6">
            <form:textarea class="form-control" path="productFeatures.notes"/>
        </div>
        <div class="has-error">
            <form:errors path="productFeatures.notes" cssClass="error"/>
        </div>
    </div>    


    <div class ="form-group">
        <form:label class="col-sm-3 control-label" path="productImage">Product Image</form:label>
            <div class="col-sm-6">
            <form:input type="file"  class="form-control" path="productImage"/>
        </div>
        <div class="has-error">
            <form:errors path="productImage" cssClass="error"/>
        </div>

    </div>    
    <div class="col-sm-12 text-center">
        <button type ="submit" class="btn btn-primary"><span class="glyphicon glyphicon-send "></span>
            Submit</button>    
    </div>

</form:form>




<%@include file="../../footer.jsp"%>
