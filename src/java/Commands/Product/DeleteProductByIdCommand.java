/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.Product;

import Business.Product;
import Commands.Command;
import Daos.ProductDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
public class DeleteProductByIdCommand implements Command{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp;

        // Getting the current session
        HttpSession session = request.getSession();
        // creating a new instance to access the database
        ProductDao instance = new ProductDao();
        
        int productID = -1;
        // getting the parameters to search from the request
        try {
           
            productID = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e)  {
            e.printStackTrace();
        }
        // deleting the object from the database
        boolean deleted = instance.deleteProduct(productID);
        
        // site where the information is processed
        forwardToJsp = "/adminController.jsp";

        return forwardToJsp;
    }
}
