package BookShop;

public class ContactInfoUI extends UI{
	
	Controller controller = null;
	
	public ContactInfoUI(Controller controller){
		this.controller = controller;
	}
	public void display(){
		
	}
	public String getInput(){
		String input = null;
		return input;
	}
	public void showResult(String result){
		System.out.println(result);
	}
}