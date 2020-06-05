package sell;

public class product {
	private String ID;
	private String name;
	private double price;
	private String unit; // 计量单位

	public product(String ID, double price, String productName, String unit) {
		this.ID = ID;
		this.price = price;
		this.name = productName;
		this.unit = unit;
	}

	public product() {
		this.ID = "0";
		this.price = 0;
		this.name = "0";
		this.unit = "0";
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "商品名称：" + name + "价格：" + price + "单位：" + unit;
	}
}
