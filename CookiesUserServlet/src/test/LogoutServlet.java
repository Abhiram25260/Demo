package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		Cookie ck[]=req.getCookies();
		ck[0].setValue("");
		res.addCookie(ck[0]);
		pw.println("LOGGED OUT SUCCESSFULLY.......!");
		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		rd.include(req, res);
	}

}
