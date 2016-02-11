<%-- 
    Document   : editOrder
    Created on : 13-Dec-2015, 21:34:47
    Author     : BrianMcM
--%>

<%@page import="Business.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.websocket.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Order</title>
    </head>
    <body>
       
        <table>
             <% Session sesssion;
            ArrayList<Order> orders = (ArrayList<Order>) session.getAttribute("orderLst");
            for(int i = 0; i<orders.size(); i++)
            {
        %>
         <form method="post" action="processRequest">
            <tr id = <%=i%>>
                <td id = 1>
                    <input type="text" value="<%=orders.get(i).getUserId()%>" name="userId">
                </td>
                <td id = 2>
                    <input type="text" value="<%=orders.get(i).getOrderId()%>" name="productId">
                </td>
                <td id = 3>
                    <input type="text" value="<%=orders.get(i).getDateOrdered()%>" name="dateOrdered">
                </td>
            </tr>
            <input type="hidden" value ="UpdateOrder" name ="action">
            <input type="submit" data-inline="true" value="updateOrder" name="updateOrder">
           </form>
            <% }%>
                
            
        </table>
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

