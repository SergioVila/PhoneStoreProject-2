
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
                        <%
                            }
                        else if(user != null && user.getIsIsAdmin() != true)
                            {             
                        %>
                    <li><a href="processRequest?action=getAllOrders">Orders</a></li>
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
                    Hey! what are you trying to do? really? come on, go back to the shop.
                    <br><br>
                    <a href="index.jsp" target="_self"> Go back where I should be...</a>
                </div>
            </div>
        </div>
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

