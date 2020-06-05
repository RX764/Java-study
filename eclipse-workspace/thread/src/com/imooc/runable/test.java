package com.imooc.runable;

class printrunnable implements Runnable {
	int i = 0;

	@Override
	public void run() {
//		System.out.println(Thread.currentThread().getName() + "\t正在运行");
//		while (i <= 10) {
//			System.out.println(Thread.currentThread().getName() + "  " + (i++) + "\t正在运行");
//		}
		char a = 'a';
		char lett[] = new char[26];
		for (int i = 0; i < 26; i++) {
			lett[i] = (char) (a + i);
//			System.out.println("*****" + lett[i]);
		}
		int j = 0;
		while (j < 26) {
			System.out.print(lett[j] + "\t");
			try {
				Thread.sleep(500);
				j++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("线程被打断");
				e.printStackTrace();
			}
		}

	}
}

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printrunnable pr1 = new printrunnable();
		Thread t1 = new Thread(pr1);
		Thread t2 = new Thread(pr1);
		t1.start();
//		printrunnable pr2 = new printrunnable();
//		Thread t2 = new Thread(pr2);
//		t2.start();
		t2.start();

	}

}
