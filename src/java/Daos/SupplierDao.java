/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Business.Supplier;
import Interfaces.SupplierDaoInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public class SupplierDao extends Dao implements SupplierDaoInterface{

    @Override
    public ArrayList<Supplier> getAllSuppliers() 
    {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Supplier> suppliers = new ArrayList();
        
        try{
            con = getConnection();

            String query = "Select * from supplier";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); 
            
            while(rs.next())
            {
                // Make a customer object for the current customer
                Supplier s = new Supplier();
                
                s.setSupplierId(rs.getInt("supplierID"));
                s.setSupplierName(rs.getString("supplierName"));
                s.setPhone(rs.getString("phone"));
                s.setCounty(rs.getString("county"));
                s.setCountry(rs.getString("country"));
                s.setEmail(rs.getString("email"));
                s.setAddress(rs.getString("Address"));
                // Store the current customer object (now filled with information) in the arraylist
                suppliers.add(s);
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
                System.out.println("Exception occured in the finally section of the getAllCustomers() method");
                System.out.println(e.getMessage());
            }
        }
        return suppliers;
    }

    @Override
    public Supplier getSupplierById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = getConnection();

            String query = "Select * from supplier where supplierID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            
            rs = ps.executeQuery(); 
            
            if(rs.next())
            {
                // Make a customer object for the current customer
                Supplier s = new Supplier();
                
                s.setSupplierId(rs.getInt("supplierID"));
                s.setSupplierName(rs.getString("supplierName"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setAddress(rs.getString("Address"));
                s.setCounty(rs.getString("County"));
                s.setCountry(rs.getString("Country"));
                
                return s;
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
        return null;
    }

    @Override
    public boolean insertSupplier(Supplier nSupplier) {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean inserted = false;
        
        try{
            con = getConnection();

            String query = "INSERT INTO supplier VALUES (?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            if(nSupplier.getSupplierId() < 0)
            {
                ps.setString(1, null);
            }else
            {
                ps.setInt(1, nSupplier.getSupplierId());
            }
                
            ps.setString(2, nSupplier.getSupplierName());
            ps.setString(3, nSupplier.getAddress());
            ps.setString(4, nSupplier.getCounty());
            ps.setString(5, nSupplier.getCountry());
            ps.setString(6, nSupplier.getEmail());
            ps.setString(7, nSupplier.getPhone());
            
            ps.execute(); 
            
            inserted = true;
              
        }catch (SQLException e){
            return false;
        }catch  (NullPointerException ex) {
            return false;
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
                System.out.println("Exception occured in the finally section of the getAllCustomers() method");
                System.out.println(e.getMessage());
            }
        }
        return inserted;
    }

    @Override
    public boolean deleteSupplierById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        
        if (id < 0)
        {
            return false;
        }
        
        try 
        {
            con = getConnection();
            
            String query = "DELETE FROM Supplier WHERE supplierID = ?";
            
            ps = con.prepareStatement(query);
            
            ps.setInt(1,id);
            
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
    public boolean updateSupplier(Supplier nSupplier) {
        Connection con = null;
        PreparedStatement ps = null;
        
        if (nSupplier == null)
        {
            return false;
        }
        
        try 
        {
            con = getConnection();

            String query = "UPDATE Supplier SET supplierName = ? , address = ?, county = ?, country = ?, email = ?, phone = ?  WHERE supplierID = ?;";
            
            ps = con.prepareStatement(query);
            
            ps.setString(1, nSupplier.getSupplierName());
            ps.setString(2, nSupplier.getAddress());
            ps.setString(3, nSupplier.getCounty());
            ps.setString(4, nSupplier.getCountry());
            ps.setString(5, nSupplier.getEmail());
            ps.setString(6, nSupplier.getPhone());
            ps.setInt(7, nSupplier.getSupplierId());
            
            int i = ps.executeUpdate(); 
            
            if (i != 0)
            {
                return true;
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            return false;
        } 
        finally 
        {
            try 
            {
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
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

}
