package hello;

class a {
//	public void eating() {
//		System.out.println("�ⲿeatingy =========");
//	}

	public void say() {
		System.out.println("�ⲿsay =========");
	}

	class b {
		public void say() {
			System.out.println("�ڲ�say =========");
		}

		public void eating() {
			say();
			System.out.println("�ڲ�eatingy =========");
		}
	}
}

public class insideclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a aa = new a();
	}

}
