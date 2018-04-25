<%-- 
    Document   : admin_home
    Created on : Feb 7, 2018, 12:28:01 AM
    Author     : Nehal
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<%@page import="DTOS.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Daos.CategoryDao"%>

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
            admin home
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

            <div class="modal fade" id="add-modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
                <div class="modal-dialog modal-sm">

                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 style="color: #4fbfa7" class="modal-title" id="Login">new category</h4>
                        </div>
                        <div class="modal-body">
                            <form action="./admin/addCategory" method="post">
                                <div class="form-group">
                                    <span style="color: #4fbfa7">category name: </span>   <input type="text" required class="form-control" id="email-modal" name="category" placeholder="category name">
                                </div>
                                <div class="form-group">
                                    <span style="color: #4fbfa7">category Description: </span> <input type="text"  class="form-control" id="password-modal" name="description" placeholder="category description">
                                </div>

                                <p class="text-center">
                                    <button class="btn btn-primary"><i class="fa fa-sign-in"></i> add </button>
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
                            <h4 style="color: #4fbfa7" class="modal-title" id="Login">delete category</h4>
                        </div>
                        <div class="modal-body">
                            <form action="./admin/removeCategory" method="post" >
                                <div class="form-group">
                                    <input type="hidden" class="form-control" name="Qp" id ="Qp" >
                                </div>
                                <div class="form-group">
                                    <span style="color: #4fbfa7">Category Name: </span>    <input type="text" required disabled class="form-control" name="categoryQp" id ="categoryQp" >
                                </div>
                                <div class="form-group">
                                    <span style="color: #4fbfa7">Category Description: </span>   <input type="text" required disabled class="form-control" name="categoryDesp" id ="categoryDesp" >
                                </div>

                                <p class="text-center">
                                    <button  class="btn btn-primary"><i class="fa fa-sign-in"></i>confirm Delete</button>
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
                            <h4 style="color: #4fbfa7" class="modal-title" id="Login">Edit category</h4>
                        </div>
                        <div class="modal-body">
                            <form action="./admin/editCategory" method="post" >
                                <div class="form-group">
                                    <input type="hidden" class="form-control" name="Q" id ="Q" >
                                </div>
                                <div class="form-group">
                                    <span style="color: #4fbfa7">Category Name: </span> <input type="text" required class="form-control" name="categoryQ" id ="categoryQ" >
                                </div>
                                <div class="form-group">
                                    <span style="color: #4fbfa7">Category Description: </span>   <input type="text"  class="form-control" name="categoryDes" id ="categoryDes" >
                                </div>

                                <p class="text-center">
                                    <button  class="btn btn-primary"><i class="fa fa-sign-in"></i> update</button>
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
                <li class="active" >
                    <a  href="admin_home.jsp"><i class="fa fa-list"></i>Category</a>
                </li>

                <li>
                    <a href="./adminProducts"><i class="fa fa-list"></i>Products</a>
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
                        <div class="box">
                             <div class="navbar-buttons">
                                <div class="navbar-collapse collapse right" id="basket-overview">
                                    <a href="#" class="btn btn-primary navbar-btn" data-toggle="modal" data-target="#add-modal"><i ></i><span> + add  new category</span></a>
                                </div>
                            </div>
                            <h1 style="color: #4fbfa7" >Category List</h1>
                           
                            <hr>


                            <div class="table-responsive">
                                <table class="table table-hover" id="myTable">
                                    <thead>
                                        <tr>
                                            <th>id</th>
                                            <th>category</th>
                                            <th>Description</th>
                                            <th>Action</th>

                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${applicationScope.categoriesList}" var="row">
                                            <tr>
                                                <th><c:out value="${row.getId()}"/></th>
                                                <th><a href="adminProducts?categoryId=${row.getId()} "><c:out value="${row.getName()}"/> </a></th>
                                                <td><c:out value="${row.getDescription()}"/> </td>
                                                <td><a onclick='EditRow(this)'  href="#" data-toggle="modal" data-target="#edit-modal" class="btn btn-primary btn-sm">Edit</a></td>

                                                <td><a onclick='deleteRow(this)' href="#" data-toggle="modal" data-target="#delete-modal" class="btn btn-primary btn-sm">Remove</a>
                                                </td>

                                            </tr>
                                        </c:forEach>
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

            <!-- *** COPYRIGHT END *** -->



        </div>
        <!-- /#all -->





        <script >
            function EditRow(r) {
                var rowEdit = r.parentNode.parentNode.rowIndex;

                //console.log(this.GetrowEdit()); 
                var idd = document.getElementById("myTable").rows[rowEdit].cells[0].innerHTML;
                document.getElementById("Q").value = idd;
                var category = document.getElementById("myTable").rows[rowEdit].cells[1].childNodes;
                document.getElementById("categoryQ").value = category[0].text;
                var category_des = document.getElementById("myTable").rows[rowEdit].cells[2].innerHTML;
                document.getElementById("categoryDes").value = category_des;
            }
            function deleteRow(r) {
                var rowEditk = r.parentNode.parentNode.rowIndex;

                //console.log(this.GetrowEdit()); 
                var iddk = document.getElementById("myTable").rows[rowEditk].cells[0].innerHTML;
                document.getElementById("Qp").value = iddk;
                var categoryk = document.getElementById("myTable").rows[rowEditk].cells[1].childNodes;
                document.getElementById("categoryQp").value = categoryk[0].text;
                var category_desk = document.getElementById("myTable").rows[rowEditk].cells[2].innerHTML;
                document.getElementById("categoryDesp").value = category_desk;
            }
            /*function UpdateRow(){
             rowID =this.GetrowEdit();
             console.log(rowID);    
             var categorytt =  document.getElementById("myTable").rows[rowID].cells[0].childNodes;
             categorytt[0].text.innerHTML= document.getElementById("categoryQ").value;
             document.getElementById("myTable").rows[rowID].cells[1].innerHTML = document.getElementById("categoryDes").value;
             }*/
        </script>


    </body>

</html>
