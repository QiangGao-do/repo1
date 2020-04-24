package nuc.test.entity;

public class User {
	private String userID=null;
	private String password=null;
	private String uname=null;
	private String utype=null;
	
	public String getuserID() {
		return userID;
	}
	public void setuserID(String userID) {
		this.userID = userID;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getuname() {
		return uname;
	}
	public void setuname(String uname) {
		this.uname = uname;
	}
	public String getutype() {
		return utype;
	}
	public void setutype(String utype) {
		this.utype = utype;
	}
}
