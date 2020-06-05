package collection;

import java.util.Date;

public class notice {
	private int id;
	private String titl;
	private String creator;
	private Date creatime;

	public notice(int id, String titl, String creator, Date creatime) {
		super();
		this.setId(id);
		this.setCreatime(creatime);
		this.setCreator(creator);
		this.setTitl(titl);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitl() {
		return titl;
	}

	public void setTitl(String titl) {
		this.titl = titl;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreatime() {
		return creatime;
	}

	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}

}
