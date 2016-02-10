/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Daos.UserDao;
import Business.User;
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
public class UserDaoTest {
    
    public UserDaoTest() {
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
     * Test of FindAllUsers method, of class UserDao.
     */
    @Test
    public void testFindAllUsers() throws Exception {
        System.out.println("FindAllUsers");
        UserDao instance = new UserDao();
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.FindAllUsers();
        assertNotEquals(expResult, result);
        assertEquals(3, result.size());
        for(User item : result)
        {
            assertNotNull(item);
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetUserByIdForNull() throws Exception {
        System.out.println("testGetUserByIdForNull");
        UserDao instance = new UserDao();
        User result = instance.getUserById(-1);
        assertNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetUserByIdForValid() throws Exception {
        System.out.println("testGetUserByIdForValid");
        UserDao instance = new UserDao();
        
        int i = 425;
        
        User nUser = new User();
        
        nUser.setUserId(i);
        nUser.setfName("jUnit");
        nUser.setlName("jUnit");
        nUser.setAddress("jUnit");
        nUser.setEmail("jUnit@jUnit.com");
        nUser.setCountry("Ireland");
        nUser.setCounty("Louth");
        nUser.setIsAdmin(true);
        nUser.setPhone("0987654");
        String pass = "password";
        nUser.setPassword(pass.toCharArray());
        
        instance.registerNewUser(nUser);
        
        User expResult = nUser;
        
        User result = instance.getUserById(i);
        
        instance.deleteUser(i);
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetUserByNameForNull() throws Exception {
        System.out.println("testGetUserByNameForNull");
        UserDao instance = new UserDao();
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.getUserByName("", "");
        assertNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetUserByNameForValid() throws Exception {
        System.out.println("testGetUserByNameForValid");
        UserDao instance = new UserDao();
        ArrayList<User> expResult = new ArrayList();
        User u = new User();
        
        u.setUserId(1);
        u.setfName("Sergio");
        u.setlName("Vilaseco");
        u.setAddress("address");
        u.setCounty("louth");
        u.setCountry("ireland");
        u.setEmail("test@test.com");
        u.setPhone("0859876543");
        u.setPasswordHashed("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
        
        expResult.add(u);
        
        ArrayList<User> result = instance.getUserByName("Ser", "Vil");
        assertNotNull(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testLoginPass() throws Exception {
        System.out.println("testLoginPass");
        UserDao instance = new UserDao();
        
        User u = new User();
        
        u.setUserId(1);
        u.setfName("Sergio");
        u.setlName("Vilaseco");
        u.setAddress("address");
        u.setCounty("louth");
        u.setCountry("ireland");
        u.setEmail("test@test.com");
        u.setPhone("0859876543");
        u.setPasswordHashed("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
        
        User expResult = u;
        
        String p = "password";
        
        User result = instance.login("test@test.com", p.toCharArray());
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testLoginFail() throws Exception {
        System.out.println("testLoginFail");
        UserDao instance = new UserDao();
        
        //valid email no pass
        User result = instance.login("test@test.com", null);
        assertNull(result);
        
        //no email and no pass
        result = instance.login(null, null);
        assertNull(result);
        
        // no email valid pass
        String p = "password";
        result = instance.login(null, p.toCharArray());
        assertNull(result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    // testing for a null value
    public void testAddUsserNull() 
    {
        System.out.println("testAddUsserNull");
        User nUser = null;
        UserDao instance = new UserDao();
        boolean expResult = false;
        boolean result = instance.registerNewUser(nUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    //@Test
    // Teting for a valid value
    public void testAddUsserValid() 
    {
        System.out.println("testAddUsserValid");
        User nUser = new User();
        nUser.setUserId(129);
        nUser.setfName("jUnit");
        nUser.setlName("jUnit");
        nUser.setAddress("jUnit");
        nUser.setEmail("jUnit@jUnit.com");
        nUser.setCountry("Ireland");
        nUser.setCounty("Louth");
        nUser.setIsAdmin(true);
        nUser.setPhone("0987654");
        String pass = "password";
        nUser.setPassword(pass.toCharArray());
        
        UserDao instance = new UserDao();
        
        boolean expResult = true;
        boolean result = instance.registerNewUser(nUser);
        // Checking if registerNewUser returns true
        assertEquals(expResult, result);
        // checking if the user inserted can be retreaved
        User nResult = instance.getUserById(129);
        assertEquals(nUser, nResult);
        
        //deleting user for future tests
        instance.deleteUser(129);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testdeleteUserIDNegative() 
    {
        System.out.println("testdeleteUserIDNegative");
        int i = -1;
        
        UserDao instance = new UserDao();
        
        boolean expResult = false;
        boolean result = instance.deleteUser(i);
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testdeleteUserIDValid() 
    {
        System.out.println("testdeleteUserIDValid");
        int i = 425;
        
        User nUser = new User();
        
        nUser.setUserId(i);
        nUser.setfName("jUnit");
        nUser.setlName("jUnit");
        nUser.setAddress("jUnit");
        nUser.setEmail("jUnit@jUnit.com");
        nUser.setCountry("Ireland");
        nUser.setCounty("Louth");
        nUser.setIsAdmin(true);
        nUser.setPhone("0987654");
        String pass = "password";
        nUser.setPassword(pass.toCharArray());
        
        UserDao instance = new UserDao();
        
        // Adding the user
        instance.registerNewUser(nUser);
        
        // Checking if the user has been inserted
        assertEquals(nUser, instance.getUserById(i));
        
        boolean expResult = true;
        
        // checking if the user can be deleted
        boolean result = instance.deleteUser(i);
        assertEquals(expResult, result);
        
        // checking if the user was deleted
        assertNull(instance.getUserById(i));
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    // testing for a registered product by productName
    public void testUpdateUserByID() {
        System.out.println("testUpdateUserByID");
        
        int i = 425;
        
        User nUser = new User();
        
        nUser.setUserId(i);
        nUser.setfName("jUnit");
        nUser.setlName("jUnit");
        nUser.setAddress("jUnit");
        nUser.setEmail("jUnit@jUnit.com");
        nUser.setCountry("Ireland");
        nUser.setCounty("Louth");
        nUser.setIsAdmin(true);
        nUser.setPhone("0987654");
        String pass = "password";
        nUser.setPassword(pass.toCharArray());
        
        UserDao instance = new UserDao();
        
        // Adding the a new user for the test
        instance.registerNewUser(nUser);
        
        nUser.setfName("Edited");
        nUser.setlName("Edited");
        nUser.setAddress("Edited");
        
        boolean expResult = true;
        
        // Checking if the user was added to the database
        User temp = new UserDao().getUserById(i);
        
        // Editing the user
        boolean result = instance.editUserDetails(nUser);
        
        // Checking if the user has been modified
        assertNotEquals(temp, instance.getUserById(i));
        //deleting user for future tests
        instance.deleteUser(i);
        // Checking the returning value for the update method
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    @Test
    public void testUpdateUserNull() {
        System.out.println("testUpdateUserNull");
        
        int i = 425;
        
        User nUser = new User();
        
        nUser.setUserId(i);
        nUser.setfName("jUnit");
        nUser.setlName("jUnit");
        nUser.setAddress("jUnit");
        nUser.setEmail("jUnit@jUnit.com");
        nUser.setCountry("Ireland");
        nUser.setCounty("Louth");
        nUser.setIsAdmin(true);
        nUser.setPhone("0987654");
        String pass = "password";
        nUser.setPassword(pass.toCharArray());
        
        UserDao instance = new UserDao();
        instance.registerNewUser(nUser);
        
        nUser.setfName("Edited");
        nUser.setlName("Edited");
        nUser.setAddress("Edited");
        
        boolean expResult = false;
        // Checking for null
        boolean resultNull = instance.editUserDetails(null);
        // seting a non registered ID
        nUser.setUserId(-1);
        boolean resultNegative = instance.editUserDetails(nUser);
        
        // Deleting user for future tests
        instance.deleteUser(i);
        
        //Null value
        assertEquals(expResult, resultNull);
        // Non-registered value
        assertEquals(expResult, resultNegative);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
}
