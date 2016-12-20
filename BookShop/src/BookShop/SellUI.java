package BookShop;

public class SellUI extends UI {
	
	public SellUI(Controller controller){
		super(controller);
	}
	public void display(){
		int number = 0;
		showResult("�п�ܭn�ϥΪ��\��G");
		showResult("1.�n�����y 2.�d�ݮ��y 3.�R�����y 0.�^�W��");
		String input = getInput().trim();
		try{
			number = Integer.valueOf(input);
		}catch(NumberFormatException e){ number = 999; }
		
		if(number==1){
			showResult("�п�J�n�n�������y�W�١G");
			String pname = getInput().trim();
			controller.addProduct(pname);
		}else if(number==2){
			controller.checkProduct();
		}else if(number==3){
			controller.checkProduct();
			showResult("�п�J�n�R�������y�s��(PID)�G");
			String pid = getInput().trim();
		}else if(number==Constant.MAIN){
			controller.switchUI(number);
		}else{
			showResult("��J���~�A�Э��s��J�C");
		}
		display();
	}
}