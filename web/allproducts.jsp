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
            Category
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
        <!-- *** NAVBAR END *** -->

        <div id="all">

            <div id="content">
                <div class="container">
         <!-- Third T3del -->

                    <div class="col-md-12">
                        <ul class="breadcrumb">
                            <li><a href="#">Home</a>
                            </li>
                            <li>All Products</li>
                        </ul>
                    </div>
                    <div class="col-md-12">
                        <div class="box">
                            <h1>All Products</h1>
                            <p>This is List of All Products</p>
                        </div>
                               <div class="box">
                            <form  action=SearchProduct style="width: 50%;margin: 0 auto;" method="Get">
                                		Price &nbsp;  From &nbsp; 
                                                <c:if test="${not empty requestScope.price_low}">
                                                <input type="number" min="0" size="4" name="pricelow" value="${requestScope.price_low}" required>
                                                </c:if>
                                                <c:if test="${empty requestScope.price_low}">
                                                    <input type="number" step="2" min="0" size="4" name="pricelow" required>
                                                </c:if>
                                		to
                                                <c:if test="${not empty requestScope.price_high}">
                                                <input type="number" min="0" size="4" name="pricehigh" value="${requestScope.price_high}" required>
                                                </c:if>
                                                <c:if test="${empty requestScope.price_high}">
                                                <input type="number" min="0" size="4" name="pricehigh" required>
                                                </c:if>
                                                <input type="hidden" name="name" value="${requestScope.Cat.getId()}"/>
                                                <input type="hidden" name="getsearch" value="${requestScope.name_search}"/>
                                                <button type="submit" class="btn btn-primary">Search</button>
                            </form>
                                <div style="width: 50%;margin: 0 auto;">
                                    <c:if test="${not empty requestScope.pricevalid}">
                                        <p style="color: red">Enter price from lower to higher</p>
                                    </c:if>
                                </div>
                            </div>
                        <div class="row products">

                            <c:forEach var = "i" begin = "0" end = "${requestScope.All.size()-1}">
                               <c:if test="${requestScope.All[i].getQuantity()>0}">
                                <div class="col-md-4 col-sm-6">
                                    <div class="product">
                                        <div class="flip-container">
                                            <div class="flipper">
                                                <div class="front">
                                                    <a href="GetDetails?name=${requestScope.All[i].getId()}">
                                                        <img src="GetImage?name=${requestScope.All[i].getId()}" alt ="Mountain View" height="250" width="350">
                                                    </a>
                                                </div>
                                                <div class="back">
                                                    <a href="GetDetails?name=${requestScope.All[i].getId()}">
                                                        <img src="GetImage?name=${requestScope.All[i].getId()}" alt="" height="250" width="350">
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                        <a href="GetDetails?name=${requestScope.All[i].getId()}" class="invisible">
                                            <img src="img/product3.jpg" alt="" height="250" width="350">
                                        </a>
                                        <div class="text">
                                            <h3><a href="GetDetails?name=${requestScope.All[i].getId()}"> ${requestScope.All[i].getName()}</a></h3>
                                            <p class="price">${requestScope.All[i].getPrice()} LE</p>
                                            <p class="buttons">
                                                <a href="GetDetails?name=${requestScope.All[i].getId()}"  class="btn btn-default">View detail</a>
                                                <a href="./AddToCart?pId=${requestScope.All[i].getId()}" class="btn btn-primary"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                               </c:if>
                            </c:forEach>




                


                        </div>
                        <!-- /.col-md-9 -->
                    </div>
                    <!-- /.container -->
                </div>
                <!-- /#content -->  

                <!-- *** COPYRIGHT ***
                 _________________________________________________________ -->
               
                 <%@ include file="footer.jsp"%>
            </div>
           
    </body>

</html>