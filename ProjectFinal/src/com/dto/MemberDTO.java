package com.dto;

public class MemberDTO {


	private String userid;
	private String passwd;
	private String username;
	private String ssn;
	private String post;
	private String addr1;
	private String addr2;
	private String phone;
	private String email1;
	private String email2;
	private String mas;
	private String hiredate;
	private String mileage;
	
	public MemberDTO(String userid, String ssn, String post, String addr1, String addr2, String phone, String email1,
			String email2) {
		super();
		this.userid = userid;
		this.ssn = ssn;
		this.post = post;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phone = phone;
		this.email1 = email1;
		this.email2 = email2;
	}

	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getMas() {
		return mas;
	}
	public void setMas(String mas) {
		this.mas = mas;
	}
	
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public MemberDTO(String userid, String passwd, String username, String ssn, String post, String addr1, String addr2,
			String phone, String email1, String email2, String mas) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.username = username;
		this.ssn=ssn;
		this.post = post;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phone = phone;
		this.email1 = email1;
		this.email2 = email2;
		this.mas = mas;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", passwd=" + passwd + ", username=" + username + ", ssn=" + ssn
				+ ", post=" + post + ", addr1=" + addr1 + ", addr2=" + addr2 + ", phone=" + phone + ", email1=" + email1
				+ ", email2=" + email2 + ", mas=" + mas + ", hiredate=" + hiredate + ", mileage=" + mileage + "]";
	}
	
	
}
