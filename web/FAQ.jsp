<%-- 
    Document   : FAQ
    Created on : 11-Feb-2016, 17:57:41
    Author     : D00128036
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
                        %>


                        <%
                            out.println("<a href='processRequest?action=logout'> Log out</a><a href='profile.jsp'>\tHello " + user.getfName() + "</a>");

                        %>

                        <%                        } else {
                        %>
                        <a id="modal_trigger" href="#myPopupIndex" data-rel="popup">Click here to Login or register</a>

                        <!--    popup appears once login is selected     -->
                        <div data-role="popup" id="myPopupLegal" class="ui-content" style="min-width:250px;">
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
                        } else if (user != null && user.getIsIsAdmin() != true) {
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
                    <br/><br/>
                    <h1 style="text-align: center"><b>FAQ</b></h1>
                    <H4><b>Got a question about buying online?</b></H4>
                    <H4><b> Check out our Online FAQ below with helpful tips and advice.</b></H4>
                    <br>
                    <p><b>How long does it take to apply for a Bill Pay phone or broadband modem?</b></p>
                    <p2 style="justify-content: center">
                        <ul>
                            <li>If your order is placed before 4pm we aim to respond within the same day. Sometimes we may require further information or documentation from you before our order processing team can make a decision on an application.</li>
                            <li>We’ll keep you updated via e-mail regarding your status and sometimes may need to contact you via phone regarding your order.</li>
                        </ul>
                    </p2>
                    <br>
                    <p><b>What are the possible decision outcomes?</b></p>
                    <p2 style="justify-content: center">
                        <ul>
                            <li>Customers who meet our service criteria will be approved and we will then send out your order.</li>
                            <li>Sometimes, we may require a deposit from the customer before we can approve the application. If this is required, our team will phone you and you can make payment by credit or debit card. This deposit will be applied as a credit to your Three account after your sixth bill, subject to terms and conditions.</li>
                            <li>Unfortunately, from time to time applications may not meet our service criteria and are unsuccessful.</li>
                        </ul>
                    </p2>
                    <br>
                    <p><b>Help! I’ve made an error in my order. Who can I contact?</b></p>
                    <p2 style="justify-content: center">
                        <ul>
                            <li>Don’t worry, mistakes happen! Please contact our Sales team at 1800-949-546 as soon as possible and they’ll be happy to help you regarding your application. Please make sure you have your order reference number handy.</li>
                        </ul>
                    </p2>
                    <br>
                    <H4><b>Delivery.</b></H4>
                    <p><b>Is it Free?</b></p>
                    <p2 style="justify-content: center">
                        <ul>
                            <li>Yes, absolutely! We offer our online customers free delivery in ROI.</li>
                        </ul>
                    </p2>
                    <br>
                    <p><b>What ways can my order be delivered?</b></p>
                    <p2 style="justify-content: center">
                        <ul>
                            <li>Your order can be delivered to your home address (Listed as ‘Current Address’ in your order form).</li>
                            <li>It can also be delivered to your workplace or an alternative address (Simply click ‘no’ when you are asked ‘Is this also your delivery address?’).</li>
                            <li>Certain products can be collected in a PhonesRUS Store of your choice with our ‘Click & Collect’ service. Simply select ‘Store Collection’ when ordering your product and select from the list of participating stores. </li>
                        </ul>
                    </p2>
                    <br>
                    <p><b>How long will I have to wait for delivery?</b></p>
                    <p2 style="justify-content: center">
                        <ul>
                            <li>The delivery period depends on the product ordered. In the event of an unforeseen delay in your delivery you will be notified via e-mail and will be contacted by our support team.</li>
                            <li>Phones and Mobile Broadband Modems: We offer next working day delivery by courier (unless otherwise stated) for all phones and modems which are credit approved before 4pm. Online Orders placed after 4pm will be delivered in two working days. The courier agent will require you to sign for these.</li>
                        </ul>
                    </p2>
                    <br>
                    <p><b>How Can I Check My Delivery Status?</b></p>
                    <p2 style="justify-content: center">
                        <ul>
                            <li>You can check the status of your online delivery anytime! Simply go on Three.ie, click ‘Shop’ and ‘Track My Order’. You’ll need to provide your Order Reference Number and Surname.</li>
                        </ul>
                    </p2>
                    <br>
                    <H4><b>Click & Collect.</b></H4>
                    <p><b>What is Click & Collect?</b></p>
                    <p2 style="justify-content: center">
                        <ul>
                            <li>Click and Collect allows customers to purchase products online at PhonesRUS.com or via our telesales team at 1800-949-546 and collect these products from certain PhonesRUS Stores.</li>
                        </ul>
                    </p2>
                    <br>
                    <p><b>How does Click & Collect work?</b></p>
                    <p2 style="justify-content: center">
                        <ul>
                            <li>Select your product and proceed to checkout, under “Delivery/Store Collection” select “Store Collection” if available. You must then select the store you wish to collect the device from. You will then proceed with the application as normal.</li>
                            <li>When you arrive in-store you must provide your Order Reference Number. In the case of Bill Pay applications you must also provide the exact Proof of Identity and Proof of Address (dated within the last 90 days) which you provided in your application.</li>
                        </ul>
                    </p2>
                    <br>
                    <h4><b>Returns.</b></h4>
                    <p><b>What’s Three’s returns policy for online purchases?</b></p>
                    <p2 style="justify-content: center">
                        <ul>
                            <li>As a consumer, you may cancel the purchase of the device within 14 days (this does not affect your statutory rights under the Sale of Goods Acts) and receive a full refund under the terms of the European Union (Consumer Information, Cancellation and Other Rights) Regulations 2013.</li>
                            <li>You may return your device within 14 days if you have experience a verifiable network fault which has been confirmed by Three Customer Services.</li>
                        </ul>
                    </p2>
                    <br>
                    <p><b>How do you return online purchases?</b></p>
                    <p2 style="justify-content: center">
                        <ul>
                            <li>Firstly, you’ll need to action your 7/14 day return in accordance with the distance selling regulations.</li>
                            <li>We'll provide you with the return address, case reference number and device value (you'll need this for your receipt for payment).</li>
                            <li>Peel off the return label included in your delivery, attach it to your envelope and return by registered post.</li>
                            <li>Responsibility for the return of goods lies with the customer and Three strongly advises using registered post.</li>
                        </ul>
                    </p2>
                    <br>
                    <h4><b>Still Have A Question?</b></h4>
                    <p2 style="justify-content: center">
                        <ul>
                            <li>Why not ask our Sales Web Chat team in the contact us panal for more information.</li>
                        </ul>
                    </p2>
                </div>
            </div><!-- @end .container -->
        </div><!-- @end #main-content -->
    </body>
</html>
