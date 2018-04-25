<%-- 
    Document   : signup
    Created on : Feb 6, 2018, 8:18:56 PM
    Author     : 3alilio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            Registerion 
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
        <%@ include file="header.jsp" %>


        <!-- *** NAVBAR END *** -->

        <div id="all">

            <div id="content">
                <div class="container">

                    <div class="col-md-12">

                        <ul class="breadcrumb">
                            <li><a href="#">Home</a>
                            </li>
                            <li>New account / Sign in</li>
                        </ul>

                    </div>

                    <div class="col-md-6">
                        <img src="../../../../AppData/Local/Temp/googlelogo_color_272x92dp.png" alt=""/>
                        <div class="box">
                            <h1>New account</h1>

                            <p class="lead">Not our registered customer yet?</p>
                            <hr>
                            <form action="./users/signUp" method="post" onsubmit="return Register()">

                                <c:choose>
                                    <c:when test="${param.error==0}">
                                        <div>
                                            <p>error while registering please try again</p>
                                        </div>
                                    </c:when>    
                                    <c:when test="${param.error==1}">
                                        <div>
                                            <p>There is an account with this email, please login or try again</p>
                                        </div>
                                    </c:when>
                                </c:choose>

                                <div class="form-group">
                                    <label for="name">Name</label>
                                    <input type="text" class="form-control" id="nametext" name="name">
                                    <h6> <font color="red" id ="namemessage"></font> </h6>

                                </div>
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="text" class="form-control" id="emailtext" name="email">
                                    <h6> <font color="red" id ="emailmessage"></font> </h6>
                                </div>
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" id="password1text" name="password">

                                </div>
                                <div class="form-group">
                                    <label for="password">Confirm Password</label>
                                    <input type="password" class="form-control" id="password2text" name="newpassword2">
                                    <h6> <font color="red" id ="passwordmessage"></font> </h6>
                                </div>
                                <div class="form-group">
                                    <label for="password">Telephone</label>
                                    <input type="text" class="form-control" id="telephonetext" name="telephone">
                                    <h6> <font color="red" id ="telephonemessage"></font> </h6>
                                </div>
                                <div class="form-group">
                                    <label for="password">Country</label>
                                    <input type="text" class="form-control" id="countrytext" name="country">
                                    <h6> <font color="red" id ="countrymessage"> </font> </h6>
                                </div>
                                <div class="form-group">
                                    <label for="password">Address</label>
                                    <input type="text" class="form-control" id="addresstext" name="address">
                                    <h6> <font color="red" id ="addressmessage"> </font> </h6>
                                </div>


                                <div class="col-md-6" style="position: absolute;top:0px;left:540px;;width: 700px;">
                                    <div class="box">
                                        <h1>Interests</h1>
                                        <p class="lead">Please choose categories you like</p>

                                        <c:forEach begin="0" end="${applicationScope.categoriesList.size()-1}" var="i">
                                            <div class="col-sm-3" >
                                                <table>
                                                    <tr>
                                                        <td><input type="checkbox" name="interestsList" value="${applicationScope.categoriesList[i].getId()}"></td>
                                                        <td>${applicationScope.categoriesList[i].getName()}</td>     
                                                    </tr>
                                                </table>
<!--                                                <h5> ${category.getName()}</h5>
                                                <input type="checkbox" name="interestsList" value="${category.getId()}">-->
                                            </div>

                                        </c:forEach>
                                        <div class="text-center">
                                            <button type="submit" class="btn btn-primary"  ><i class="fa fa-user-md"></i> Register</button>
                                        </div>

                                    </div>

                                </div>

                            </form>
                        </div>
                    </div>




                </div>
                <!-- /.container -->
            </div>
            <!-- /#content -->





            <!-- * COPYRIGHT *
     _______________________________________________________ -->
            <%@ include file="footer.jsp" %>


        </div>
        <!-- /#all -->




    </body>
    <script>
        function Register() {
            document.getElementById("emailmessage").innerHTML = "";
            document.getElementById("telephonemessage").innerHTML = "";
            document.getElementById("namemessage").innerHTML = "";
            document.getElementById("addressmessage").innerHTML = "";
            document.getElementById("passwordmessage").innerHTML = "";
            var Email;
            var RegEmail = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
            var EmailText = document.getElementById("emailtext").value;
            CheckEmail = RegEmail.test(EmailText);
            if (CheckEmail == true) {
                Email = true;
            } else {
                document.getElementById("emailmessage").innerHTML = "This is Wrong Email";
                Email = false;
            }

            var Telephone;
            var TelephoneText = document.getElementById("telephonetext").value;
            var RegTel = /^\d+$/;
            var CheckedTele = RegTel.test(TelephoneText);

            if (TelephoneText.length != 0) {
                if (CheckedTele == true) {
                    Telephone = true;
                } else {
                    document.getElementById("telephonemessage").innerHTML = "Plese Enter Numbers Only";
                    Telephone = false;
                }
            } else {
                document.getElementById("telephonemessage").innerHTML = "Plese Enter Telephone";
                Telephone = false;
            }

            var FullName;
            var FullNameText = document.getElementById("nametext").value;
            if (FullNameText.length == 0) {
                document.getElementById("namemessage").innerHTML = "Plese Enter Your Name";
                FullName = false;
            } else {
                FullName = true;
            }

            var Address;
            var AddressText = document.getElementById("addresstext").value;
            if (AddressText.length == 0) {
                document.getElementById("addressmessage").innerHTML = "Plese Enter Your Address";
                Address = false;
            } else {
                Address = true;
            }

            var Password;
            var Password1 = document.getElementById("password1text").value;
            var Password2 = document.getElementById("password2text").value;

            if (Password1 == Password2) {
                Password = true;

            } else {
                document.getElementById("passwordmessage").innerHTML = "The Passwords Doesn't Match";
                Password = false;
            }
            if (Password1.length == 0 || Password2.length == 0) {
                document.getElementById("passwordmessage").innerHTML = "Please Write A Password";
                Password = false;
            }

            if (Email == true && Telephone == true && FullName == true && Address == true && Password == true) {
                return true;
            } else {
                return false;
            }
        }
    </script>


</html>
