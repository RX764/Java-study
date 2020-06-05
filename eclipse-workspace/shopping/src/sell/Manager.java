package sell;

import java.util.Arrays;

public class Manager extends Employee {
	String department;

	public Manager(String num, String n, String pwd, String b) {
		super(num, n, pwd);
		department = b;
	}

	public void viewSell() {// �������۽������鿴���
		SellEvents events = SellEvents.getInstance();
		SellEvents s[] = new SellEvents[events.size()];
		int idx = 0;
		for (Object o : events) {
			s[idx] = (SellEvents) o;
			idx++;
		}
		Arrays.sort(s);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}
}
