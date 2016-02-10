<%-- 
    Document   : deleteProduct
    Created on : 13-Dec-2015, 16:04:43
    Author     : BrianMcM
--%>

<%@page import="Business.User"%>
<%@page import="Business.Supplier"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.websocket.Session"%>
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
                            if(user == null || user.getIsIsAdmin() == false)
                            {
                                response.sendRedirect("error.jsp");
                            }
                            if (session.getAttribute("loggedSessionId") != null && session.getAttribute("user") != null) {

                                out.println("<a href='processRequest?action=logout'> Log out</a><a>\tHello " + user.getfName() + "</a>");

                            } else {
                        %>
                        <a id="modal_trigger" href="#myPopupDeleteSupplier" data-rel="popup">Click here to Login or register</a>

                        <!--    popup appears once login is selected     -->
                        <div data-role="popup" id="myPopupDeleteSupplier" class="ui-content" style="min-width:250px;">
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
        <br>
        <div id="main-content">
            <div class="container">
                <table>
                    <tr>
                            <td id = 1>
                                ID
                            </td>
                            <td id = 2>
                                Name
                            </td>
                            <td id = 3>
                                Email
                            </td>
                            <td id = 4>
                                Address
                            </td>
                            <td id = 5>
                                County
                            </td>
                            <td id = 6>
                                Country
                            </td>
                            <td id = 5>
                                Phone
                            </td>
                            <td>
                                
                            </td>
                        </tr>
                        
                    
                    <% Session sesssion;
                        ArrayList<Supplier> suppliers = (ArrayList<Supplier>) session.getAttribute("supplierLst");
                        for (int i = 0; i < suppliers.size(); i++) {
                    %>

                    <form method="post" action="processRequest">
                        <tr id = <%=i%>>
                            <td id = 1>
                                <input type="text" value="<%=suppliers.get(i).getSupplierId()%>" name="supplierId">
                            </td>
                            <td id = 2>
                                <input type="text" value="<%=suppliers.get(i).getSupplierName()%>" name="supplierName">
                            </td>
                            <td id = 3>
                                <input type="text" value="<%=suppliers.get(i).getEmail()%>" name="supplierEmail">
                            </td>
                            <td id = 4>
                                <input type="text" value="<%=suppliers.get(i).getAddress()%>" name="supplierAddress">
                            </td>
                            <td id = 5>
                                <input type="text" value="<%=suppliers.get(i).getCounty()%>" name="supplierCounty">
                            </td>
                            <td id = 6>
                                <input type="text" value="<%=suppliers.get(i).getCountry()%>" name="supplierCountry">
                            </td>
                            <td id = 5>
                                <input type="text" value="<%=suppliers.get(i).getPhone()%>" name="supplierPhone">
                            </td>
                            <td>
                                <input type="hidden" name="supplierID" value="<%=suppliers.get(i).getSupplierId()%>"/>
                                <input type="hidden" name="action" value="DeleteSupplierById" />
                                <input type="submit" value="Delete"/>
                            </td>
                        </tr>


                    </form>
                    <% }%>

                    
                </table>
                    <br>
                    <br>
                    <div>
                        <a href="adminController.jsp">Back to the control panel</a>
                    </div>
            </div>

        </div>
    </body>
</html>
