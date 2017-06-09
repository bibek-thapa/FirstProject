
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<%@include file="../header.jsp" %>
<%@include file="../navbar.jsp" %>



<p></p>

<div class="container">
    <p></p>
    
     <c:choose>
                
                <c:when test="${empty thought}">
                    <p></p>
                    <p></p>
                    <h1 class="text-center text-warning" >Cart is Empty</h1>
                    <hr>
                    <span></span>
                    <h4 class="monospaced text-center">Fill your cart over <a href="${SITE_URL}">here</a></h4>
                </c:when>
                
                <c:otherwise>
    
    <div class="row">

        <div class="col-md-8 col-sm-8">
            
                          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 

            <div class="row">



                <c:forEach var="order" items="${thought}" varStatus="loop">
                    <div class="col-sm-4 col-lg-4 col-md-4 col-xs-4">


                        <div class="thumbnail">
                            <a href="${SITE_URL}/cart/remove?id=${loop.index}">  <span class="pull-right glyphicon glyphicon-remove"></span></a>  
                            <img src="${SITE_URL}/imageDisplay?id=${order.product.id}" alt="" class="img-responsive">

                            <div class="caption">
                                <h4 class="pull-right">Rs.${order.product.pperUnit}</h4>
                                <h4><a href="${SITE_URL}/product/view?id=${order.product.id}">${order.product.productName}</a></h4>
                                <p>Description</p>
                                qty<input class="form-control field-right" name="orderQuantity" value="${order.orderQuantity}" readonly />
                            </div><!--end of caption-->
                        </div><!--end of thumbnail-->

                    </div>
                </c:forEach>

            </div>
        </div>
        <p>    
        <hr>
        
        <div class="col-md-3 col-xs-3 col-sm-3">
            <div class="col-md-12 col-sm-12 col-lg-12 col-xs-12">
               
            <!--Start of the Form -->    
             <form:form method="POST" action="${SITE_URL}/cart/order" modelAttribute="cartForm">

                    <div class="form-group">
                        <label class="label label-info form-control" >FirstName</label>
                        <p></p>
                        <form:input path="firstName" class="form-control" />
                        <div class="has-error">
                        <form:errors path="firstName" cssClass="error"></form:errors>
                        </div>
                        </div>

                    <div class="form-group">
                        <label class="label label-info form-control" >LastName</label>
                        <p></p>
                        <form:input path="lastName" class="form-control"/>
                        <form:errors path="lastName" cssClass="error"></form:errors>

                    </div>

                    <div class="form-group">
                        <label class="label label-info form-control" >Address</label>
                        <p></p>
                        <form:input path="address" class="form-control" type="text"/>
                        <form:errors path="address" cssClass="error"></form:errors>

                    </div>
                    
                    <div class="form-group">
                        <label class="label label-info form-control" >Email Address</label>
                        <p></p>
                        <form:input path="emailAddress" class="form-control" type="email"/>
                        <form:errors path="emailAddress" cssClass="error"></form:errors>

                    </div>

                    <div class="form-group">
                        <label class="label label-info form-control" >Phone Number</label>
                        <p></p>
                        <form:input path="contactNumber" class="form-control" type="number"/>
                        <form:errors path="contactNumber" cssClass="error"></form:errors>
                    </div>
            </div>
            <div class="col-md-12"> <hr></div>


            <div class="col-sm-12 col-xs-12 col-sm-12">
                <a><button class="btn btn-primary" type="submit">Proceed to Checkout</button></a>
            </div>
             </form:form>
        </div>   
    </div>
</div>
                </c:otherwise>           
                </c:choose>

${message}
<%@include file="../footer.jsp" %>
