package BookShop;

public class Order{
	
	/* Variable */
	private String account = null;
	private String pid = null;	// Unique Value
	private String oid = null;	// Unique Value
	private int orderstatus = 0; //
	
	/* Constructor */
	public Order(String oid,String pid,String account){
		orderstatus = 1;
		setOid(oid);
		setPid(pid);
		setAccount(account);
	}
	private void setAccount(String account){
		this.account = account;
	}
	private void setPid(String pid){
		this.pid = pid;
	}
	private void setOid(String oid){
		this.oid = oid;
	}
	public String getAccount(){
		return new String(account);
	}
	public String getPid(){
		return new String(pid);
	}
	public String getOid(){
		return new String(oid);
	}
	public void accept(){
		orderstatus = 2;
	}
}