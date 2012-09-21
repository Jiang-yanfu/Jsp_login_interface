package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005flogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 String type = "admin_login"; 
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/pages/../layouts/header.jsp");
    _jspx_dependants.add("/pages/../layouts/footer.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
 if(type.equals("login")){
			if(session.getAttribute("name") == null && session.getAttribute("admin_name") == null)
			{
				Cookie[] cookies = request.getCookies();
				for(Cookie each : cookies)
				{
					System.out.println("cookie: " + each.getName() + " : " + each.getValue());
					if(each.getName().equals("name"))
					{
						session.setAttribute("name", each.getValue());
						response.sendRedirect("http://localhost:8080/jsp/pages/LoggedIn.jsp");
					}
				}
			}
			else
			{
				response.sendRedirect("http://localhost:8080/jsp/pages/LoggedIn.jsp");
			}
}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");

if (type.equals("index") || type.equals("error")) {

      out.write("\r\n");
      out.write("<link href=\"styles/styles.css\" rel=\"stylesheet\" />\r\n");

			} else if (type.equals("login")
			&& request.getAttribute("error_message") == null
			|| type.equals("register")
			&& request.getAttribute("error_message") == null || type.equals("admin_login")
			&& request.getAttribute("error_message") == null) {

      out.write("\r\n");
      out.write("<link href=\"../styles/styles.css\" rel=\"stylesheet\" />\r\n");
      out.write("<script src=\"../script/script.js\"></script>\r\n");

			} else if (type.equals("login")
			&& request.getAttribute("error_message") != null
			|| type.equals("register")
			&& request.getAttribute("error_message") != null || type.equals("admin_login")
			&& request.getAttribute("error_message") != null) {

      out.write("\r\n");
      out.write("<link href=\"styles/styles.css\" rel=\"stylesheet\" />\r\n");
      out.write("<script src=\"script/script.js\"></script>\r\n");

}

      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");

if (type.equals("index")) {

      out.write("\r\n");
      out.write("<title>Welcome</title>\r\n");

} else if (type.equals("register")) {

      out.write("\r\n");
      out.write("<title>Register</title>\r\n");

} else if (type.equals("error")) {

      out.write("\r\n");
      out.write("<title>Error</title>\r\n");

} else if (type.equals("login")) {

      out.write("\r\n");
      out.write("<title>Login</title>\r\n");

}

      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"wrapper\"><header>\r\n");
      out.write("<h1>Welcome to the JSP login interface</h1>\r\n");
      out.write("</header> <nav>\r\n");
      out.write("<ul>\r\n");
      out.write("\t");

				if (type.equals("index") || type.equals("error")
				|| request.getAttribute("error_message") != null) {
	
      out.write("\r\n");
      out.write("\t<li><a href=\"pages/register.jsp\">Register</a></li>\r\n");
      out.write("\t<li><a href=\"pages/login.jsp\">Login</a></li>\r\n");
      out.write("\t<li><a href=\"pages/admin_login.jsp\">Admin</a></li>\r\n");
      out.write("\t");

	} else {
	
      out.write("\r\n");
      out.write("\t<li><a href=\"register.jsp\">Register</a></li>\r\n");
      out.write("\t<li><a href=\"login.jsp\">Login</a></li>\r\n");
      out.write("\t<li><a href=\"admin_login.jsp\">Admin</a></li>\r\n");
      out.write("\t");

	}
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</ul>\r\n");
      out.write("</nav>");
      out.write("\r\n");
      out.write("<section>\r\n");
      out.write("\t");
 if (request.getAttribute("error_message") != null) {
      out.write("\r\n");
      out.write("\t<p class=\"required\" id=\"error\">Sorry, authentication failed</p>\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("\t<form id = \"form\" method=\"post\" action = \"/jsp/AuthAdmin\">\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t<label for = \"name\">Name: </label>\r\n");
      out.write("\t\t\t<input id=\"name\" name = \"name\" type = \"text\" autofocus autocomplete required placeholder=\"your name\" />\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t<label for=\"password\">Password: </label>\r\n");
      out.write("\t\t\t<input id = \"password\" name = \"password\" type = \"password\" required placeholder = \"the length is at least 6 chars\" pattern = \"^[A-Za-z0-9]{6,}$\" />\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t\t<input type = \"submit\" id = \"submit\" name = \"submit\" value=\"login\" />\r\n");
      out.write("\t\t</form>\r\n");
      out.write("</section>\r\n");
      out.write("<footer>\r\n");
      out.write("\t&copy; Allen Liu<br />\r\n");
      out.write("\tlast update on September 21th\r\n");
      out.write("</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
