/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.OrderProduct;

import Commands.OrderProduct.*;
import Business.OrderProduct;
import Commands.Command;
import Daos.OrderProductDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
public class UpdateOrderProductCommand implements Command{
   
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp;

        // Getting the current session
        HttpSession session = request.getSession();
        // creating a new instance to access the database
        OrderProductDao instance = new OrderProductDao();
        // getting the parameters to search from the request
        OrderProduct newObj = (OrderProduct) request.getAttribute("OrderProductToUpdated");
        OrderProduct oldObj = (OrderProduct) request.getAttribute("OrderProductToUpdated");
        // Consulting the database
        boolean updated = instance.updateOrderProduct(newObj, oldObj);

        if (updated) {
            request.setAttribute("orderProductUpdated", newObj);
        } else {
             request.setAttribute("orderProductUpdated", null);
        }
        // site where the information is processed
        forwardToJsp = "/index.jsp";

        return forwardToJsp;
    }
}
