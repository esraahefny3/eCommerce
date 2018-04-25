<%-- 
    Document   : customer-order
    Created on : Feb 6, 2018, 7:06:24 PM
    Author     : Nehal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        Delivered Order
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

    <!-- *** TOP BAR END *** -->

    <!-- *** NAVBAR ***
 _________________________________________________________ -->

       <%@ include file="header.jsp"%>
    <!-- /#navbar -->

    <!-- *** NAVBAR END *** -->

    <div id="all">

        <div id="content">
            <div class="container">

                <div class="col-md-12">

                    <ul class="breadcrumb">
                        <li><a href="home.jsp">Home</a>
                        </li>
                        <li><a href="#">My orders</a>
                        </li>
                        <li>Order # ${requestScope.orderId}</li>
                    </ul>

                </div>

                <%@ include file="customer_side.jsp"%>

                <div class="col-md-9" id="customer-order">
                    <div class="box">
                        <h1>Order #${requestScope.orderId}</h1>

<!--                        <p class="lead">Order #1735 was placed on <strong>22/06/2013</strong>.</p>-->
                        
                        <hr>

                        <table class="table">
                                        <thead>
                                            <tr>
                                                <th colspan="2">Product</th>
                                                <th>Quantity</th>
                                                <th>Unit price</th>
                                                
                                                <th>Total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${order_details}" var="entry" >
                                        <tr>
                                            <td>
                                                   <img src="GetImage?name=${entry.getProduct().getId()}"> 
                                                </td>
                                            
                                            <td>${entry.getProduct().getName()}</td>
                                            <td>${entry.getNo_items()}</td>
                                            <td>${entry.getPur_price()} LE</td>
                                            <td>${entry.getPur_price() * entry.getNo_items()} LE</td>
                                          
                                        </tr>
                                    </c:forEach>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th colspan="4">Total</th>
                                                <th>${requestScope.Check} LE</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                        <!-- /.table-responsive -->

                     

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
