package singleletontest;

import singleletonone.singleletontwo;

class myrunnable implements Runnable {
	int i = 0;

	@Override
	public void run() {
		int j = 0;
		singleletontwo two = singleletontwo.getinstance();
		while (two.num() <= 10) {
			System.out.println("j=" + (j++) + " " + Thread.currentThread().getName() + "正在运行,i=" + two.num());
		}

	}
}

public class twotest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		singleletontwo two = singleletontwo.getinstance();
//		singleletontwo three = singleletontwo.getinstance();
//		System.out.println(two + "\n" + three);
//		
		System.out.println("****************************************");
		myrunnable pr = new myrunnable();
		Thread t1 = new Thread(pr, "线程1：");
		Thread t2 = new Thread(pr, "线程2：");
		t1.start();
		t2.start();

	}

}
