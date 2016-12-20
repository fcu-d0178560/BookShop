package BookShop;

public class MainUI extends UI {
	
	Controller controller = null;
	
	public MainUI(Controller controller){
		this.controller = controller;
	}
	public void display(){
		System.out.println("歡迎使用二手書交流平台，請輸入數字進行操作");
		System.out.println("1.買書 2.賣書 3.註冊/登入 4.修改聯絡資訊");
		int input = Integer.parseInt(getInput().trim());
		controller.switchUI(input);
	}
	public String getInput(){
		String input = null;
		return input;
	}
	public void showResult(String result){
		
	}
}