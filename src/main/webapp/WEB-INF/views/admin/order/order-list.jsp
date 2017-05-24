<%@include file="../../header.jsp" %>

<table class="table table-striped table-responsive">
    <tr>
        <th>Id</th>
        <th>Quantity</th>
        <th>Ordered Date</th>
        <th>Customer </th>
        <th>Edit</th>
        <th>Delete</th>
        
    </tr>
    <c:forEach var="order" items="${orderList}">
    <tr>
        <td>${order.id}</td>
        <td>${order.orderQuantity}</td>
        <td>${order.createdTime}</td>
       
        <td><a href="${SITE_URL}/order/edit/${order.id}" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a></td>
        <td><a href="${SITE_URL}/order/delete/${order.id}" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></a></td>

    </tr>
    </c:forEach>
    
    
    
</table>



<%@include file="../../footer.jsp" %>
