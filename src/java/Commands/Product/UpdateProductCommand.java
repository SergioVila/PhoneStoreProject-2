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
public class UpdateProductCommand implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp;

        // Getting the current session
        HttpSession session = request.getSession();
        // creating a new instance to access the database
        ProductDao instance = new ProductDao();
        // getting the parameters to search from the request 
        Product toUpdate = (Product) session.getAttribute("ProductToUpdated");
        
        
        Product newProduct = new Product();
        newProduct.setProductID(toUpdate.getProductID());
        newProduct.setPrice(Double.parseDouble(request.getParameter("price")));
        newProduct.setProductName(request.getParameter("name"));
        newProduct.setStock(Integer.parseInt(request.getParameter("stock")));
        newProduct.setDesc(request.getParameter("desc"));
        
        // Consulting the database
        boolean updated = instance.updateProduct(newProduct);

        if (updated) {
            request.setAttribute("searchByName", newProduct);
        } else {
            request.setAttribute("searchByName", null);
        }
        // site where the information is processed
        forwardToJsp = "/phoneItem.jsp";

        return forwardToJsp;
    }
}
