package BookShop;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ProductController {
	
	private int serial = 0;
	private Controller controller = null;
	private ArrayList<Product> product = new ArrayList<Product>();
	private ProductHandler handler = null;
	
	public ProductController(String filename,Controller controller){
		this.controller = controller;
		handler = new ProductHandler(filename);
		loadProduct();
	}
	public String getSerial(){
		String serial = Integer.toString(this.serial);
		this.serial += 1;
		return serial;
	}
	public int showProduct(){
		int count = 0;
		for(int i=0;i<product.size();i++){
			String pid = product.get(i).getPid();
			String pname = product.get(i).getPname();
			String result = Constant.DELIMITER+"PID:"+pid+Constant.DELIMITER+"商品名稱:"+pname+Constant.DELIMITER;
			controller.showResult(result);
		}
		if(count==0) controller.showResult("目前沒有登錄任何書籍！");
		return count;
	}
	public void addProduct(String account,String pname){ // need account and product name to create product
		String pid = controller.getTime()+getSerial();
		product.add(new Product(pid,pname,account));
	}
	public void deleteProduct(String pid){ // need product id to choose which product to delete
		for(int i=0;i<product.size();i++){
			if(product.get(i).getPid().equals(pid)){
				product.remove(i);
				break;
			}
		}
	}
	public int checkProduct(String account){
		int count = 0;
		for(int i=0;i<product.size();i++){
			if(product.get(i).getAccount().equals(account)){
				String pid = product.get(i).getPid();
				String pname = product.get(i).getPname();
				controller.showResult(Constant.DELIMITER+"商品編號："+pid+Constant.DELIMITER+"商品名稱："+pname+Constant.DELIMITER);
				count++;
			}
		}
		if(count==0) controller.showResult("目前沒有任何登錄書籍！");
		return count;
	}
	public void checkOrder(String account){
		int count = 0;
		for(int i=0;i<product.size();i++){
			if(product.get(i).getAccount().equals(account)){
				String pid = product.get(i).getPid();
				controller.checkOrder(pid);
				count++;
			}
		}
		if(count==0){
			controller.showResult("目前沒有任何登錄書籍！");
		}
	}
	private void loadProduct(){ // load product data from last status
		String line = handler.readLine();
		while(line!=null){
			StringTokenizer token = new StringTokenizer(line,Constant.DELIMITER);
			String pid = token.nextToken();
			String pname = token.nextToken();
			String account = token.nextToken().trim();
			product.add(new Product(pid,pname,account));
			line = handler.readLine();
		}
	}
	private void saveProduct(){ // save product data to last status
		String file = "";
		for(int i=0;i<product.size();i++){
			String pid = product.get(i).getPid();
			String pname = product.get(i).getPname();
			String account = product.get(i).getAccount();
			String line = pid+Constant.DELIMITER+pname+Constant.DELIMITER+account+"\n";
			file += line;
		}
		handler.writeFile(file);
	}
	public Product getProduct(String pid){ // get target product by product id
		Product target = null;
		for(int i=0;i<product.size();i++){
			if(product.get(i).getPid().equals(pid)){
				target = product.get(i);
				break;
			}
		}
		return target;
	}
	public void end(){
		saveProduct();
	}
}