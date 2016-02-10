<%-- 
    Document   : cart.jsp
    Created on : 14-Dec-2015, 13:01:06
    Author     : BrianMcM
--%>

<%@page import="Daos.ProductDao"%>
<%@page import="Business.Product"%>
<%@page import="Daos.UserDao"%>
<%@page import="Business.OrderProduct"%>
<%@page import="Business.User"%>
<%@page import="java.util.Date"%>
<%@page import="Business.Order"%>
<%@page import="java.util.ArrayList"%>
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
                </ul>
            </div>
        </nav>
        <br>
        <br>
        <br>
        <div id="main-content">
            <div class="container">
                <div class="row">
                <form method="post" action="processRequest">
                    <%
                        
                        ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("productOnOrderLst");
                        
                       
                        if (productList != null)
                        {
                            for (int i = 0; i < productList.size(); i++) {

                                Product p = productList.get(i);
                                
                                %>

                    <div class ="span4">
                        <div>
                            <br>
                            <%
                                int prodID = p.getProductID();
                                out.println("Product ID: " + prodID);
                            %>
                            <br>
                            <%
                                String productName = p.getProductName();
                                out.println("Product Name: " + productName);
                            %>
                            <br>
                            <%
                                Double price = p.getPrice();
                                out.println("Product price: " + price);
                            %>
                            
                        </div>
                    </div>
                    <%
                            }
                        }

                    %>
                    <input type="hidden" name="">
                    <input
                    </form>
                </div>
            </div><!-- @end .container -->
        </div><!-- @end #main-content -->
    </body>
</html>


