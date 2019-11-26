package web.mongo.db.modal;

public class VisitorInfo {
	String vId;
	String vname;
	String vemail;
	String vphone;
	String checkintime;
	String checkouttime;
	
	
	
	public VisitorInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public VisitorInfo(String vId, String vname, String vemail, String vphone, String checkintime,
			String checkouttime) {
		super();
		this.vId = vId;
		this.vname = vname;
		this.vemail = vemail;
		this.vphone = vphone;
		this.checkintime = checkintime;
		this.checkouttime = checkouttime;
	}


	public String getvId() {
		return vId;
	}

	public void setvId(String vId) {
		this.vId = vId;
	}

	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVemail() {
		return vemail;
	}
	public void setVemail(String vemail) {
		this.vemail = vemail;
	}
	public String getVphone() {
		return vphone;
	}
	public void setVphone(String vphone) {
		this.vphone = vphone;
	}
	public String getCheckintime() {
		return checkintime;
	}

	public void setCheckintime(String checkintime) {
		this.checkintime = checkintime;
	}

	public String getCheckouttime() {
		return checkouttime;
	}

	public void setCheckouttime(String checkouttime) {
		this.checkouttime = checkouttime;
	}
	
	
	
	
}
