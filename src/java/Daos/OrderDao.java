/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Interfaces.OrderDaoInterface;
import Business.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public class OrderDao extends Dao implements OrderDaoInterface{
    
    @Override
    public ArrayList<Order> getAllOrders()
    {
          
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Order> orders = new ArrayList();
        
        try{
            con = getConnection();

            String query = "Select * from orders";
            ps = con.prepareStatement(query);
            
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                // Make a customer object for the current customer
                Order o = new Order();
                
                //productID,  ProductName, price, description, stock
                o.setOrderId(rs.getInt("orderID"));
                o.setUserId(rs.getInt("userID"));
                o.setDateOrdered(rs.getDate("dateOrdered"));
                
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
    public Order getOrderById(int id)
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try 
        {
            con = getConnection();
            
            String query = "SELECT * FROM orders WHERE orderID = ?";
            
            ps = con.prepareStatement(query);
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            while (rs.next()) 
            {
                Order o = new Order();
                
                o.setOrderId(rs.getInt("orderID"));
                o.setUserId(rs.getInt("userID"));
                o.setDateOrdered(rs.getDate("dateOrdered"));
                
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
    public boolean insertOrder(Order nOrder)
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try 
        {
            con = getConnection();
            
            String query = "INSERT INTO Orders VALUES(?,?,?)";
            
            ps = con.prepareStatement(query);
            
            if (nOrder.getOrderId() == -1)
            {
                ps.setString(1, "NULL");
            }
            else
            {
                ps.setInt(1, nOrder.getOrderId());
            }
            
            Date orderD = new Date(nOrder.getDateOrdered().getYear(), nOrder.getDateOrdered().getMonth(),nOrder.getDateOrdered().getDate());
            
            ps.setDate(2, (orderD));
            
            ps.setInt(3, nOrder.getUserId());
            
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
    public boolean deleteOrderById(int id)
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if(id < 0)
        {
            return false;
        }
        
        try 
        {
            con = getConnection();
            
            String query = "DELETE FROM Orders WHERE orderID = ?";
            
            ps = con.prepareStatement(query);
            
            ps.setInt(1, id);
            
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
    public boolean updateOrder(Order nOrder)
    {
        Connection con = null;
        PreparedStatement ps = null;
        
        boolean inserted = false;
        
        try{
            con = getConnection();

            String query = "UPDATE Orders SET dateOrdered = ?, userID = ? WHERE orderID = ?";
            
            ps = con.prepareStatement(query);
            
            Date orderD = new Date(nOrder.getDateOrdered().getYear(), nOrder.getDateOrdered().getMonth(),nOrder.getDateOrdered().getDate());
            
            ps.setDate(1, orderD);
            ps.setInt(2, nOrder.getUserId());
            ps.setInt(3, nOrder.getOrderId());
            
            
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
                System.out.println("Exception occured in the finally section of the getAllCustomers() method");
                System.out.println(e.getMessage());
            }
        }
        return inserted;
    }
    
}
