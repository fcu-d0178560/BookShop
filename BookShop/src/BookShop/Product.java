package BookShop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product{
	
	/* Variable */
	private String account = null; // Unique Value
	private String pid = null; // Unique Value
	private String pname = null;
	
	/* Constructor */
	public Product(String pid,String pname,String account){
		setPid(pid);
		setPname(pname);
		setAccount(account);
	}
	private void setAccount(String account){
		this.account = account;
	}
	private void setPid(String pid){
		this.pid = pid;
	}
	private void setPname(String pname){
		this.pname = pname;
	}
	public String getAccount(){
		return new String(account);
	}
	public String getPid(){
		return new String(pid);
	}
	public String getPname(){
		return new String(pname);
	}
}