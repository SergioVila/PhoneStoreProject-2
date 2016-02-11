<%-- 
    Document   : contacts
    Created on : Dec 8, 2015, 3:02:18 PM
    Author     : Megatronus
--%>

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
                            if (session.getAttribute("loggedSessionId") != null && session.getAttribute("user") != null) {
                        
                                out.println("<a href='processRequest?action=logout'> Log out</a><a>\tHello " + user.getfName() + "</a>");

                            } else {
                        %>
                        <a id="modal_trigger" href="#myPopupContact" data-rel="popup">Click here to Login or register</a>

                        <!--    popup appears once login is selected     -->
                        <div data-role="popup" id="myPopupContact" class="ui-content" style="min-width:250px;">
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
        <header id="heading">
            <div class="container text-center">
                <br>
                <h1>PHONES R US</h1>

                <p><a href="phoneStore.html" class="btn btn-large"><strong>SHOP NOW</strong></a></p>
            </div>
        </header>
        <div id="main-content">
            <div class="container">
                <div class="row">
                    <p class="text-center">Here you will find three ways of contacting the team.</p>
                    <div class="span4">
                        <h2>Email us</h2>
                        <p>Say Hi to Niall, Sergio or Brian and ask questions about our products simply by emailing us.</p>
                        <p class="text-center"><a class="btn" id="email" href="#emailPopup" data-rel="popup">Email</a></p>
                        <div data-role="popup" id="emailPopup" class="ui-content" style="min-width:250px;">
                            <form method="post" action="demoform.asp" class="text-center">
                                <div>
                                    <h3>Email</h3>
                                    <br>
                                    <br>
                                    <br>
                                    <ul style="float: left">
                                        <li>Sergio: sergio@gmail.com</li>
                                        <li>Niall: niall@gmail.com</li>
                                        <li>Brian: brian@gmail.com</li>
                                    </ul>
                                </div>
                                <br>
                                <br>
                                <br>
                                <div>
                                    <input type="text" name="emailTo" id="emailTo" style="width: 25px" placeholder="To">
                                    <input type="text" name="emailText" id="emailText" style="width: 25px" placeholder="TEXT">
                                    <input type="submit" data-inline="true" value="send">
                                </div>
                            </form>
                        </div>
                    </div>

                    <div class="span4">
                        <h2>Call us</h2>
                        <p>Here you will find the numbers to all three developers.</p>
                        <p class="text-center"><a class="btn" id="phone" href="#numberPopup" data-rel="popup">Call us</a></p>
                        <div data-role="popup" id="numberPopup" class="ui-content" style="min-width:250px;">
                            <form method="post" action="demoform.asp" class="text-center">
                                <div>
                                    <ul>
                                        <li>Sergio: 084-3658597</li>
                                        <li>Niall: 083-3123585</li>
                                        <li>Brian: 086-6759897</li>
                                    </ul>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="span4">
                        <h2>Write to us</h2>
                        <p>Please feel free to write to us either please click the button below to display our full postage address.</p>
                        <p class="text-center"><a class="btn" id="post" href="#postalPopup" data-rel="popup">Postal Address</a></p>
                        <div data-role="popup" id="postalPopup" class="ui-content" style="min-width:250px;">
                            <form method="post" action="demoform.asp" class="text-center">
                                <div>
                                    Unit 4,<br>
                                    Dublin rd.,<br>
                                    Dundalk,<br>
                                    Co. Louth,<br>
                                    Ireland<br>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="span4">
                        <h2>Call us on Skype</h2>
                        <p>Please feel free to call one of our customer service employees to answer any of your questions.</p>
                        <p class="text-center"><a class="btn" id="post" href="skype:Brian mc manus?call" data-rel="popup">Call using Skype</a></p>
                        
                    </div>
                </div><!-- @end .row -->
            </div><!-- @end .container -->
        </div><!-- @end #main-content -->
    </body>
</html>
