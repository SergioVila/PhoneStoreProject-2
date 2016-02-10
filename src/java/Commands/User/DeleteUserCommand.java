
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.User;

/**
 *
 * @author Sergio
 */
import Business.User;
import Commands.Command;
import Daos.UserDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteUserCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp;

        // Getting the current session
        HttpSession session = request.getSession();
        // creating a new instance to access the database
        UserDao instance = new UserDao();
        
        int userID = -1;
        // getting the parameters to search from the request
        try {
            userID = Integer.parseInt(request.getParameter("userID"));
        } catch (NumberFormatException e)  {
            e.printStackTrace();
        }
        // deleting the object from the database
        boolean deleted = instance.deleteUser(userID);
        // setting a new arrayList with the users returned
        session.setAttribute("deleted", deleted);
        
         ArrayList<User> lst = instance.FindAllUsers();
        
        
        // Setting the list as an attibute in the session
        request.setAttribute("getallusers", lst);
        // Setting the page where the servlet will forward the request
        forwardToJsp = "deleteUser.jsp";

        return forwardToJsp;
    }
}
