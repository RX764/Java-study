package com.imooc.thread1;

class mythead extends Thread {
	public mythead(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(getName() + "\t��������\t" + i);

		}
	}
}

public class threadtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mythead mt1 = new mythead("�߳�1");
		mythead mt2 = new mythead("�߳�2");
		mt1.start();
		mt2.start();
	}

}
