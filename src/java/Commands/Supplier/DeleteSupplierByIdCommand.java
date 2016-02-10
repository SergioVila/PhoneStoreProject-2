/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.Supplier;

import Commands.Command;
import Daos.SupplierDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
public class DeleteSupplierByIdCommand implements Command{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp;

        // Getting the current session
        HttpSession session = request.getSession();
        // creating a new instance to access the database
        SupplierDao instance = new SupplierDao();
        
        int supplierID = -1;
        // getting the parameters to search from the request
        try {
            supplierID = Integer.parseInt(request.getParameter("supplierID"));
        } catch (NumberFormatException e)  {
            e.printStackTrace();
        }
        // deleting the object from the database
        boolean deleted = instance.deleteSupplierById(supplierID);
        
        forwardToJsp = "/adminController.jsp";

        return forwardToJsp;
    }
}
