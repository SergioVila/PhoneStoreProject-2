<%-- 
    Document   : phoneItem
    Created on : Dec 10, 2015, 12:40:50 PM
    Author     : Megatronus
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
                            
                            if (session.getAttribute("loggedSessionId") != null && session.getAttribute("user") != null) {

                                out.println("<a href='processRequest?action=logout'> Log out</a><a>\tHello " + user.getfName() + "</a>");

                            } else {
                        %>
                        <a id="modal_trigger" href="#myPopupIndex" data-rel="popup">Click here to Login or register</a>

                        <!--    popup appears once login is selected     -->
                        <div data-role="popup" id="myPopupIndex" class="ui-content" style="min-width:250px;">
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


                     <%
                            user = (User) session.getAttribute("user");
                            Product phoneObj;
                            phoneObj = (Product) request.getAttribute("searchByName");
                        %>
                    <div class ="span4" style="alignment-adjust: central">
                        <div>
                            <img src="images/phoneStore/<%= phoneObj.getProductName()%>.jpg">
                        </div>
                       
                        <%
                            if (user != null && user.getIsIsAdmin() == true) {
                        %>
                        <div>
                            <form action="processRequest" method="post">
                                <%
                                    out.println("Product ID: ");
                                %>
                                <input type="text" value="<%=phoneObj.getProductID()%>" name="id"> 
                                <%
                                    out.println("Product Name: ");
                                %>
                                <input type="text" value="<%=phoneObj.getProductName()%>" name="name">
                                <%
                                    out.println("Price: ");
                                %>
                                <input type="text" value="<%=phoneObj.getPrice()%>" name="price">
                                <%
                                    out.println("Description: ");
                                %>
                                <input type="text" style="height: 500px; width: 370px" value="<%=phoneObj.getDesc()%>" name="desc">

                                <%
                                    out.println("Stock left: ");
                                %>
                                <input type="text" value="<%=phoneObj.getStock()%>" name="stock">
                                <%
                                    session.setAttribute("ProductToUpdated", phoneObj);
                                %>
                                <input type="hidden" name="action" value="updateproduct"/>
                                <input type="submit" value="Save changes"/>
                            </form>
                                
                           
                            <form action="processRequest" method="post">
                                
                                <input type="hidden" value="<%=phoneObj.getProductID()%>" name="id"> 
                                
                                <input type="hidden" value="<%=phoneObj.getProductName()%>" name="name">
                                
                                <input type="hidden" value="<%=phoneObj.getPrice()%>" name="price">
                                
                                <input type="hidden" style="height: 500px; width: 370px" value="<%=phoneObj.getDesc()%>" name="desc">

                                <input type="hidden" value="<%=phoneObj.getStock()%>" name="stock">
                                
                                <input type="hidden" name="action" value="registerNewOrderProduct"/>
                                <input type="submit" data-inline="true" value="Add to the cart" name="registerNewOrderProduct" onclick = "window.alert('Product added to the cart.')">
                            </form>

                            <%
                            } else {
                            %>
                            <div>
                                <%
                                    out.println("Product Name: " + phoneObj.getProductName());
                                %>
                                <br>
                                <%
                                    out.println("Price: " + phoneObj.getPrice());
                                %>
                                <br>
                                <label for="desc">Description</label>
                                <textarea name="desc" row="5" cols="50">
                                <%
                                    out.println(phoneObj.getDesc());
                                %>
                                </textarea>
                                <br>
                                <%
                                    out.println("Stock left: " + phoneObj.getStock());
                                %>
                            </div>
                            <input type="submit" data-inline="true" value="Add to the cart" name="registerNewOrderProduct" onclick = "window.alert('Product added to the cart.')">

                            <%
                                }
                            %>
                        </div>
                    </div>
                </div><!-- @end .container -->
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
