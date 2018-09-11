package com.dgut.bean;

public class UserInformation {
	int id;
	int userId;
	String gender;
	String nickName;
	String briefIntroduction;
	String headIconUrl;
	
	public String getHeadIconUrl() {
		return headIconUrl;
	}
	public void setHeadIconUrl(String headIconUrl) {
		this.headIconUrl = headIconUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getBriefIntroduction() {
		return briefIntroduction;
	}
	public void setBriefIntroduction(String briefIntroduction) {
		this.briefIntroduction = briefIntroduction;
	}
	@Override
	public String toString() {
		return "UserInformation [id=" + id + ", userId=" + userId + ", gender=" + gender + ", nickName=" + nickName
				+ ", briefIntroduction=" + briefIntroduction + ", headIconUrl=" + headIconUrl + "]";
	}
	
}
