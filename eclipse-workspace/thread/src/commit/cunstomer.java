package commit;

public class cunstomer implements Runnable {
	queue qu;

	public cunstomer(queue qu) {
		this.qu = qu;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			qu.getN();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
