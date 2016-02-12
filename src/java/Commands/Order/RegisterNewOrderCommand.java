/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.Order;

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
public class RegisterNewOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";

        HttpSession session = request.getSession();



        //Get the product Id
        ProductDao productDao = new ProductDao();
        Product p = productDao.getProduct(Integer.parseInt(request.getParameter("productID")));
        ArrayList<Product> productArray = (ArrayList<Product>) session.getAttribute("productOnOrderLst");

        if (productArray == null) {
            productArray = new ArrayList();
            if(p!=null)
            {
            productArray.add(p);
            session.setAttribute("productOnOrderLst", productArray);
            }
        } else {
            if(p!=null)
            {
            productArray.add(p);
            session.setAttribute("productOnOrderLst", productArray);
            }
        }

        forwardToJsp = "phoneStore.jsp";

        return forwardToJsp;
    }
}
