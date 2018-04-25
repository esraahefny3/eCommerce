<%-- 
    Document   : customer-account
    Created on : Feb 6, 2018, 7:07:59 PM
    Author     : Nehal
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
            Profile
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
                            <li>My account</li>
                        </ul>

                    </div>

                    <%@ include file="customer_side.jsp"%>

                    <div class="col-md-9">
                        <div class="box">
                            <h1>My account</h1>
                            <p class="lead">Change your personal details or your password here.</p>

                            <h3>Change password</h3>

                            <form ACTION="ChangeUserPassword" METHOD=post>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="password_old">Old password</label>
                                            <input type="password" class="form-control" id="password_old" required name="old_password">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="password_1">New password</label>
                                            <input type="password" class="form-control" id="password1" required name="password1">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="password_2">Retype new password</label>
                                            <input type="password" class="form-control" id="password2" required name="password2">
                                        </div>
                                    </div>
                                </div>
                                <!-- /.row -->
                                <h6> <font color="red" id =passVal"></font> </h6>

                                <div class="col-sm-12 text-center">
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Save new password</button>
                                    <c:if test="${not empty requestScope.passchanged}">
                                        <c:if test="${requestScope.passchanged==true}">
                                            <p style="color:green;">Password Changed succesfuly</p>
                                        </c:if>
                                        <c:if test="${requestScope.passchanged==false}">
                                            <p style="color:red;">Error occured</p>
                                        </c:if>
                                    </c:if>
                                </div>
                            </form>

                            <hr>

                            <h3>Personal details</h3>
                            <form ACTION=ChangeUserData METHOD=post onsubmit="return Personal()">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="firstname" >Full Name</label>
                                            <input type="text" class="form-control" id="name" value="${sessionScope.user.getFullName()}" name="fullname">
                                            <h6> <font color="red" id ="nameVal"></font> </h6>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="lastname">job</label>
                                            <input type="text" class="form-control" id="job" value="${sessionScope.user.getJob()}" name="job">
                                        </div>
                                    </div>
                                </div>
                                <!-- /.row -->

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="company">Country</label>
                                            <input type="text" class="form-control" id="country" value="${sessionScope.user.getCountry()}" name="Country">
                                            <h6> <font color="red" id ="countryVal"></font> </h6>

                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="street">Address</label>
                                            <input type="text" class="form-control" id="address" value="${sessionScope.user.getAddress()}" name="address">
                                            <h6> <font color="red" id ="addressVal"></font> </h6>

                                        </div>
                                    </div>
                                </div>
                                <!-- /.row -->

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="phone">Credit</label>
                                            <input type="text" class="form-control" id="Credit" disabled value="${sessionScope.user.getCredit()}" name="credit">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="email">BirthDate</label>
                                            <input type="date" class="form-control" id="BirthDate" value="${sessionScope.user.getBirthDate()}" name="date">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">     
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="phone">Telephone</label>
                                            <input type="text" class="form-control" id="phone" value="${sessionScope.user.getPhone()}" name="phone">
                                            <h6> <font color="red" id ="teleVal"></font> </h6>

                                        </div>
                                    </div>

                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="email">Email</label>
                                            <input type="text" class="form-control" id="email" value="${sessionScope.user.getEmail()}" name="email">
                                            <h6> <font color="red" id ="emailVal"></font> </h6>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">     
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="phone">Cards</label>
                                            <input type="text" class="form-control" id="phonee" disabled value="${sessionScope.user.getNoOfUsedCards()}" name="cards">
                                        </div>
                                    </div>
                                </div>


                                <div class="col-sm-12 text-center">
                                    <button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Save changes</button>

                                </div>
                                <c:if test="${not empty requestScope.isupdated}">
                                    <c:if test="${requestScope.isupdated==1}">
                                        <p style="color:green;">Updated Successfuly</p>
                                    </c:if>
                                    <c:if test="${requestScope.isupdated==2}">
                                        <p style="color:red;">Error occured</p>
                                    </c:if>
                                </c:if>

                            </form>

                            <!--interests-->     
                            <li><a href="#" data-toggle="modal"  data-target="#interests_modal" id="edit_interests"> <button  class="btn btn-primary"  ><i class="fa fa-user-md"></i> Edit Interests</button></a></li>

                            <div class="modal fade" id="interests_modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
                                <div class="modal-dialog modal-body">

                                    <div class="modal-content" >
                                        <form action="./updateInterests"> 
                                            <div class="col-md-12">
                                                <div class="box">
                                                    <h1>Interests</h1>
                                                    <p class="lead">Please choose categories you like</p>

                                                    <c:forEach items="${applicationScope.categoriesList}" var="category">
                                                        <div class="col-md-6" style="border: 1px solid gray;">

                                                            <h5> ${category.getName()}</h5>
                                                            <c:choose>
                                                                <c:when test="${category.getId()==sessionScope.user_Interestes.get(category.getId()).getId()}">
                                                                    <input type="checkbox" name="interestsList" value="${category.getId()}"checked>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <input type="checkbox" name="interestsList" value="${category.getId()}">

                                                                </c:otherwise>
                                                            </c:choose>
                                                        </div>

                                                    </c:forEach>

                                                    <div class="text-center">
                                                        <button type="submit" class="btn btn-primary"  ><i class="fa fa-user-md"></i> Save</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>



                                    </div>


                                </div>

                            </div>

                            <h3>Recharge Credit</h3>

                            <form  ACTION=RechargeCredit METHOD=post onsubmit="return Recharge()">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label for="password_old">Enter Code</label>
                                            <input type="text" class="form-control" id="creditcode" name="code" >
                                            <h5> <font color="red" id ="codeVal"></font>   </h5>
                                        </div>
                                        <c:if test="${not empty requestScope.check}">
                                            <c:if test="${requestScope.check==1}">
                                                <p style="color: green">Credit Added Successfuley</p>
                                            </c:if>
                                            <c:if test="${requestScope.check==2}">
                                                <p style="color: red">This Card Already charged</p>
                                            </c:if>
                                            <c:if test="${requestScope.check==3}">
                                                <p style="color: red">This is invalid code</p>
                                            </c:if>
                                            <c:if test="${requestScope.check==4}">
                                                <p style="color: green">Credit Added Successfuley <br /> This your Card number ${sessionScope.user.getNoOfUsedCards()}<br /> You Won an Extra 50 LE</p>
                                                </c:if>
                                            </c:if>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 text-center">
                                        <button  type="submit" class="btn btn-primary"><i class="fa fa-save"></i>Submit Code</button>
                                    </div>  

                                </div>
                                <!-- /.row -->                            
                            </form>

                        </div>
                    </div>

                </div>
                <!-- /.container -->
            </div>
            <!-- /#content -->

         <li><a href="#" data-toggle="modal" hidden data-target="#feedback_modal" id="feedBackModalLink">Login</a></li>
       
         <div class="modal fade" id="feedback_modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
            <div class="modal-dialog modal-sm">
                
                <div class="modal-content">
                    <div class="modal-header">
                            <h4 class="modal-title" >
                             <c:if test="${not empty requestScope.passchanged}">
                                        <c:if test="${requestScope.passchanged==true}">
                                            <p style="color:green;">Password Changed succesfuly</p>
                                        </c:if>
                                        <c:if test="${requestScope.passchanged==false}">
                                            <p style="color:red;">Error occured</p>
                                        </c:if>
                             </c:if>
                            </h4>
                       
                            <a href="./customer-account.jsp" >    
                                <p class="text-center">
                                     <button  class="btn btn-primary"> Ok</button>
                                </p>
                            </a>
              
                    </div>
                    
                    </div> 
                             
            </div>
        </div>
         
         
            <li><a href="#" data-toggle="modal" hidden data-target="#isUpdated_modal" id="isUpdatedModalLink">Login</a></li>
       
         <div class="modal fade" id="isUpdated_modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
            <div class="modal-dialog modal-sm">
                
                <div class="modal-content">
                    <div class="modal-header">
                            <h4 class="modal-title" >
                              <c:if test="${not empty requestScope.isupdated}">
                                    <c:if test="${requestScope.isupdated==1}">
                                        <p style="color:green;">Updated Successfuly</p>
                                    </c:if>
                                    <c:if test="${requestScope.isupdated==2}">
                                        <p style="color:red;">Error occured</p>
                                    </c:if>
                                </c:if>
                            </h4>
                       
                            <a href="./customer-account.jsp" >    
                                <p class="text-center">
                                     <button  class="btn btn-primary"> Ok</button>
                                </p>
                            </a>
              
                    </div>
                    
                    </div> 
                             
            </div>
        </div>
            
            
              <li><a href="#" data-toggle="modal" hidden data-target="#check_modal" id="checkModalLink">Login</a></li>
       
         <div class="modal fade" id="check_modal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
            <div class="modal-dialog modal-sm">
                
                <div class="modal-content">
                    <div class="modal-header">
                            <h4 class="modal-title">
                               <c:if test="${not empty requestScope.check}">
                                            <c:if test="${requestScope.check==1}">
                                                <p style="color: green">Credit Added Successfuley</p>
                                            </c:if>
                                            <c:if test="${requestScope.check==2}">
                                                <p style="color: red">This Card Already charged</p>
                                            </c:if>
                                            <c:if test="${requestScope.check==3}">
                                                <p style="color: red">This is invalid code</p>
                                            </c:if>
                                            <c:if test="${requestScope.check==4}">
                                                <p style="color: green">Credit Added Successfuley <br /> This your Card number ${sessionScope.user.getNoOfUsedCards()}<br /> You Won an Extra 50 LE</p>
                                                </c:if>
                                </c:if>
                            </h4>
                       
                            <a href="./customer-account.jsp" >    
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

        </div>
        <!-- /#all -->
       <c:if test="${not empty requestScope.passchanged}">
        <script type="text/javascript">
            document.getElementById("feedBackModalLink").click();
        </script>
       </c:if>>
       
        <c:if test="${not empty requestScope.isupdated}">
        <script type="text/javascript">
            document.getElementById("isUpdatedModalLink").click();
        </script>
       </c:if>
        
        <c:if test="${not empty requestScope.check}">
        <script type="text/javascript">
            document.getElementById("checkModalLink").click();
        </script>
       </c:if>>

        
        <script>
            function Recharge() {
                var CodeNumber = document.getElementById("creditcode").value;
                var reg1 = /^(0|[1-9][0-9]*)$/;
                var Checked1 = reg1.test(CodeNumber);
                if (CodeNumber.length != 0) {
                    if (Checked1 == true) {
                        if (CodeNumber.length == 15) {
                            return true;
                        } else {
                            document.getElementById("codeVal").innerHTML = "The Code Must be 15 Digits";
                            return false;
                        }
                    } else {
                        document.getElementById("codeVal").innerHTML = "Plese Enter Numbers Only";
                        return false;
                    }
                } else {
                    document.getElementById("codeVal").innerHTML = "Plese Enter Value";
                    return false;
                }
            }
            
            function Personal() {
                document.getElementById("emailVal").innerHTML = "";
                document.getElementById("teleVal").innerHTML = "";
                document.getElementById("nameVal").innerHTML = "";
                document.getElementById("countryVal").innerHTML = "";
                document.getElementById("addressVal").innerHTML = "";


                var EmailText = document.getElementById("email").value;
                var reg = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
                var CheckedEmail = reg.test(EmailText);
                if (CheckedEmail != true) {
                    document.getElementById("emailVal").innerHTML = "This is Wrong Email";
                }

                var PhoneText = document.getElementById("phone").value;
                var reg1 = /^\d+$/;
                var Checked1 = reg1.test(PhoneText);
                var Phoneboolean;
                if (PhoneText.length != 0) {
                    if (Checked1 == true) {
                        Phoneboolean = true;
                    } else {
                        document.getElementById("teleVal").innerHTML = "Plese Enter Numbers Only";
                        Phoneboolean = false;
                    }
                    if(PhoneText.length > 12){
                    document.getElementById("teleVal").innerHTML = "Plese Enter Telephone Not More Than 12";
                    Phoneboolean = false;
                    
                    }
                } else {
                    document.getElementById("teleVal").innerHTML = "Plese Enter Telephone";
                    Phoneboolean = false;
                }

                var FullName = document.getElementById("name").value;
                var Nameboolean;
                if (FullName.length != 0) {
                    Nameboolean = true;
                } else {
                    Nameboolean = false;
                    document.getElementById("nameVal").innerHTML = "Please Enter Name";
                }

                var CountryName = document.getElementById("country").value;
                var Countryboolean;
                if (CountryName.length != 0) {
                    Countryboolean = true;
                } else {
                    Countryboolean = false;
                    document.getElementById("countryVal").innerHTML = "Please Enter Your Country";
                }

                var AddressName = document.getElementById("address").value;
                var Addressboolean;
                if (AddressName.length != 0) {
                    Addressboolean = true;
                } else {
                    Addressboolean = false;
                    document.getElementById("addressVal").innerHTML = "Please Enter Your Address";
                }


                if (CheckedEmail == true && Phoneboolean == true && Nameboolean == true && Countryboolean == true && Addressboolean == true) {
                    return true;
                } else {
                    return false;
                }
            }

        </script>
    </body>
</html>

