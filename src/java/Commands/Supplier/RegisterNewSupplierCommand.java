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

/**
 *
 * @author Sergio
 */
public class RegisterNewSupplierCommand implements Command{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "";

        //Getting the supplier to be registered
        Supplier supplier = new Supplier();
        
        supplier.setSupplierName(request.getParameter("supplierName"));
        supplier.setPhone(request.getParameter("supplierPhone"));
        supplier.setEmail(request.getParameter("supplierEmail"));
        supplier.setCounty(request.getParameter("supplierCounty"));
        supplier.setCountry(request.getParameter("supplierCountry"));
        supplier.setAddress(request.getParameter("supplierAddress"));
        
        // Checking for null value
        if (supplier != null)
        {
            SupplierDao instance = new SupplierDao();
            if (instance.insertSupplier(supplier))
            {
                forwardToJsp = "adminController.jsp";
            }
            else
            {
                forwardToJsp = "addSupplier.jsp";
            }
        }
        
        return forwardToJsp ;
    }
}
