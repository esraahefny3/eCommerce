<%-- 
    Document   : detail
    Created on : Feb 6, 2018, 6:39:38 PM
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
        Details
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
   <%@include file="header.jsp" %>

    <!-- *** NAVBAR END *** -->

    <div id="all">

        <div id="content">
            <div class="container">

               

                
    <div class="col-md-12">

                        <div class="row" id="productMain">
                            <div class="col-sm-6">
                                <div id="mainImage">
                                    <img src="GetImage?name=${requestScope.detailObject.getId()}" alt="" width="500" height="500">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="box">
                                    <h1 class="text-center">${requestScope.detailObject.getName()}</h1>
                                    <p class="price">${requestScope.detailObject.getPrice()} LE </p>

                                    <p class="text-center buttons">
                                        <a href="./AddToCart?pId=${param.name}" class="btn btn-primary"><i class="fa fa-shopping-cart"></i> Add to cart</a> 
                                    </p>
                                </div>
                                <div class="box" id="details">
                                    <p>
                                    <h4>Product details</h4>
                                    <p>${requestScope.detailObject.getDescription()}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                <!-- /.col-md-9 -->
            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->



        <!-- *** COPYRIGHT ***
 _________________________________________________________ -->
      <%@ include file="footer.jsp" %>
        <!-- *** COPYRIGHT END *** -->



    </div>
    <!-- /#all -->


    


</body>

</html>