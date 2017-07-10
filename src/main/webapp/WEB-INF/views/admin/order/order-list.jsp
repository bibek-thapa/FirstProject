<%@include file="../../header.jsp" %>

<h2 class="text-center">Order List</h2>
<div class="container">
<table class="table table-striped table-responsive">
    <tr>
        <th>Id</th>
        <th>Customer</th>
        <th>Edit</th>
        <th>Delete</th>
        
    </tr>
    <c:forEach var="order" items="${orderList}">
    <tr>
        <td>${order.id}</td>
        <td>${order.customer.firstName} ${order.customer.lastName}</td>
        <td><a href="${SITE_URL}/order/edit/${order.id}" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a></td>
        <td><a href="${SITE_URL}/order/delete/${order.id}" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></a></td>

    </tr>
    </c:forEach>
    
    
    
</table>
</div>



<%@include file="../../footer.jsp" %>
