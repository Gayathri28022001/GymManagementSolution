package com.example.gms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//javaBean and POJO 

public class Batch implements Serializable {

	private static final long serialVersionUID = 1L;
	private int bid;
	private String batchName;
	private String timeSlot;
	private String trainerName;

	private List<Participants> participants = new ArrayList<>();

	public Batch() {
		super();
	}

	public Batch(int bid, String batchName, String timeSlot, String trainerName) {
		super();
		this.bid = bid;
		this.batchName = batchName;
		this.timeSlot = timeSlot;
		this.trainerName = trainerName;
	}

	// Getters and Setters
	
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	@Override
	public String toString() {
		return "Batch [bid=" + bid + ", batchName=" + batchName + ", timeSlot=" + timeSlot + ", trainerName="
				+ trainerName + "]";
	}

	public void addParticipant(Participants p) {
		participants.add(p);
	}

	public void startBatch() {
		System.out.println("Batch ID: " + bid + ", " + batchName + " at " + timeSlot + " is starting.");
		for (Participants p : participants) {
			p.notifyParticipant();

		}

	}

}
