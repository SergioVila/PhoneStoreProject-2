<%-- 
    Document   : orederList
    Created on : Dec 12, 2015, 10:37:34 AM
    Author     : Megatronus
--%>

<%@page import="Business.OrderProduct"%>
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
                    <li><a href="processRequest?action=getAllProducts">Phone Store</a></li>
                    <li><a href="about.jsp">About us</a></li>
                    <li><a href="contacts.jsp">Contacts</a></li>
                    <li style="float: right;list-style-type: none">
                        <%
                            User user = (User) session.getAttribute("user");
                            if (user == null) {
                                response.sendRedirect("error.jsp");
                            }
                            if (session.getAttribute("loggedSessionId") != null && session.getAttribute("user") != null) {

                                out.println("<a href='processRequest?action=logout'> Log out</a><a>\tHello " + user.getfName() + "</a>");

                            } else {
                        %>
                        <a id="modal_trigger" href="#myPopupOrderList" data-rel="popup">Click here to Login or register</a>

                        <!--    popup appears once login is selected     -->
                        <div data-role="popup" id="myPopupOrderList" class="ui-content" style="min-width:250px;">
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
                    <%
                        ArrayList<Order> orderList = (ArrayList<Order>) request.getAttribute("orderLst");
                        ArrayList<Product> productList = (ArrayList<Product>) request.getAttribute("productList");
                        ArrayList<OrderProduct> opList = (ArrayList<OrderProduct>) request.getAttribute("orderProductList");
                        ArrayList<User> userList = (ArrayList<User>) request.getAttribute("userLst");
                        if (orderList != null && productList != null && opList != null) {
                            for (User us : userList) {
                                for (Order or : orderList) {
                                    if (us.getUserId() == or.getUserId()) {
                                        for (OrderProduct op : opList) {
                                            if (or.getOrderId() == op.getOrderId()) {
                                                for (Product pr : productList) {
                                                    if (pr.getProductID() == op.getProductId()) {%>

                    <div class ="span4">
                        <a href="processRequest?action=displayorderdetails&orUser=<%=us.getUserId()%>&order=<%=or.getOrderId()%>&product=<%=pr.getProductID()%>" class="thumbnail" target="_self">
                            
                            <br>
                            <%
                                
                                int orderID = or.getOrderId();
                                out.println("Order ID: " + orderID);
                            %>
                            <br>
                            <%
                                String name = us.getfName() + " " + us.getlName();
                                out.println("User: " + name);
                            %>
                            <br>
                            <%
                                String productName = pr.getProductName();
                                out.println("Product: " + productName);
                            %>
                            <br>
                            <%
                                String productDesc = pr.getDesc().substring(0, 50);
                                out.println("Description: " + productDesc);
                            %>
                            <br>
                            <%
                                Date dateOrdered = or.getDateOrdered();
                                out.println("Date Ordered: " + dateOrdered);
                            %>
                            <br>
                            <%
                                int qtty = op.getQty();
                                out.println("Quantity: " + dateOrdered);
                            %>
                        </a>
                    </div><!-- div per item -->
                    <%
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    %>
                </div><!-- row -->
            </div><!-- @end.container -->
        </div><!-- @end #main-content -->
    </body>
</html>
