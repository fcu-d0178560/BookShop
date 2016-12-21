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
			if(controller.checkAccount(account)){
				showResult("�п�J�K�X�G");
				String password = getInput().trim();
				if(!controller.login(account,password)){
					showResult("�n�J���ѡA�K�X���~�I");
				}else{
					showResult("�n�J���\�I");
					controller.switchUI(Constant.MAIN);
				}
			}else{ showResult("��J���b�����s�b�I"); }

		}else if(number==2){
			showResult("�п�J�b���G");
			String account = getInput().trim();
			if(!controller.checkAccount(account)){
				showResult("�п�J�K�X�G");
				String password = getInput().trim();
				showResult("�п�J������X�G");
				String phonenumber = getInput().trim();
				controller.register(account,password,phonenumber);
				showResult("���U���\�I");
			}else{ showResult("�b���w�Q���U�L�I"); }

		}else if(number==3){
			controller.checkLogin();
			showResult("�п�J�s��������X�G");
			String phone = getInput().trim();
			result = controller.modifyPhone(phone);
			if(result==false) showResult("�ק��p����T���ѡA�P�x�s��T�ۦP�C");
		}else if(number==Constant.MAIN){
			controller.switchUI(number);
		}else{
			showResult("��J���~�A�Э��s��J�C");
		}
		
		display();
	}
}