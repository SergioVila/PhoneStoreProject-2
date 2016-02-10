/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.Product;

import Commands.Command;
import Daos.ProductDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
public class DeleteProductByNameCommand implements Command{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp;

        // Getting the current session
        HttpSession session = request.getSession();
        // creating a new instance to access the database
        ProductDao instance = new ProductDao();
        
        String productName = null;
        // getting the parameters to search from the request
        productName = (String)request.getAttribute("product");
        // deleting the object from the database
        boolean deleted = instance.deleteProduct(productName);
        // setting a new arrayList with the products returned
        session.setAttribute("deleted", deleted);
        // site where the information is processed
        forwardToJsp = "/phoneStore.jsp";

        return forwardToJsp;
    }
}
