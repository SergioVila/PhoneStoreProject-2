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
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
public class GetAllOrderProductsCommand implements Command{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        // Seting the jsp page to forward to
        String forwardToJsp = "";
        // Creating the instance to reteave all the data from the database
        OrderProductDao instance = new OrderProductDao();
        // Setting an ArrayList with all the information retreaved
        ArrayList<OrderProduct> lst = instance.getAllOrdersProduct();
        // Checking if the list is null
        if (lst != null) {
            // Getting the session
            HttpSession session = request.getSession();
            // Setting the list as an attibute in the session
            session.setAttribute("orderProductLst", lst);
            // Setting the page where the servlet will forward the request
            forwardToJsp = "retreaveListSucceed.jsp";
        } else {
            // // Setting the page where the servlet will forward the request
            forwardToJsp = "retreaveListFails.jsp";
        }

        return forwardToJsp;
    }
}
