package BookShop;

import java.util.Scanner;

public class UI {
	
	Controller controller = null;
	
	/* Input Test
	public static void main(String[] args){ 
		UI ui = new UI();
		System.out.println("Hello World");
		String input = ui.getInput();
		ui.showResult(input);
	}
	*/
	public UI(Controller controller){
		this.controller = controller;
	}
	public void display(){
		
	}
	public String getInput(){
		String input = null;
		Scanner scanner = new Scanner(System.in);
		input = scanner.next();
		scanner.reset();
		return input;
	}
	public void showResult(String result){
		System.out.println(result);
	}
}