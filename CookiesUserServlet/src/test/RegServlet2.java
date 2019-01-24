package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class RegServlet2 extends HttpServlet{
	public ServletContext sct;
	public RegServlet rb;
	public void init()throws ServletException {
		sct=this.getServletContext();
		rb=(RegServlet)sct.getAttribute("beanRef");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String Addr=req.getParameter("Addr");
		Long Phno=Long.parseLong(req.getParameter("Phno"));
		String MID=req.getParameter("MID");
		
		rb.setAddr(Addr);
		rb.setPhno(Phno);
		rb.setMID(MID);
		
		pw.println("REGISTRATION DETAILS ARE VALID");
		pw.println("<br>TO VIEW DETAILS ");
		pw.println("<a href='view'>CLICK HERE</a>");
	}

}
