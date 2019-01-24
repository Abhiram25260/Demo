package test;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class AddTrain extends GenericServlet {
	@Override
	public void init()throws ServletException{}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String tNo=req.getParameter("tNo");
		String tName=req.getParameter("tName");
		String fStation=req.getParameter("fStation");
		String tStation=req.getParameter("tStation");
		int avl=Integer.parseInt(req.getParameter("avl"));
		pw.println(tName);
		
		TrainBean tb=new TrainBean();
		tb.setTNo(tNo);
		tb.setTName(tName);
		tb.setFStation(fStation);
		tb.setTStation(tStation);
		tb.setAvl(avl);
		req.setAttribute("beanRef", tb);
		RequestDispatcher rd=req.getRequestDispatcher("AddTrainADO");
		rd.forward(req, res);
		
		
		
	}

}
