<%@include file="../../header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>

<h2 class="text-center">Product Update</h2> 

<form class="form-horizontal" method="POST" action="${SITE_URL}/product/edit/${product.id}">
    <div class ="form-group">
        
        <label class="col-sm-3 control-label">Product Name</label>
        <div class="col-sm-8">
            <input class="form-control" name="productName" value="${product.productName}">
        </div>
    </div>
    
     <div class ="form-group">
        
        <label class="col-sm-3 control-label">Price Per Unit</label>
        <div class="col-sm-8">
            <input class="form-control" name="pperUnit" value="${product.pperUnit}">
        </div>
    </div>
    <div class="col-sm-12 text-center">
    <button type ="submit" class="btn btn-primary"><span class="glyphicon glyphicon-send "></span>
        Update </button>    
    </div>
    
</form>




<%@include file="../../footer.jsp"%>
