package com.pritesh.userapp.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer uId;
	private String userName;
	private String phone;
	private String gender;
	private String address;

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserDTO() {
		super();
	}

	@Override
	public String toString() {
		return "UserDTO [uId=" + uId + ", userName=" + userName + ", phone=" + phone + ", gender=" + gender
				+ ", address=" + address + "]";
	}

}
