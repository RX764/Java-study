package homework;

public class GenerateWeather implements Runnable {
	weather genweather = new weather();

	public GenerateWeather(weather genweather) {
		// TODO Auto-generated constructor stub
		this.genweather = genweather;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 100; i++) {
//			System.out.println("��" + i + "�����ɺͶ�ȡ");
			genweather.generateinfo(i);
		}
	}

}
