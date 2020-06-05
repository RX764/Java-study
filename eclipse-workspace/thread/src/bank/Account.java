package bank;

public class Account {
	private String name;
	private int balance;

	public synchronized void operate(int x) {
		try {
			int tmp = getBalance();
			Thread.sleep(100L);
			this.balance = tmp + x;
			System.out.println(Thread.currentThread().getName() + "运行结束，增加" + x + ",当前余额为：" + balance);
			Thread.sleep(100L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String tosString() {
		return "账户{姓名=" + name + ",余额=" + balance + "}";
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
