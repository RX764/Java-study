package commit;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queue qu = new queue();
		new Thread(new product(qu)).start();
		new Thread(new cunstomer(qu)).start();
	}

}
