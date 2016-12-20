package BookShop;

public class SellUI extends UI {
	
	public SellUI(Controller controller){
		super(controller);
	}
	public void display(){
		int number = 0;
		showResult("�п�ܭn�ϥΪ��\��G");
		showResult("1.�n�J 2.���U 0.�^�W��");
		String input = getInput().trim();
		try{
			number = Integer.valueOf(input);
		}catch(NumberFormatException e){ number = 999; }
		
		if(number==1){
			
		}else if(number==2){
			
		}else if(number==Constant.MAIN){
			controller.switchUI(number);
		}else{
			showResult("��J���~�A�Э��s��J�C");
			display();
		}
	}
}