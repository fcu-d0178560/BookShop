package BookShop;

public class BuyUI extends UI{
	
	public BuyUI(Controller controller){
		super(controller);
	}
	public void display(){
		int number = 0;
		showResult("�п�ܭn�ϥΪ��\��G");
		showResult("1.�ʶR���y 2.�d�ݭq�� 3.�����q�� 0.�^�W��");
		String input = getInput().trim();
		try{
			number = Integer.valueOf(input);
		}catch(NumberFormatException e){ number = 999; }
		
		if(number==1){
			controller.showProduct();
			showResult("�п�J�n�ʶR�����y�s��(PID)�G");
			controller.order(getInput().trim());
		}else if(number==2){
			controller.showOrder();
		}else if(number==3){
			controller.showOrder();
			showResult("�п�J�n�������q��s��(OID)�G");
			controller.cancelOrder(getInput().trim());
		}else if(number==Constant.MAIN){
			controller.switchUI(number);
		}else{
			showResult("��J���~�A�Э��s��J�C");
		}
		display();
	}
}