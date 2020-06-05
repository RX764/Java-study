package bank;

public class Cashier extends Thread {
	private Account account;
	private int amount = 0;

	public Cashier(String name, Account account, int amount) {
		super(name);
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void run() {
		account.operate(amount);
	}

}
