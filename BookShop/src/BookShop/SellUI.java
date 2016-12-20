package BookShop;

public class SellUI extends UI {
	
	public SellUI(Controller controller){
		super(controller);
	}
	public void display(){
		int number = 0;
		showResult("請選擇要使用的功能：");
		showResult("1.登入 2.註冊 0.回上頁");
		String input = getInput().trim();
		try{
			number = Integer.valueOf(input);
		}catch(NumberFormatException e){ number = 999; }
		
		if(number==1){
			
		}else if(number==2){
			
		}else if(number==Constant.MAIN){
			controller.switchUI(number);
		}else{
			showResult("輸入錯誤，請重新輸入。");
			display();
		}
	}
}