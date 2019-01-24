package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class ViewServlet extends HttpServlet{
	public ServletContext sct;
	public RegServlet rb;
	public void init()throws ServletException {
		sct=this.getServletContext();
		rb=(RegServlet)sct.getAttribute("beanRef");
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		pw.println("-----------REGISTRATION DETAILS-------------------");
		pw.println("<br>USER NAME:"+rb.getUName());
		pw.println("<br>PASSWORD:"+rb.getPWord());
		pw.println("<br>FIRST NAME:"+rb.getFName());
		pw.println("<br>LAST NAME:"+rb.getLName());
		pw.println("<br>ADDRESS:"+rb.getAddr());
		pw.println("<br>PHONE NO:"+rb.getPhno());
		pw.println("<br>MAIL ID:"+rb.getMID());
		
		pw.println("<br><br><form action='final' method='post'>");
		pw.println("<br><input type='submit' value='REGISTER'>");
		pw.println("<br></form>");
	}

}
