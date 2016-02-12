package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Business.User;

public final class about_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--\r\n");
      out.write("To change this license header, choose License Headers in Project Properties.\r\n");
      out.write("To change this template file, choose Tools | Templates\r\n");
      out.write("and open the template in the editor.\r\n");
      out.write("-->\r\n");
      out.write("<html>\r\n");
      out.write("    <head><!--Links calling on the different bootstrap packages and css file -->\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\">\r\n");
      out.write("        <title>PHONES R US</title>\r\n");
      out.write("\r\n");
      out.write("        <!-- favicons are otherwise known as shortcut icons -->\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"http://teamtreehouse.com/assets/favicon.ico\">\r\n");
      out.write("        <link rel=\"icon\" href=\"http://teamtreehouse.com/assets/favicon.ico\">\r\n");
      out.write("\r\n");
      out.write("        <!-- These three lines call on the three css files stored in the css folder of the project -->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"css/bootstrap-responsive.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"css/global.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- This imports the jquery file that eases our use of javascript, the min jquery file is used as it removes all unnecessary characters-->\r\n");
      out.write("        <script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js\"></script>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css\">\r\n");
      out.write("        <script type=\"text/javascript\" language=\"javascript\" charset=\"utf-8\" src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <nav id=\"navigation\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <ul class=\"navlinks\">\r\n");
      out.write("                    <li><a href=\"index.jsp\">Home</a></li>\r\n");
      out.write("                    <li><a href=\"processRequest?action=getAllProducts\">Phone Store</a></li>\r\n");
      out.write("                    <li><a href=\"about.jsp\">About us</a></li>\r\n");
      out.write("                    <li><a href=\"contacts.jsp\">Contacts</a></li>\r\n");
      out.write("                    <li style=\"float: right;list-style-type: none\">\r\n");
      out.write("                        ");

                            User user = (User) session.getAttribute("user");
                            if (session.getAttribute("loggedSessionId") != null && session.getAttribute("user") != null) {
                       
                               out.println("<a href='processRequest?action=logout'> Log out</a><a>\tHello " + user.getfName() + "</a>");

                            } else {
                        
      out.write("\r\n");
      out.write("                        <a id=\"modal_trigger\" href=\"#myPopupAbout\" data-rel=\"popup\">Click here to Login or register</a>\r\n");
      out.write("\r\n");
      out.write("                        <!--    popup appears once login is selected     -->\r\n");
      out.write("                        <div data-role=\"popup\" id=\"myPopupAbout\" class=\"ui-content\" style=\"min-width:250px;\">\r\n");
      out.write("                            <form method=\"post\" action=\"processRequest\">\r\n");
      out.write("                                <h3>Login information</h3>\r\n");
      out.write("                                <br>\r\n");
      out.write("                                <br>\r\n");
      out.write("                                <div>\r\n");
      out.write("                                    <input type=\"text\" name=\"username\" placeholder=\"Username/Email\">\r\n");
      out.write("\r\n");
      out.write("                                    <input type=\"password\" name=\"password\" placeholder=\"Password\">\r\n");
      out.write("\r\n");
      out.write("                                    <input type=\"hidden\" value =\"Login\" name =\"action\">\r\n");
      out.write("                                    <input type=\"submit\" data-inline=\"true\" value=\"Login\" name=\"login\">\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <a href = \"register.jsp\"><input type=\"submit\" data-inline=\"true\" value=\"Register\"></a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");

                            }
                        
      out.write("\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                    ");

                        if (user != null && user.getIsIsAdmin() == true) {
                    
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                    <li><a href=\"processRequest?action=getAllOrders\">Orders</a></li>\r\n");
      out.write("                    <li><a href=\"adminController.jsp\">Admin Panel</a></li>\r\n");
      out.write("                    <li><a href=\"cart.jsp\">Cart</a></li>\r\n");
      out.write("                        ");

                            }
                        else if(user != null && user.getIsIsAdmin() != true)
                            {             
                        
      out.write("\r\n");
      out.write("                    <li><a href=\"processRequest?action=getAllOrders\">Orders</a></li>\r\n");
      out.write("                    <li><a href=\"cart.jsp\">Cart</a></li>\r\n");
      out.write("                        ");
    }
                        
      out.write("\r\n");
      out.write("                    <li><a href=\"legal.jsp\">Legal</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        <header id=\"heading\">\r\n");
      out.write("            <div class=\"container text-center\">\r\n");
      out.write("                <br>\r\n");
      out.write("                <h1>PHONES R US</h1>\r\n");
      out.write("\r\n");
      out.write("                <p><a href=\"phoneStore.html\" class=\"btn btn-large\"><strong>SHOP NOW</strong></a></p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
      out.write("         <div id=\"main-content\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row-fluid\">\r\n");
      out.write("                    <ul class=\"thumbnails\">\r\n");
      out.write("\r\n");
      out.write("                        <li class=\"span4\">\r\n");
      out.write("                            <a href=\"\" class=\"thumbnail\" target=\"Serg\">\r\n");
      out.write("                                <img src=\"images/Developers/serg.jpg\" alt=\"Serg\">\r\n");
      out.write("                                <h3><span>This is Sergio</span></h3>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"span4\">\r\n");
      out.write("                            <a href=\"\" class=\"thumnail\" target=\"Brian\">\r\n");
      out.write("                                <img src=\"images/Developers/brian.jpg\" alt=\"Brian\">\r\n");
      out.write("                                <h3><span>This is Brian</span></h3>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"span4\">\r\n");
      out.write("                            <a href=\"\" class=\"thumbnail\" target=\"Niall\">\r\n");
      out.write("                                <img src=\"images/Developers/niall.jpg\" alt=\"Niall\">\r\n");
      out.write("                                <h3><span>This is Niall</span></h3>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div><!-- @end .row-fluid -->\r\n");
      out.write("            </div><!-- @end .container -->\r\n");
      out.write("        </div><!-- @end #main-content -->\r\n");
      out.write("    </body>\r\n");
      out.write("    \r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
