package test;
import org.hibernate.*;
import org.hibernate.cfg.*;
public class HBConnection {
	public static SessionFactory sf;
	private HBConnection() {}
	static{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sf=cfg.buildSessionFactory();
	}//end of static block
	public static SessionFactory getsf(){
		return sf;
	}//static block end

}
