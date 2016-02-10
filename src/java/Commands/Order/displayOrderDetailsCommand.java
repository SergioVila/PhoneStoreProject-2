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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
public class displayOrderDetailsCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession Session = request.getSession();
        UserDao userInstance = new UserDao();
        OrderDao orderInstance = new OrderDao();
        ProductDao productInstance = new ProductDao();
        OrderProductDao OPInstance = new OrderProductDao();
        
        
        User nUser = userInstance.getUserById(Integer.parseInt(request.getParameter("orUser")));
        
        
        request.setAttribute("nUser",nUser);


        Order order = orderInstance.getOrderById(Integer.parseInt(request.getParameter("order")));
        request.setAttribute("nOrder",order);
        Product phoneObj = productInstance.getProduct(Integer.parseInt(request.getParameter("product")));
        request.setAttribute("nProduct",phoneObj);
        OrderProduct orderProd = OPInstance.getOrderProductById(order.getOrderId(), phoneObj.getProductID());
        request.setAttribute("nOrderProduct",orderProd);
        String forwardToJsp = "/orderDetails.jsp";

        return forwardToJsp;
    }
}
