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
public class LinksDao extends Dao {

    // This method returns all the mobiles in the database.
    
    public ArrayList<Product> getProductsByUser(int userID) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Product> products = new ArrayList();

        try {
            con = getConnection();

            String query = "select Product.* from \n" +
"product, orders, OrderProduct\n" +
"where Product.productID = OrderProduct.productID\n" +
"and OrderProduct.orderID = Orders.orderID\n" +
"and Orders.userID = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, userID);
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
}
