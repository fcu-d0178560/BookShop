package BookShop;

public class MainUI extends UI {
	
	Controller controller = null;
	
	public MainUI(Controller controller){
		this.controller = controller;
	}
	public void display(){
		System.out.println("�w��ϥΤG��ѥ�y���x�A�п�J�Ʀr�i��ާ@");
		System.out.println("1.�R�� 2.��� 3.���U/�n�J 4.�ק��p����T");
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