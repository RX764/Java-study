package homework;

public class ReadWheather implements Runnable {

	weather reWeather;

	public ReadWheather(weather reWeather) {
		// TODO Auto-generated constructor stub
		this.reWeather = reWeather;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 100; i++) {
			reWeather.readinfo(i);
		}

	}

}
