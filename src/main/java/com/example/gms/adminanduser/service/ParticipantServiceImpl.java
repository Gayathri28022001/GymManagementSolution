package com.example.gms.adminanduser.service;

import java.util.List;

import com.example.gms.adminanduser.dao.IParticipantDAO;
import com.example.gms.adminanduser.dao.ParticipantDAOImpl;
import com.example.gms.model.Participants;

public class ParticipantServiceImpl implements IParticipantService {

	// fields
	private IParticipantDAO participantDao;

	// constructors --special method for instantiating an object
	public ParticipantServiceImpl() {
		participantDao = new ParticipantDAOImpl();
	}

	@Override
	public Participants getParticipant(long id) {
		// TODO Auto-generated method stub
		return participantDao.get(id);
	}

	@Override
	public List<Participants> getAllParticipants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveParticipant(Participants object) {
		// TODO Auto-generated method stub
		participantDao.save(object);

	}

	@Override
	public void updateParticipant(Participants object) {
		// TODO Auto-generated method stub
		participantDao.update(object);

	}

	@Override
	public void deleteParticipant(long id) {
		// TODO Auto-generated method stub

	}

}
