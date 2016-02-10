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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetUserByIdCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        // getting the current session
        HttpSession session = request.getSession();
        // new object to acces the database
        UserDao instance = new UserDao();
        // Getting the user stored into the session
        int id = Integer.parseInt(request.getParameter("user"));
        // searching for an user based on the ID
        User searchById = instance.getUserById(id);

        // If it's not null setting boolean variable as true and setting the userfound (searchById) as an attribute
        if (searchById != null) {
            
            //session.setAttribute("loggedSessionId", clientSessionId);
            request.setAttribute("searchById", searchById);
        }
        // If null, setting the boolean variable as false and the user as null
        else {
            request.setAttribute("searchById", null);
        }

        // returning the page to forward
        return  "user.jsp";
    }
}
