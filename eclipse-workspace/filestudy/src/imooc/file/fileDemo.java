package imooc.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class fileDemo {
//��ȡ�ı�����ʾ
	public static void main(String[] args) {
		try {
			File f1 = new File("D:\\eclipse-workspace\\filestudy\\src\\imooc\\file\\test.txt");
			if (f1.createNewFile()) {
				System.out.println("�����ļ��ɹ�");
			} else {
				System.out.println("�ļ��Ѵ���");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		FileInputStream files = null;
//		int b = 0;
		try {
			files = new FileInputStream("D:\\eclipse-workspace\\filestudy\\src\\imooc\\file\\test.txt");

			byte b[] = new byte[100];
			files.read(b, 0, 6);
			System.out.println(new String(b));
			files.close();
		} catch (FileNotFoundException e) {
			System.out.println("�ļ������� ");
			System.exit(-1);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

//
//		try {
//			long num = 0;
//			while ((b = files.read()) != -1) {
//				System.out.println((char) b);
//				num++;
//			}
//			files.close();
//			System.out.println("************************");
//			System.out.println("һ����ȡ��" + num + "���ֽ�");
//		} catch (IOException e) {
//			System.out.println("���ļ���ȡ����");
//			System.exit(-1);
//		}
	}

}
