package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class EditProfileServlet extends HttpServlet{
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
			pw.println("PLEASE LOGIN TO CONTINUE.....!");
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, res);
		}
		else {
			pw.println("WELCOME :"+ck[0].getValue()+"<br>");
			pw.println("<form action='update' method='post'><br>");
			pw.println("FIRST NAME: <input type='text' name='FName' value='"+rb.getFName()+"'><br>");
			pw.println("LAST NAME: <input type='text' name='LName' value='"+rb.getLName()+"'><br>");
			pw.println("ADDRESS: <input type='text' name='Addr' value='"+rb.getAddr()+"'><br>");
			pw.println("PHONE No: <input type='text' name='Phno' value='"+rb.getPhno()+"'><br>");
			pw.println("MAIL ID: <input type='text' name='MID' value='"+rb.getMID()+"'><br>");
			pw.println("<input type='submit' value='UPDATE'><br>");
			
		}
		
		
	}
}
