package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class UpdateServlet extends HttpServlet{
	public Connection con;
	public RegServlet rb;
	public ServletContext sct;
	public void init()throws ServletException {
		con=DBConnection.getcon();
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
			
			try {
				PreparedStatement ps=con.prepareStatement("update UserDetails set FName=?,LName=?,Addr=?,Phno=?,MID=? where UName=? and Password=?");
				ps.setString(1, FName);
				ps.setString(2, LName);
				ps.setString(3, Addr);
				ps.setLong(4, Phno);
				ps.setString(5, MID);
				ps.setString(6, rb.getUName());
				ps.setString(7, rb.getPWord());
				
				int k=ps.executeUpdate();
				
				if(k>0) {
					pw.println("<br>WELCOME :"+ck[0].getValue());
					RequestDispatcher rd=req.getRequestDispatcher("Link.html");
					rd.include(req, res);
					pw.println("<br>UPDATED SUCCESSFULLY");
				}
			}catch(Exception e) {}
			
		}
	}

}
