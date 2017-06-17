<%@include file="header.jsp" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<%@include file="navbar.jsp" %>


<div class="container">

    <div class="row">

        <div class="col-md-3 col-sm-3 col-xs-3">
            <p class="lead text-center">Categories</p>
            <div class="list-group">
                <a href="${SITE_URL}/" class="list-group-item">All</a>
                <a href="${SITE_URL}/category/view/electronics" class="list-group-item">Electronics</a>
                <a href="${SITE_URL}/category/view/fashion" class="list-group-item">Fashion</a>
                <a href="${SITE_URL}/category/view/sports" class="list-group-item">Sports</a>
            </div>
            <c:if test="${ not empty pageContext.request.userPrincipal.name}">
                <a href="${SITE_URL}/product/create"><span class="glyphicon glyphicon-plus-sign info"></span> Add Product</a>
            </c:if>
        </div>

        <div class="col-md-9 col-sm-9 col-xs-9">


            <p></p>
            <div class="row">         
                <c:forEach var="product" items="${productList}">
                    <div class="col-sm-4 col-lg-4 col-md-4 col-xs-4">
                        <div class="thumbnail">
                            <a href="${SITE_URL}/product/view?id=${product.id}"> <img src="${SITE_URL}/imageDisplay?id=${product.id}" alt=""></a>
                            <div class="caption">
                                <h4 class="pull-right">Rs. ${product.pperUnit}</h4>
                                <h4><a href="${SITE_URL}/product/view?id=${product.id}">${product.productName}</a>
                                </h4>
                                <p>Description</p>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">15 reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                </p>
                            </div>



                        </div>
                    </div>

                </c:forEach>
            </div>


            <!-- /.container -->

            <div class="container">


                <!-- Footer -->
                <footer>
                    <div class="row">
                        <div class="col-lg-12 col-sm-12 col-xs-12">
                            <p>Copyright &copy; 2017</p>
                        </div>
                    </div>
                </footer>

            </div>
        </div>

    </div>
</div>

<%@include file="footer.jsp" %>