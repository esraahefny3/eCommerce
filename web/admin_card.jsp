<%-- 
    Document   : newjsp
    Created on : Feb 10, 2018, 2:56:10 PM
    Author     : 3alilio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="robots" content="all,follow">
        <meta name="googlebot" content="index,follow,snippet,archive">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Obaju e-commerce template">
        <meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
        <meta name="keywords" content="">

        <title>
            Admin card
        </title>

        <meta name="keywords" content="">

        <link href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100' rel='stylesheet' type='text/css'>

        <!-- styles -->
        <link href="css/font-awesome.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/animate.min.css" rel="stylesheet">
        <link href="css/owl.carousel.css" rel="stylesheet">
        <link href="css/owl.theme.css" rel="stylesheet">

        <!-- theme stylesheet -->
        <link href="css/style.default.css" rel="stylesheet" id="theme-stylesheet">

        <!-- your stylesheet with modifications -->
        <link href="css/custom.css" rel="stylesheet">

        <script src="js/respond.min.js"></script>

        <link rel="shortcut icon" href="favicon.png">



    </head>

    <body>
        <!-- *** TOPBAR ***
     _________________________________________________________ -->
       <%@ include file="header.jsp"%>
   

        <!-- *** NAVBAR END *** -->

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">



                    </div>

                    <div class="col-md-3">
    <!-- *** CUSTOMER MENU ***
_________________________________________________________ -->
    
    <div class="panel panel-default sidebar-menu">

        <div class="panel-heading">
            <h3 class="panel-title">Management</h3>
        </div>

        <div class="panel-body">

            <ul class="nav nav-pills nav-stacked">
                <li >
                    <a href="admin_home.jsp"><i class="fa fa-list"></i>Category</a>
                </li>

                <li>
                    <a href="./adminProducts"><i class="fa fa-list"></i>Products</a>
                </li>
                <li >
                    <a href="adminCustmores"><i class="fa fa-user"></i>Customers</a>
                </li>
                <li>
                    <a href="AdminOrders"><i class="fa fa-list"></i>Orders</a>
                </li>
                <li class="active" >
                    <a  href="AddCard"><i class="fa fa-list"></i>Cards</a>
                </li>
                <li>
                    <a href="GetHome"><i class="fa fa-list"></i>Home Page</a>
                </li>
            </ul>
        </div>

    </div>
    <!-- *** CUSTOMER MENU END *** -->
</div>


                    <div class="col-md-9" id="customer-orders">
                        
                        
                        
                        <div class="box">
                            <h1>Admin Card</h1>
                            <hr>

                            <form action="AddCard" method="post">
                            <div class="form-group">
                                <label for="email">Code</label>
                                <input type="text"  name="code" pattern="\d{15}" oninvalid="this.setCustomValidity('Please Enter 15 number')" oninput="this.setCustomValidity('')" >
                            </div>
                            <div class="form-group" >
                                <label for="password">Value</label>
                                <input type="number" min="20" name="value" required="">
                            </div>
                            <c:if test="${not empty requestScope.CheckAdd}">
                                <c:if test="${requestScope.CheckAdd==true}">
                                    <p style="color:green">Card Added Successfuly</p>
                                </c:if>
                                <c:if test="${requestScope.CheckAdd==false}">
                                    <p style="color:red">Card can't be added</p>
                                </c:if>    
                            </c:if>   
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary"><i class="fa fa-sign-in"></i> Add Card</button>
                            </div>
                        </form>
                        </div>
                        <c:if test="${not empty requestScope.cards_list}">
                        <div class="box">
                          <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Code</th>
                                            <th>Value</th>
                                            <th>Submitted</th>
                                            <th>User ID</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                    <c:forEach var="i"  begin="0" end="${requestScope.cards_list.size()-1}" >
                                        <tr>
                                            <th>${requestScope.cards_list[i].getCode()}</th>
                                            <td>${requestScope.cards_list[i].getValue()}</td>
                                            <c:if test="${requestScope.cards_list[i].getCharged()==0}">
                                            <td>Not charged</td>
                                            </c:if>
                                            <c:if test="${requestScope.cards_list[i].getCharged()==1}">
                                            <td>Charged</td>
                                            </c:if>
                                            <c:if test="${requestScope.cards_list[i].getUser_id()==0}">
                                            <td></td>
                                            </c:if>
                                            <c:if test="${requestScope.cards_list[i].getUser_id()!=0}">
                                            <td>${requestScope.cards_list[i].getUser_id()}</td>
                                            </c:if>                                            
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                         </div>
                        </c:if>
                        <c:if test="${ empty requestScope.cards_list}">
                            <h1>No cards to show</h1>
                        </c:if>
                    </div>
                    
                    

                </div>
                <!-- /.container -->
            </div>
            <!-- /#content -->




            <!-- *** COPYRIGHT ***
     _________________________________________________________ -->
           <%@ include file="footer.jsp"%>
   
            <!-- *** COPYRIGHT END *** -->



        </div>
        <!-- /#all -->




     



    </body>

</html>
