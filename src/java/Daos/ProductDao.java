/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Interfaces.ProductDaoInterface;
import Business.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public class ProductDao extends Dao implements ProductDaoInterface {

    // This method returns all the mobiles in the database.
    @Override
    public ArrayList<Product> getAllProducts() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Product> products = new ArrayList();

        try {
            con = getConnection();

            String query = "Select * from product";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                // Make a customer object for the current customer
                Product p = new Product();

                //productID,  ProductName, price, description, stock
                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("ProductName"));
                p.setPrice(rs.getDouble("price"));
                p.setDesc(rs.getString("description"));
                p.setStock(rs.getInt("stock"));

                // Store the current customer object (now filled with information) in the arraylist
                products.add(p);
            }
        } catch (SQLException e) {
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
        return products;
    }

    @Override
    public Product getProduct(int ID) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            String query = "Select * from product where productID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, ID);
            rs = ps.executeQuery();

            if (rs.next()) {
                // Make a customer object for the current customer
                Product p = new Product();

                //productID,  ProductName, price, description, stock
                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("ProductName"));
                p.setPrice(rs.getDouble("price"));
                p.setDesc(rs.getString("description"));
                p.setStock(rs.getInt("stock"));

                return p;
            }
        } catch (SQLException e) {
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
    public ArrayList<Product> getProductLikeName(String name) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            String query = "Select * from product where productName like ?";
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();

            ArrayList<Product> products = new ArrayList();
            
            while (rs.next()) {
                // Make a customer object for the current customer
                Product p = new Product();

                //productID,  ProductName, price, description, stock
                p.setProductID(rs.getInt("productID"));
                p.setProductName(rs.getString("ProductName"));
                p.setPrice(rs.getDouble("price"));
                p.setDesc(rs.getString("description"));
                p.setStock(rs.getInt("stock"));

                products.add(p);
            }
            return products;
        } catch (SQLException e) {
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
    }

    @Override
    public boolean registerProduct(Product nProduct) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean inserted = false;

        try {
            con = getConnection();

            String query = "INSERT INTO product VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(query);
            if (nProduct.getProductID() < 0) {
                ps.setString(1, null);
            } else {
                ps.setInt(1, nProduct.getProductID());
            }

            ps.setString(2, nProduct.getProductName());
            ps.setDouble(3, nProduct.getPrice());
            ps.setString(4, nProduct.getDesc());
            ps.setInt(5, nProduct.getStock());

            ps.execute();

            inserted = true;

        } catch (SQLException e) {
            return false;
        } catch (NullPointerException ex) {
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
    public boolean deleteProduct(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean inserted = false;

        try {
            con = getConnection();

            String query = "DELETE FROM product where productID = ?";
            ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int i = ps.executeUpdate();

            if (i != 0) {
                inserted = true;
            }

        }
        catch (SQLIntegrityConstraintViolationException  e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                try {
                    String query = "UPDATE Product SET price = ?, description = ?, stock = ? WHERE productID = ?";

                    ps = con.prepareStatement(query);
                    ps.setDouble(2, 0.0);
                    ps.setString(3, "This item is no longer supplied");
                    ps.setInt(4, 0);
                    ps.setInt(5, id);

                    int i = ps.executeUpdate();
                    if (i != 0) {
                        inserted = true;
                    }
                    return true;
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
        catch(SQLException e)
        {
            return false;
        } catch (NullPointerException ex) {
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
    public boolean deleteProduct(String productName) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean inserted = false;

        try {
            con = getConnection();

            String query = "DELETE FROM product where productName = ?";
            ps = con.prepareStatement(query);

            ps.setString(1, productName);

            int i = ps.executeUpdate();

            if (i != 0) {
                inserted = true;
            }

        } catch (SQLException e) {
            return false;
        } catch (NullPointerException ex) {
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
    public boolean updateProduct(Product nProduct) {

        Connection con = null;
        PreparedStatement ps = null;

        boolean inserted = false;

        try {
            con = getConnection();

            String query = "UPDATE Product SET productName = ?, price = ?, description = ?, stock = ? WHERE productID = ?";

            ps = con.prepareStatement(query);

            ps.setString(1, nProduct.getProductName());
            ps.setDouble(2, nProduct.getPrice());
            ps.setString(3, nProduct.getDesc());
            ps.setInt(4, nProduct.getStock());
            ps.setInt(5, nProduct.getProductID());

            int i = ps.executeUpdate();

            if (i != 0) {
                inserted = true;
            }

        } catch (SQLException e) {
            return false;
        } catch (NullPointerException ex) {
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
