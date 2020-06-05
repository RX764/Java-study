package sell;

import java.util.ArrayList;

public class Customer {
	private ArrayList orderList;
	private String ID;
	private String name;

	public Customer(String ID, String name) {
		orderList = new ArrayList();
		this.ID = ID;
		this.name = name;
	}

	public void selectProduct(String ProductID, int num) {
		OrderInfo oInfo = new OrderInfo(ProductID, num);
		orderList.add(oInfo);
	}

	public ArrayList getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList orderList) {
		this.orderList = orderList;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

}
