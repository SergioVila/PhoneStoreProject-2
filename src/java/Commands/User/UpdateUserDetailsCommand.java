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
public class UpdateUserDetailsCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp;

        // Getting the current session
        HttpSession session = request.getSession();
        // creating a new instance to access the database
        UserDao instance = new UserDao();
        // getting the parameters to search from the request
        User toUpdate = new User();
        
        toUpdate.setUserId(Integer.parseInt(request.getParameter("userID")));
        toUpdate.setfName(request.getParameter("fName"));
        toUpdate.setlName(request.getParameter("lName"));
        toUpdate.setAddress(request.getParameter("address"));
        toUpdate.setCounty(request.getParameter("county"));
        toUpdate.setCountry(request.getParameter("country"));
        toUpdate.setEmail(request.getParameter("email"));
        toUpdate.setPhone(request.getParameter("phone"));
        toUpdate.setIsAdmin(Boolean.parseBoolean(request.getParameter("admin")));
        toUpdate.setPasswordHashed(request.getParameter("password"));
        // Consulting the database
        boolean updated = instance.editUserDetails(toUpdate);

        if (updated) {
            request.setAttribute("userUpdated", toUpdate);
        } else {
             request.setAttribute("userUpdated", null);
        }
        // site where the information is processed
        forwardToJsp = "/userList.jsp";

        return forwardToJsp;
    }
}
