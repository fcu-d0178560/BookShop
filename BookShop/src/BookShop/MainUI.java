package BookShop;

public class MainUI extends UI {
	
	public MainUI(Controller controller){
		super(controller);
	}
	public void display(){
		int number = 0;
		showResult("歡迎使用二手書交流平台，請輸入數字進行操作：");
		showResult("1.買書 2.賣書 3.註冊/登入 4.查看交易資訊");
		String input = getInput().trim();
		try{
			number = Integer.valueOf(input);
		}catch(NumberFormatException e){ number = 999; }
		controller.switchUI(number);
	}
}