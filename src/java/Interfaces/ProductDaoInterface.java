/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Business.Product;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public interface ProductDaoInterface {
    
    public ArrayList<Product> getAllProducts();
    
    public Product getProduct(int ID);
    
    public ArrayList<Product> getProductLikeName(String name);
    
    public boolean registerProduct(Product nProduct);
    
    public boolean deleteProduct(int id);
    
    public boolean deleteProduct(String productName);
    
    public boolean updateProduct(Product nProduct);
}
