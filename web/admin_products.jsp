    <%-- 
    Document   : admin_products
    Created on : Feb 7, 2018, 12:28:37 AM
    Author     : Nehal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="robots" content="all,follow">
        <meta name="googlebot" content="index,follow,snippet,archive">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Obaju e-commerce template">
        <meta name="author" content="Ondrej Svestka | ondrejsvestka.cz">
        <meta name="keywords" content="">

        <title>
            admin products
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
                      <div class="modal fade" id="add-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
                <div class="modal-dialog modal-sm">

                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 style="color: #4fbfa7" class="modal-title" id="Login">new product</h4>
                        </div>
                        <div class="modal-body">
                            <form action="./admin/addProduct?categId=${param.categoryId}" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                  <span style="color: #4fbfa7">product name: </span>  <input type="text" class="form-control" id="email-modal" name="anam" required placeholder="product name">
                                </div>
                               
                                <div class="form-group">
                                 <c:if test="${param.categoryId != null  }">    
                                          <input type="hidden" pattern="\d+" required class="form-control" required id="email-modal"  name="cateid"  value="${param.categoryId}" placeholder="cateid" >
                                          </c:if>

                                    <c:if test="${ param.categoryId == null  }">
                                      <span style="color: #4fbfa7">Category Name: </span>     <!--<input pattern="\d+" required class="form-control" id="email-modal"  name="caid"  placeholder="cateid"> -->
                                      <select id="mySelect" name="cateid" >
                                           <c:forEach items="${applicationScope.categoriesList}"  var="row">
                                        <option value="${row.getId()}">${row.getName()}</option>
                                         </c:forEach>
                                      </select>
                                    </c:if>
                                </div>



                                <div class="form-group">
                                 <span style="color: #4fbfa7">company:</span>   <input type="text" required  class="form-control" required id="password-modal" name="apass" placeholder="company">
                                </div>
                                <div class="form-group">
                                    <span style="color: #4fbfa7">quantity: </span>  <input  required pattern="\d+" class="form-control" required id="password-modal" name="aquan" placeholder="quantity" oninvalid="this.setCustomValidity('Please Enter numbers only')" oninput="this.setCustomValidity('')">
                                </div>
                                <div class="form-group">
                                 <span style="color: #4fbfa7">product description: </span>   <input type="text"  class="form-control"  id="password-modal" name="adesc" placeholder="Description">
                                </div>
                                <div class="form-group">
                                    <span style="color: #4fbfa7">price: </span>   <input  required pattern="\d+(.\d+)?" class="form-control" required id="password-modal" name="aprice" placeholder="price" oninvalid="this.setCustomValidity('Please Enter numbers only')" oninput="this.setCustomValidity('')">
                                </div>
                                <div class="form-group">
                                <span style="color: #4fbfa7" >insert image: </span> <input type="file" id="myFile" name="file" accept="image/x-png,image/gif,image/jpeg">                   
                                </div>
                                

                                <p class="text-center">
                                    <button class="btn btn-primary"><i class="fa fa-sign-in"></i> add </button>
                                </p>

                            </form>

                        </div>
                    </div>
                </div>
            </div>
                       <div class="modal fade" id="edit-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
                <div class="modal-dialog modal-sm">

                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 style="color: #4fbfa7" class="modal-title" id="Login">Edit Product</h4>
                        </div>
                        <div class="modal-body">
                            <form action="./admin/editProduct?cateId=${param.categoryId}" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <input type="hidden" class="form-control" id="idpu" name="idpu" >
                                </div>
                                <div class="form-group">
                                    <span style="color: #4fbfa7">product name: </span>  <input type="text" required class="form-control" id="nameee" name="productdu" >
                                </div>
                                <div class="form-group">
                                    <span style="color: #4fbfa7">product company: </span>     <input type="text"  required class="form-control" id="company" name="companydu">
                                </div>
                                <div class="form-group">
                                    <span style="color: #4fbfa7">product quantity: </span>    <input  required pattern="\d+" class="form-control" id="quantity" name="quantitydu" min="0" oninvalid="this.setCustomValidity('Please Enter numbers only')" oninput="this.setCustomValidity('')">
                                </div>
                                <div class="form-group">
                                    <span style="color: #4fbfa7">product description: </span>    <input type="text"  class="form-control" id="dec" name="Descriptiondu">
                                </div>
                                <div class="form-group">
                                    <span style="color: #4fbfa7">product price: </span>   <input  pattern="\d+(.\d+)?" required="" class="form-control" id="price" name="pricedu" min="0" oninvalid="this.setCustomValidity('Please Enter numbers only')" oninput="this.setCustomValidity('')">
                                </div>
                                 <div class="form-group">
                                <span style="color: #4fbfa7" >insert image: </span> <input type="file" id="myFile" name="editfile" accept="image/x-png,image/gif,image/jpeg" >                   
                                </div>

                                <p class="text-center">
                                    <button class="btn btn-primary"><i class="fa fa-sign-in"></i> update</button>
                                </p>

                            </form>

                        </div>
                    </div>
                </div>
            </div>

                 <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
                <div class="modal-dialog modal-sm">

                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 style="color: #4fbfa7" class="modal-title" id="Login">delete product</h4>
                        </div>
                        <div class="modal-body">
                            <form action="./admin/removeProduct?catId=${param.categoryId}" method="post" >
                                <div class="form-group">
                                         <input type="hidden" required pattern="\d+" class="form-control" id="idp" name="idp" >
                                </div>
                                <div class="form-group">
                                    <span style="color: #4fbfa7">product name: </span>     <input type="text" disabled required class="form-control" id="nam" name="dnam" >
                                </div>
                                <div class="form-group">
                                    <span style="color: #4fbfa7">company name: </span>    <input type="text" disabled class="form-control" id="comp" name="companyd">
                                </div>
                                <div class="form-group">
                                    <span style="color: #4fbfa7">Quantity: </span>    <input type="number" disabled required pattern="\d+"  required class="form-control" id="quan" name="quantityd">
                                </div>
                                <div class="form-group">
                                    <span style="color: #4fbfa7">product Description: </span>    <input type="text" disabled required class="form-control" id="deck" name="Descriptiond">
                                </div>
                                <div class="form-group">
                                    <span style="color: #4fbfa7">product price: </span>   <input type="number" disabled required pattern="\d+"  class="form-control" id="pric" name="priced">
                                </div>


                                <p class="text-center">
                                    <button  class="btn btn-primary"><i class="fa fa-sign-in"></i>confirm Delete</button>
                                </p>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
                                
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

                <li class="active" >
                    <a  href="./adminProducts"><i class="fa fa-list"></i>Products</a>
                </li>
                <li >
                    <a href="adminCustmores"><i class="fa fa-user"></i>Customers</a>
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
                            <c:if test="${applicationScope.categoriesList.size()>0}">
                                      <div class="navbar-collapse collapse right" id="basket-overview">
                                          <a href="#" class="btn btn-primary navbar-btn" data-toggle="modal" data-target="#add-modal"><i ></i><span> + add  new product</span></a>
                                      </div>
                                      </c:if>
                        <c:if test="${not empty requestScope.product_list}">  
                            <div class="box">
                                  <div class="navbar-buttons">
                                      
                                  </div>
                                <h1 style="color: #4fbfa7" > Products</h1>
                                
                                <hr>

                                <div class="table-responsive">
                                    <table class="table table-hover" id="myTable">
                                        <thead>
                                            <tr>
                                                <th style="display:none;" >id</th>
                                                 <th>photo</th>
                                                <th>product name</th>
                                                <th>company</th>
                                                <th>quantity</th>
                                                <th>Description</th>
                                                <th>price</th>
                                                <th>Action</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${requestScope.product_list}"  var="row">
                                                <tr>
                                                     <td style="display:none;" >${row.getId()}</td>
                                                    <td><img src="GetImage?name=${row.getId()}" width = "80px" ></td>
                                                    <td>${row.getName()}</td>
                                                    <td>${row.getCompanyName()}</td>
                                                    <td>${row.getQuantity()}</td>
                                                    <td>${row.getDescription()}</td>
                                                    <td>${row.getPrice()}</td>
                                                    <td><a onclick='EditRow(this)' href="#" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#edit-modal" >Edit</a></td>
                                                    <td><a onclick='deleteRow(this)' href="#" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#delete-modal">Remove</a>
                                                    </td>
                                                </tr>
                                            </c:forEach> 


                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${empty requestScope.product_list}">
                            <h1>No products to show </h1>
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




      
        <script >
                                                function EditRow(r) {
                                                    var rowEdit = r.parentNode.parentNode.rowIndex;
                                                    var idpu = document.getElementById("myTable").rows[rowEdit].cells[0].innerHTML;
                                                    document.getElementById("idpu").value = idpu;
                                                    var namee = document.getElementById("myTable").rows[rowEdit].cells[2].innerHTML;
                                                    document.getElementById("nameee").value = namee;
                                                    var company = document.getElementById("myTable").rows[rowEdit].cells[3].innerHTML;
                                                    document.getElementById("company").value = company;
                                                    var quantity = document.getElementById("myTable").rows[rowEdit].cells[4].innerHTML;
                                                    document.getElementById("quantity").value = quantity;
                                                    var Description = document.getElementById("myTable").rows[rowEdit].cells[5].innerHTML;
                                                    document.getElementById("dec").value = Description;
                                                    var price = document.getElementById("myTable").rows[rowEdit].cells[6].innerHTML;
                                                    document.getElementById("price").value = price;

                                                }
                                                function deleteRow(r) {
                                                    var rowEditk = r.parentNode.parentNode.rowIndex;
                                                    var idk = document.getElementById("myTable").rows[rowEditk].cells[0].innerHTML;
                                                    document.getElementById("idp").value = idk;
                                                    var nameek = document.getElementById("myTable").rows[rowEditk].cells[2].innerHTML;
                                                    document.getElementById("nam").value = nameek;
                                                    var companyk = document.getElementById("myTable").rows[rowEditk].cells[3].innerHTML;
                                                    document.getElementById("comp").value = companyk;
                                                    var quantityk = document.getElementById("myTable").rows[rowEditk].cells[4].innerHTML;
                                                    document.getElementById("quan").value = quantityk;
                                                    var Descriptionk = document.getElementById("myTable").rows[rowEditk].cells[5].innerHTML;
                                                    document.getElementById("deck").value = Descriptionk;
                                                    var pricek = document.getElementById("myTable").rows[rowEditk].cells[6].innerHTML;
                                                    document.getElementById("pric").value = pricek;
                                                }
        </script>

    </body>

</html>
