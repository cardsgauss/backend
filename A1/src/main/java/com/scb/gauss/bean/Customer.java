package com.scb.gauss.bean;

public class Customer {
	private int id;
	private String name;
	private String email;
	private String mobile;
	private String product ;
	private long aadhaar;
	private String address;
	private String income;
	private String profile;
	private String reason;
	private String status;
	public String getSup_verification() {
		return sup_verification;
	}
	public void setSup_verification(String sup_verification) {
		this.sup_verification = sup_verification;
	}

	private int score;
	private String sup_verification;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public long getAadhaar() {
		return aadhaar;
	}
	public void setAadhaar(long aadhaar) {
		this.aadhaar = aadhaar;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public Customer(int id, String name, String email, String mobile, String product, long aadhaar, String address,
			String income, String profile,String reason,String status,int score,String sup_verification) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.product = product;
		this.aadhaar = aadhaar;
		this.address = address;
		this.income = income;
		this.profile = profile;
		this.reason=reason;
		this.status=status;
		this.score=score;
		this.sup_verification=sup_verification;
	}
	
	public Customer() {
		super();
	}

}
