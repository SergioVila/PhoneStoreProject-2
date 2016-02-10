/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.Order;

import Commands.Order.*;
import Business.Order;
import Commands.Command;
import Daos.OrderDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
public class UpdateOrderCommand implements Command{
   
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp;

        // Getting the current session
        HttpSession session = request.getSession();
        // creating a new instance to access the database
        OrderDao instance = new OrderDao();
        // getting the parameters to search from the request
        Order toUpdate = (Order) request.getAttribute("OrderToUpdated");
        // Consulting the database
        boolean updated = instance.updateOrder(toUpdate);

        if (updated) {
            request.setAttribute("orderUpdated", toUpdate);
        } else {
             request.setAttribute("orderUpdated", null);
        }
        // site where the information is processed
        forwardToJsp = "/index.jsp";

        return forwardToJsp;
    }
}
