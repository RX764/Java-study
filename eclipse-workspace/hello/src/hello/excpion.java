package hello;

import java.util.Scanner;

public class excpion {

	public static void main(String[] args) {

		int t1 = 100;
		Integer t2 = t1;
		Integer t3 = new Integer(t1);
		System.out.println(t1 + "\t" + t2 + "\t" + t3);
		System.out.println("====================================");
		int t4 = t2;
		int t5 = t2.intValue();
		double t6 = t2.doubleValue();

		System.out.println(t6);

		// TODO Auto-generated method stub
		try {
			// int result = test();
			// System.out.println("result =" + result);
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("除数不为0");
		}
		System.out.println("main运算结束");
	}

	public static int test() throws ArithmeticException {
		Scanner in = new Scanner(System.in);
		int a, b;
		System.out.println("请输入 a：");
		a = in.nextInt();
		System.out.println("请输入 b：");
		b = in.nextInt();
		return a / b;
	}

}
