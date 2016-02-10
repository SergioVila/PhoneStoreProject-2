/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Business.Product;
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
public class LinksDaoTest {
    
    public LinksDaoTest() {
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
     * Test of getProductsByUser method, of class LinksDao.
     */
    @Test
    public void testGetProductsByUser() {
        System.out.println("getProductsByUser");
        LinksDao instance = new LinksDao();
        ArrayList<Product> expResult = null;
        ArrayList<Product> result = instance.getProductsByUser(1);
        // Checking for null values
        assertNotNull(result);
        // Checking the result to be an instance of order and not null
        for(Product o : result)
        {
            assertTrue(o instanceof Product);
            assertNotNull(o);
        }
    }
    
}
