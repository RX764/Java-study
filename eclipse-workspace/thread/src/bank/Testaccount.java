package bank;

public class Testaccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account acc = new Account("����", 100);
		System.out.println(acc);
		Cashier t1 = new Cashier("��Ա1", acc, 300);
		Cashier t2 = new Cashier("��Ա2", acc, -40);
		t1.start();
		t2.start();

	}

}
