package hello;

public class caesar {
	private int key;
	private String s;

	public void setkey(int key) {
		this.key = key;
	}

	public void set_s(String s) {
		this.s = s;
	}

	public String process() {
		String es = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c <= 'z' && c >= 'a') {
				c += key % 26;
				if (c > 'z')
					c -= 26;
				if (c < 'a')
					c = (char) (c + 26);
			} else if (c <= 'Z' && c >= 'A') {
				c += key % 26;
				// char c;
				if (c > 'Z')
//					c = c - 26; // 方案1
					c -= 26; // 方案2
				if (c < 'A')
					c = (char) (c + 26); // 方案3
			}
			es += c;
		}
		return es;
	}
}
