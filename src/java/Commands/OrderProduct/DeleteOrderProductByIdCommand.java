/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.OrderProduct;

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
public class DeleteOrderProductByIdCommand implements Command{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp;

        // Getting the current session
        HttpSession session = request.getSession();
        // creating a new instance to access the database
        OrderProductDao instance = new OrderProductDao();
        
        int orderID = -1;
        // getting the parameters to search from the request
        try {
            orderID = Integer.parseInt(request.getParameter("orderID"));
            
            // deleting the object from the database
            boolean deleted = instance.deleteOrderProductById(orderID);
            // setting a new arrayList with the orders returned
            session.setAttribute("deleted", deleted);
            // site where the information is processed
            
            forwardToJsp = "/index.jsp";
        } catch (NumberFormatException e)  {
            forwardToJsp = "/Error.html";
        }
        

        return forwardToJsp;
    }
}
