package BookShop;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {
	
	private SimpleDateFormat dateformat = null;
	private String account = null;
	
	private UI lastUI = null;
	
	private UserDataController	user_controller		= null;
	private OrderController		order_controller	= null;
	private ProductController	product_controller	= null;
	
	public static void main(String[] args){
		
		Controller controller = new Controller();
		
		// System.out.println(controller.getTime()); Serial number test
	}
	
	public Controller(){

		dateformat = new SimpleDateFormat ("MMddmm");
		
		user_controller		= new UserDataController("UserData.txt",this);
		order_controller	= new OrderController("Order.txt",this);
		product_controller	= new ProductController("Product.txt",this);
		
		switchUI(Constant.MAIN);
	}
	public String getTime(){
		return new String(dateformat.format(new Date()));
	}
	public void switchUI(int UI){
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
				lastUI = new OrderUI(this);
				break;
			case Constant.END:
				end();
			default:
				lastUI.showResult("輸入的數字為未定義的功能，請重新輸入。");
		}
		lastUI.display();
	}
	public String getPname(String pid){
		String product = null;
		product = product_controller.getProduct(pid).getPname();
		return product;
	}
	public String getPhone(String account){
		String phone = null;
		phone = user_controller.getUser(account).getPhone();
		return phone;
	}
	public void showResult(String result){
		lastUI.showResult(result);
	}
	public void showOrder(){
		order_controller.showOrder(account);
	}
	public void checkPid(){
		product_controller.checkOrder(account);
	}
	public void checkOrder(String pid){
		order_controller.checkOrder(pid);
	}
	public void acceptOrder(String oid){
		Order order = order_controller.getOrder(oid);
		if(order!=null){
			order_controller.acceptOrder(oid);
		}else{
			lastUI.showResult("欲接受的訂單編號不存在！");
		}
	}
	public void checkAcceptOrder(){
		order_controller.checkAcceptOrder(account);
	}
	public void order(String pid){
		Product product = product_controller.getProduct(pid);
		if(product!=null){
			order_controller.order(account, pid);
		}else{
			lastUI.showResult("欲購買的書籍編號不存在！");
		}
	}
	public void cancelOrder(String oid){
		Order order = order_controller.getOrder(oid);
		if(order!=null) order_controller.cancelOrder(oid);
		else lastUI.showResult("欲取消的訂單編號不存在！");
	}
	public int showProduct(){
		return product_controller.showProduct();
	}
	public void addProduct(String pname){
		product_controller.addProduct(account, pname);
	}
	public void deleteProduct(String pid){
		Product product = product_controller.getProduct(pid);
		if(product!=null) product_controller.deleteProduct(pid);
		else lastUI.showResult("欲刪除的書籍不存在！");
	}
	public int checkProduct(){
		return product_controller.checkProduct(account);
	}

	public Boolean checkAccount(String account){
		Boolean result = user_controller.checkAccount(account);
		return result;
	}
	public Boolean login(String account,String password){
		Boolean result = user_controller.login(account, password);
		if(result==true) this.account = account;
		return result;
	}
	public void register(String account,String password,String phonenumber){
		user_controller.register(account, password, phonenumber);
	}
	public Boolean modifyPhone(String phonenumber){
		return user_controller.modifyPhone(account,phonenumber);
	}
	public void checkLogin(){
		if(account==null){
			lastUI.showResult("請先進行  註冊/登入  後才能使用其他功能！");
			switchUI(Constant.REGISTER);
		}
	}
	public void end(){
		user_controller.end();
		order_controller.end();
		product_controller.end();
		System.exit(0);
	}
}