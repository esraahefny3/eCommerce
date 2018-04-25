<%-- 
    Document   : admin_customer
    Created on : Feb 7, 2018, 12:28:55 AM
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
            Customers
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
                <li class="active" >
                    <a chref="adminCustmores"><i class="fa fa-user"></i>Customers</a>
                </li>
                <li>
                    <a href="AdminOrders"><i class="fa fa-list"></i>Orders</a>
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
                        <div class="box">
                             <h1 style="color: #4fbfa7" >Customers</h1>
                             
                            <hr>

                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Email</th>
                                            <th>Phone</th>
                                            <th>Address</th>
                                            <th>Country</th>
                                            <th>Job</th>
                                            <th>Credit</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:if test="${(requestScope.users_list.size())!=0}">
                                    <c:forEach var="i"  begin="0" end="${requestScope.users_list.size()-1}" >
                                        <tr>
                                            <th><a href="AdminOrders?userId=${requestScope.users_list[i].getId()}">${requestScope.users_list[i].getFullName()}</a></th>
                                            <td>${requestScope.users_list[i].getEmail()}</td>
                                            <td>${requestScope.users_list[i].getPhone()}</td>
                                            <td>${requestScope.users_list[i].getAddress()}</td>
                                            <td>${requestScope.users_list[i].getCountry()}</td>
                                            <td>${requestScope.users_list[i].getJob()}</td>
                                            <td>${requestScope.users_list[i].getCredit()}</td>
                                            
                                        </tr>
                                    </c:forEach>
                                    </c:if>
                                    <c:if test="${(requestScope.users_list.size())==0}">
                                            <h1>No Oders to show</h1>
                                    </c:if>    
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container -->
            </div>
            <!-- /#content -->




            <!-- *** COPYRIGHT ***
     _________________________________________________________ -->
         <%@ include file="footer.jsp"%>
   

        </div>
        <!-- /#all -->





    </body>

</html>

