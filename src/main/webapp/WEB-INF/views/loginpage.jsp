
<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

    <div id="login-overlay" class="modal-dialog">
      <div class="modal-content">
          <div class="modal-header">
              <h4 class="modal-title" id="myModalLabel">Login to <b>OnlineStore.com</b></h4> or go back to our <a href="./index.jsp">main site</a>.
          </div>
          <div class="modal-body">
              <div class="row">
                  <div class="col-xs-6">
                      <div class="well">
                          <c:url value="${SITE_URL}/login" var="loginUrl"></c:url>
                          <form id="loginForm" method="POST" action="${SITE_URL}/login">
                              <c:if test="${param.error!=null}">
                                  <div class="error">
                                  <p>Invalid Username and password<p>
                                  </div>
                                  </c:if>
                                      <c:if test="${param.logout!=null}">
                                     <div class="success">
                                          <p class="alert alert-success">You have been logged out</p>
                                     </div> 
                                     </c:if>       
                              
                              <div class="form-group">
                                  <label for="username" class="control-label">Username</label>
                                  <input type="text" class="form-control" name="userName" value="" required="" title="Please enter your username" placeholder="username">
                                  <span class="help-block"></span>
                              </div>
                              <div class="form-group">
                                  <label for="password" class="control-label">Password</label>
                                  <input type="password" class="form-control" name="password" placeholder="password" value="" required="" title="Please enter your password">
                                  <span class="help-block"></span>
                              </div>
                              <div id="loginErrorMsg" class="alert alert-error hide">Wrong username or password</div>
                              <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

                              <div class="checkbox">
                                  <label>
                                      <input type="checkbox" name="remember" id="remember"> Remember login
                                  </label>
                                  <p class="help-block">(if this is a private computer)</p>
                              </div>
                              <button type="submit"  name="submit" class="btn btn-success btn-block">Login</button>
                          </form>
                      </div>
                  </div>
                  <div class="col-xs-6">
                      <p class="lead">Register now for <span class="text-success">FREE</span></p>
                      <ul class="list-unstyled" style="line-height: 2">
                          <li><span class="fa fa-check text-success"></span> See all your orders</li>
                          <li><span class="fa fa-check text-success"></span> Shipping is always free</li>
                          <li><span class="fa fa-check text-success"></span> Save your favorites</li>
                          <li><span class="fa fa-check text-success"></span> Fast checkout</li>
                          <li><span class="fa fa-check text-success"></span> Get a gift <small>(only new customers)</small></li>
                          <li><span class="fa fa-check text-success"></span>Holiday discounts up to 30% off</li>
                      </ul>
                      <p><a href="#" class="btn btn-info btn-block">Yes please, register now!</a></p>
                  </div>
              </div>
          </div>
      </div>

  </div>
<script type="text/javascript">

</script>

<%@include file="footer.jsp" %>
