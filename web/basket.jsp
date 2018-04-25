<%-- 
    Document   : basket
    Created on : Feb 6, 2018, 8:02:42 PM
    Author     : Nehal
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="DTOS.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        Basket
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

                <div class="col-md-12">
                    <ul class="breadcrumb">
                        <li><a href="#">Home</a>
                        </li>
                        <li>Shopping cart</li>
                    </ul>
                </div>

                <div class="col-md-12" id="basket">

                    <div class="box">

                        <form method="post" action="./proceedToCheckout">

                            <h1>Shopping cart</h1>
                            <p class="text-muted">You currently have <c:out value="${sessionScope.cart.size()}"/> item(s) in your cart.</p>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th colspan="2">Product</th>
                                            <th>Quantity</th>
                                            <th>Unit price</th>
                                            
                                            <th colspan="2">Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                       
                                        <c:forEach items="${sessionScope.cart}" var="mapEntry">
                                        <tr>
                                            <td>
                                                <a href="#">
                                                    <img src="GetImage?name=${mapEntry.value.getId()}" alt="no image" class="img-responsive">
                                               </a>
                                            </td>
                                            <td><a href="#"><c:out value="${mapEntry.value.getName()}"/></a>
                                            </td>
                                            <td>
                                             <c:choose>
                                                 <c:when test="${mapEntry.value.getRequested_quantity()==0}">
                                                     <input type="number" style="width:100px;" value="1" name="${mapEntry.key}" min="1" max="infinite" class="form-control">
                                                </c:when>
                                                <c:otherwise>
                                                       <input type="number" style="width:100px;" value="${mapEntry.value.getRequested_quantity()}" name="${mapEntry.key}" min="1" max="infinite" class="form-control">
                                                </c:otherwise>
                                             </c:choose>
                                            </td>
                                            <td><c:out value="${mapEntry.value.getPrice()}"/></td>
                                            
                                            <td><a href="./RemoveFromCart?pId=${mapEntry.key}"><i class="fa fa-trash-o"></i></a>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                        
                                    </tbody>
                                    
                                </table>

                            </div>
                            <!-- /.table-responsive -->

                            <div class="box-footer">
                                <div class="pull-left">
                                    <a href="./getAllProducts" class="btn btn-default"><i class="fa fa-chevron-left"></i> Continue shopping</a>
                                </div>
                                <div class="pull-right">
                                    <button type="submit" class="btn btn-primary">Proceed to checkout <i class="fa fa-chevron-right"></i>
                                    </button>
                                </div>
                            </div>

                        </form>

                    </div>
                    <!-- /.box -->


                   


                </div>
                <!-- /.col-md-9 -->


            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->

       <!-- error dialog-->
         <li><a href="#" data-toggle="modal" hidden data-target="#error_modal" id="errorModalLink">Login</a></li>
       
         <div class="modal fade" id="error_modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
            <div class="modal-dialog modal-sm">
                
                <div class="modal-content">
                    <div class="modal-header">
                            <h4 class="modal-title" id="LoginE">${param.error_modal}</h4>
                       
                            <a href="./basket.jsp" >    
                                <p class="text-center">
                                     <button  class="btn btn-primary"> Ok</button>
                                </p>
                            </a>
              
                    </div>
                    
                    </div> 
                             
            </div>
        </div>
       
       
       
       
       <!--/error dialog-->



        
<!-- *** COPYRIGHT ***
 _________________________________________________________ -->
      
    <%@ include file="footer.jsp"%>
        <!-- *** COPYRIGHT END *** -->

    </div>
    <!-- /#all -->


    

        
     <c:if test="${param.error_modal!=null}">
        <script type="text/javascript">
            <% System.err.println("yaraab");%>
            document.getElementById("errorModalLink").click();
        </script>
    </c:if>


</body>

</html>