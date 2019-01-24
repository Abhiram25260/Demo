package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class ViewProfileServlet extends HttpServlet{
	public ServletContext sct;
	public RegServlet rb;
	public void init()throws ServletException {
		sct=this.getServletContext();
		rb=(RegServlet)sct.getAttribute("beanRef");
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		Cookie ck[]=req.getCookies();
		if(ck==null) {
			pw.println("PLEASE LOGIN TO CONTINUE....!");
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, res);
		}
		else {
			pw.println("Welcome :"+ck[0].getValue()+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("Link.html");
			rd.include(req, res);
			pw.println("PROFILE DETAILS");
			pw.println("<br>FIRST NAME: "+rb.getFName()+"<br>LAST NAME: "+rb.getLName()+"<br>ADDRESS: "+rb.getAddr()
														+"<br>PHONE No: "+rb.getPhno()+"<br>MAIL ID: "+rb.getMID());
		}
	}

}
