package com.scb.gauss.bean;

public class Application {
	private int appId;
	private String appName = "";
	private String status = "";
	private int age;
	private String handledBy = "";
	private int id;

	public Application(int appId, String appName, String status, int age, String handledBy, int id) {
		super();
		this.appId = appId;
		this.appName = appName;
		this.status = status;
		this.age = age;
		this.handledBy = handledBy;
		this.id=id;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHandledBy() {
		return handledBy;
	}

	public void setHandledBy(String handledBy) {
		this.handledBy = handledBy;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Application() {
		super();
	}

	@Override
	public String toString() {
		return "Application [appId=" + appId + ", appName=" + appName + ", status=" + status + ", age=" + age
				+ ", handledBy=" + handledBy + ", id=" + id + "]";
	}
	
	

}
