
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@include file="header.jsp" %>

<h1 class="text-center">Update Person </h1>
<br/>
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/person/edit/${person.id}">
            <div class ="form-group">
                
                <label class="control-label col-sm-3">Person Name</label>
                <div class="col-sm-8">
                <input name="firstName" class="form-control" value="${person.firstName}">
                </div>
            </div>
            
            <div class="form-group">
                <label class="control-label col-sm-3">Company Name</label>
                <div class="col-sm-8">
                    <select class="form-control" name="${company.companyName}" >
                        <c:forEach var="company" items="${companyList}">
                            <option class="form-control" value="${company.id}">${company.companyName}</option>
                        </c:forEach>
                        
                        
                    </select>
                    
                    
                </div>
                <br/>
                <div class="clearfix">&nbsp;</div>
                    <div class="col-sm-12 text-center">
                <button type ="submit" class="btn btn-primary ">Update</button>   
                    </div>
                     
                    
                
            </div>
            
            
            
        </form>
   
 <%@include file="footer.jsp" %>