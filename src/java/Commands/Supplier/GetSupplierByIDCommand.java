/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.Supplier;

import Business.Supplier;
import Commands.Command;
import Daos.SupplierDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
public class GetSupplierByIDCommand implements Command{
 
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        // getting the current session
        HttpSession session = request.getSession();
        // new object to acces the database
        SupplierDao instance = new SupplierDao();
        // Getting the user stored into the session
        int id = Integer.parseInt(request.getParameter("supplier"));
        // searching for an user based on the ID
        Supplier searchById = instance.getSupplierById(id);
        // If it's not null setting boolean variable as true and setting the userfound (searchById) as an attribute
        if (searchById != null) {
            
            //session.setAttribute("loggedSessionId", clientSessionId);
            session.setAttribute("found", true);
            session.setAttribute("searchById", searchById);
        }
        // If null, setting the boolean variable as false and the user as null
        else {
            session.setAttribute("found", false);
            session.setAttribute("searchById", null);
        }

        // returning the page to forward
        return  "/supplier.jsp";
    }
}
