package BookShop;

public class OrderUI extends UI {
	
	public OrderUI(Controller controller){
		super(controller);
	}
	public void display(){
		int number = 0;
		showResult("�п�ܭn�ϥΪ��\��G");
		showResult("1.�d�ݥ����T 2.�d�ݭq�� 3.�����q�� 0.�^�W��");
		String input = getInput().trim();
		try{
			number = Integer.valueOf(input);
		}catch(NumberFormatException e){ number = 999; }
		
		if(number==1){
			controller.checkLogin();
			controller.checkAcceptOrder();
		}else if(number==2){
			controller.checkLogin();
			controller.checkPid();
		}else if(number==3){
			controller.checkLogin();
			controller.checkPid();
			showResult("�п�J�n�������q��s���G");
			String oid = getInput().trim();
			controller.acceptOrder(oid);
		}else if(number==4){
			controller.end();
		}else if(number==Constant.MAIN){
			controller.checkLogin();
			controller.switchUI(number);
		}else{
			showResult("��J���~�A�Э��s��J�C");
		}
		
		display();
	}
}