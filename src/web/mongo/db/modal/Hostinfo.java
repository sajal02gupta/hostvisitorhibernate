package web.mongo.db.modal;

public class Hostinfo {
	private String hname;
	private String hemail;
	private String hphone;
	public Hostinfo(String hname, String hemail, String hphone) {
		super();
		this.hname = hname;
		this.hemail = hemail;
		this.hphone = hphone;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getHemail() {
		return hemail;
	}
	public void setHemail(String hemail) {
		this.hemail = hemail;
	}
	public String getHphone() {
		return hphone;
	}
	public void setHphone(String hphone) {
		this.hphone = hphone;
	}
	
	
}
