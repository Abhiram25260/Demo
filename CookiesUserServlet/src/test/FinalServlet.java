package test;
import org.hibernate.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class FinalServlet extends HttpServlet{
	public RegServlet rb;
	public ServletContext sct;
	public SessionFactory sf;
	public void init()throws ServletException {
		sct=this.getServletContext();
		rb=(RegServlet)sct.getAttribute("beanRef");
		sf=HBConnection.getsf();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Session ses=sf.openSession();
		Transaction t=ses.beginTransaction();
		ses.save(rb);
		t.commit();
		ses.close();
		pw.println("USER REGISTERED SUCESSFULLY-------!");
		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		rd.include(req, res);
		
		
	}

}
