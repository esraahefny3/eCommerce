<%-- 
    Document   : customer-orders
    Created on : Feb 6, 2018, 7:05:16 PM
    Author     : Nehal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        All Orders
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

                    <ul class="breadcrumb">
                        <li><a href="#">Home</a>
                        </li>
                        <li>My orders</li>
                    </ul>

                </div>

                <%@ include file="customer_side.jsp"%>

                
                
                <div class="col-md-9" id="customer-orders">
                    <div class="box">
                        <h1>My orders</h1>

                        <p class="lead">Your orders on one place.</p>
                       
                        <hr>
                      <c:if test="${not empty requestScope.orders_list}">   
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Order</th>
                                        <th>Date</th>
                                        <th>Total</th>
                                    
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                          <c:forEach var="i"  begin="0" end="${requestScope.orders_list.size()-1}" >
                                    <tr>
                                        <th># ${requestScope.orders_list[i].getId()}</th>
                                        <td>${requestScope.formatted_date[i]}</td>
                                        <td>${requestScope.prices[i]}</td>
                                        <td>
                                            <form action="ViewDetailedOrder" method="Post">
                                                 <button  type="submit" class="btn btn-primary"><i class="fa fa-save"></i>View</button>
                                                 <input type="hidden" name="orderId" value="${requestScope.orders_list[i].getId()}"/>
                                            </form>
                                        </td>
                                    </tr> 
                          </c:forEach>
                                </tbody>
                            </table>
                        </div>
                      </c:if>
                        <c:if test="${empty requestScope.orders_list}">
                            No Orders To Show
                        </c:if>
                    </div>
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
