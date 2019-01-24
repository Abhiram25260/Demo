package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class DisServlet extends GenericServlet{
	public void init()throws ServletException{
		
	}
	@SuppressWarnings("unchecked")
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		RequestDispatcher rd=req.getRequestDispatcher("Link.html");
		rd.include(req, res);
		ArrayList<TrainBean> al=(ArrayList<TrainBean>)req.getAttribute("jcfref");
		pw.println("TRAIN DETAILS");
		al.forEach((k)->
		{
			pw.println("<br>"+k.getTNo()+"&nbsp"+k.getTName()+"&nbsp"+k.getFStation()+"&nbsp"+k.getTStation()+"&nbsp"+k.getAvl());
		});
	}

}
