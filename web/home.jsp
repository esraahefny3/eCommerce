<%-- 
    Document   : userHome.jsp
    Created on : Feb 6, 2018, 11:22:08 PM
    Author     : esraa
--%>

<%@page import="DTOS.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
   
     
<head>

    <meta charset="utf-8">
    <meta name="robots" content="all,follow">
    <meta name="googlebot" content="index,follow,snippet,archive">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Obaju e-commerce template">
    <meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
    <meta name="keywords" content="">

    <title>
        Home
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

    <%@ include file="header.jsp"%>
    
    
    <div id="all">

        <div id="content">
                 <div class="container">
                <div class="col-md-12">
                    <div id="main-slider">
                        
                        
                        <div style="margin-top: 50px;"class="item">
                            <img class="img-responsive" src="img/5.jpg" alt="">
                        </div>
                        <div style="margin-top: 20px;"class="item">
                            <img class="img-responsive" src="img/slider1.jpg" alt="">
                        </div>
                        <div style="margin-top: 80px;"class="item">
                            <img class="img-responsive" src="img/7.jpg" alt="">
                        </div>
                    </div>
                    <!-- /#main-slider -->
                </div>
            </div>
            <!--slider end-->
            <!-- *** ADVANTAGES HOMEPAGE ***-->
            
             <div id="advantages">

                <div class="container">
                    <div class="same-height-row">
                        <div class="col-sm-4">
                            <div class="box same-height clickable">
                                <div class="icon"><i class="fa fa-heart"></i>
                                </div>

                                <h3><a href="#">We love our customers</a></h3>
                                <p>We are known to provide best possible service ever</p>
                            </div>
                        </div>

                        <div class="col-sm-4">
                            <div class="box same-height clickable">
                                <div class="icon"><i class="fa fa-tags"></i>
                                </div>

                                <h3><a href="#">Best prices</a></h3>
                                <p>You can check that the height of the boxes adjust when longer text like this one is used in one of them.</p>
                            </div>
                        </div>

                        <div class="col-sm-4">
                            <div class="box same-height clickable">
                                <div class="icon"><i class="fa fa-thumbs-up"></i>
                                </div>

                                <h3><a href="#">100% satisfaction guaranteed</a></h3>
                                <p>Free returns on everything for 3 months.</p>
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.container -->

            </div>
            <!-- /#advantages -->

            <!-- *** ADVANTAGES END *** -->
            
            
            
            
            
            <!-- *** HOT PRODUCT SLIDESHOW ***-->
            
            <div id="hot">

                <div class="box">
                    <div class="container">
                        <div class="col-md-12">
                            <h2>Our Latest Products</h2>
                        </div>
                    </div>
                </div>

                <div class="container">
                    <div class="product-slider">
                        
                        <!--product-->
                        
                         <c:forEach var = "i" begin = "0" end = "5">
                                <div class="item">
                                    <div class="product">
                                        <div class="flip-container">
                                            <div class="flipper">
                                                <div class="front">
                                                    <a href="GetDetails?name=${requestScope.HomeProducts[i].getId()}">
                                                        <img src="GetImage?name=${requestScope.HomeProducts[i].getId()}" alt="" height="200" width="100%">
                                                    </a>
                                                </div>
                                                <div class="back">
                                                    <a href="GetDetails?name=${requestScope.HomeProducts[i].getId()}">
                                                        <img src="GetImage?name=${requestScope.HomeProducts[i].getId()}" alt="" height="200" width="100%">
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                        <a href="www.google.com" class="invisible">
                                            <img src="GetImage?name=${requestScope.HomeProducts[i].getId()}" alt="" height="200" width="100%">
                                            
                                        </a>
                                        <div class="text">
                                            <h3><a href="GetDetails?name=${requestScope.HomeProducts[i].getId()}">${requestScope.HomeProducts[i].getName()}</a></h3>
                                            <p class="price">${requestScope.HomeProducts[i].getPrice()} LE</p>
                                        </div>
                                        <!-- /.text -->
                                    </div>
                                    <!-- /.product -->
                                </div>
                            </c:forEach>
                        
                        <!--product-->
                     

                      

                    </div>
                    <!-- /.product-slider -->
                </div>
                <!-- /.container -->

            </div>
            <!-- /#hot -->

            <!-- *** HOT END *** -->

           
            <!-- *** GET INSPIRED ***
 _________________________________________________________ -->
            <div class="container" data-animate="fadeInUpBig">
                <div class="col-md-12">
                    <div class="box slideshow">
                        <h3>Get Inspired</h3>
                        <p class="lead">Get the inspiration from our world class designers</p>
                        <div id="get-inspired" class="owl-carousel owl-theme">
                           
                            <div class="item">
                                <a href="#">
                                    <img src="img/getinspired2.jpg" alt="Get inspired" class="img-responsive">
                                </a>
                            </div>
                            <div style="margin-left:60px;margin-top:20px;"class="item">
                                <a href="#">
                                    <img src="img/blog2.jpg" alt="Get inspired" class="img-responsive">
                                </a>
                            </div>
                             <div class="item">
                                <a href="#">
                                    <img src="img/slider3.jpg" alt="Get inspired" class="img-responsive">
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- *** GET INSPIRED END *** -->

            <!-- *** BLOG HOMEPAGE ***
 _________________________________________________________ -->

          
            <!-- /.container -->

            <!-- *** BLOG HOMEPAGE END *** -->


        </div>
        <!-- /#content -->
		<!-- *** COPYRIGHT ***
 _________________________________________________________ -->
       
    <%@ include file="footer.jsp" %>
        <!-- *** COPYRIGHT END *** -->
    </div>
    <!-- /#all -->


    

    <!-- *** SCRIPTS TO INCLUDE ***
 _________________________________________________________ -->
   
    
   

</body>

</html>