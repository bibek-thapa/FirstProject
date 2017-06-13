<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>

<style>
    @media (min-width: 768px) {
        .navbar-brand {
            position: absolute;
            width: 100%;
            left: 0;
            top: 0;
            text-align: center;
            margin: auto;
        }
    }
</style>
<nav class="navbar navbar-inverse ">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${SITE_URL}">Online Store</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Men<span class="sr-only">(current)</span></a></li>
                <li><a href="#">Women</a></li>
                <li><a href="#">Luggage</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">


                <c:choose>
                    <c:when test="${not empty thought}">
                        <li><a href="${SITE_URL}/cart/list">&nbsp;<span class="glyphicon glyphicon-shopping-cart">(${thought.size()})</span></a></li>
                        </c:when>
                        <c:otherwise>
                        <li><a href="${SITE_URL}/cart/list">&nbsp;<span class="glyphicon glyphicon-shopping-cart"></span></a></li>
                            </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${ empty pageContext.request.userPrincipal.name}">
                            <li><a href="#"><span class="glyphicon glyphicon-apple"></span></a>
                            <li><a href="${SITE_URL}/login">Sign In&nbsp;<span class="glyphicon glyphicon-log-in"></span></a></li>
                    </c:when>
                        <c:otherwise>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><label>Welcome <span class="caret"></span></label></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="${SITE_URL}/logout">Sign Out&nbsp;<span class="glyphicon glyphicon-log-out"></span></a></li>
                            </ul>

                        </li>
                         </c:otherwise> 
                </c:choose>
                </ul>
                           




        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>



