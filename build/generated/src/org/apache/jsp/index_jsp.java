package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Business.User;
import Service.UserService;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en-US\">\n");
      out.write("    <head><!--Links calling on the different bootstrap packages and css file -->\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\">\n");
      out.write("        <title>PHONES R US</title>\n");
      out.write("\n");
      out.write("        <!-- favicons are otherwise known as shortcut icons -->\n");
      out.write("        <link rel=\"shortcut icon\" href=\"http://teamtreehouse.com/assets/favicon.ico\">\n");
      out.write("        <link rel=\"icon\" href=\"http://teamtreehouse.com/assets/favicon.ico\">\n");
      out.write("\n");
      out.write("        <!-- These three lines call on the three css files stored in the css folder of the project -->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"css/bootstrap-responsive.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"css/global.css\">\n");
      out.write("\n");
      out.write("        <!-- This imports the jquery file that eases our use of javascript, the min jquery file is used as it removes all unnecessary characters-->\n");
      out.write("        <script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css\">\n");
      out.write("        <script type=\"text/javascript\" language=\"javascript\" charset=\"utf-8\" src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav id=\"navigation\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <ul class=\"navlinks\">\n");
      out.write("                    <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                    <li><a href=\"processRequest?action=getAllProducts\">Phone Store</a></li>\n");
      out.write("                    <li><a href=\"about.jsp\">About us</a></li>\n");
      out.write("                    <li><a href=\"contacts.jsp\">Contacts</a></li>\n");
      out.write("                    <li style=\"float: right;list-style-type: none\">\n");
      out.write("                        ");

                            User user = (User) session.getAttribute("user");
                            
                            if (session.getAttribute("loggedSessionId") != null && session.getAttribute("user") != null) {
                        
                                out.println("<a href='processRequest?action=logout'> Log out</a><a>\tHello " + user.getfName() + "</a>");

                            } else {
                        
      out.write("\n");
      out.write("                        <a id=\"modal_trigger\" href=\"#myPopupOrder\" data-rel=\"popup\">Click here to Login or register</a>\n");
      out.write("\n");
      out.write("                        <!--    popup appears once login is selected     -->\n");
      out.write("                        <div data-role=\"popup\" id=\"myPopupOrder\" class=\"ui-content\" style=\"min-width:250px;\">\n");
      out.write("                            <form method=\"post\" action=\"processRequest\">\n");
      out.write("                                <h3>Login information</h3>\n");
      out.write("                                <br>\n");
      out.write("                                <br>\n");
      out.write("                                <div>\n");
      out.write("                                    <input type=\"text\" name=\"username\" placeholder=\"Username/Email\">\n");
      out.write("\n");
      out.write("                                    <input type=\"password\" name=\"password\" placeholder=\"Password\">\n");
      out.write("\n");
      out.write("                                    <input type=\"hidden\" value =\"Login\" name =\"action\">\n");
      out.write("                                    <input type=\"submit\" data-inline=\"true\" value=\"Login\" name=\"login\">\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                            <div>\n");
      out.write("                                <a href = \"register.jsp\"><input type=\"submit\" data-inline=\"true\" value=\"Register\"></a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        \n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <header id=\"heading\">\n");
      out.write("            <div class=\"container text-center\">\n");
      out.write("                <br>\n");
      out.write("                <h1>PHONES R US</h1>\n");
      out.write("\n");
      out.write("                <p><a href=\"processRequest?action=getAllProducts\" class=\"btn btn-large\"><strong>SHOP NOW</strong></a></p>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <div id=\"main-content\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"span4\">\n");
      out.write("                        <h2>The Team</h2>\n");
      out.write("                        <p>Say Hi to Niall, Sergio or Brian and ask questions about our products simply by emailing us.</p>\n");
      out.write("                        <p class=\"text-center\"><a class=\"btn\" href=\"contacts.jsp\">Read more</a></p>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"span4\">\n");
      out.write("                        <h2>Our Products</h2>\n");
      out.write("                        <p>We supply a wide range of phones ranging from iPhones to Android.\n");
      out.write("                            We pride ourselves on high quality merchandise and support.</p>\n");
      out.write("                        <p class=\"text-center\">\n");
      out.write("                            <a class=\"btn\" href=\"phoneStore.jsp\">\n");
      out.write("                                Contact us</a></p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"span4\">\n");
      out.write("                        <h2>Networks</h2>\n");
      out.write("                        <p>We currently are in dealership with Three mobile who supply many brilliant plans for mobiles of all makes as well as supplying modems</p>\n");
      out.write("                        <p class=\"text-center\"><a class=\"btn\" href=\"http://www.three.ie/\"><strong>TAKE ME THERE</strong></a></p>\n");
      out.write("                    </div>\n");
      out.write("                </div><!-- @end .row -->\n");
      out.write("                <form action=\"processRequest\" method=\"post\">\n");
      out.write("                    <div class=\"row-fluid\">\n");
      out.write("                        <ul class=\"thumbnails\">\n");
      out.write("                            <li class=\"span4\">\n");
      out.write("                                <a href=\"\" class=\"thumbnail\" target=\"Apple\" name=\"Apple\">\n");
      out.write("                                    <img src=\"images/phones/appleBrand.jpg\" alt=\"Apple Phones\">\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"span4\">\n");
      out.write("                                <a href=\"\" class=\"thumbnail\" target=\"HTC\" name=\"htc\">\n");
      out.write("                                    <img src=\"images/phones/htcBrand.jpg\" alt=\"HTC Phones\">\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"span4\">\n");
      out.write("                                <a href=\"\" class=\"thumbnail\" target=\"Nokia\" name=\"nokia\">\n");
      out.write("                                    <img src=\"images/phones/nokiaBrand.jpg\" alt=\"Nokia Phones\">\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div><!-- @end .row-fluid -->\n");
      out.write("\n");
      out.write("                    <div class=\"row-fluid\">\n");
      out.write("                        <ul class=\"thumbnails\">\n");
      out.write("\n");
      out.write("                            <li class=\"span4\">\n");
      out.write("                                <a href=\"\" class=\"thumbnail\" target=\"Samsung\" name = \"samsung\">\n");
      out.write("                                    <img src=\"images/phones/samsungBrand.png\" alt=\"Samsung Phones\">\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"span4\">\n");
      out.write("                                <a href=\"\" class=\"thumbnail\" target=\"Sony\" name=\"sony\">\n");
      out.write("                                    <img src=\"images/phones/sonyBrand.jpg\" alt=\"Sony Phones\">\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"span4\">\n");
      out.write("                                <a href=\"\" class=\"thumbnail\" target=\"Lucky\" name=\"other\">\n");
      out.write("                                    <img src=\"images/phones/lucky.jpg\" alt=\"Other brands\">\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div><!-- @end .row-fluid -->\n");
      out.write("                </form>\n");
      out.write("            </div><!-- @end .container -->\n");
      out.write("        </div><!-- @end #main-content -->\n");
      out.write("        <div id=\"footer\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <p>Please feel free to <a href=\"contacts.jsp\">Email</a> us</p>\n");
      out.write("                <p><a href=\"http://latch.elevenpaths.com\" target=\"_blank\"><img src=\"img/latch_logo.png\" width=\"150\" alt=\"http://latch.elevenpaths.com\" ></a></p>\n");
      out.write("                <p>\n");
      out.write("                    <small>Follow us on twitter: \n");
      out.write("                        <a href=\"<a href=https://twitter.com/NiallMulready\" \n");
      out.write("                           class=\"twitter-follow-button\" \n");
      out.write("                           data-show-count=\"false\" data-size=\"large\" \n");
      out.write("                           data-show-screen-name=\"false\">Follow @NiallMulready</a>\n");
      out.write("                        <script>!function (d, s, id) {\n");
      out.write("                                var js, fjs = d.getElementsByTagName(s)[0],\n");
      out.write("                                        p = /^http:/.test(d.location) ? 'http' : 'https';\n");
      out.write("                                if (!d.getElementById(id))\n");
      out.write("                                {\n");
      out.write("                                    js = d.createElement(s);\n");
      out.write("                                    js.id = id;\n");
      out.write("                                    js.src = p + '://platform.twitter.com/widgets.js';\n");
      out.write("                                    fjs.parentNode.insertBefore(js, fjs);\n");
      out.write("                                }\n");
      out.write("                            }(document, 'script', 'twitter-wjs');\n");
      out.write("                            </script>\n");
      out.write("                    </small>\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
