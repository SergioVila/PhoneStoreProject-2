/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Daos.OrderDao;
import Business.Order;
import java.util.ArrayList;
import java.util.Date;
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
public class OrderDaoTest {
    
    public OrderDaoTest() {
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
     * Test of getAllOrders method, of class OrderDao.
     */
    @Test
    public void testGetAllOrders() 
    {
        System.out.println("getAllOrders");
        OrderDao instance = new OrderDao();
        ArrayList<Order> expResult = null;
        ArrayList<Order> result = instance.getAllOrders();
        // Checking for null values
        assertNotNull(result);
        // Checking the result to be an instance of order and not null
        for(Order o : result)
        {
            assertTrue(o instanceof Order);
            assertNotNull(o);
        }
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    // Not working, has to set Insert and delete product @Test
    public void testGetOrderById() 
    {
        System.out.println("testGetOrderById");
        OrderDao instance = new OrderDao();
        int id = -1;
        // Checking for null
        Order expResult = null;
        Order result = instance.getOrderById(id);
        assertNull(result);
        // Checking for an actual value
        id = 2;
        result = instance.getOrderById(id);
        assertNotNull(result);
        // Checking for parameters in the obect
        assertEquals(id, result.getOrderId());
    }
    
    @Test
    public void testInsertOrder()
    {
        System.out.println("testInsertOrder");
        OrderDao instance = new OrderDao();
        
        int orderID= 333;
        
        // deleting for future tests
        instance.deleteOrderById(orderID);
        
        Order o = new Order();
        o.setDateOrdered(new Date(101, 03, 24));
        o.setUserId(1);
        o.setOrderId(orderID);
        
        boolean expResult = true;
        boolean result = instance.insertOrder(o);
        
        // checking the order has been inserted into the database
        
        assertEquals(o, instance.getOrderById(orderID));
        System.out.println("obj " + instance.getOrderById(orderID));
        // Checking the returning values for the insert method
        assertEquals(expResult, result);
        // Deleting order for future test
        assertTrue(instance.deleteOrderById(orderID));
        // checking if the order was deleted from the database
        assertNull(instance.getOrderById(orderID));
        
    }
    
    @Test
    public void testInsertOrderAlreadyThere()
    {
        System.out.println("testInsertOrderAlreadyThere");
        OrderDao instance = new OrderDao();
        
        int orderID= 333;
        
        // deleting for future tests
        instance.deleteOrderById(orderID);
        
        Order o = new Order();
        o.setDateOrdered(new Date(101, 03, 24));
        o.setUserId(1);
        o.setOrderId(orderID);
        
        boolean expResult = true;
        // Inserting the data into the database
        boolean result = instance.insertOrder(o);
        
        // checking the order has been inserted into the database
        assertEquals(o, instance.getOrderById(orderID));
        System.out.println("obj " + instance.getOrderById(orderID));
        // Checking the returning values for the insert method
        assertEquals(expResult, result);
        // Inserting the data into the database again
        result = instance.insertOrder(o);
        // Checking if the the insert method returned false
        assertFalse(result);
        // Deleting order for future test
        assertTrue(instance.deleteOrderById(orderID));
        // checking if the order was deleted from the database
        assertNull(instance.getOrderById(orderID));
        
        
    }
    
    @Test
    public void testDeleteOrder()
    {
        System.out.println("testDeleteOrder");
        
        OrderDao instance = new OrderDao();
        
        int orderID= 333;
        
        // deleting for future tests
        instance.deleteOrderById(orderID);
        
        Order o = new Order();
        o.setDateOrdered(new Date(101, 03, 24));
        o.setUserId(1);
        o.setOrderId(orderID);
        
        // Inserting the data into the database
        boolean result = instance.insertOrder(o);
        // Checking the returning result for the method
        assertTrue(result);
        // checking the order has been inserted into the database
        assertEquals(o, instance.getOrderById(orderID));
        System.out.println("obj " + instance.getOrderById(orderID));
        // Deleting order
        assertTrue(instance.deleteOrderById(orderID));
        // checking if the order was deleted from the database
        assertNull(instance.getOrderById(orderID));
        // Deleting the order again and checking it it returns false
        assertFalse(instance.deleteOrderById(orderID));
        
        
    }
    
    @Test
    public void testUpdateOrder()
    {
        System.out.println("testUpdateOrder");
        
        OrderDao instance = new OrderDao();
        
        int orderID= 333;
        
        // deleting for future tests
        instance.deleteOrderById(orderID);
        
        Order o1 = new Order();
        Order o2 = new Order();
        o1.setDateOrdered(new Date(101, 03, 24));
        o1.setOrderId(orderID);
        o1.setUserId(1);
        
        // Inserting the Order into the database
        boolean result = instance.insertOrder(o1);
        
        // Checking if the Order is in the database
        assertTrue(result);
        assertEquals(o1,instance.getOrderById(orderID));
        System.out.println("Order: " + instance.getOrderById(orderID));
        // Seting the seconf Order to compare
        o2.setDateOrdered(new Date(84, 03, 24));
        o2.setOrderId(orderID);
        o2.setUserId(2);
        // Updating the information into the database
        assertTrue(instance.updateOrder(o2));
        // Checking than o1 is different than the info in the database
        assertNotEquals(o1, instance.getOrderById(orderID));
        // deleting for future tests
        assertTrue(instance.deleteOrderById(orderID));
        
    }

    /**
     * Test of deleteOrderById method, of class OrderDao.
     */
    @Test
    public void testDeleteOrderById() {
        System.out.println("deleteOrderById");
        int id = 0;
        OrderDao instance = new OrderDao();
        boolean expResult = false;
        boolean result = instance.deleteOrderById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
    
    
}
