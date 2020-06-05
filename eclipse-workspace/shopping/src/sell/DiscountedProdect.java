package sell;

import java.text.DecimalFormat;
import java.util.Calendar;

public class DiscountedProdect extends product {
	private Calendar startdate;
	private Calendar enddate;
	private double discount;// �ۿ�

	public DiscountedProdect(String ID, double price, String productName, String unit, Calendar startdate,
			Calendar enddate, double discount) {
		super(ID, price, productName, unit);
		this.startdate = startdate;
		this.enddate = enddate;
		this.discount = discount;
	}

	@Override
	public double getPrice() {
		DecimalFormat precision = new DecimalFormat("0.00");
		double price = super.getPrice();
		Calendar rightNow = Calendar.getInstance();// �õ���ǰ����
		if (rightNow.after(startdate) && rightNow.before(enddate)) {
			String strPrice = precision.format(price * (1 - (100 - discount) / 100));
			return Double.parseDouble(strPrice);
		} else {
			return price;
		}
	}

	public String tosString() {
		return super.toString() + "�ۿ���:" + (discount / 10) + "�ۣ��ۿ�ʱ��Σ�" + startdate.get(Calendar.YEAR) + "/"
				+ (startdate.get(Calendar.MONTH) + 1) + "����" + enddate.get(Calendar.YEAR) + "/"
				+ (enddate.get(Calendar.MONTH) + 1);
	}
}
