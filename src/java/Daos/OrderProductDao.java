/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Interfaces.OrderProductInterface;
import Business.OrderProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public class OrderProductDao extends Dao implements OrderProductInterface{

    @Override
    public ArrayList<OrderProduct> getAllOrdersProduct() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<OrderProduct> orders = new ArrayList();
        
        try{
            con = getConnection();

            String query = "Select * from OrderProduct";
            ps = con.prepareStatement(query);
            
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                // Make a customer object for the current customer
                OrderProduct o = new OrderProduct();
                
                //productID,  ProductName, price, description, stock
                o.setOrderId(rs.getInt("orderID"));
                o.setProductId(rs.getInt("productID"));
                o.setQty(rs.getInt("quantity"));
                
                // Store the current customer object (now filled with information) in the arraylist
                orders.add(o);
            }
        }catch (SQLException e) {
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                return null;
            }
        }
        return orders;
    }

    @Override
    public ArrayList<OrderProduct> getAllOrdersProductByUserID(int userID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<OrderProduct> orders = new ArrayList();
        
        try{
            con = getConnection();

            String query = "select OrderProduct.* from\n" +
"product, orders, OrderProduct\n" +
"where Product.productID = OrderProduct.productID\n" +
"and OrderProduct.orderID = Orders.orderID\n" +
"and Orders.userID = ?";
            ps = con.prepareStatement(query);
            
            ps.setInt(1, userID);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                // Make a customer object for the current customer
                OrderProduct o = new OrderProduct();
                
                //productID,  ProductName, price, description, stock
                o.setOrderId(rs.getInt("orderID"));
                o.setProductId(rs.getInt("productID"));
                o.setQty(rs.getInt("quantity"));
                
                // Store the current customer object (now filled with information) in the arraylist
                orders.add(o);
            }
        }catch (SQLException e) {
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                return null;
            }
        }
        return orders;
    }

    @Override
    public OrderProduct getOrderProductById(int orderID, int productID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try 
        {
            con = getConnection();
            
            String query = "SELECT * FROM OrderProduct WHERE orderID = ? and productID = ?";
            
            ps = con.prepareStatement(query);
            
            ps.setInt(1, orderID);
            ps.setInt(2, productID);
            
            rs = ps.executeQuery();
            
            while (rs.next()) 
            {
                OrderProduct o = new OrderProduct();
                
                o.setOrderId(rs.getInt("orderID"));
                o.setProductId(rs.getInt("productID"));
                o.setQty(rs.getInt("quantity"));
                
                return o;
            }
        } 
        catch (SQLException e) 
        {
            return null;
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean insertOrderProduct(OrderProduct nOrder) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (nOrder == null)
        {
            return false;
        }
        
        try 
        {
            con = getConnection();
            
            String query = "INSERT INTO OrderProduct VALUES(?,?,?)";
            
            ps = con.prepareStatement(query);
            
            ps.setInt(1, nOrder.getOrderId());
            ps.setInt(2, nOrder.getProductId());
            ps.setInt(3, nOrder.getQty());
            
            int i = ps.executeUpdate();
            
            if (i != 0)
            {
                return true;
            }
            
        } 
        catch (SQLException e) 
        {
            return false;
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean deleteOrderProductById(int orderID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if(orderID <= 0)
        {
            return false;
        }
        
        try 
        {
            con = getConnection();
            
            String query = "DELETE FROM OrderProduct WHERE orderID = ?";
            
            ps = con.prepareStatement(query);
            
            ps.setInt(1, orderID);
            
            int i = ps.executeUpdate(); 
            
            if (i != 0)
            {
                return true;
            }
        } 
        catch (SQLException e) 
        {
            return false;
        } 
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean updateOrderProduct(OrderProduct newData, OrderProduct oldData) {
        Connection con = null;
        PreparedStatement ps = null;
        
        boolean inserted = false;
        
        try{
            con = getConnection();
            
            String query = "UPDATE OrderProduct SET orderID = ?, productID = ?, quantity = ? WHERE orderID = ? AND productID = ?";
            
            ps = con.prepareStatement(query);
            
            ps.setInt(1, newData.getOrderId());
            ps.setInt(2, newData.getProductId());
            ps.setInt(3, newData.getQty());
            ps.setInt(4, oldData.getOrderId());
            ps.setInt(5, oldData.getProductId());
            
            
            int i = ps.executeUpdate(); 
            
            if (i != 0)
            {
                inserted = true;
            }
              
        }catch (SQLException e){
            return false;
        }catch  (NullPointerException ex) {
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                return false;
            }
        }
        return inserted;
    }
    
}
