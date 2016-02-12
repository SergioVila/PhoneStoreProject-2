/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.Account;

import Business.User;
import Commands.Command;
import Daos.AccountDao;
import Service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
public class updateLoginCommand {

    public class LoginCommand implements Command {

        public String execute(HttpServletRequest request, HttpServletResponse response) {
            String forwardToJsp;
            //If login successful, store the session id for this client...
            HttpSession session = request.getSession();

            // Account dao not implemented yet
            AccountDao instance = new AccountDao();
            
            instance.update();

            forwardToJsp = "/index.jsp";
            
            return forwardToJsp;
        }
    }
}
