package com.example.gms.model;

import java.io.Serializable;

//javaBean and POJO
public class Participants implements Serializable {
	private static final long serialVersionUID = 1L;
	private int pid;
	private String name;
	private String phone;
	private String email;
	private int bid;

	public Participants() {
		super();
	}

	public Participants(int pid, String name, String phone, String email, int bid) {
		super();
		this.pid = pid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.bid = bid;
	}

	//Getters and Setters
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	@Override
	public String toString() {
		return "Participants [pid=" + pid + ", name=" + name + ", phone=" + phone + ", email=" + email + ", bid=" + bid
				+ "]";
	}

	public void notifyParticipant() {
		System.out.println("Hello " + name + ", your batch is starting soon!");
	}

}
