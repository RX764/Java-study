package sell;

public class VIPCoustomer extends Customer {
	private int jifen;

	public VIPCoustomer(String ID, String name, int jifen) {
		super(ID, name);
		this.jifen = jifen;
	}

	public void setFen(int f) {
		jifen += f;
	}

	public int getFen() {
		return jifen;
	}

}
