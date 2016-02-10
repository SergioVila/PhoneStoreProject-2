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
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
public class GetAllOrdersCommand implements Command{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        // Seting the jsp page to forward to
        String forwardToJsp = "";
        // Creating the instance to reteave all the data from the database
        OrderDao instance = new OrderDao();
        // Setting an ArrayList with all the information retreaved
        ArrayList<Order> lst = instance.getAllOrders();
        // Getting the session
        HttpSession session = request.getSession();
        // Setting the list as an attibute in the session
        request.setAttribute("orderLst", lst);
        // Setting the page where the servlet will forward the request
        forwardToJsp = "orderList.jsp";


        return forwardToJsp;
    }
}
