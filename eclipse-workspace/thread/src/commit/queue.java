package commit;

public class queue {
	private int n;
	boolean flag = false;

	public synchronized int getN() {
		if (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("����\t" + n);
		flag = false;
		notifyAll();
		return n;
	}

	public synchronized void setN(int n) {
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("����\t" + n);
		this.n = n;
		flag = true;
		notifyAll();
	}

}
