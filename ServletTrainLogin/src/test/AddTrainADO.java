package test;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class AddTrainADO extends GenericServlet {
public Connection con;
@Override
public void init()throws ServletException
{
	con=DBConnection.getcon();
}
	@Override

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		try {
			
			
			
			PreparedStatement ps=con.prepareStatement("insert into TrainDetails values(?,?,?,?,?)");
			TrainBean tb=(TrainBean)req.getAttribute("beanRef");
			ps.setString(1,tb.getTNo());
			ps.setString(2,tb.getTName());
			ps.setString(3,tb.getFStation());
			ps.setString(4,tb.getTStation());
			ps.setInt(5,tb.getAvl());
			
			int k=ps.executeUpdate();
			if(k>0)
			{
				RequestDispatcher rd=req.getRequestDispatcher("Link.html");
				rd.include(req, res);
				pw.println("<br>Train Details Added Succesflly");
				
			}
		}
		catch(Exception e) {e.printStackTrace();}
		
		
	}

}
