/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Business.User;
import Daos.UserDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio
 */
public class UserService {
    
    // Creaing UserDao object
    UserDao u = new UserDao();
    
    // This method returns an user cased on the username and password received
    public User login(String username, char[] password)
    {
        // Checking if the user/password match with some records in the database
        User user = u.login(username, password);
        // Returning user
        return user;
    }
	
    // retreaving all the users stored into the database
    public List<User> getAllUsers()
    {
        // Consulting the database to retreave all the users
        ArrayList<User> lst = u.FindAllUsers();
        // returning a list of users (ArrayList)
        return lst;	
    }
    
    
}
