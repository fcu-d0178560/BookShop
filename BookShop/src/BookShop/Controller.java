package BookShop;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {
	
	SimpleDateFormat dateformat = null;
	
	private Boolean login = false;
	private UI lastUI = null;
	
	private UserDataController	user_controller		= null;
	private OrderController		order_controller	= null;
	private ProductController	product_controller	= null;
	
	public static void main(String[] args){
		
		Controller controller = new Controller();
		
		// System.out.println(controller.getTime()); Serial number test
	}
	
	public Controller(){

		dateformat = new SimpleDateFormat ("yyyyMMddHHMM");
		
		user_controller		= new UserDataController("UserData.txt",this);
		order_controller	= new OrderController("Order.txt",this);
		product_controller	= new ProductController("Product.txt",this);
		
		switchUI(Constant.MAIN);
	}
	public String getTime(){
		return new String(dateformat.format(new Date()));
	}
	public void switchUI(int UI){
		if(checkLogin()!=true && UI!=Constant.REGISTER){
			lastUI.showResult("請先進行 註冊/登入 後才能使用其他功能");
		}
		switch(UI){
			case Constant.MAIN:
				lastUI = new MainUI(this);
				break;
			case Constant.BUY:
				lastUI = new BuyUI(this);
				break;
			case Constant.SELL:
				lastUI = new SellUI(this);
				break;
			case Constant.REGISTER:
				lastUI = new RegisterUI(this);
				break;
			case Constant.CONTACTINFO:
				lastUI = new ContactInfoUI(this);
				break;
			default:
				lastUI.showResult("輸入的數字為未定義的功能，請重新輸入。");
		}
		lastUI.display();
	}
	public Boolean login(String account,String password){
		Boolean result = false;
		result = user_controller.login(account, password);
		return result;
	}
	public Boolean register(String account,String password,String phonenumber){
		Boolean result = false;
		result = user_controller.register(account, password, phonenumber);
		return result;
	}
	public Boolean checkLogin(){
		return login;
	}
	public void end(){
		user_controller.end();
		order_controller.end();
		product_controller.end();
	}
}