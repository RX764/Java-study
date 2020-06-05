package sell;

import java.util.ArrayList;

public class Operator extends Employee {
	private String startTime;
	private String endTime;

	public Operator(String num, String n, String pwd, String startTime, String endTime) {
		super(num, n, pwd);
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public void checkout(Customer s) {
		double price = 0;
		ArrayList list = s.getOrderList();
		for (int i = 0; i < list.size(); i++) {
			OrderInfo info = (OrderInfo) (list.get(i));
			String pID = info.getProductID();
			int num = info.getNum();
			ProductList pList = ProductList.getInstance();
			product p = pList.get(pID);
			double temp = p.getPrice();
			price += temp * num;
		}
		if (s instanceof VIPCoustomer) {
			VIPCoustomer v = (VIPCoustomer) s;
			v.setFen((int) (price / 100));
			price = price - v.getFen() / 1000 * 5;
		}
		SellEvent se = new SellEvent(ID, s.getID(), list, price);
	}

}
