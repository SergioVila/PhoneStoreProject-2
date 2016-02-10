
package Commands.User;

/**
 *
 * @author Sergio
 */
import Business.User;
import Commands.Command;
import Service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command 
{
    public String execute(HttpServletRequest request, HttpServletResponse response) 
    {
        String forwardToJsp;

        //If login successful, store the session id for this client...
        HttpSession session = request.getSession();
        String clientSessionId = session.getId();
        
        if(session.getAttribute("loggedSessionId") != null)
        {
            session.invalidate();
            session = null;
        }
        
        forwardToJsp = "/index.jsp";				

        return forwardToJsp;
    }
}
