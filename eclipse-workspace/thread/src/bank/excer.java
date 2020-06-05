package bank;

class mythread implements Runnable {
	private int id;
	private static Object lock = new Object();

	public mythread(int id) {
		super();
		this.id = id;
	}

	@Override
	public void run() {
		synchronized (lock) {
			for (int i = 0; i < 50; i++) {
				System.out.println("Ïß³ÌID£º" + this.id + "  i = " + i);
			}
		}
	}
}

public class excer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < 5; i++) {
				new Thread(new mythread(i)).start();
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
