/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;


import Commands.Command;
import Commands.Order.*;
import Commands.OrderProduct.*;
import Commands.Product.*;
import Commands.Supplier.*;
import Commands.User.*;
import Commands.Order.GetAllOrdersDetailed;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Sergio
 */
@WebServlet(urlPatterns={"/processRequest"}) 
public class ProcessRequest extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     */
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessRequest() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
         processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        processRequest(request, response);
    }
    
    // Servlet to process the requests
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    {
        // Creating variables 
        String forwardToJsp = null;
        String action = request.getParameter("action").toLowerCase();
        Command command = null;
        // Selecting the action
        switch(action)
        {
            // User login
            case "login":
                command = new LoginCommand();
                break;	
            // Registering a new user
            case "registernewuser":
                command = new RegisterNewUserCommand();
                break;
            // Getting the list of users form the database
            case "getallusers":
                command = new GetAllUsersCommand();
                break;
            // Getting specific user by ID;
            case "getuserbyid":
                command = new GetUserByIdCommand();
                break;
            // Getting specific user by name and/or surname
            case "getuserbyname":
                command = new GetUserByNameCommand();
                break;
            // User login
            case "deleteuser":
                command = new DeleteUserCommand();
                break;	
            // Registering a new user
            case "updateuserdetails":
                command = new UpdateUserDetailsCommand();
                break;
            // Getting the list of users form the database
            case "listofusers":
                command = new UpdateUserDetailsCommand();
                break;
            // Getting specific user by ID;
            case "getallsuppliers":
                command = new GetAllSuppliersCommand();
                break;
            // Getting specific user by name and/or surname
            case "getsupplierbyid":
                command = new GetSupplierByIDCommand();
                break;
            // User login
            case "registernewsupplier":
                command = new RegisterNewSupplierCommand();
                break;	
            // Registering a new user
            case "register":
                command = new RegisterNewUserCommand();
                break;
            // Getting the list of users form the database
            case "updatesupplier":
                command = new UpdateSupplierCommand();
                break;
            // Getting specific user by ID;
            case "deleteproductbyid":
                command = new DeleteProductByIdCommand();
                break;
            // Getting specific user by name and/or surname
            case "deleteproductbyname":
                command = new DeleteProductByNameCommand();
                break;
            // User login
            case "getallproducts":
                command = new GetAllProductsCommand();
                break;	
            // Registering a new user
            case "getproductbyid":
                command = new GetProductByIdCommand();
                break;
            // Getting the list of users form the database
            case "getproductbyname":
                command = new GetProductByNameCommand();
                break;
            // Getting specific user by ID;
            case "registernewproduct":
                command = new RegisterNewProductCommand();
                break;
            // Getting specific user by name and/or surname
            case "updateproduct":
                command = new UpdateProductCommand();
                break;
            // Getting specific user by ID;
            case "deleteorderproductbyid":
                command = new DeleteOrderProductByIdCommand();
                break;
            // Getting specific user by name and/or surname
            case "getallorderproducts":
                command = new GetAllOrderProductsCommand();
                break;
            // User login
            case "getorderproductbyid":
                command = new GetOrderProductByIDCommand();
                break;	
            // Registering a new user
            case "registerneworderproduct":
                command = new RegisterNewOrderProductCommand();
                break;
            // Getting the list of users form the database
            case "updateorderproduct":
                command = new UpdateOrderProductCommand();
                break;
            // Getting specific user by ID;
            case "deleteorderbyid":
                command = new DeleteOrderByIdCommand();
                break;
            // Getting specific user by name and/or surname
            case "getallorders":
                command = new GetAllOrdersDetailed();
                break;
                // Getting specific user by ID;
            case "getorderbyid":
                command = new GetOrderByIDCommand();
                break;
            // Getting specific user by name and/or surname
            case "registerneworder":
                command = new RegisterNewOrderCommand();
                break;
            // User login
            case "updateordercommand":
                command = new UpdateOrderCommand();
                break;	
            case "getalluserstodelete":
                command =  new GetAllUsersToDeleteCommand();
                break;
            case "logout":
                command =  new LogoutCommand();
                break;
            case "getallsuppliersfordelete":
                command = new GetAllSuppliersForDeleteCommand();
                break;
            case "deletesupplierbyid":
                command = new DeleteSupplierByIdCommand();
                break;
            case "getallproductstodelete":
                command = new GetAllProductsToDeleteCommand();
                break;
            case "getallordersforedit":
                command = new GetAllOrdersCommand();
                break;
            case "getallordersfordelete":
                command = new GetAllOrdersForDeleteCommand();
                break;
            case "displayorderdetails":
                command = new displayOrderDetailsCommand();
                break;
            case "deleteordertbyid":
                command = new DeleteOrderByIdCommand();
                break;
            default:
                command = null;
                break;
        }
        
        if (command != null)
        {
            forwardToJsp = command.execute(request, response);
        }
        else
        {
            forwardToJsp = "/Error.html";
        }
        
        
        // Forwarding approach
        
        //Get the request dispatcher object and forward the request to the appropriate JSP page...
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + forwardToJsp);
        try {
            dispatcher.forward(request, response);
            
            // B) Redirecting approach:
            // response.sendRedirect(forwardToJsp);
        } catch (ServletException ex) {
            ex.printStackTrace();
            Logger.getLogger(ProcessRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProcessRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
