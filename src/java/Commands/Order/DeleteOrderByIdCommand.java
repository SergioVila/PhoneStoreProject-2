/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.Order;

import Business.Order;
import Commands.Order.*;
import Commands.Command;
import Daos.OrderDao;
import Daos.OrderProductDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
public class DeleteOrderByIdCommand implements Command{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp;

        // Getting the current session
        HttpSession session = request.getSession();
        // creating a new instance to access the database
        OrderDao instance = new OrderDao();
        
        int orderID = -1;
        // getting the parameters to search from the request
        try {
            orderID = Integer.parseInt(request.getParameter("orderId"));
        } catch (NumberFormatException e)  {
            e.printStackTrace();
        }
        
        
        boolean deleted = false;
            
        deleted = new OrderProductDao().deleteOrderProductById(orderID);
        
        deleted = new OrderDao().deleteOrderById(orderID);
       
        forwardToJsp = "/adminController.jsp";

        return forwardToJsp;
    }
}
