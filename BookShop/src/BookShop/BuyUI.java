package BookShop;

public class BuyUI extends UI{
	
	public BuyUI(Controller controller){
		super(controller);
	}
	public void display(){
		int number = 0;
		showResult("請選擇要使用的功能：");
		showResult("1.購買書籍 2.查看訂單 3.取消訂單 0.回上頁");
		String input = getInput().trim();
		try{
			number = Integer.valueOf(input);
		}catch(NumberFormatException e){ number = 999; }
		
		if(number==1){
			controller.showProduct();
			showResult("請輸入要購買的書籍編號(PID)：");
			controller.order(getInput().trim());
		}else if(number==2){
			controller.showOrder();
		}else if(number==3){
			controller.showOrder();
			showResult("請輸入要取消的訂單編號(OID)：");
			controller.cancelOrder(getInput().trim());
		}else if(number==Constant.MAIN){
			controller.switchUI(number);
		}else{
			showResult("輸入錯誤，請重新輸入。");
		}
		display();
	}
}