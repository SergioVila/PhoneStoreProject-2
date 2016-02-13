/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.User;

import Business.User;
import Commands.Command;
import Daos.UserDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
public class RegisterNewUserCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";

        //Getting the user to be registered
        User user = new User();
        if(request.getParameter("fName") != null && request.getParameter("lName") != null && request.getParameter("address") != null &&
                request.getParameter("county") != null && request.getParameter("country") != null && request.getParameter("email") != null &&
                request.getParameter("phone") != null && request.getParameter("password") != null)
        {
            user.setfName(request.getParameter("fName"));
            user.setlName(request.getParameter("lName"));
            user.setAddress(request.getParameter("address"));
            user.setCounty(request.getParameter("county"));
            user.setCountry(request.getParameter("country"));
            user.setEmail(request.getParameter("email"));
            user.setPhone(request.getParameter("phone"));
            user.setPassword(request.getParameter("password").toCharArray());
        }
        
        // Checking for null value
        if (user != null)
        {
            UserDao instance = new UserDao();
            if (instance.registerNewUser(user))
            {
                forwardToJsp = "index.jsp";
            }
            else
            {//sets an attribute and redirects back to registration page
                request.setAttribute("error", "error");
                forwardToJsp = "register.jsp";
            }
        }
        
        return forwardToJsp ;
    }
    
}
