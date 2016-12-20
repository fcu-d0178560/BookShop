package BookShop;

public class SellUI extends UI {
	
	public SellUI(Controller controller){
		super(controller);
	}
	public void display(){
		int number = 0;
		showResult("請選擇要使用的功能：");
		showResult("1.登錄書籍 2.查看書籍 3.刪除書籍 0.回上頁");
		String input = getInput().trim();
		try{
			number = Integer.valueOf(input);
		}catch(NumberFormatException e){ number = 999; }
		
		if(number==1){
			showResult("請輸入要登錄的書籍名稱：");
			String pname = getInput().trim();
			controller.addProduct(pname);
		}else if(number==2){
			controller.checkProduct();
		}else if(number==3){
			controller.checkProduct();
			showResult("請輸入要刪除的書籍編號(PID)：");
			String pid = getInput().trim();
		}else if(number==Constant.MAIN){
			controller.switchUI(number);
		}else{
			showResult("輸入錯誤，請重新輸入。");
		}
		display();
	}
}