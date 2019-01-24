package test;
import java.io.*;
@SuppressWarnings("serial")
public class TrainBean implements Serializable{
	private String TNo,TName,FStation,TStation;
	private int avl;
	public String getTNo() {
		return TNo;
	}
	public void setTNo(String tNo) {
		TNo = tNo;
	}
	public String getTName() {
		return TName;
	}
	public void setTName(String tName) {
		TName = tName;
	}
	public String getFStation() {
		return FStation;
	}
	public void setFStation(String fStation) {
		FStation = fStation;
	}
	public String getTStation() {
		return TStation;
	}
	public void setTStation(String tStation) {
		TStation = tStation;
	}
	public int getAvl() {
		return avl;
	}
	public void setAvl(int avl) {
		this.avl = avl;
	}
	
	

}
