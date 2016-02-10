<%-- 
    Document   : deleteProduct
    Created on : 13-Dec-2015, 16:04:43
    Author     : BrianMcM
--%>

<%@page import="Business.User"%>
<%@page import="Business.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.websocket.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Product</title>
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
                        <a id="modal_trigger" href="#myPopupEditProduct" data-rel="popup">Click here to Login or register</a>

                        <!--    popup appears once login is selected     -->
                        <div data-role="popup" id="myPopupEditProduct" class="ui-content" style="min-width:250px;">
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
        <table>
             <% 
            ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("productLst");
            for(int i = 0; i<products.size(); i++)
            {
        %>
         <form method="post" action="processRequest">
            <tr id = <%=i%>>
                <td id = 1>
                    <input type="text" value="<%=products.get(i).getProductID()%>" name="productId">
                </td>
                <td id = 2>
                    <input type="text" value="<%=products.get(i).getProductName()%>" name="productName">
                </td>
                <td id = 3>
                    <input type="text" value="<%=products.get(i).getDesc().substring(0,50)%>" name="productDescription">
                </td>
                <td id = 4>
                    <input type="text" value="<%=products.get(i).getPrice()%>" name="productPrice">
                </td>
                <td id = 5>
                    <input type="text" value="<%=products.get(i).getStock()%>" name="productStock">
                </td>
            </tr>
            <input type="hidden" value ="UpdateProduct" name ="action">
            <input type="submit" data-inline="true" value="updateProduct" name="updateProduct">
            </form>
            <% }%>
                
            
        </table>
       
    </body>
</html>
