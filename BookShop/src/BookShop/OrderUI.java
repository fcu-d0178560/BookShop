package BookShop;

public class OrderUI extends UI {
	
	public OrderUI(Controller controller){
		super(controller);
	}
	public void display(){
		int number = 0;
		showResult("請選擇要使用的功能：");
		showResult("1.查看交易資訊 2.查看訂單 3.接受訂單 0.回上頁");
		String input = getInput().trim();
		try{
			number = Integer.valueOf(input);
		}catch(NumberFormatException e){ number = 999; }
		
		if(number==1){
			controller.checkLogin();
			controller.checkAcceptOrder();
		}else if(number==2){
			controller.checkLogin();
			controller.checkPid();
		}else if(number==3){
			controller.checkLogin();
			controller.checkPid();
			showResult("請輸入要接受的訂單編號：");
			String oid = getInput().trim();
			controller.acceptOrder(oid);
		}else if(number==4){
			controller.end();
		}else if(number==Constant.MAIN){
			controller.checkLogin();
			controller.switchUI(number);
		}else{
			showResult("輸入錯誤，請重新輸入。");
		}
		
		display();
	}
}