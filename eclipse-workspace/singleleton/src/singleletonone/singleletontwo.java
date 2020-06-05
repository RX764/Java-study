package singleletonone;

//懒汉式 线程不安全
public class singleletontwo {
	private singleletontwo() {

	}

	int i = 0;

	public int num() {
		while (i <= 10) {
			return i++;
		}
		return 11;
	}

	private static singleletontwo instance = null;

	public static singleletontwo getinstance() {
		if (instance == null)
			instance = new singleletontwo();
		return instance;
	}
}
