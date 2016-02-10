/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Daos.ProductDao;
import Business.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sergio
 */
public class ProductDaoTest {
    
    public ProductDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllProducts method, of class ProductDao.
     */
    @Test
    public void testGetAllProducts() throws SQLException {
        System.out.println("getAllProducts");
        ProductDao instance = new ProductDao();
        ArrayList<Product> expResult = null;
        ArrayList<Product> result = instance.getAllProducts();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of registerProduct method, of class ProductDao.
     */
    @Test
    // testing for a null value
    public void testInsertNullProduct() 
    {
        System.out.println("registerNullProduct");
        Product nProduct = null;
        ProductDao instance = new ProductDao();
        boolean expResult = false;
        boolean result = instance.registerProduct(nProduct);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    // Teting for a valid value
    public void testInsertValidProduct() 
    {
        System.out.println("registerValidProduct");
        Product nProduct = new Product();
        int ID = 247;
        nProduct.setProductID(ID);
        nProduct.setProductName("Test23");
        nProduct.setDesc("Test");
        nProduct.setPrice(1.1);
        nProduct.setStock(1);
        
        ProductDao instance = new ProductDao();
        
        boolean expResult = true;
        boolean result = instance.registerProduct(nProduct);
        
        assertEquals(expResult, result);
        
        // Checking if the product is in the database
        Product p = instance.getProduct(ID);
        assertEquals(nProduct, p);
        // Deleting item for future tests
        instance.deleteProduct(ID);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of deleteProduct method, of class ProductDao.
     */
    @Test
    // testing for a non-registered product
    public void testDeleteProductNotRegistered() {
        System.out.println("testDeleteProductNotRegistered");
        int id = -1;
        ProductDao instance = new ProductDao();
        boolean expResult = false;
        boolean result = instance.deleteProduct(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    // testing for a registered product by ID
    public void testDeleteProductRegisteredID() {
        System.out.println("testDeleteProductRegisteredID");
        
        int id = 100;
        
        Product nProduct = new Product();
        
        nProduct.setProductID(id);
        nProduct.setProductName("Test55");
        nProduct.setDesc("Test");
        nProduct.setPrice(1.1);
        nProduct.setStock(1);
        
        ProductDao instance = new ProductDao();
        boolean expResult = true;
        // Adding the product to the database
        instance.registerProduct(nProduct);
        
        // Checking if the product is in the database
        Product p = instance.getProduct(id);
        assertEquals(nProduct, p);
        // Deleting product
        boolean result = instance.deleteProduct(id);
        // checking if the item was deleted
        assertEquals(expResult, result);
        // Checking if the item was in the database
        p = instance.getProduct(id);
        // p should be null if the item was properly deleted
        assertNull(p);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
     @Test
    // testing for a registered product by productName
    public void testDeleteProductRegisteredName() {
        System.out.println("testDeleteProductRegisteredName");
        
        // Creating a product object for the test
        Product nProduct = new Product();
        
        String name = "Test23";
        int ID = 247;
        nProduct.setProductID(ID);
        nProduct.setProductName(name);
        nProduct.setDesc("Test");
        nProduct.setPrice(1.1);
        nProduct.setStock(1);
        
        // Creating a ProductDao instance
        ProductDao instance = new ProductDao();
        
        // registering the product into the database
        instance.registerProduct(nProduct);
        
        // Checking that the product is in the database
        assertEquals(nProduct, instance.getProduct(ID));
        // Checking method returns
        boolean expResult = true;
        boolean result = instance.deleteProduct(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
     @Test
    // testing for a registered product by productName
    public void testUpdateProductRegisteredID() {
        System.out.println("testUpdateProductRegisteredID");
        int id = 331;
        
        ProductDao instance = new ProductDao();
        // Creating a product object to register into the database
        Product nProduct = new Product(id,"test",1.0,"test",20);
        // Inserting the product into the database
        instance.registerProduct(nProduct);
        // Checking if the product was registered
        assertEquals(nProduct, instance.getProduct(id));
        
        // Giving a new value to nProduct
        nProduct = new Product(id,"jUnit-Test",9.0,"description",9);
        // Checking returning values
        boolean expResult = true;
        boolean result = instance.updateProduct(nProduct);
        assertEquals(expResult, result);
        // Checking update in the database
        assertEquals(nProduct, instance.getProduct(id));
        // Deleting product for future tests
        instance.deleteProduct(id);
        // Checking if the product was deleted
        assertNull(instance.getProduct(id));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
}
