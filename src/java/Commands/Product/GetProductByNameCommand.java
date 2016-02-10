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
public class GetProductByNameCommand implements Command{
    
     @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        // getting the current session
        HttpSession session = request.getSession();
        // new object to acces the database
        ProductDao instance = new ProductDao();
        // Getting the user stored into the session
        String product = request.getParameter("id");
        // searching for an user based on the ID
        ArrayList<Product> searchByName = instance.getProductLikeName(product);
        // If it's not null setting boolean variable as true and setting the userfound (searchById) as an attribute
        if (searchByName != null) {
            
            request.setAttribute("productList", searchByName);
        }
        // If null, setting the boolean variable as false and the user as null
        else {
            request.setAttribute("productList", null);
        }

        // returning the page to forward
        return  "/phoneStore.jsp";
    }
}