package com.imooc.thread;

class mythread extends Thread {
	@Override
	public void run() {
//		System.out.println(getName() + "   �߳�ִ��!");
		for (int i = 1; i < 10; i += 2) {
			System.out.print(i + "\t");
		}
	}
}

public class threadtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mythread mt = new mythread();
		mt.start(); // �����̣߳����ǵ���run����.������ִ��run����Ĵ���
		for (int i = 0; i < 10; i += 2) {
			System.out.print(i + "\t");
		}

	}

}
