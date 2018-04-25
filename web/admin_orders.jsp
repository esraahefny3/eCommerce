<%-- 
    Document   : admin_orders
    Created on : Feb 7, 2018, 12:28:22 AM
    Author     : Nehal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            customers
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
                <li class="active" >
                    <a  href="AdminOrders"><i class="fa fa-list"></i>Orders</a>
                </li>
                <li>
                    <a href="AddCard"><i class="fa fa-list"></i>Cards</a>
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
                        <c:if test="${not empty requestScope.orders_list}">   
                        <div class="box">
                            
                            <h1 style="color: #4fbfa7" >customer orders</h1>
                            <hr>

                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>order number</th>
                                            <th>order Date</th>
                                            <th>status</th>
                                            <th>user ID</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="i"  begin="0" end="${requestScope.orders_list.size()}" >
                                        <tr>
                                  <th><a href="Detailed_order?orderId=${requestScope.orders_list[i].getId()}">${requestScope.orders_list[i].getId()}</a></th>
                                           <td>${requestScope.formatted_date[i]}</td>
                                           <c:if test="${requestScope.orders_list[i].getCheckSubmitted()==0}">
                                            <td>Not Submitted</td>
                                        </c:if>
                                            <c:if test="${requestScope.orders_list[i].getCheckSubmitted()==1}">
                                            <td>Submitted</td>
                                            </c:if>
                                            <td>${requestScope.orders_list[i].getUserId()}</td>
                                        </tr>
                                        </c:forEach> 
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        </c:if>
                        <c:if test="${empty requestScope.orders_list}">
                            <h1>No orders to show for This User</h1>
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
