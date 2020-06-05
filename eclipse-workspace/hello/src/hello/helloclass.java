package hello;

import java.util.Scanner;

//凯撒密码

public class helloclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

//乘法表  方式1
//		for(int i=1;i<=9;i++)
//		{
//			for(int j=1;j<=9;j++)
//			{
//				if(j>i)
//					continue;
//				System.out.print(i*j + "\t");				
//			}
//			System.out.println();
//		}

//乘法表  二维数组  for-each  方式2
//		int arr[][] = new int [9][];
//		for(int i=1;i<=arr.length;i++)
//		{
//			arr[i-1] = new int [i];
//			for(int j= 1 ;j<=i;j++)
//			{
//				arr[i-1][j-1] = i*j;
//			}
//		}
//		for(int ar[] :arr)
//		{
//			for(int a : ar)
//			{
//				System.out.print(a+"\t");
//			}
//			System.out.println();
//			
//		}
		System.out.print("key:");
		int key = in.nextInt();
		in.nextLine();
		String str;
		System.out.print("字符串:");
		String s = in.nextLine();
		caesar cae = new caesar();
		cae.setkey(key);
		cae.set_s(s);
		str = cae.process();
		System.out.println("输入: " + s + ", 加密后为 : " + str);
		cae.setkey(-key);
		cae.set_s(str);
		str = cae.process();
		System.out.println("还原后为：" + str);

		in.close();

	}

}
