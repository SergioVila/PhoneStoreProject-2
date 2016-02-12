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
public class UpdateSupplierCommand implements Command{
   
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp;

        // Getting the current session
        HttpSession session = request.getSession();
        // creating a new instance to access the database
        SupplierDao instance = new SupplierDao();
        // getting the parameters to search from the request
        Supplier toUpdate = new Supplier();
        boolean updated = false;
        
        if(request.getParameter("supplierId") != null && request.getParameter("userName") != null && request.getParameter("address") != null 
                && request.getParameter("email") != null && request.getParameter("country") != null && request.getParameter("county") != null && 
                request.getParameter("phone") != null)
        {
        toUpdate.setSupplierId(Integer.parseInt(request.getParameter("supplierId")));
        
        toUpdate.setSupplierName(request.getParameter("userName"));
        toUpdate.setAddress(request.getParameter("address"));
        toUpdate.setEmail(request.getParameter("email"));
        toUpdate.setCountry(request.getParameter("country"));
        toUpdate.setCounty(request.getParameter("county"));
        toUpdate.setPhone(request.getParameter("phone"));
        // Consulting the database
        updated = instance.updateSupplier(toUpdate);
        }
        
        

        if (updated) {
            request.setAttribute("supplierUpdated", toUpdate);
        } else {
             request.setAttribute("supplierUpdated", null);
        }
        // site where the information is processed
        forwardToJsp = "/adminController.jsp";

        return forwardToJsp;
    }
}
