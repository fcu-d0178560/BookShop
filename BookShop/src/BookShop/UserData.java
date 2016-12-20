package BookShop;

public class UserData{
	
	/* Variable */
	private String account = null;	// Unique Value
	private String password = null;
	private String phone = null;

	/* Constructor */
	public UserData(String account,String password,String phone){
		setAccount(account);
		setPassword(password);
		setPhone(phone);
	}
	private void setAccount(String account){
		this.account = account;
	}
	private void setPassword(String password){
		this.password = password;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	private String getPassword(){
		String password = new String(this.password);
		return password;
	}
	public String getAccount(){
		String account = new String(this.account);
		return account;
	}
	public String getPhone(){
		String phone = new String(this.phone);
		return phone;
	}
	public String getUserInfo(){
		String info = getAccount()+Constant.DELIMITER+getPassword()+Constant.DELIMITER+getPhone();
		return info;
	}
	public Boolean comparePassword(String password){
		Boolean result = false;
		if(getPassword().equals(password)) result = true;
		return result;
	}
}