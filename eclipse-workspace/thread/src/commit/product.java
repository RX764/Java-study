package commit;

public class product implements Runnable {
	queue qu;

	// ������ǹ����
	public product(queue qu) {
		// TODO Auto-generated constructor stub
		this.qu = qu;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while (true) {
			qu.setN(i++);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
