
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
            <form:form method="post" action="${SITE_URL}/cart/order">
                <div class="row">

                    <div class="col-md-8 col-sm-8">

                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 

                        <div class="row">


                            <c:set var="total" value="${0}"></c:set>
                            <c:forEach var="orderdetail" items="${thought}" varStatus="loop">
                                <div class="col-sm-4 col-lg-4 col-md-4 col-xs-4">


                                    <div class="thumbnail">
                                        <a href="${SITE_URL}/cart/remove?id=${loop.index}">  <span class="pull-right glyphicon glyphicon-remove"></span></a>  
                                        <img src="${SITE_URL}/imageDisplay?id=${orderdetail.product.id}" alt="" class="img-responsive">

                                        <div class="caption">
                                            <h4 class="pull-right">Rs.${orderdetail.product.pperUnit}</h4>
                                            <h4><a href="${SITE_URL}/product/view?id=${orderdetail.product.id}">${orderdetail.product.productName}</a></h4>
                                            <p>Description</p>
                                           <input class="form-control field-right" name="orderQuantity" value="${orderdetail.orderQuantity}" readonly />
                                            <c:set var="total" value="${total + orderdetail.product.pperUnit * orderdetail.orderQuantity}"></c:set>
                                        </div><!--end of caption-->
                                    </div><!--end of thumbnail-->
                                </div>
                            </c:forEach>

                        </div>
                    </div>
                      
                    

                    <div class="col-md-3 col-xs-3 col-sm-3"> <!--Start of the other column!-->

                        <div class="col-md-12 col-sm-12 col-lg-12 col-xs-12">
                            <table class="table table-hover table-responsive">
                                <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Quantity</th>
                                    <th>Price(Rs.)</th>
                                    <th>SubTotal(Rs.)</th>
                                </tr>
                                </thead>
                                <c:forEach var="tabledata" items="${thought}">
                                    <tr class="active">
                                        <td class="text-center">${tabledata.product.productName}</td>
                                        <td class="text-center">${tabledata.orderQuantity}</td>
                                        <td class="text-center" >${tabledata.product.pperUnit}</td>
                                        <td class="text-center"><span style="color: #245269;">${tabledata.product.pperUnit * tabledata.orderQuantity} </span></td>
                                    </tr>
                                </c:forEach>
                            </table>

                        </div>
                        <div class="col-md-12 col-sm-12 col-lg-12 col-xs-12">
                            <h3><span style="color: #337ab7; font-weight: bold ;">Total : </span></h3>
                            <h4><span style="color: #0f0f0f; font-weight: bold ;">Rs . ${total}</span></h4>
                        </div>
                        <div class="col-sm-12 col-xs-12 col-sm-12">
                            <a><button class="btn btn-primary" type="submit">Proceed to Checkout</button></a>
                            <p>

                        </div>
                       
                      </form:form>
                        <p>
                      <div class="col-sm-12 col-xs-12 col-sm-12">
                          <h4><a href="${SITE_URL}/" class="btn btn-info">Continue Buying</a></h4>
                            <p>

                      </div>

                    </div>  

                </div>
           
            
        </div>
    </c:otherwise>           
</c:choose>



<%@include file="../footer.jsp" %>
