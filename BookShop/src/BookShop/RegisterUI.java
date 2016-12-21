package BookShop;

public class RegisterUI extends UI {
	
	public RegisterUI(Controller controller){
		super(controller);
	}
	public void display(){
		Boolean result = false;
		int number = 0;
		showResult("請選擇要使用的功能：");
		showResult("1.登入 2.註冊 3.修改聯絡資訊 0.回上頁");
		String input = getInput().trim();
		try{
			number = Integer.valueOf(input);
		}catch(NumberFormatException e){ number = 999; }
		
		if(number==1){
			showResult("請輸入帳號：");
			String account = getInput().trim();
			if(controller.checkAccount(account)){
				showResult("請輸入密碼：");
				String password = getInput().trim();
				if(!controller.login(account,password)){
					showResult("登入失敗，密碼錯誤！");
				}else{
					showResult("登入成功！");
					controller.switchUI(Constant.MAIN);
				}
			}else{ showResult("輸入的帳號不存在！"); }

		}else if(number==2){
			showResult("請輸入帳號：");
			String account = getInput().trim();
			if(!controller.checkAccount(account)){
				showResult("請輸入密碼：");
				String password = getInput().trim();
				showResult("請輸入手機號碼：");
				String phonenumber = getInput().trim();
				controller.register(account,password,phonenumber);
				showResult("註冊成功！");
			}else{ showResult("帳號已被註冊過！"); }

		}else if(number==3){
			controller.checkLogin();
			showResult("請輸入新的手機號碼：");
			String phone = getInput().trim();
			result = controller.modifyPhone(phone);
			if(result==false) showResult("修改聯絡資訊失敗，與儲存資訊相同。");
		}else if(number==Constant.MAIN){
			controller.switchUI(number);
		}else{
			showResult("輸入錯誤，請重新輸入。");
		}
		
		display();
	}
}