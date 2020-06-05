package bank;

public class Account {
	private String name;
	private int balance;

	public synchronized void operate(int x) {
		try {
			int tmp = getBalance();
			Thread.sleep(100L);
			this.balance = tmp + x;
			System.out.println(Thread.currentThread().getName() + "���н���������" + x + ",��ǰ���Ϊ��" + balance);
			Thread.sleep(100L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String tosString() {
		return "�˻�{����=" + name + ",���=" + balance + "}";
	}

	public Account(String name, int balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
