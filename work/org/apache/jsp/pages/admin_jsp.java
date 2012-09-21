package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 String type = "loggedIn"; 
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/pages/../layouts/header_login.jsp");
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

	System.out.println(session.getAttribute("name"));
	if(session.getAttribute("admin_name") == null){
	response.sendRedirect("http://localhost:8080/jsp/pages/admin_login.jsp");
}

      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
 if(request.getAttribute("model") != null && request.getAttribute("model").equals("yes")){
      out.write("\r\n");
      out.write("<link href = \"../jsp/styles/styles.css\" rel=\"stylesheet\" />\r\n");
      out.write("<script src =\"../jsp/script/script.js\"></script>\r\n");
 }else{
      out.write("\r\n");
      out.write("<link href = \"../styles/styles.css\" rel=\"stylesheet\" />\r\n");
      out.write("<script src =\"../script/script.js\"></script>\r\n");
} 
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
if (session.getAttribute("name") != null){ 
      out.write("\r\n");
      out.write("\t<title>Welcome, ");
      out.print( session.getAttribute("name") );
      out.write("</title>\r\n");
} 
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id= \"wrapper\">\r\n");
      out.write("<header><h1>Welcome to the JSP login interface</h1></header>\r\n");
      out.write("<nav>\r\n");
      out.write("\r\n");
      out.write("</nav>");
      out.write("\r\n");
      out.write("<section>\r\n");
      out.write("\t<p id=\"loggedIn\">Admin have logged in as ");
      out.print( session.getAttribute("name") );
      out.write("</p>\r\n");
      out.write("\t");

		ArrayList<String> users = (ArrayList<String>)request.getAttribute("users");
	
      out.write("\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<tr><th>Name</th><th>Option</th></tr>\r\n");
      out.write("\t\t");
 for(String user : users){ 
      out.write("\r\n");
      out.write("\t\t\t<tr><td>");
 out.print(user); 
      out.write("</td><td><a href = \"#\">delete?</a></td></tr>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t</table>\r\n");
      out.write("\t");
 if(request.getAttribute("model") != null && request.getAttribute("model").equals("yes")){
      out.write("\r\n");
      out.write("\t<a href=\"../jsp/Logout\">Logout</a>\r\n");
      out.write("\t");
 }else {
      out.write("\r\n");
      out.write("\t<a href=\"../Logout\">Logout</a>\r\n");
      out.write("\t");
} 
      out.write("\r\n");
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
