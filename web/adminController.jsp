
<%@page import="Business.User"%>
<%-- 
    Document   : register
    Created on : Dec 8, 2015, 3:09:17 PM
    Author     : Megatronus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><!--Links calling on the different bootstrap packages and css file -->
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
        <title>PHONES R US | Admin controller</title>

        <!-- favicons are otherwise known as shortcut icons -->
        <link rel="shortcut icon" href="http://teamtreehouse.com/assets/favicon.ico">
        <link rel="icon" href="http://teamtreehouse.com/assets/favicon.ico">

        <!-- These three lines call on the three css files stored in the css folder of the project -->
        <link rel="stylesheet" type="text/css" media="all" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" media="all" href="css/bootstrap-responsive.min.css">
        <link rel="stylesheet" type="text/css" media="all" href="css/global.css">

        <!-- This imports the jquery file that eases our use of javascript, the min jquery file is used as it removes all unnecessary characters-->
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
        <script type="text/javascript" language="javascript" charset="utf-8" src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav id="navigation">
            <div class="container">
                <ul class="navlinks">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="processRequest?action=getAllProducts">Phone Store</a></li>
                    <li><a href="about.jsp">About us</a></li>
                    <li><a href="contacts.jsp">Contacts</a></li>
                    <li style="float: right;list-style-type: none">
                        <%
                            User user = (User) session.getAttribute("user");
                            
                            if(user == null || user.getIsIsAdmin() == false)
                            {
                                response.sendRedirect("error.jsp");
                            }
                            
                            
                            if (session.getAttribute("loggedSessionId") != null && session.getAttribute("user") != null) {
                       
                                out.println("<a href='processRequest?action=logout'> Log out</a><a>\tHello " + user.getfName() + "</a>");
                            } else {
                        %>
                        <a id="modal_trigger" href="#myPopupAdminCon" data-rel="popup">Click here to Login or register</a>

                        <!--    popup appears once login is selected     -->
                        <div data-role="popup" id="myPopupAdminCon" class="ui-content" style="min-width:250px;">
                            <form method="post" action="processRequest">
                                <h3>Login information</h3>
                                <br>
                                <br>
                                <div>
                                    <input type="text" name="username" placeholder="Username/Email">

                                    <input type="password" name="password" placeholder="Password">

                                    <input type="hidden" value ="Login" name ="action">
                                    <input type="submit" data-inline="true" value="Login" name="login">

                                </div>
                            </form>
                            <div>
                                <a href = "register.jsp"><input type="submit" data-inline="true" value="Register"></a>
                            </div>
                        </div>
                        <%
                            }
                        %>
                    </li>

                    <%
                        if (user != null && user.getIsIsAdmin() == true) {
                    %>
                    
                    <li><a href="processRequest?action=getAllOrders">Orders</a></li>
                    <li><a href="adminController.jsp">Admin Panel</a></li>
                    <li><a href="cart.jsp">Cart</a></li>
                        <%
                            }
                        else if(user != null && user.getIsIsAdmin() != true)
                            {             
                        %>
                    <li><a href="processRequest?action=getAllOrders">Orders</a></li>
                    <li><a href="cart.jsp">Cart</a></li>
                        <%    }
                        %>
                    <li><a href="legal.jsp">Legal</a></li>
                </ul>
            </div>
        </nav>
        <br>
        <br>
        <br>
        <br>
        <div id="main-content">
            <div class="container">
                <div class="row">
                    <div class ="span4">
                        
                        <a href="registerAdmin.jsp" class="thumbnail" target="_self"><img src="./img/addUser.png" width="30%">Add new user</a>
                    </div>
                    <div class ="span4">
                        <a href="processRequest?action=getAllUsers" class="thumbnail" target="_self"><img src="./img/listUsers.png" width="30%">User list</a>
                    </div>
                    <div class ="span4">
                        <a href="processRequest?action=GetAllUsersToDelete" class="thumbnail" target="_self"><img src="./img/deleteUser.png" width="30%">Delete user</a>
                    </div>

                </div>
                <br>
                 <div class="row">
                    <div class ="span4">
                        
                        <a href="addSupplier.jsp" class="thumbnail" target="_self"><img src="./img/addSupplier.png" width="30%">Add new supplier</a>
                    </div>
                    <div class ="span4">
                        
                        <a href="processRequest?action=getAllSuppliers" class="thumbnail" target="_self"><img src="./img/listSupplier.png" width="30%">Supplier list</a>
                    </div>
                    <div class ="span4">
                        <a href="processRequest?action=getallsuppliersfordelete" class="thumbnail" target="_self"><img src="./img/deleteSupplier.png" width="30%">Delete supplier</a>
                    </div>

                </div>
                <br>
                 <div class="row">
                    <div class ="span4">
                        
                        <a href="addProduct.jsp" class="thumbnail" target="_self"><img src="./img/addProduct.png" width="30%">Add new product</a>
                    </div>
                    <div class ="span4">
                        <a href="processRequest?action=getallproducts" class="thumbnail" target="_self"><img src="./img/listProduct.png" width="30%">Product List</a>
                    </div>
                    <div class ="span4">
                        <a href="processRequest?action=GetAllProductsToDelete" class="thumbnail" target="_self"><img src="./img/deleteProduct.png" width="30%">Delete product</a>
                    </div>
                
                </div>
                <br>
                 <div class="row">
                    <div class ="span4">
                        
                        <a href="addOrder.jsp" class="thumbnail" target="_self"><img src="./img/addOrder.png" width="30%">Add new order</a>
                    </div>
                    <div class ="span4">
                        <a href="processRequest?action=getAllOrders" class="thumbnail" target="_self"><img src="./img/listOrder.png" width="30%">Order List</a>
                    </div>
                    <div class ="span4">
                        <a href="processRequest?action=getallordersfordelete" class="thumbnail" target="_self"><img src="./img/deleteOrder.png" width="30%">Delete orders</a>
                    </div>
            </div>
        </div>
    </body>
</html>

