package singleletontest;

import java.util.Scanner;

import singleletonone.singleletononeclass;

public class onetest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 饿汉式 空间换时间
		singleletononeclass one = singleletononeclass.getinstance();
		singleletononeclass two = singleletononeclass.getinstance();
		System.out.println(one);
		System.out.println(two);

		Scanner in = new Scanner(System.in);
		System.out.println("1:");
		String name1String = in.nextLine();
		System.out.println("2:");
		String name2String = in.nextLine();
		System.out.println("3:");
		int a = in.nextInt();
		System.out.println("4:");
		int b = in.nextInt();
		System.out.println(name1String + name2String);
	}

}
