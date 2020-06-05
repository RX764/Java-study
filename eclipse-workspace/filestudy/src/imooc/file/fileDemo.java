package imooc.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class fileDemo {
//读取文本并显示
	public static void main(String[] args) {
		try {
			File f1 = new File("D:\\eclipse-workspace\\filestudy\\src\\imooc\\file\\test.txt");
			if (f1.createNewFile()) {
				System.out.println("创建文件成功");
			} else {
				System.out.println("文件已存在");
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
			System.out.println("文件不存在 ");
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
//			System.out.println("一共读取了" + num + "个字节");
//		} catch (IOException e) {
//			System.out.println("此文件读取出错");
//			System.exit(-1);
//		}
	}

}
