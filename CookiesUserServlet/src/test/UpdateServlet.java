package test;
import java.io.*;
import org.hibernate.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class UpdateServlet extends HttpServlet{
	public SessionFactory sf;
	public RegServlet rb;
	public ServletContext sct;
	public void init()throws ServletException {
		sf=HBConnection.getsf();
		sct=this.getServletContext();
		rb=(RegServlet)sct.getAttribute("beanRef");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		Cookie ck[]=req.getCookies();
		if(ck==null) {
			pw.println("PLEASE LOGIN TO CONTINUE.........!");
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, res);
		}else {
			String FName=req.getParameter("FName");
			String LName=req.getParameter("LName");
			String Addr=req.getParameter("Addr");
			Long Phno=Long.parseLong(req.getParameter("Phno"));
			String MID=req.getParameter("MID");
			
			rb.setFName(FName);
			rb.setLName(LName);
			rb.setAddr(Addr);
			rb.setPhno(Phno);
			rb.setMID(MID);
			
			Session ses=sf.openSession();
			Transaction t=ses.beginTransaction();
			ses.save(rb);
			t.commit();
			ses.close();
			RequestDispatcher rd=req.getRequestDispatcher("Link.html");
			rd.include(req, res);
			pw.println("<br>UPDATED SUCCESSFULLY");
			
			
			
		}
	}

}
