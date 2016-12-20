package BookShop;

public class RegisterUI extends UI {
	
	public RegisterUI(Controller controller){
		super(controller);
	}
	public void display(){
		Boolean result = false;
		int number = 0;
		showResult("�п�ܭn�ϥΪ��\��G");
		showResult("1.�n�J 2.���U 3.�ק��p����T 0.�^�W��");
		String input = getInput().trim();
		try{
			number = Integer.valueOf(input);
		}catch(NumberFormatException e){ number = 999; }
		
		if(number==1){
			showResult("�п�J�b���G");
			String account = getInput().trim();
			showResult("�п�J�K�X�G");
			String password = getInput().trim();
			result = controller.login(account,password);
		}else if(number==2){
			showResult("�п�J�b���G");
			String account = getInput().trim();
			showResult("�п�J�K�X�G");
			String password = getInput().trim();
			showResult("�п�J������X�G");
			String phonenumber = getInput().trim();
			result = controller.register(account,password,phonenumber);
		}else if(number==3){
			showResult("�п�J�s��������X�G");
			String phone = getInput().trim();
			result = controller.modifyPhone(phone);
			if(result==false) showResult("�ק��p����T���ѡA�P�x�s��T�ۦP�C");
		}else if(number==Constant.MAIN){
			controller.switchUI(number);
		}else{
			showResult("��J���~�A�Э��s��J�C");
		}
		
		if(result==true){
			controller.switchUI(Constant.MAIN);
		}else{
			display();
		}
	}
}