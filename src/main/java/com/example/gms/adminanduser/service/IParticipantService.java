package com.example.gms.adminanduser.service;

import java.util.List;

import com.example.gms.model.Participants;

public interface IParticipantService {

	public Participants getParticipant(long id);

	public List<Participants> getAllParticipants();
	
	public void saveParticipant(Participants object);

	public void updateParticipant(Participants object);

	public void deleteParticipant(long id);

}
