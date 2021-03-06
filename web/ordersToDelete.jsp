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
        <div id="main-content">
            <div class="container">
                <div class="row">
                    <br>
                    <br>
                    <table width="100%">
                        <tr>
                            <td id = 1>
                                <b>Order ID</b>
                            </td>
                            <td id = 2>
                                <b>Customer name</b>
                            </td>
                            <td id = 3>
                                <b>Product</b>
                            </td>
                            <td id = 4>
                                <b>Order Date</b>
                            </td>
                            <td id = 5>
                                <b>Items</b>
                            </td>
                            <td>
                                
                            </td>

                        </tr>
                        <tr>
                            <td id = 1>
                                --------
                            </td>
                            <td id = 2>
                                -------------
                            </td>
                            <td id = 3>
                                -------
                            </td>
                            <td id = 4>
                                ----------
                            </td>
                            <td id = 5>
                                -----
                            </td>
                            <td>
                                ---------------------
                            </td>
                        </tr>  
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
                                                        if (pr.getProductID() == op.getProductId()) {
                        %>
                        <form method="post" action="processRequest">
                            <tr>
                                <td id = 1>
                                    <%=or.getOrderId()%>
                                </td>
                                <td id = 2>
                                    <%=us.getfName() + " " + us.getlName()%>
                                </td>
                                <td id = 3>
                                    <%=pr.getProductName()%>
                                </td>
                                <td id = 4>
                                    <%=or.getDateOrdered()%>
                                </td>
                                <td id = 5>
                                    <%=op.getQty()%>
                                </td>
                                <td id = 6>
                                    <input type="hidden" value ="<%=or.getOrderId()%>" name ="orderId">
                                    <input type="hidden" value ="DeleteOrdertById" name ="action">
                                    <input type="submit" data-inline="true" value="Delete Order" name="Delete Order">
                                </td>

                            </tr>
                        
                        </form>
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
                    </table>
                </div><!-- row -->
            </div><!-- @end.container -->
        </div><!-- @end #main-content -->
        <div id="footer">
            <div class="container">
                <ul id="footerList">
                    <li id="footerItem"><p>Please feel free to <a href="contacts.jsp">Email</a> us</p></li>
                    <li id="footerItem">&nbsp;&nbsp;&nbsp;</li>
                    <li id="footerItem"><p><a href="http://latch.elevenpaths.com" target="_blank"><img src="img/latch_logo.png" width="150" alt="http://latch.elevenpaths.com" ></a></p></li>
                    <li id="footerItem">&nbsp;&nbsp;&nbsp;</li>
                    <li id="footerItem"><p>
                            <small>Follow us on twitter: 
                                <a href="<a href=https://twitter.com/NiallMulready" 
                                   class="twitter-follow-button" 
                                   data-show-count="false" data-size="large" 
                                   data-show-screen-name="false">Follow @NiallMulready</a>
                                <script>!function (d, s, id) {
                                        var js, fjs = d.getElementsByTagName(s)[0],
                                                p = /^http:/.test(d.location) ? 'http' : 'https';
                                        if (!d.getElementById(id))
                                        {
                                            js = d.createElement(s);
                                            js.id = id;
                                            js.src = p + '://platform.twitter.com/widgets.js';
                                            fjs.parentNode.insertBefore(js, fjs);
                                        }
                                    }(document, 'script', 'twitter-wjs');
                                </script>
                            </small>
                        </p></li>
                    <li id="footerItem">&nbsp;&nbsp;&nbsp;</li>
                    <li id="footerItem"><div class="fb-like" data-href="https://www.facebook.com/Phones-R-US-118666461853804/?skip_nax_wizard=true" data-layout="standard" data-action="like" data-show-faces="true" data-share="true"></div></li>
                    <li id="footerItem">&nbsp;&nbsp;&nbsp;</li>
                    <li id="footerItem">Please have a look at our <a href="FAQ.jsp"><b>FAQ</b></a> if you have any questions</li>
                </ul>
            </div>
        </div>
    </body>
</html>
