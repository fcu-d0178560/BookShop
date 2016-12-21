package BookShop;

public class BuyUI extends UI{
	
	public BuyUI(Controller controller){
		super(controller);
	}
	public void display(){
		int number = 0;
		showResult("�п�ܭn�ϥΪ��\��G");
		showResult("1.�d�ݮ��y 2.�ʶR���y 3.�d�ݭq�� 4.�����q�� 5.���} 0.�^�W��");
		String input = getInput().trim();
		try{
			number = Integer.valueOf(input);
		}catch(NumberFormatException e){ number = 999; }
		
		if(number==1){
			controller.checkLogin();
			controller.showProduct();
		}else if(number==2){
			controller.checkLogin();
			if(controller.showProduct()!=0){
				showResult("�п�J�n�ʶR�����y�s��(PID)�G");
				controller.order(getInput().trim());
			}
		}else if(number==3){
			controller.checkLogin();
			controller.showOrder();
		}else if(number==4){
			controller.checkLogin();
			if(controller.showOrder()!=0){
				showResult("�п�J�n�������q��s��(OID)�G");
				controller.cancelOrder(getInput().trim());
			}
		}else if(number==5){
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