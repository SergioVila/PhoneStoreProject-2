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

/**
 *
 * @author Sergio
 */
public class RegisterNewProductCommand implements Command{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";

        //Getting the product to be registered
        Product product = new Product();
        
        product.setProductName(request.getParameter("productName"));
        product.setDesc(request.getParameter("desc"));
        product.setPrice(Double.parseDouble(request.getParameter("productPrice")));
        product.setStock(Integer.parseInt(request.getParameter("productStock")));
        
        ProductDao instance = new ProductDao();
        if(product != null)
        {
        instance.registerProduct(product);
        }
            
        return "adminController.jsp" ;
    }
}
