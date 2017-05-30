<%@include file="../../header.jsp" %>
<h2 class="text-center" >Product Details</h2>
<div class="clearfix">&nbsp;</div>

<div class="container">
<table class="table table-striped table-responsive">
    <tr>
        <th>Id</th>
        <th>Product Name</th>
        <th>Price Per Unit</th>
        <th>Edit</th>
        <th>Delete</th>
        
    </tr>
    <c:forEach var="product" items="${productList}">
    <tr>
        <td>${product.id}</td>
        <td>${product.productName}</td>
        <td>${product.pperUnit}</td>
        <td><a href="${SITE_URL}/product/edit/${product.id}" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a></td>
        <td><a href="${SITE_URL}/product/delete/${product.id}" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span></a></td>

    </tr>
    </c:forEach>
    
    
    
</table>
</div>



<%@include file="../../footer.jsp" %>
