<%-- 
    Document   : order
    Created on : Dec 12, 2015, 10:43:56 AM
    Author     : Megatronus
--%>

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
                            if (session.getAttribute("loggedSessionId") != null && session.getAttribute("user") != null) {
                        %>
                        
                           
                            <%
                                out.println("<a href='processRequest?action=logout'> Log out</a><a>\tHello " + user.getfName() + "</a>");

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
        <br>
        <br>
        <br>
        <div id="main-content">
            <div class="container">
                <div class="row">
                    <br/><br/>
                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><b><span
                                style='font-size:9.0pt'>Introduction<o:p></o:p></span></b></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>These
                            terms and conditions govern your use of this website; by using this website,
                            you accept these terms and conditions in full.<span
                                style='mso-spacerun:yes'>&nbsp;&nbsp; </span>If you disagree with these terms
                            and conditions or any part of these terms and conditions, you must not use this
                            website. <o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>This
                            website uses cookies.<span style='mso-spacerun:yes'>&nbsp; </span>By using this
                            website and agreeing to these terms and conditions, you consent to our <span
                                class=SpellE>PhoneRUs's</span> use of cookies in accordance with the terms of <span
                                class=SpellE><span class=GramE>PhoneRUs's</span></span><span class=GramE> .</span><o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><b><span
                                style='font-size:9.0pt'>License to use website<o:p></o:p></span></b></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>Unless
                            otherwise stated, <span class=SpellE>PhoneRUs</span> and/or its licensors own
                            the intellectual property rights in the website and material on the
                            website.<span style='mso-spacerun:yes'>&nbsp; </span>Subject to the license
                            below, all these intellectual property rights are reserved.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>You
                            may view, download for caching purposes only, and print pages from the website
                            for your own personal use, subject to the restrictions set out below and
                            elsewhere in these terms and conditions.<span style='mso-spacerun:yes'>&nbsp;
                            </span><o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>You
                            must not:<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='margin-left:36.0pt;text-align:justify;text-indent:
                       -18.0pt;mso-list:l2 level1 lfo3;tab-stops:list 36.0pt'><![if !supportLists]><span
                            style='font-size:9.0pt;font-family:Symbol;mso-fareast-font-family:Symbol;
                            mso-bidi-font-family:Symbol'><span style='mso-list:Ignore'>-<span
                                    style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span></span><![endif]><span
                            style='font-size:9.0pt'>republish material from this website (including
                            republication on another website);<o:p></o:p></span></p>

                    <p class=MsoNormal style='margin-left:36.0pt;text-align:justify;text-indent:
                       -18.0pt;mso-list:l2 level1 lfo3;tab-stops:list 36.0pt'><![if !supportLists]><span
                            style='font-size:9.0pt;font-family:Symbol;mso-fareast-font-family:Symbol;
                            mso-bidi-font-family:Symbol'><span style='mso-list:Ignore'>-<span
                                    style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span></span><![endif]><span
                            style='font-size:9.0pt'>sell, rent or sub-license material from the website;<o:p></o:p></span></p>

                    <p class=MsoNormal style='margin-left:36.0pt;text-align:justify;text-indent:
                       -18.0pt;mso-list:l2 level1 lfo3;tab-stops:list 36.0pt'><![if !supportLists]><span
                            style='font-size:9.0pt;font-family:Symbol;mso-fareast-font-family:Symbol;
                            mso-bidi-font-family:Symbol'><span style='mso-list:Ignore'>-<span
                                    style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span></span><![endif]><span
                            style='font-size:9.0pt'>show any material from the website in public;<o:p></o:p></span></p>

                    <p class=MsoNormal style='margin-left:36.0pt;text-align:justify;text-indent:
                       -18.0pt;mso-list:l2 level1 lfo3;tab-stops:list 36.0pt'><![if !supportLists]><span
                            style='font-size:9.0pt;font-family:Symbol;mso-fareast-font-family:Symbol;
                            mso-bidi-font-family:Symbol'><span style='mso-list:Ignore'>-<span
                                    style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span></span><![endif]><span
                            style='font-size:9.0pt'>reproduce, duplicate, copy or otherwise exploit
                            material on this website for a commercial purpose;<o:p></o:p></span></p>

                    <p class=MsoNormal style='margin-left:36.0pt;text-align:justify;text-indent:
                       -18.0pt;mso-list:l2 level1 lfo3;tab-stops:list 36.0pt'><![if !supportLists]><span
                            style='font-size:9.0pt;font-family:Symbol;mso-fareast-font-family:Symbol;
                            mso-bidi-font-family:Symbol'><span style='mso-list:Ignore'>-<span
                                    style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span></span><![endif]><span
                            style='font-size:9.0pt'>edit or otherwise modify any material on the website; <o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><b><span
                                style='font-size:9.0pt'>Acceptable use<o:p></o:p></span></b></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>You
                            must not use this website in any way that causes, or may cause, damage to the
                            website or impairment of the availability or accessibility of the website; or
                            in any way which is unlawful, illegal, fraudulent or harmful, or in connection
                            with any unlawful, illegal, fraudulent or harmful purpose or activity.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>You
                            must not use this website to copy, store, host, transmit, send, use, publish or
                            distribute any material which consists of (or is linked to) any spyware,
                            computer virus, Trojan horse, worm, keystroke logger, rootkit or other
                            malicious computer software.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>You
                            must not conduct any systematic or automated data collection activities
                            (including without limitation scraping, data mining, data extraction and data
                            harvesting) on or in relation to this website without <span class=SpellE>PhoneRUs</span>
                            express written consent.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>You
                            must not use this website to transmit or send unsolicited commercial
                            communications.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>You
                            must not use this website for any purposes related to marketing without <span
                                class=SpellE>PhoneRUs</span> express written consent.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><b><span style='font-size:9.0pt'>Restricted
                                access<o:p></o:p></span></b></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>Access
                            to certain areas of this website is restricted.<span
                                style='mso-spacerun:yes'>&nbsp; </span><span class=SpellE>PhoneRUs</span>
                            reserves the right to restrict access to other areas of this website, or indeed
                            this entire website, at <span class=SpellE>PhoneRUs</span> discretion.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>If <span
                                class=SpellE>PhoneRUs</span> provides you with a user ID and password to enable
                            you to access restricted areas of this website or other content or services,
                            you must ensure that the user ID and password are kept confidential.<span
                                style='mso-spacerun:yes'>&nbsp; </span><o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span class=SpellE><span
                                style='font-size:9.0pt'>PhoneRUs</span></span><span style='font-size:9.0pt'>
                            may disable your user ID and password in <span class=SpellE>PhoneRUs</span>
                            sole discretion without notice or explanation.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><b><span
                                style='font-size:9.0pt'>Limitations of liability<o:p></o:p></span></b></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span class=SpellE><span
                                style='font-size:9.0pt'>PhoneRUs</span></span><span style='font-size:9.0pt'>
                            will not be liable to you (whether under the law of contact, the law of torts
                            or otherwise) in relation to the contents of, or use of, or otherwise in
                            connection with, this website:<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='margin-left:36.0pt;text-align:justify;text-indent:
                       -18.0pt;mso-list:l1 level1 lfo2;tab-stops:list 36.0pt left 576.0pt'><![if !supportLists]><span
                            style='font-size:9.0pt;font-family:Wingdings;mso-fareast-font-family:Wingdings;
                            mso-bidi-font-family:Wingdings'><span style='mso-list:Ignore'>l<span
                                    style='font:7.0pt "Times New Roman"'>&nbsp; </span></span></span><![endif]><span
                            style='font-size:9.0pt'>to the extent that the website is provided free-of-charge,
                            for any direct loss;<o:p></o:p></span></p>

                    <p class=MsoNormal style='margin-left:36.0pt;text-align:justify;text-indent:
                       -18.0pt;mso-list:l1 level1 lfo2;tab-stops:list 36.0pt left 576.0pt'><![if !supportLists]><span
                            style='font-size:9.0pt;font-family:Wingdings;mso-fareast-font-family:Wingdings;
                            mso-bidi-font-family:Wingdings'><span style='mso-list:Ignore'>l<span
                                    style='font:7.0pt "Times New Roman"'>&nbsp; </span></span></span><![endif]><span
                            style='font-size:9.0pt'>for any indirect, special or consequential loss; or<o:p></o:p></span></p>

                    <p class=MsoNormal style='margin-left:36.0pt;text-align:justify;text-indent:
                       -18.0pt;mso-list:l1 level1 lfo2;tab-stops:list 36.0pt left 576.0pt'><![if !supportLists]><span
                            style='font-size:9.0pt;font-family:Wingdings;mso-fareast-font-family:Wingdings;
                            mso-bidi-font-family:Wingdings'><span style='mso-list:Ignore'>l<span
                                    style='font:7.0pt "Times New Roman"'>&nbsp; </span></span></span><![endif]><span
                            style='font-size:9.0pt'>for any business losses, loss of revenue, income,
                            profits or anticipated savings, loss of contracts or business relationships,
                            loss of reputation or goodwill, or loss or corruption of information or data.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><span
                            style='font-size:9.0pt'>These limitations of liability apply even if <span
                                class=SpellE>PhoneRUs</span> has been expressly advised of the potential loss.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><b><span
                                style='font-size:9.0pt'>Exceptions<o:p></o:p></span></b></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>Nothing
                            in this website disclaimer will exclude or limit any warranty implied by law
                            that it would be unlawful to exclude or limit; and nothing in this website
                            disclaimer will exclude or limit <span class=SpellE>PhoneRUs</span> liability
                            in respect of any:<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='margin-left:36.0pt;text-align:justify;text-indent:
                       -18.0pt;mso-list:l0 level1 lfo1;tab-stops:list 36.0pt left 576.0pt'><![if !supportLists]><span
                            style='font-size:9.0pt;font-family:Wingdings;mso-fareast-font-family:Wingdings;
                            mso-bidi-font-family:Wingdings'><span style='mso-list:Ignore'>l<span
                                    style='font:7.0pt "Times New Roman"'>&nbsp; </span></span></span><![endif]><span
                            style='font-size:9.0pt'>fraud or fraudulent misrepresentation on the part of <span
                                class=SpellE>PhoneRUs</span>; or<o:p></o:p></span></p>

                    <p class=MsoNormal style='margin-left:36.0pt;text-align:justify;text-indent:
                       -18.0pt;mso-list:l0 level1 lfo1;tab-stops:list 36.0pt left 576.0pt'><![if !supportLists]><span
                            style='font-size:9.0pt;font-family:Wingdings;mso-fareast-font-family:Wingdings;
                            mso-bidi-font-family:Wingdings'><span style='mso-list:Ignore'>l<span
                                    style='font:7.0pt "Times New Roman"'>&nbsp; </span></span></span><![endif]><span
                            style='font-size:9.0pt'>matter which it would be illegal or unlawful for <span
                                class=SpellE>PhoneRUs</span> to exclude or limit, or to attempt or purport to
                            exclude or limit, its liability. <o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><b><span
                                style='font-size:9.0pt'>Reasonableness<o:p></o:p></span></b></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><span
                            style='font-size:9.0pt'>By using this website, you agree that the exclusions
                            and limitations of liability set out in this website disclaimer are
                            reasonable.<span style='mso-spacerun:yes'>&nbsp; </span><o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><span
                            style='font-size:9.0pt'>If you do not think they are reasonable, you must not
                            use this website.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><b><span
                                style='font-size:9.0pt'>Other parties<o:p></o:p></span></b></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span lang=EN-GB
                                                                        style='font-size:9.0pt;mso-fareast-font-family:SimSun;mso-ansi-language:EN-GB;
                                                                        mso-fareast-language:AR-SA'>You accept that, as a limited liability entity, <span
                                class=SpellE>PhoneRUs</span> has an interest in limiting the personal liability
                            of its officers and employees.<span style='mso-spacerun:yes'>&nbsp; </span>You
                            agree that you will not bring any claim personally against <span class=SpellE>PhoneRUs</span>
                            officers or employees in respect of any losses you suffer in connection with
                            the website.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>Without
                            prejudice to the foregoing paragraph, you agree that the limitations of
                            warranties and liability set out in this website disclaimer will protect <span
                                class=SpellE>PhoneRUs</span> officers, employees, agents, subsidiaries,
                            successors, assigns and sub-contractors as well as <span class=SpellE>PhoneRUs</span>.
                            <o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><b><span
                                style='font-size:9.0pt'>Unenforceable provisions<o:p></o:p></span></b></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>If
                            any provision of this website disclaimer is, or is found to be, unenforceable
                            under applicable law, that will not affect the enforceability of the other
                            provisions of this website disclaimer.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><b><span
                                style='font-size:9.0pt'>Indemnity<o:p></o:p></span></b></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>You
                            hereby indemnify <span class=SpellE>PhoneRUs</span> and undertake to keep <span
                                class=SpellE>PhoneRUs</span> indemnified against any losses, damages, costs,
                            liabilities and expenses (including without limitation legal expenses and any
                            amounts paid by <span class=SpellE>PhoneRUs</span> to a third party in
                            settlement of a claim or dispute on the advice of <span class=SpellE>PhoneRUs</span>
                            legal advisers) incurred or suffered by <span class=SpellE>PhoneRUs</span>
                            arising out of any breach by you of any provision of these terms and conditions,
                            or arising out of any claim that you have breached any provision of these terms
                            and conditions.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><b><span
                                style='font-size:9.0pt'>Breaches of these terms and conditions<o:p></o:p></span></b></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>Without
                            prejudice to <span class=SpellE>PhoneRUs</span> other rights under these terms
                            and conditions, if you breach these terms and conditions in any way, <span
                                class=SpellE>PhoneRUs</span> may take such action as <span class=SpellE>PhoneRUs</span>
                            deems appropriate to deal with the breach, including suspending your access to
                            the website, prohibiting you from accessing the website, blocking computers
                            using your IP address from accessing the website, contacting your internet
                            service provider to request that they block your access to the website and/or
                            bringing court proceedings against you.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><b><span
                                style='font-size:9.0pt'>Variation<o:p></o:p></span></b></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span class=SpellE><span
                                style='font-size:9.0pt'>PhoneRUs</span></span><span style='font-size:9.0pt'>
                            may revise these terms and conditions from time-to-time.<span
                                style='mso-spacerun:yes'>&nbsp; </span>Revised terms and conditions will apply
                            to the use of this website from the date of the publication of the revised
                            terms and conditions on this website.<span style='mso-spacerun:yes'>&nbsp;
                            </span>Please check this page regularly to ensure you are familiar with the
                            current version.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><b><span
                                style='font-size:9.0pt'>Assignment<o:p></o:p></span></b></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span class=SpellE><span
                                style='font-size:9.0pt'>PhoneRUs</span></span><span style='font-size:9.0pt'>
                            may transfer, sub-contract or otherwise deal with <span class=SpellE>PhoneRUs</span>
                            rights and/or obligations under these terms and conditions without notifying
                            you or obtaining your consent.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><span
                            style='font-size:9.0pt'>You may not transfer, sub-contract or otherwise deal
                            with your rights and/or obligations under these terms and conditions.<span
                                style='mso-spacerun:yes'>&nbsp; </span><o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><b><span
                                style='font-size:9.0pt'>Severability<o:p></o:p></span></b></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>If
                            a provision of these terms and conditions is determined by any court or other
                            competent authority to be unlawful and/or unenforceable, the other provisions
                            will continue in effect.<span style='mso-spacerun:yes'>&nbsp; </span>If any
                            unlawful and/or unenforceable provision would be lawful or enforceable if part
                            of it were deleted, that part will be deemed to be deleted, and the rest of the
                            provision will continue in effect. <o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><b><span
                                style='font-size:9.0pt'>Entire agreement<o:p></o:p></span></b></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>These
                            terms and conditions constitute the entire agreement between you and <span
                                class=SpellE>PhoneRUs</span> in relation to your use of this website, and
                            supersede all previous agreements in respect of your use of this website.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><b><span
                                style='font-size:9.0pt'>Law and jurisdiction<o:p></o:p></span></b></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>These
                            terms and conditions will be governed by and construed in accordance with Irish
                            law, and any disputes relating to these terms and conditions will be subject to
                            the exclusive jurisdiction of the courts of Irish law.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><b><span style='font-size:9.0pt'>Registrations
                                and <span class=SpellE>authorisations</span><o:p></o:p></span></b></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span class=SpellE><span
                                style='font-size:9.0pt'>PhoneRUs</span></span><span style='font-size:9.0pt'> is
                            registered with Ireland registration office.<span
                                style='mso-spacerun:yes'>&nbsp; </span>You can find the online version of the
                            register at <a href="http://www.registration.ie">www.registration.ie</a> <span
                                style='mso-spacerun:yes'>&nbsp;&nbsp;</span><span class=SpellE>PhoneRUs</span>
                            registration number is 1234567.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span class=SpellE><span
                                style='font-size:9.0pt'>PhoneRUs</span></span><span style='font-size:9.0pt'> registration
                            number is 1234567.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span class=SpellE><b><span
                                    style='font-size:9.0pt'>PhoneRUs</span></b></span><b><span style='font-size:
                                                                                   9.0pt'> details<o:p></o:p></span></b></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><span
                            style='font-size:9.0pt'>The full name of <span class=SpellE>PhoneRUs</span> is <span
                                class=SpellE>PhoneRUs</span>.<span style='mso-spacerun:yes'>&nbsp; </span><o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'>[<span
                                class=SpellE>PhoneRUs</span> is registered in Ireland under registration number
                            1234567.<span style='mso-spacerun:yes'>&nbsp; </span><o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                    <p class=MsoNormal style='text-align:justify;mso-outline-level:1'><span
                            style='font-size:9.0pt'>You can contact <span class=SpellE>PhoneRUs</span> by
                            email to <span class=SpellE>admin@phonesrus</span>.<o:p></o:p></span></p>

                    <p class=MsoNormal style='text-align:justify'><span style='font-size:9.0pt'><o:p>&nbsp;</o:p></span></p>

                </div>
            </div><!-- @end .container -->
        </div><!-- @end #main-content -->
    </body>
</html>

