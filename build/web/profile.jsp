<%-- 
    Document   : profile
    Created on : 10-Feb-2016, 15:26:31
    Author     : d00128036
--%>

<%@page import="Business.Product"%>
<%@page import="Business.User"%>
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
                            if(user == null)
                            {
                                response.sendRedirect("index.jsp");
                            }
                            if (session.getAttribute("loggedSessionId") != null && session.getAttribute("user") != null) {
                        
                                out.println("<a href='processRequest?action=logout'> Log out</a><a>\tHello " + user.getfName() + "</a>");
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
                    

                        <div class ="span4" style="alignment-adjust: central">
                            <%
                                User userObj;
                                userObj = (User) session.getAttribute("user");
                            %>
                            </br>
                            
                            <div>
                                <form action="processRequest" method="post">
                                <%
                                    out.println("User ID: ");
                                %>
                                <input type="text" value="<%=userObj.getUserId()%>" name="userID">
                                <%
                                    out.println("User Name: ");
                                %>
                                <br>
                                <input type="text" value="<%=userObj.getfName()%>" name="fName">
                                <input type="text" value="<%=userObj.getlName()%>" name="lName">
                                <%
                                    out.println("Email: ");
                                %>
                                <input type="text" value="<%=userObj.getEmail()%>" name="email">
                                <%
                                    out.println("Phone: ");
                                %>
                                <input type="text" value="<%=userObj.getPhone()%>" name="phone">
                                <%
                                    out.println("Address: ");
                                %>
                                <input type="text" value="<%=userObj.getAddress()%>" name="address">
                                <%
                                    out.println("County: ");
                                %>
                                <input type="text" value="<%=userObj.getCounty()%>" name="county">

                                <%
                                    out.println("Country: ");
                                %>
                                <input type="text" value="<%=userObj.getCountry()%>" name="country">
                                <%
                                    out.println("Admin: ");
                                %>
                                <input type="text" value="<%=userObj.getIsIsAdmin()%>" name="admin">
                                <input type="hidden" value="<%=userObj.getPassword()%>" name="password">
                                <%
                                    request.setAttribute("UserToUpdated", userObj);
                                %>

                                
                                <input type="hidden" name="action" value="updateuserdetails" />
                                <input type="submit" name="submit" value="Edit"/>
                                </form>
                            </div>
                </div> <!-- @end .container -->
        </div><!-- @end #main-content -->
    </body>
</html>