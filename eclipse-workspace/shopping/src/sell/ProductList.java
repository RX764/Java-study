package sell;

import java.util.Calendar;

public class ProductList {

	static int idx = 0;
	static final int totalcount = 100;
	String idlist[] = new String[totalcount];
	product ProductList[] = new product[totalcount];
	private static ProductList productList = null;

	public static ProductList getInstance() {
		if (productList == null)
			productList = new ProductList();
		return productList;
	}

	private ProductList() {
		Calendar startdate = Calendar.getInstance();
		startdate.set(2020, 5, 1);
		Calendar enddate = Calendar.getInstance();
		enddate.set(2020, 6, 1);
		put("101", new product("10", 35.4, "红酒", "瓶"));
	}

	public product get(String prodID) {
		product p;
		int k = -1;
		for (int i = 0; i < idx; i++) {
			if (idlist[i].compareTo(prodID) == 0)
				k = i;
		}
		if (k == -1)
			return null;
		else {
			return ProductList[k];
		}
	}

	void put(String prodID, product prod) {
		if (idx >= totalcount) {
			System.out.println("商品列表已满");
		}
		idlist[idx] = prodID;
		ProductList[idx] = prod;
		idx++;
	}

	boolean remove(String prodID) {
		int k = -1;
		for (int i = 0; i < idx; i++) {
			if (idlist[i].compareTo(prodID) == 0)
				k = i;
		}
		if (k != -1) {
			for (int i = k; i < idx - 1; i++) {
				idlist[i] = idlist[i + 1];
				ProductList[i] = ProductList[i + 1];
			}
			idx--;
			idlist[idx] = null;
			ProductList[idx] = null;
			return true;

		} else {
			return false;
		}
	}

	public String tuString() {
		StringBuffer buffer = new StringBuffer("");
		for (int i = 0; i < idx; i++) {
			buffer.append(idlist[i] + "-------" + ProductList[i] + "\n");
		}
		return buffer.toString();
	}
}
