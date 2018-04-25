<!-- *** TOPBAR ***
    

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
 _________________________________________________________ -->
    <div id="top">
        <div class="container">
            <div class="col-md-6 offer" data-animate="fadeInDown">
               </div>
            <div class="col-md-6" data-animate="fadeInDown">
                <ul class="menu">
                     <c:choose>
                        <c:when test="${sessionScope.user==null}">
                             <li><a href="#" data-toggle="modal" data-target="#login-modal" id="loginModalLink">Login</a></li>
                             <li><a href="./register.jsp">Register</a></li>
                        </c:when>    
                        <c:otherwise>
                        <li><div style="color:white;">${sessionScope.user.getEmail()}</div></li>
                        </c:otherwise>
                    </c:choose>
                   
                   
                    <c:if test="${sessionScope.user!=null}">
                        <li><a href="customer-account.jsp">profile</a></li>
                        <li><a href="./users/logout">logout</a></li>
                    </c:if>
                    <c:if test="${sessionScope.user.getIsAdmin()==1}">
                        <li><a href="admin_home.jsp">Admin</a></li>
                    </c:if>    
                </ul>
            </div>
        </div>
        
        
        
       <!---cookiees--> 
         <c:if test="${requestScope.cookieEnabled==false}">
             <p style="color: white;">please enable cookies</p>
       </c:if>
       
       
       
        <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
            <div class="modal-dialog modal-sm">

                <div class="modal-content">
                    <div class="modal-header">
                       <a href="./closeServlet">
                         <button type="button" class="close"  aria-hidden="true">&times;</button>
                       </a>
                        <h4 class="modal-title" id="Login">Customer login</h4>
                    </div>
                    <div class="modal-body">
                        <form action="./users/login" method="Post">
                            <div class="form-group">
                                <c:choose>
                                    <c:when test="${param.wrongEmail!=null}">
                                        <input type="email" class="form-control" id="email-modal" value="${param.wrongEmail}" name="email" required>
                                    </c:when>    
                                    <c:otherwise>
                                        <input type="email" class="form-control" id="email-modal" placeholder="email" name="email" required>
                                   </c:otherwise>
                                </c:choose>
                            </div>
                            
                            <div class="form-group">
                                <input type="password" class="form-control" id="password-modal" placeholder="password" name="pass" required>
                            </div>

                            <p class="text-center">
                                <button class="btn btn-primary"><i class="fa fa-sign-in"></i> Log in</button>
                            </p>

                        </form>
                        <c:if test="${param.wrongEmail!=null}">
                            <p class="text-center text-muted" style="color: red">**Wrong email or password!</p>
                        </c:if>
                        <p class="text-center text-muted"><a href="register.jsp"><strong>Register now</strong></a>! It is easy and done in 1&nbsp;minute and gives you access to special discounts and much more!</p>

                    </div>
                </div>
            </div>
        </div>

    </div>
    
    <!-- *** TOP BAR END *** -->

    <!-- *** NAVBAR ***
 _________________________________________________________ -->

    <div class="navbar navbar-default yamm" role="navigation" id="navbar">
        <div class="container">
            <div class="navbar-header">

                <a class="navbar-brand home"  data-animate-hover="bounce">
                    <img src="img/logo.png" alt="Obaju logo" class="hidden-xs">
                    <img src="img/logo-small.png" alt="Obaju logo" class="visible-xs"><span class="sr-only">Obaju - go to homepage</span>
                </a>
             
            </div>
            <!--/.navbar-header -->

            <div class="navbar-collapse collapse" id="navigation">

                <ul class="nav navbar-nav navbar-left">
                    <li ><a onmouseover="this.style.background='#4fbfa7';" onmouseout="this.style.background='white';"  href="./GetHome">Home</a>
                    </li>
                    <li class="dropdown yamm-fw">
                        <a onmouseover="this.style.background='#4fbfa7';" onmouseout="this.style.background='white';"   href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="200">Category <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <div class="yamm-content">
                                  
                                    <c:if test="${applicationScope.categoriesList.size()>0}">
                                        <c:choose >
                                            <c:when test="${applicationScope.categoriesList.size()<20}">
                                                <c:forEach var = "i" begin = "0" end = "${applicationScope.categoriesList.size()-1}">
                                                        <div class="col-sm-3">
                                                            <h5>  <a href="GetProducts?name=${applicationScope.categoriesList.get(i).getId()}">${applicationScope.categoriesList.get(i).getName()}</a>
                                                            </h5>
                                                        </div>
                                                 </c:forEach>
                                            </c:when>
                                            <c:when test="${applicationScope.categoriesList.size()>=20}">
                                                <c:forEach var = "i" begin = "0" end = "19">
                                                        <div class="col-sm-3">
                                                            <h5>  <a href="GetProducts?name=${applicationScope.categoriesList.get(i).getId()}">${applicationScope.categoriesList.get(i).getName()}</a>
                                                            </h5>
                                                        </div>
                                                 </c:forEach>
                                                 <div class="col-sm-3">
                                                <h5><a href="./moreCategories.jsp">more</a></h5>
                                            </div>
                                            </c:when>
                                            
                                         </c:choose>
                                    </c:if>
                                   
                                         
                                </div>
                                <!-- /.yamm-content -->
                            </li>
                        </ul>
                    </li>

                    <li >
                        <a href="getAllProducts" onmouseover="this.style.background='#4fbfa7';" onmouseout="this.style.background='white';" > All Products </a>
                    </li>

                    
                </ul>

            </div>
            <!--/.nav-collapse -->

            <div class="navbar-buttons">

                <div class="navbar-collapse collapse right" id="basket-overview">
                    <a href="basket.jsp" class="btn btn-primary navbar-btn"><i class="fa fa-shopping-cart"></i><span style=""class="hidden-sm">${sessionScope.cart.size()}</span></a>
                </div>
                <!--/.nav-collapse -->

                <div class="navbar-collapse collapse right" id="search-not-mobile">
                    <button type="button" class="btn navbar-btn btn-primary" data-toggle="collapse" data-target="#search">
                        <span class="sr-only">Toggle search</span>
                        <i class="fa fa-search"></i>
                    </button>
                </div>

            </div>

           
            
            <div class="collapse clearfix" id="search">

                    <form action="SearchProduct" class="navbar-form" role="search" method="Get">
                        <div class="input-group">
                            <input pattern="^[^-\s][a-zA-Z0-9_\s-]+$" class="form-control" placeholder="Search" name = "getsearch" required>
                            <input type="hidden" class="form-control" name = "name" hidden value="${requestScope.Cat.getId()}">
                                                        <span class="input-group-btn">

                                <button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button>

                            </span>
                        </div>
                    </form>

                </div>
                                                        
                           
            <!--/.nav-collapse -->

        </div>
        <!-- /.container -->
        
        
        
        
    </div>
    <!-- /#navbar -->

    <!-- *** NAVBAR END *** -->


