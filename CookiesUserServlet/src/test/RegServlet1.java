package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class RegServlet1 extends HttpServlet{
	public ServletContext sct;
	public RegServlet rb;
	public void init()throws ServletException {
		sct=this.getServletContext();
		rb=new RegServlet();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		//PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String UName=req.getParameter("UName");
		String PWord=req.getParameter("PWord");
		String FName=req.getParameter("FName");
		String LName=req.getParameter("LName");
		
		rb.setUName(UName);
		rb.setPWord(PWord);
		rb.setFName(FName);
		rb.setLName(LName);
		
		sct.setAttribute("beanRef", rb);
		
		RequestDispatcher rd=req.getRequestDispatcher("RegInput2.html");
		rd.forward(req, res);
	}

}
