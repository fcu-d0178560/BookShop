package BookShop;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class UserDataController {
	
	private Controller controller = null;
	private ArrayList<UserData> user = new ArrayList<UserData>();
	private UserDataHandler handler = null;
	
	public UserDataController(String filename,Controller controller){
		this.controller = controller;
		handler = new UserDataHandler(filename);
		loadUser();
	}
	public Boolean login (String account,String password){ // need account and password to login
		Boolean result = false;
		//System.out.println("開始驗證密碼："+user.size()); // Login Test
		for(int i=0;i<user.size();i++){
			//System.out.println("開始驗證密碼："+user.get(i).getAccount()); // Login Test
			if(user.get(i).getAccount().equals(account)){
				if(user.get(i).comparePassword(password)){
					result = true;
					break;
				}
			}
		}
		return result;
	}
	public void register(String account,String password,String phonenumber){ // need account and password to register an user data
		user.add(new UserData(account,password,phonenumber));
	}
	public Boolean checkAccount(String account){
		Boolean result = false;
		for(int i=0;i<user.size();i++){ // check if the account is used
			if(user.get(i).getAccount().equals(account)){
				result = true;
				break;
			}
		}
		return result;
	}
	public Boolean modifyPhone (String account,String phonenumber){ // modify User contact info
		Boolean result = true;
		for(int i=0;i<user.size();i++){
			if(user.get(i).getAccount().equals(account)){
				if(!user.get(i).getPhone().equals(phonenumber)){
					user.get(i).setPhone(phonenumber);
					return result;
				}
				break;
			}
		}
		result = false;
		return result;
	}
	private void loadUser(){ // load User data from last status 
		String line = handler.readLine();
		//System.out.println("載入資料："+line); // Load Test
		while(line!=null){
			StringTokenizer token = new StringTokenizer(line,Constant.DELIMITER);
			String account = token.nextToken().trim();
			String password = token.nextToken().trim();
			String phone = token.nextToken().trim();
			//System.out.println("Token："+account+","+password+","+phone); // Load Test
			user.add(new UserData(account,password,phone));
			line = handler.readLine();
		}
	}
	private void saveUser(){ // save User data to last status
		String file = "";
		for(int i=0;i<user.size();i++){
			String info = user.get(i).getUserInfo();
			String line = info+"\n";
			file += line;
		}
		handler.writeFile(file);
	}
	public UserData getUser(String account){ // get target User by account
		UserData target = null;
		for(int i=0;i<user.size();i++){
			if(user.get(i).getAccount().equals(account)){
				target = user.get(i);
				break;
			}
		}
		return target;
	}
	public void end(){
		saveUser();
	}
}