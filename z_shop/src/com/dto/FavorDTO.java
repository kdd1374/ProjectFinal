package com.dto;

public class FavorDTO {

	private String gCode;
	private String gCategory;
	private String gName;
	private int gPrice;
	private String gImage;
	private int gAmount;
	private String userid;
	private String username;
	private String post;
	private String addr1;
	private String addr2;
	private String phone;
	private String email1;
	private String email2;
	public FavorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FavorDTO(String gCode, String gCategory, String gName, int gPrice, String gImage, int gAmount, String userid,
			String username, String post, String addr1, String addr2,  String phone, String email1, String email2) {
		super();
		this.gCode = gCode;
		this.gCategory = gCategory;
		this.gName = gName;
		this.gPrice = gPrice;
		this.gImage = gImage;
		this.gAmount = gAmount;
		this.userid = userid;
		this.username = username;
		this.post = post;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phone = phone;
		this.email1 = email1;
		this.email2 = email2;
	}
	

	@Override
	public String toString() {
		return "CartDTO [gCode=" + gCode + ", gCategory=" + gCategory + ", gName=" + gName
				+ ", gPrice=" + gPrice + ", gImage=" + gImage + ", gAmount=" + gAmount + ", userid=" + userid
				+ ", username=" + username + ", post=" + post + ", addr1=" + addr1 + ", addr2=" + addr2 + ", "
						+ "phone=" + phone + ", email1=" + email1 + ", email2=" + email2 + "]";
	}

	public String getgCode() {
		return gCode;
	}
	public void setgCode(String gCode) {
		this.gCode = gCode;
	}
	public String getgCategory() {
		return gCategory;
	}
	public void setgCategory(String gCategory) {
		this.gCategory = gCategory;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public int getgPrice() {
		return gPrice;
	}
	public void setgPrice(int gPrice) {
		this.gPrice = gPrice;
	}
	public String getgImage() {
		return gImage;
	}
	public void setgImage(String gImage) {
		this.gImage = gImage;
	}
	public int getgAmount() {
		return gAmount;
	}
	public void setgAmount(int gAmount) {
		this.gAmount = gAmount;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	
}
