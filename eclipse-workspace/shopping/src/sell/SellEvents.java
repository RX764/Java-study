package sell;

import java.util.ArrayList;

public class SellEvents extends ArrayList {
	private static SellEvents events= new SellEvents();
	private SellEvents() {
		super();
	}
	public static SellEvents getInstance() {
		return events;
	}
}
