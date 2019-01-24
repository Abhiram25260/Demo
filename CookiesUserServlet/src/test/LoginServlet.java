package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	public Connection con;
	public void init()throws ServletException {
		con=DBConnection.getcon();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String UName=req.getParameter("UName");
		String PWord=req.getParameter("PWord");
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from UserDetails where UName=? and Password=?");
			ps.setString(1, UName);
			ps.setString(2, PWord);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				RegServlet rb=new RegServlet();
				rb.setUName(rs.getString(1));
				rb.setPWord(rs.getString(2));
				rb.setFName(rs.getString(3));
				rb.setLName(rs.getString(4));
				rb.setAddr(rs.getString(5));
				rb.setPhno(rs.getLong(6));
				rb.setMID(rs.getString(7));
				ServletContext sct=this.getServletContext();
				sct.setAttribute("beanRef", rb);
				Cookie ck=new Cookie("Fname",rs.getString(3));
				res.addCookie(ck);
				
				pw.println("WELCOME :"+rs.getString(3)+"<br>");
				RequestDispatcher rd=req.getRequestDispatcher("Link.html");
				rd.include(req, res);
			}
			else {
				pw.println("INVALID USER_NAME OR PASSWORD please TryAgain");
				RequestDispatcher rd=req.getRequestDispatcher("Login.html");
				rd.include(req, res);
			}
		}catch(Exception e) {}
	}
}
