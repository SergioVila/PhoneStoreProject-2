/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.Order;

import Business.Order;
import Business.OrderProduct;
import Business.Product;
import Business.User;
import Commands.Command;
import Daos.OrderDao;
import Daos.OrderProductDao;
import Daos.ProductDao;
import Daos.UserDao;
import java.util.ArrayList;
import java.util.HashSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
public class GetAllOrdersForDeleteCommand implements Command{
 
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        // getting the current session
        HttpSession session = request.getSession();
        // Getting the user stored into the session
        User s = (User)session.getAttribute("user");
      
        ArrayList<OrderProduct> op;
        
        // If it's not null setting boolean variable as true and setting the userfound (searchById) as an attribute
        if(s != null && s.getIsIsAdmin())
        {
            op = new OrderProductDao().getAllOrdersProduct();
        }
        else
        {
            op = new OrderProductDao().getAllOrdersProductByUserID(s.getUserId());
        }
        ArrayList<Product> lst = new ArrayList();
        
        for(OrderProduct item : op)
        {
            Product p = new ProductDao().getProduct(item.getProductId());
            
            lst.add(p);
        }
        // Getting all the orders related with the user
        ArrayList<Order> orderList = new OrderDao().getAllOrders();
        
        ArrayList<User> users = new ArrayList();
        
        for(Order o : orderList)
        {
            UserDao instance = new UserDao();
            User nUser = instance.getUserById(o.getUserId());
            
            if(s.getUserId() == nUser.getUserId() || s.getIsIsAdmin())
            {
               users.add(nUser); 
            }
        }
        
        ArrayList<Order> orderList2 = new ArrayList();
        
        for(Order o : orderList)
        {
            if(o.getUserId() == s.getUserId() || s.getIsIsAdmin())
            {
                orderList2.add(o);
            }
        }
        
        if (orderList2 != null && op != null && lst != null && users != null) {
            request.setAttribute("orderLst", orderList2);
            request.setAttribute("orderProductList", op);
            request.setAttribute("productList", lst);
            request.setAttribute("userLst", users);
        }
        // If null, setting the boolean variable as false and the user as null
        else {
            
            request.setAttribute("orderList", null);
            request.setAttribute("orderProductList", null);
            request.setAttribute("oProductList", null);
            request.setAttribute("userLst",null);
         
        }

        // returning the page to forward
        return  "/ordersToDelete.jsp";
    }
}


