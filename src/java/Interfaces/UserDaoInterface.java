/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Business.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public interface UserDaoInterface {
    
    public ArrayList<User> FindAllUsers() throws SQLException;
    
     public User getUserById(int userId);
     
     public ArrayList<User> getUserByName(String fName, String lName);
         
     public User login(String email, char[] userPassword);
     
    public boolean registerNewUser(User nUser);
    
    public boolean deleteUser(int userID);
    
    public boolean editUserDetails(User nUser);
}
