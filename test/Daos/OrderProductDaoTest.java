/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Daos.OrderProductDao;
import Business.OrderProduct;
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
public class OrderProductDaoTest {
    public OrderProductDao instance = new OrderProductDao();
    public OrderProductDaoTest() {
        
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
     * Test of getAllOrdersProduct method, of class OrderProductDao.
     */
    @Test
    public void testGetAllOrdersProduct() {
        System.out.println("getAllOrdersProduct");
        
        ArrayList<OrderProduct> expResult = null;
        ArrayList<OrderProduct> result = instance.getAllOrdersProduct();
        // Checking for null values
        assertNotNull(result);
        // Checking the result to be an instance of order and not null
        for(OrderProduct o : result)
        {
            assertTrue(o instanceof OrderProduct);
            assertNotNull(o);
        }
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderProductById method, of class OrderProductDao.
     */
    @Test
    public void testGetOrderProductById() {
        System.out.println("getOrderProductById");
        int productID = 1;
        int orderID = 1;
        
        OrderProduct expResult = null;
        OrderProduct result = instance.getOrderProductById(orderID,productID);
        // Checking that the instance return an object
        assertNotNull(result);
        // Checking the value of quantity as it's a known value
        int expResult2 = 2;
        assertEquals(expResult2, result.getQty());
        // Checking for a non-registered combination
        productID = 1; // Valid
        orderID = -1; // Invalid
        // Consulting the database
        result = instance.getOrderProductById(orderID,productID);
        // Checking if it returns NULL (it should)
        assertNull(result);
        // Checking for a non-registered combination 2
        productID = -1; // Invalid
        orderID = 1; // Valid
        // Consulting the database
        result = instance.getOrderProductById(orderID,productID);
        // Checking if it returns NULL (it should)
        assertNull(result);
        // Checking for a non-registered combination 2
        productID = -1; // Invalid
        orderID = -1; // Invalid
        // Consulting the database
        result = instance.getOrderProductById(orderID,productID);
        // Checking if it returns NULL (it should)
        assertNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertOrderProduct method, of class OrderProductDao.
     */
    @Test
    public void testInsertOrderProduct() {
        System.out.println("insertOrderProduct");
        
        OrderProduct nOrder = null;
        // Checking for null product
        boolean result = instance.insertOrderProduct(nOrder);
        // Checking the method returning values
        assertFalse(result);
        // inserting a valid object
        nOrder = new OrderProduct(1,10,3);
        result = instance.insertOrderProduct(nOrder);
        assertTrue(result);
        // Checking if the object is into the database
        OrderProduct o = instance.getOrderProductById(nOrder.getOrderId(), nOrder.getProductId());
        // Checking that the returning value is not null
        assertNotNull(o);
        // Checking the returning value with the object
        assertEquals(nOrder, o);
        // deleting object for future tests
        result = instance.deleteOrderProductById(nOrder.getOrderId());
        // Checking the returning value
        assertTrue(result);
        // checking if the object is in the database
        result = instance.deleteOrderProductById(nOrder.getOrderId());
        assertFalse(result);
        // Checking for null return value
        assertNull(instance.getOrderProductById(nOrder.getOrderId(), nOrder.getProductId()));
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of deleteOrderProductById method, of class OrderProductDao.
     */
    @Test
    public void testDeleteOrderProductById() {
        System.out.println("deleteOrderProductById");
        int orderID = 0;
        int productID = 0;
        
        boolean expResult = false;
        boolean result = instance.deleteOrderProductById(orderID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateOrderProduct method, of class OrderProductDao.
     */
    @Test
    public void testUpdateOrderProduct() {
        System.out.println("updateOrderProduct");
        OrderProductDao instance = new OrderProductDao();
        
        OrderProduct op = new OrderProduct();
        
        op.setOrderId(4);
        op.setProductId(1);
        op.setQty(10);
        
        // Inserting the object into the database
        assertTrue(instance.insertOrderProduct(op));
        // Checking if the object is properly inserted into the database
        assertEquals(op, instance.getOrderProductById(op.getOrderId(), op.getProductId()));
        // Creating new OrderProduct objec
        OrderProduct op2 = new OrderProduct();
        op2.setOrderId(4);
        op2.setProductId(1);
        op2.setQty(22);
        // Updating the product
        boolean result = instance.updateOrderProduct(op2, op);
        // checking returning value
        assertTrue(result);
        // Checking if the object is in the database
        assertEquals(op2, instance.getOrderProductById(op2.getOrderId(), op2.getProductId()));
        // Checking if the product has been modified
        assertNotEquals(op,instance.getOrderProductById(op2.getOrderId(), op2.getProductId()));
        // Deleting object for future test
        result = instance.deleteOrderProductById(op2.getOrderId());
        // Checking if the value was deleted
        assertTrue(result);
        // Checking if the object is in the database
        assertNull(instance.getOrderProductById(op2.getOrderId(), op2.getProductId()));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
