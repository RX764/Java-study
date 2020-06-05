package hello;

class a {
//	public void eating() {
//		System.out.println("外部eatingy =========");
//	}

	public void say() {
		System.out.println("外部say =========");
	}

	class b {
		public void say() {
			System.out.println("内部say =========");
		}

		public void eating() {
			say();
			System.out.println("内部eatingy =========");
		}
	}
}

public class insideclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a aa = new a();
	}

}
