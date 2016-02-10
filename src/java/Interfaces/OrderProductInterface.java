/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Business.OrderProduct;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public interface OrderProductInterface {
    
    public ArrayList<OrderProduct> getAllOrdersProduct();
    
    public ArrayList<OrderProduct> getAllOrdersProductByUserID(int userID);
    
    public OrderProduct getOrderProductById(int orderID, int productID);
    
    public boolean insertOrderProduct(OrderProduct nOrder);
    
    public boolean deleteOrderProductById(int orderID);
    
    public boolean updateOrderProduct(OrderProduct newData, OrderProduct oldData);
}
