package test;
import org.hibernate.*;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	public SessionFactory sf;
	public ServletContext sct;
	public void init()throws ServletException {
		sf=HBConnection.getsf();
		sct=this.getServletContext();
	}
	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String UName=req.getParameter("UName");
		String PWord=req.getParameter("PWord");
		
		Session ses=sf.openSession();
		Query q=ses.createQuery("from RegServlet rb where rb.UName=:un and rb.PWord=:pw");
		q.setParameter("un", UName);
		q.setParameter("pw", PWord);
		List l=q.list();
			if(l.size()==0) {
				pw.println("INVALID USER_NAME OR PASSWORD please TryAgain");
				RequestDispatcher rd=req.getRequestDispatcher("Login.html");
				rd.include(req, res);
			}
			else {
				l.forEach((k)->
				{
					RegServlet rb=(RegServlet)k;
					rb.getFName();
					rb.getLName();
					rb.getAddr();
					rb.getPhno();
					rb.getMID();
					rb.getUName();
					rb.getPWord();
					sct.setAttribute("beanRef", rb);
					Cookie ck=new Cookie("FName", rb.getFName());
					res.addCookie(ck);
					RequestDispatcher rd=req.getRequestDispatcher("Link.html");
					try {
						rd.include(req, res);
					} catch (ServletException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
			}
		ses.close();
	}
}
