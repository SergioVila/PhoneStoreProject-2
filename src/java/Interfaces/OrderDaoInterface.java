/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Business.Order;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public interface OrderDaoInterface {
    
    public ArrayList<Order> getAllOrders();
    
    public Order getOrderById(int id);
    
    public boolean insertOrder(Order nOrder);
    
    public boolean deleteOrderById(int id);
    
    public boolean updateOrder(Order nOrder);
}
