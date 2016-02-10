
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

public class GetUserByNameCommand implements Command 
{
    public String execute(HttpServletRequest request, HttpServletResponse response) 
    {
        String forwardToJsp;
        
        // Getting the current session
        HttpSession session = request.getSession();
        // creating a new instance to access the database
        UserDao instance = new UserDao();
        // getting the parameters to search from the request
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        // Consulting the database
        ArrayList<User> userByNames = instance.getUserByName(fName, lName);
        // setting a new arrayList with the users returned
        session.setAttribute("usersByNames", userByNames);
        // site where the information is processed
        forwardToJsp = "/index.jsp";				

        return forwardToJsp;
    }
}
