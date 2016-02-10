/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.Product;

import Business.Product;
import Commands.Command;
import Daos.ProductDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
public class GetAllProductsToDeleteCommand implements Command{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        // Seting the jsp page to forward to
        String forwardToJsp = "";
        // Creating the instance to reteave all the data from the database
        ProductDao instance = new ProductDao();
        // Setting an ArrayList with all the information retreaved
        ArrayList<Product> lst = instance.getAllProducts();
        // Checking if the list is null
        
        // Getting the session
        HttpSession session = request.getSession();
        // Setting the list as an attibute in the session
        request.setAttribute("productList", lst);
        // Setting the page where the servlet will forward the request
        forwardToJsp = "/deleteProduct.jsp";
        

        return forwardToJsp;

    }
    
}
