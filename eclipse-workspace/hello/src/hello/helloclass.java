package hello;

import java.util.Scanner;

//��������

public class helloclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

//�˷���  ��ʽ1
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

//�˷���  ��ά����  for-each  ��ʽ2
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
		System.out.print("�ַ���:");
		String s = in.nextLine();
		caesar cae = new caesar();
		cae.setkey(key);
		cae.set_s(s);
		str = cae.process();
		System.out.println("����: " + s + ", ���ܺ�Ϊ : " + str);
		cae.setkey(-key);
		cae.set_s(str);
		str = cae.process();
		System.out.println("��ԭ��Ϊ��" + str);

		in.close();

	}

}
