<%-- 
    Document   : index
    Created on : Dec 8, 2015, 2:58:05 PM
    Author     : sergio
testing
--%>

<%@page import="Business.User"%>
<%@page import="Service.UserService"%>
<!doctype html>
<html lang="en-US">
    <head><!--Links calling on the different bootstrap packages and css file ***hello sergio**** -->
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
        <div id="fb-root"></div>
        <script>(function(d, s, id) {
          var js, fjs = d.getElementsByTagName(s)[0];
          if (d.getElementById(id)) return;
          js = d.createElement(s); js.id = id;
          js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.5";
          fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));
        </script>
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
                        %>
                        
                           
                            <%
                                out.println("<a href='processRequest?action=logout'> Log out</a><a href='profile.jsp'>\tHello " + user.getfName() + "</a>");

                            %>
                       
                        <%                        } else {
                        %>
                        <a id="modal_trigger" href="#myPopupIndex" data-rel="popup">Click here to Login or register</a>

                        <!--    popup appears once login is selected     -->
                        <div data-role="popup" id="myPopupIndex" class="ui-content" style="min-width:250px;">
                            <form method="post" action="processRequest">
                                <h3>Login information</h3>
                                <br>
                                <br>
                                <div>
                                    <input type="email" name="username" placeholder="Username/Email">

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

        <header id="heading">
            <div class="container text-center">
                <br>
                <h1>PHONES R US</h1>

                <p><a href="processRequest?action=getAllProducts" class="btn btn-large"><strong>SHOP NOW</strong></a></p>
            </div>
        </header>
        <div id="main-content">
            <div class="container">
                <div class="row">
                    <div class="span4">
                        <h2>The Team</h2>
                        <p>Say Hi to Niall, Sergio or Brian and ask questions about our products simply by emailing us.</p>
                        <p class="text-center"><a class="btn" href="contacts.jsp">Read more</a></p>
                    </div>

                    <div class="span4">
                        <h2>Our Products</h2>
                        <p>We supply a wide range of phones ranging from iPhones to Android.
                            We pride ourselves on high quality merchandise and support.</p>
                        <p class="text-center">
                            <a class="btn" href="phoneStore.jsp">
                                Contact us</a></p>
                    </div>
                    <div class="span4">
                        <h2>Networks</h2>
                        <p>We currently are in dealership with Three mobile who supply many brilliant plans for mobiles of all makes as well as supplying modems</p>
                        <p class="text-center"><a class="btn" href="http://www.three.ie/"><strong>TAKE ME THERE</strong></a></p>
                    </div>
                </div><!-- @end .row -->
                <form action="processRequest" method="post">
                    <div class="row-fluid">
                        <ul class="thumbnails">
                            <li class="span4">
                                <a href="" class="thumbnail" target="Apple" name="Apple">
                                    <img src="images/phones/appleBrand.jpg" alt="Apple Phones">
                                </a>
                            </li>
                            <li class="span4">
                                <a href="" class="thumbnail" target="HTC" name="htc">
                                    <img src="images/phones/htcBrand.jpg" alt="HTC Phones">
                                </a>
                            </li>
                            <li class="span4">
                                <a href="" class="thumbnail" target="Nokia" name="nokia">
                                    <img src="images/phones/nokiaBrand.jpg" alt="Nokia Phones">
                                </a>
                            </li>
                        </ul>
                    </div><!-- @end .row-fluid -->

                    <div class="row-fluid">
                        <ul class="thumbnails">

                            <li class="span4">
                                <a href="" class="thumbnail" target="Samsung" name = "samsung">
                                    <img src="images/phones/samsungBrand.png" alt="Samsung Phones">
                                </a>
                            </li>
                            <li class="span4">
                                <a href="" class="thumbnail" target="Sony" name="sony">
                                    <img src="images/phones/sonyBrand.jpg" alt="Sony Phones">
                                </a>
                            </li>
                            <li class="span4">
                                <a href="" class="thumbnail" target="Lucky" name="other">
                                    <img src="images/phones/lucky.jpg" alt="Other brands">
                                </a>
                            </li>
                        </ul>
                    </div><!-- @end .row-fluid -->
                </form>
            </div><!-- @end .container -->
        </div><!-- @end #main-content -->
        <div id="footer">
            <div class="container">
                <p>Please feel free to <a href="contacts.jsp">Email</a> us</p>
                <p><a href="http://latch.elevenpaths.com" target="_blank"><img src="img/latch_logo.png" width="150" alt="http://latch.elevenpaths.com" ></a></p>
                <p>
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
                    <div class="fb-like" data-href="https://www.facebook.com/Phones-R-US-118666461853804/?skip_nax_wizard=true" data-layout="standard" data-action="like" data-show-faces="true" data-share="true"></div>
                </p>
            </div>
        </div>
    </body>
</html>
