/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.User;

import Business.User;
import Commands.Command;
import Daos.UserDao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
public class GetAllUsersToDeleteCommand implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        // Seting the jsp page to forward to
        String forwardToJsp = "";
        // Creating the instance to reteave all the data from the database
        UserDao instance = new UserDao();
        // Setting an ArrayList with all the information retreaved
        ArrayList<User> lst = instance.FindAllUsers();
        // Checking if the list is null
        if (lst != null) {
            // Getting the session
            HttpSession session = request.getSession();
            // Setting the list as an attibute in the session
            request.setAttribute("getallusers", lst);
            // Setting the page where the servlet will forward the request
            forwardToJsp = "deleteUser.jsp";
        } else {
            // // Setting the page where the servlet will forward the request
            forwardToJsp = "deleteUser.jsp";
        }

        return forwardToJsp;

    }
}
