
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<nav class="navbar navbar-collapse navbar-fixed-top navbar-inverse" >

    <div class="container-fluid">
        <ul class="nav nav-pills">
            <li class="active"><a href="/index.html"><span
                        class="glyphicon glyphicon-home"></span>&nbsp;Home</a></li>
            <li><a href="/index.html"><span
                        class="glyphicon glyphicon-briefcase"></span>&nbsp;Products</a></li>
            <li><a href="/index.html"><span
                        ></span>&nbsp;Departments</a></li>
            <li><a href="/contact.html"><span class="glyphicon glyphicon-earphone"></
                        span>ContactUs&nbsp;</a></li>

            <ul class="nav nav-pills navbar-right">

                <li><a href="#"><span class="glyphicon glyphicon-log-in"></
                            span>&nbsp;Sign In</a></li>

                      <li class="dropdown">  
                        <a data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></
                                span>Welcome<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><span class="glyphicon glyphicon-picture"></
                                        span>&nbsp;My Profile</a></li> 
                        </ul>    
                    </li>
              
            </ul>
        </ul>


    </div> 
</nav>   

<!--<script>
$(document).ready(function(){
    $("#hide").click(function(){
        $("#pa").hide();
    });
    $("#show").click(function(){
        $("#pa").show();
    });
});
</script>


<p>If you click on the "Hide" button, I will disappear.</p>

<div id="pa">
    <h1>Hello World</h1>
</div>

<button id="hide">Hide</button>
<button id="show">Show</button>                   -->



<%@include file="footer.jsp" %>