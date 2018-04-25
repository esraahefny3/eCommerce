pla<%-- 
    Document   : checkout2
    Created on : Feb 6, 2018, 7:08:58 PM
    Author     : Nehal
--%>

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
       Check out 2
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
                        <li>Checkout - Order review</li>
                    </ul>
                </div>

                <div class="col-md-9" id="checkout">

                    <div class="box">
                        <form method="post" action="./SubmitOrder">
                            <h1>Checkout - Order review</h1>
                            <ul class="nav nav-pills nav-justified">
                                <li><a href="checkout1.jsp"><i class="fa fa-map-marker"></i><br>Address</a>
                                </li>
                                <li class="active"><a href="#"><i class="fa fa-eye"></i><br>Order Review</a>
                                </li>
                            </ul>

                            <div class="content">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th colspan="2">Product</th>
                                                <th>Requested Quantity</th>
                                                 <th>Available Quantity</th>
                                                <th>Unit price</th>
                                                <th>Total price</th>
                                                <th>Total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${sessionScope.cart}" var="mapEntry">
                                                <tr>
                                                    <td>
                                                        <a href="#">
                                                            <img src="GetImage?name=${mapEntry.value.getId()}" alt="no image">
                                                </a>
                                                    </td>
                                                    <td><a href="#"><c:out value="${mapEntry.value.getName()}"/></a>
                                                    </td>
                                                    
                                                       <!--<input type="number" value="2" class="form-control">-->
                                                    <td><c:out value="${mapEntry.value.getRequested_quantity()}"/></td>
                                                    <td><c:out value="${mapEntry.value.getAvailable()}"/></td>
                                                   
                                                    <td><c:out value="${mapEntry.value.getPrice()}"/></td>
                                                    <td><c:out value="${mapEntry.value.getAvailable()*mapEntry.value.getPrice()}"/></td>
                                                   
                                                    <td><a href="./RemoveFromCart?pId=${mapEntry.key}"><i class="fa fa-trash-o"></i></a>
                                                    </td>
                                                </tr>
                                             </c:forEach>
                                            
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th colspan="4">Total</th>
                                                <th>${requestScope.total}</th>
                                            </tr>
                                        </tfoot>
                                    </table>

                                </div>
                                <!-- /.table-responsive -->
                            </div>
                            <!-- /.content -->

                            <div class="box-footer">
                                <div class="pull-left">
                                    <a href="checkout1.jsp" class="btn btn-default"><i class="fa fa-chevron-left"></i>Back to Payment method</a>
                                </div>
                                <div class="pull-right">
                                    <button type="submit" class="btn btn-primary">Place an order<i class="fa fa-chevron-right"></i>
                                    </button>
                                </div>
                                <input type="hidden" name="total" value="${requestScope.total}"/>
                                
                            </div>
                        </form>
                    </div>
                    <!-- /.box -->


                </div>
                <!-- /.col-md-9 -->

                <div class="col-md-3">

                    <div class="box" id="order-summary">
                        <div class="box-header">
                            <h3>Order summary</h3>
                        </div>
                        <p class="text-muted">Shipping and handling are for free.</p>

                        <div class="table-responsive">
                            <table class="table">
                                <tbody>
                                    <tr>
                                        <td>Order subtotal</td>
                                        <th>${requestScope.total}</th>
                                    </tr>
                                  
                                    <tr>
                                        <td>User credit</td>
                                        <th>${sessionScope.user.getCredit()}</th>
                                    </tr>
                                    <tr class="total">
                                        <td>Total</td>
                                        <th>${requestScope.total}</th>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                    </div>

                </div>
                <!-- /.col-md-3 -->

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
                            
       <li><a href="#" data-toggle="modal" hidden data-target="#done_modal" id="doneModalLink">Login</a></li>
       
         <div class="modal fade" id="done_modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
            <div class="modal-dialog modal-sm">
                
                <div class="modal-content">
                    <div class="modal-header">
                            <h4 class="modal-title" id="LoginE">${param.done_modal}</h4>
                       
                            <a href="./GetHome" >    
                                <p class="text-center">
                                     <button  class="btn btn-primary"> Ok</button>
                                </p>
                            </a>
              
                    </div>
                    
                    </div> 
                             
            </div>
        </div>



        <!-- *** COPYRIGHT ***
 _________________________________________________________ -->
     
         <%@ include file="footer.jsp"%>
        <!-- *** COPYRIGHT END *** -->
        
         <c:if test="${param.error_modal!=null}">
        <script type="text/javascript">
            document.getElementById("errorModalLink").click();
        </script>
    </c:if>
        
         <c:if test="${param.done_modal!=null}">
        <script type="text/javascript">
            document.getElementById("doneModalLink").click();
        </script>
    </c:if>



    </div>
    <!-- /#all -->


    






</body>

</html>