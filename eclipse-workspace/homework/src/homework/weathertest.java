package homework;

public class weathertest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		weather we = new weather();

		new Thread(new GenerateWeather(we)).start();
		new Thread(new ReadWheather(we)).start();
	}

}
