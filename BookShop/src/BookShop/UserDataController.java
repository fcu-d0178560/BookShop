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
	}
	public Boolean login (String account,String password){ // need account and password to login
		Boolean result = false;
		for(int i=0;i<user.size();i++){
			if(user.get(i).getAccount().equals(account)){
				if(user.get(i).comparePassword(password)){
					// login success
				}
			}
		}
		return result;
	}
	public Boolean register (String account,String password,String phonenumber){ // need account and password to register an user data
		Boolean result = false;
		for(int i=0;i<user.size();i++){ // check if the account is used
			if(user.get(i).getAccount().equals(account)){
				return result;
			}
		}
		user.add(new UserData(account,password,phonenumber));
		result = true;
		return result;
	}
	public Boolean modify (String account,String phonenumber){ // modify User contact info
		Boolean result = true;
		for(int i=0;i<user.size();i++){
			if(user.get(i).getAccount().equals(account)){
				user.get(i).setPhone(phonenumber);
				return result;
			}
		}
		result = false;
		return result;
	}
	private void loadUser(){ // load User data from last status 
		String line = handler.readLine();
		while(line!=null){
			StringTokenizer token = new StringTokenizer(line,Constant.DELIMITER);
			String account = token.nextToken();
			String password = token.nextToken();
			String phone = token.nextToken().trim();
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