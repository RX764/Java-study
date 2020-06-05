package sell;

public class OrderInfo {
	private String ID;
	private int num;

	public OrderInfo(String ID, int n) {
		this.ID = ID;
		this.num = n;
	}

	public String getProductID() {
		return ID;
	}

	public int getNum() {
		return num;
	}

}
