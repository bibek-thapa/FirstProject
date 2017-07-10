
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@include file="../../header.jsp" %>

<h1 class="text-center">Update Company </h1>
<br/>
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/company/edit/${company.id}">
            <div class ="form-group">
                
                <label class="control-label col-sm-3">Company Name</label>
                <div class="col-sm-8">
                <input name="companyName" class="form-control" value="${company.companyName}">
                </div>
            </div>
            
            
                <br/>
                <div class="clearfix">&nbsp;</div>
                    <div class="col-sm-12 text-center">
                <button type ="submit" class="btn btn-primary ">Update</button>   
                    </div>
                     
                    
                
            </div>
            
            
            
        </form>
   
 <%@include file="../../footer.jsp" %>