<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@include file="../../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2 class="text-center">Order Details</h2> 
<form class="form-horizontal" method="POST" action="${SITE_URL}/order/create">
    <div class="form-group">
        <label  for="Order Form"class="col-sm-3 control-label">Order Quantity</label>
        <div class="col-sm-3">

            <select class="form-control" name="orderQuantity">
                <c:forEach var="i" begin="1" end="100">

                    <option value="${i}">${i}</option>       
                </c:forEach>

            </select>
        </div>
    </div>
    
<!--    <div class="form-group">
        <label  class="col-sm-3 control-label">Customer</label>
        <div class="col-sm-3">

            <select class="form-control" name="customer.id">
                

            </select>
        </div>
    </div>-->
    
   





        <div class="clearfix">&nbsp;
        </div>
        <div class="col-sm-12 text-center" >
            <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-send"></span>Send</button>

        </div>
</form>

<%@include file="../../footer.jsp" %>




