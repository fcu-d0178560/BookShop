package BookShop;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class OrderController {
	
	private int serial = 0;
	private Controller controller = null;
	private ArrayList<Order> order = new ArrayList<Order>();
	private ArrayList<Order> acceptorder = new ArrayList<Order>();
	private OrderHandler handler = null;
	
	public OrderController(String filename,Controller controller){
		this.controller = controller;
		handler = new OrderHandler(filename);
	}
	public String getSerial(){
		String serial = Integer.toString(this.serial);
		this.serial += 1;
		return serial;
	}
	public void order (String account,String pid){ // need account and product id to create an order
		String oid = controller.getTime()+getSerial();
		order.add(new Order(oid,pid,account));
	}
	public void acceptOrder (String oid){ // input order id to accept target order
		for(int i=0;i<order.size();i++){
			if(order.get(i).getOid().equals(oid)){
				Order target = order.get(i);
				order.remove(target);
				acceptorder.add(target);
				break;
			}
		}
	}
	public void showOrder (String account){	// show order
		controller.showResult("訂單訊息：");
		for(int i=0;i<order.size();i++){
			if(order.get(i).getAccount().equals(account)){
				if(order.get(i).getAccount().equals(account)){
					String oid = order.get(i).getOid();
					String pname = controller.getPname(acceptorder.get(i).getPid());
					controller.showResult(Constant.DELIMITER+"訂單編號："+oid+Constant.DELIMITER+"商品名稱："+pname+Constant.DELIMITER);
				}
			}
		}
	}
	public void checkOrder(String pid){
		for(int i=0;i<order.size();i++){
			if(order.get(i).getPid().equals(pid)){
				String oid = order.get(i).getOid();
				String pname = controller.getPname(pid);
				String account = order.get(i).getAccount();
				controller.showResult(Constant.DELIMITER+"訂單編號："+oid+Constant.DELIMITER+"商品名稱："+pname+Constant.DELIMITER+"訂貨人："+account+Constant.DELIMITER);
			}
		}
	}
	public void cancelOrder(String oid){
		for(int i=0;i<order.size();i++){
			if(order.get(i).getOid().equals(oid)){
				order.remove(i);
				break;
			}
		}
	}
	public void checkAcceptOrder(String account){ // check if there is order belong this account
		controller.showResult("交易資訊：");
		for(int i=0;i<acceptorder.size();i++){
			if(acceptorder.get(i).getAccount().equals(account)){
				String pname = controller.getPname(acceptorder.get(i).getPid());
				String phone = controller.getPhone(acceptorder.get(i).getAccount());
				controller.showResult(Constant.DELIMITER+"商品名稱："+pname+Constant.DELIMITER+"連絡資訊："+phone+Constant.DELIMITER);
			}
		}
	}
	public Order getOrder(String oid){
		Order target = null;
		for(int i=0;i<order.size();i++){
			if(order.get(i).getOid().equals(oid)){
				target = order.get(i);
				return target;
			}
		}
		for(int i=0;i<acceptorder.size();i++){
			if(acceptorder.get(i).getOid().equals(oid)){
				target = order.get(i);
				return target;
			}
		}
		return target;
	}
	public void finishOrder (String oid){ // finish the order to make sure the trade is success
		for(int i=0;i<acceptorder.size();i++){
			if(acceptorder.get(i).getOid().equals(oid)){
				Order target = acceptorder.get(i);
				acceptorder.remove(target);
				break;
			}
		}
	}
	private void loadOrder(){ // load Order data from last status 
		String line = handler.readLine();
		while(line!=null){
			StringTokenizer token = new StringTokenizer(line,Constant.DELIMITER);
			String oid = token.nextToken();
			String pid = token.nextToken();
			String account = token.nextToken();
			int orderstatus = Integer.parseInt(token.nextToken().trim());
			order.add(new Order(oid,pid,account));
			if(orderstatus==2){
				acceptOrder(oid);
			}
			line = handler.readLine();
		}
	}
	private void saveOrder(){ // save Order data to last status
		String file = "";
		for(int i=0;i<order.size();i++){
			String oid = order.get(i).getOid();
			String pid = order.get(i).getPid();
			String account = order.get(i).getAccount();
			String line = oid+Constant.DELIMITER+pid+Constant.DELIMITER+account+Constant.DELIMITER+1+"\n";
			file += line;
		}
		for(int i=0;i<acceptorder.size();i++){
			String oid = acceptorder.get(i).getOid();
			String pid = acceptorder.get(i).getPid();
			String account = acceptorder.get(i).getAccount();
			String line = oid+Constant.DELIMITER+pid+Constant.DELIMITER+account+Constant.DELIMITER+2+"\n";
			file += line;
		}
		handler.writeFile(file);
	}
	public void end(){
		saveOrder();
	}
}