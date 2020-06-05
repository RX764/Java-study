package homework;

public class weather {
	private static int sd;
	private static int wd;
	private boolean flag = false;

	public synchronized void generateinfo(int i) {

		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.setSd((int) (Math.random() * 50));
		this.setWd((int) (Math.random() * 50));
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("��" + i + "��������������[�¶ȣ�" + getWd() + "�棬ʪ�ȣ�" + getSd() + "]");
		flag = true;
		notifyAll();
	}

	public synchronized void readinfo(int i) {
		if (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("��" + i + "�ζ�ȡ��������[�¶ȣ�" + getWd() + "�棬ʪ�ȣ�" + getSd() + "]");
		flag = false;
		notifyAll();

	}

	public int getSd() {
		return sd;
	}

	public void setSd(int sd) {
		System.out.println("");
		this.sd = sd;
	}

	public int getWd() {
		return wd;
	}

	public void setWd(int wd) {
		this.wd = wd;
	}

}
