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
       
    </body>
</html>

