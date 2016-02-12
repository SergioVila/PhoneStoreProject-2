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
import Commands.Account.updateLoginCommand;
import Commands.Command;
import Service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command 
{
    public String execute(HttpServletRequest request, HttpServletResponse response) 
    {
        String forwardToJsp;
        
        //The user wants to log in...
        String username = request.getParameter("username");
        char[] password = (request.getParameter("password").toCharArray());
        
        boolean pass = true;
        
        for(char item : password){
            if(Character.isDigit(item))
            {
                continue;
            }else if (Character.isLetter(item))
            {
                continue;
            }else{
                pass = false;
            }
        }
        
        if (!pass)
        {
            forwardToJsp = "/index.jsp";
        }else{
        
            //Use the UserServive class to login...
            UserService userService = new UserService();
            User userLoggingIn = userService.login(username, password);

            if (userLoggingIn != null)
            {
                //If login successful, store the session id for this client...
                HttpSession session = request.getSession();
                String clientSessionId = session.getId();
                session.setAttribute("loggedSessionId", clientSessionId);
                session.setAttribute("user", userLoggingIn);
            }else{
                new updateLoginCommand();
            }
            forwardToJsp = "/index.jsp";
        }

        return forwardToJsp;
    }
}
