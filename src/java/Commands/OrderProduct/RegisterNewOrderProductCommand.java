/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.OrderProduct;

import Business.OrderProduct;
import Business.Product;
import Commands.Command;
import Daos.OrderProductDao;
import Daos.ProductDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
public class RegisterNewOrderProductCommand implements Command{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";
 
        HttpSession session = request.getSession();
 
        //Get the product Id
        ProductDao productDao = new ProductDao();
        Product p = productDao.getProduct(Integer.parseInt(request.getParameter("id")));
        ArrayList<Product> productArray = (ArrayList<Product>) session.getAttribute("productOnOrderLst");
 
        if (productArray == null) {
            productArray = new ArrayList();
            productArray.add(p);
            session.setAttribute("productOnOrderLst", productArray);
        } else {
            productArray.add(p);
            session.setAttribute("productOnOrderLst", productArray);
        }
 
        forwardToJsp = "cart.jsp";
 
        return forwardToJsp;
    }
}
