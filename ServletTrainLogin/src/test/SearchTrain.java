package test;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.*;
@SuppressWarnings("serial")
public class SearchTrain extends GenericServlet {
	
	
	
	public Connection con;
	public void init()throws ServletException{
		con=DBConnection.getcon();
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String tno=req.getParameter("tNo");
	
		try {
			PreparedStatement ps=con.prepareStatement("select * from TrainDetails where TRAINNO=?");
			ps.setString(1,tno);
			
			ResultSet rs=ps.executeQuery();
			
				pw.println("WELCOME  train Details ");
			
						
						//+rs.getString(3));
				
				ArrayList<TrainBean> al=new ArrayList<TrainBean>();
				while(rs.next()) {
					TrainBean tb=new TrainBean();
					tb.setTNo(rs.getString(1));
					tb.setTName(rs.getString(2));
					tb.setFStation(rs.getString(3));
					tb.setTStation(rs.getString(4));
					tb.setAvl(rs.getInt(5));
					al.add(tb);
				}
				req.setAttribute("jcfref", al);
				RequestDispatcher rd=req.getRequestDispatcher("tview");
				rd.forward(req, res);
				
		}catch(Exception e) {}
		
	
	}
}
