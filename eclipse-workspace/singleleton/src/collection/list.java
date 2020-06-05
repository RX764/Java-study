package collection;

import java.util.ArrayList;
import java.util.List;

public class list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList list = new ArrayList();
		// 或者
		List list = new ArrayList();

		list.add("C");
		list.add("JAVA");
		list.add("python");
		list.add("PHP");
		list.add("C++");
		System.out.println("元数个数为：" + list.size());
		System.out.println("=================================");
//		list.remove(4);
//		list.remove("C++");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
		System.out.println("\n=================================");

	}

}
