package BookShop;

public class MainUI extends UI {
	
	public MainUI(Controller controller){
		super(controller);
	}
	public void display(){
		int number = 0;
		showResult("�w��ϥΤG��ѥ�y���x�A�п�J�Ʀr�i��ާ@�G");
		showResult("1.�R�� 2.��� 3.���U/�n�J 4.�d�ݥ����T");
		String input = getInput().trim();
		try{
			number = Integer.valueOf(input);
		}catch(NumberFormatException e){ number = 999; }
		controller.switchUI(number);
	}
}