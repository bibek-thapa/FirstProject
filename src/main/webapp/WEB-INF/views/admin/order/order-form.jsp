
<%@include file="../../header.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>




  <h2 class="text-center">Add Order Data</h2>
  <div class="container">
  <form:form class="form-horizontal" method="POST" action="${SITE_URL}/order/create"  modelAttribute="orderForm" >
     
            <div class="form-group">
          <!--<label class="col-sm-3 control-label" for="orderQuantity">Order Quantity</label>-->
          <form:label cssClass="col-sm-3 control-label" path="orderQuantity">Order Quantity</form:label>
          <div class="col-sm-3">
              <form:input path="orderQuantity" cssClass="form-control" />
          </div>
          
          <div class="has-error">
              <form:errors path="orderQuantity" cssClass="error" />
          </div>
          </div>
          
          <div class="form-group">
              <label class="col-sm-3 control-label">Product</label>
              <div class="col-sm-8">
                    <form:select path="product.id" class="form-control">
            		<form:option value="" label="--Please Select"/>
            		<form:options items="${productList}" itemValue="id" itemLabel="productName"/>
                    </form:select>
                  
                  <div class="has-error">
                     <form:errors path="product.id" cssClass="error"/>
                  </div> 
              </div>   
          </div>
                  
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

<!--<h2 class="text-center">Order Details</h2> 
<form class="form-horizontal" method="POST" action="${SITE_URL}/order/create">
    <div class="form-group">
        <label  for="Order Form"class="col-sm-3 control-label">Order Quantity</label>
        <div class="col-sm-3">

            <select class="form-control" name="orderQuantity">
                <%--<c:forEach var="i" begin="1" end="100">--%>

                    <option value="${i}">${i}</option>       
                <%--</c:forEach>--%>

            </select>
        </div>
    </div>

    <div class="form-group">
        <label  class="col-sm-3 control-label">Product</label>
        <div class="col-sm-3">

            <select class="form-control" name="product.id">
                <%--<c:forEach var="product" items="${productList}">--%>
                    <option value="${product.id}" >${product.productName}</option>   
                <%--</c:forEach>--%>
            </select>
            
            
        </div>
    </div>







    <div class="clearfix">&nbsp;
    </div>
    <div class="col-sm-12 text-center" >
        <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-send"></span>Send</button>

    </div>
</form>
    
   <%@include file="../../footer.jsp" %>   





