<%@include file="../../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2 class="text-center"> Update Order </h2>

<form class="form-horizontal" method="POST" action="${SITE_URL}/order/edit/${order.id}">
    <div class="form-group">
        <label class="col-sm-3 control-label">Update the Quantity</label>
        
        <div class="col-sm-3">
        <select class="form-control" name="orderQuantity">
            <option value="${order.orderQuantity}">Select the quantity  </option>
            <c:forEach var="i" begin="1" end="100">
            <option value="${i}">${i}</option>
            </c:forEach>
            </select>
        </div>
        <br/>
         <div class="clearfix">&nbsp;</div>
        <div class="col-sm-12 text-center">
            <button type="submit" class=" btn btn-primary"><span class="glyphicon glyphicon-send"></span>Send</button>
            
        </div>   
        
        
    </div>
    


</form>
<%@include file="../../footer.jsp" %>