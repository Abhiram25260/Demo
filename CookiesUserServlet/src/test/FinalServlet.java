package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class FinalServlet extends HttpServlet{
	public RegServlet rb;
	public ServletContext sct;
	public Connection con;
	public void init()throws ServletException {
		sct=this.getServletContext();
		rb=(RegServlet)sct.getAttribute("beanRef");
		con=DBConnection.getcon();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		try {
			PreparedStatement ps=con.prepareStatement("insert into UserDetails values(?,?,?,?,?,?,?)");
			ps.setString(1, rb.getUName());
			ps.setString(2, rb.getPWord());
			ps.setString(3, rb.getFName());
			ps.setString(4, rb.getLName());
			ps.setString(5, rb.getAddr());
			ps.setLong(6, rb.getPhno());
			ps.setString(7, rb.getMID());
			
			int k=ps.executeUpdate();
			if(k>0) {
				pw.println("USER REGISTERED SUCESSFULLY-------!");
				
				RequestDispatcher rd=req.getRequestDispatcher("Login.html");
				rd.include(req, res);
			}
		}catch(Exception e) {}
	}

}
