package com.imooc.thread;

class mythread extends Thread {
	@Override
	public void run() {
//		System.out.println(getName() + "   线程执行!");
		for (int i = 1; i < 10; i += 2) {
			System.out.print(i + "\t");
		}
	}
}

public class threadtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mythread mt = new mythread();
		mt.start(); // 启动线程，不是调用run方法.但还是执行run里面的代码
		for (int i = 0; i < 10; i += 2) {
			System.out.print(i + "\t");
		}

	}

}
