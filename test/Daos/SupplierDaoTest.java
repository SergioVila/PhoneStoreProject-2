/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Business.Supplier;
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
public class SupplierDaoTest {
    
    public SupplierDaoTest() {
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
     * Test of getAllOrders method, of class SupplierDao.
     */
    @Test
    public void testGetAllSuppliers() {
        System.out.println("getAllOrders");
        SupplierDao instance = new SupplierDao();
        ArrayList<Supplier> expResult = null;
        ArrayList<Supplier> result = instance.getAllSuppliers();
        // Checking for null values
        assertNotNull(result);
        // Checking the result to be an instance of order and not null
        for(Supplier o : result)
        {
            assertTrue(o instanceof Supplier);
            assertNotNull(o);
        }
    }

    /**
     * Test of getOrderById method, of class SupplierDao.
     */
    @Test
    public void testGetSupplierById() {
        System.out.println("getSupplierById");
        int id = -1;
        SupplierDao instance = new SupplierDao();
        // Checking for null
        Supplier expResult = null;
        Supplier result = instance.getSupplierById(id);
        assertNull(result);
        // Checking for an actual value
        id = 2;
        result = instance.getSupplierById(id);
        assertNotNull(result);
        // Checking for parameters in the obect
        assertEquals(id, result.getSupplierId());
        
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertSupplier method, of class SupplierDao.
     */
    @Test
    public void testInsertSupplier() {
        System.out.println("insertSupplier");
        System.out.println("testInsertOrder");
        SupplierDao instance = new SupplierDao();
        
        int supplierID= 333;
        
        Supplier s = new Supplier();
        
        s.setSupplierId(supplierID);
        s.setSupplierName("Test");
        s.setPhone("1234567");
        s.setCounty("Dublin");
        s.setCountry("Irelnd");
        s.setEmail("Email");
        s.setAddress("Address");
        
        
        boolean expResult = true;
        boolean result = instance.insertSupplier(s);
        // Checking the returning value
        assertTrue(result);
        // Checking if the supplier inserted matches with the product created locally
        assertEquals(s,instance.getSupplierById(supplierID));
        // Checking for null
        instance.insertSupplier(null);
        // Deleting order for future test
        assertTrue(instance.deleteSupplierById(supplierID));
        // checking if the order was deleted from the database
        assertNull(instance.getSupplierById(supplierID));
        
        
    }

    /**
     * Test of deleteSupplierById method, of class SupplierDao.
     */
    @Test
    public void testDeleteSupplierById() {
        System.out.println("deleteSupplierById");
        
        int id = 654;
        
        Supplier s = new Supplier();
        SupplierDao instance = new SupplierDao();
        
        s.setSupplierId(id);
        s.setSupplierName("Test");
        s.setPhone("1234567");
        s.setCounty("Dublin");
        s.setCountry("Irelnd");
        s.setEmail("Email");
        s.setAddress("Address");
        
        
        boolean expResult = true;
        boolean result = instance.insertSupplier(s);
        // Checking the returning value
        assertTrue(result);
        // Checking if the supplier inserted matches with the product created locally
        assertEquals(s,instance.getSupplierById(id));
        // deleting the objec
        assertTrue(instance.deleteSupplierById(id));
        // Checking if the object is in the database
        assertNull(instance.getSupplierById(id));
        
    }

    /**
     * Test of updateSupplier method, of class SupplierDao.
     */
    @Test
    public void testUpdateSupplier() {
        System.out.println("updateSupplier");
        int id = 543;
        
        SupplierDao instance = new SupplierDao();
        
        Supplier s = new Supplier();
        
        s.setSupplierId(id);
        s.setSupplierName("Test");
        s.setPhone("1234567");
        s.setCounty("Dublin");
        s.setCountry("Irelnd");
        s.setEmail("Email");
        s.setAddress("Address");
        
        
        boolean expResult = true;
        boolean result = instance.insertSupplier(s);
        // Checking the returning value
        assertTrue(result);
        // Checking if the supplier inserted matches with the product created locally
        assertEquals(s,instance.getSupplierById(id));
        
        // creating a new object
        Supplier s2 = new Supplier();
        
        s2.setSupplierId(id);
        s2.setSupplierName("jUnit");
        s2.setPhone("jUnit");
        s2.setCounty("jUnit");
        s2.setCountry("jUnit");
        s2.setEmail("jUnit");
        s2.setAddress("jUnit");
        
        // Checking the udate method
        result = instance.updateSupplier(s2);
        // Checking returning value
        assertTrue(result);
        // Checking if the updated information in the database matches with the object created locally
        assertEquals(s2, instance.getSupplierById(id));
        // deleting the objec
        assertTrue(instance.deleteSupplierById(id));
        // Checking if the object is in the database
        assertNull(instance.getSupplierById(id));
        
    }
    
}
