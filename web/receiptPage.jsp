<%-- 
    Document   : receiptPage
    Created on : Dec 14, 2015, 5:54:07 PM
    Author     : Megatronus
--%>

<%@page import="Business.Product"%>
<%@page import="Business.User"%>
<%@page import="java.util.Date"%>
<%@page import="Business.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><!--Links calling on the different bootstrap packages and css file -->
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
        <title>PHONES R US</title>

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
                    <li><a href="about.jsp">About us</a></li>
                    <li><a href="contacts.jsp">Contacts</a></li>
                    <li style="float: right;list-style-type: none">
                        <%
                            User user = (User) session.getAttribute("user");
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
                        <%
                        }          
                        %>
                    <li><a href="legal.jsp">Legal</a></li>
                </ul>
            </div>
        </nav>
        <br>
        <br>
        <br>
        <div id="main-content">
            <div class="container">
                <div class="row">
                    <%
                        Order order = (Order)session.getAttribute("receipt");
                        ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("productList");
                        double tPrice = 0.0;
                        
                        if (order != null && productList != null)
                        {
                            for (int i = 0; i < productList.size(); i++) {
                                out.print("Order ID: "+order.getOrderId()+" Date ordered: " +order.getDateOrdered());
                                Product p = productList.get(i);
                    %>

                    <div class ="span4">
                        <div>
                            <br>
                            <%
                                int productID = p.getProductID();
                                out.println("Product ID: " + productID);
                            %>
                            <br>
                            <%
                                String name = p.getProductName();
                                out.println("Product Name: " + name);
                            %>
                            <br>
                            <%
                                double price = p.getPrice();
                                out.println("Price: " + price);
                                tPrice+=price;
                            %>
                        </div>
                    </div>
                        <br>
                    <%
                            }
                            out.println("Total Price: "+ tPrice);
                        }
                    %>
                </div>
                <h3>Thank you for ordering from us your order will be dispatched shortly please return to the <a href="index.jsp">HOME PAGE</a></h3>
            </div><!-- @end .container -->
        </div><!-- @end #main-content -->
    </body>
</html>