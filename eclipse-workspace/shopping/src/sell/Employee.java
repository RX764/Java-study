package sell;

import java.util.Scanner;

public abstract class Employee {
	String ID;
	String name;
	String pass;// ����

	public Employee(String ID, String name, String pass) {
		this.ID = ID;
		this.name = name;
		this.pass = pass;
	}

	public boolean login() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�������˹���� ��");
		String num = scanner.nextLine();
//		scanner.nextLine();
		System.out.print("�������˹���� ��");
		String pwd = scanner.nextLine();
		if (num.equals(ID) && pwd.equals(pass))
			return true;
		else {
			return false;
		}

	}

}
