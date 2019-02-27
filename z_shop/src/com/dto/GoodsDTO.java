package com.dto;

public class GoodsDTO {

	private int gAmount;
	private String gCode;
	private String gCategory;
	private String gName;
	private int gPrice;
	private String gImage;
	private String gCountry;
	private String gCompany;
	private String gDate;
	
	public GoodsDTO(String gCode, String gCategory, String gName, int gPrice, String gImage, String gCountry,
			String gCompany, String gDate) {
		super();
		this.gCode = gCode;
		this.gCategory = gCategory;
		this.gName = gName;
		this.gPrice = gPrice;
		this.gImage = gImage;
		this.gCountry = gCountry;
		this.gCompany = gCompany;
		this.gDate = gDate;
	}
	public GoodsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GoodsDTO(int gAmount, String gCode, String gCategory, String gName, int gPrice, String gImage, String gCountry,
			String gCompany, String gDate) {
		super();
		this.gAmount = gAmount;
		this.gCode = gCode;
		this.gCategory = gCategory;
		this.gName = gName;
		this.gPrice = gPrice;
		this.gImage = gImage;
		this.gCountry = gCountry;
		this.gCompany = gCompany;
		this.gDate = gDate;
	}
	public int getgAmount() {
		return gAmount;
	}
	public void setgAmount(int gAmount) {
		this.gAmount = gAmount;
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
	public String getgCountry() {
		return gCountry;
	}
	public void setgCountry(String gCountry) {
		this.gCountry = gCountry;
	}
	public String getgCompany() {
		return gCompany;
	}
	public void setgCompany(String gCompany) {
		this.gCompany = gCompany;
	}
	public String getgDate() {
		return gDate;
	}
	public void setgDate(String gDate) {
		this.gDate = gDate;
	}
	@Override
	public String toString() {
		return "GoodsDTO [gAmount=" + gAmount + ", gCode=" + gCode + ", gCategory=" + gCategory + ", gName=" + gName
				+ ", gPrice=" + gPrice + ", gImage=" + gImage + ", gCountry=" + gCountry + ", gCompany=" + gCompany
				+ ", gDate=" + gDate + "]";
	}
	

	
}
