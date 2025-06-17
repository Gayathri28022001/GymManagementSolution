package com.example.gms.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.gms.model.Participants;

public interface ParticipantDAO {

	void createConnection();

	void closeConnection();

	void createParticipants(Participants participant) throws SQLException;

	void updateParticipant(Participants participant) throws SQLException;

	public ResultSet retrieveParticipants(int pid) throws SQLException;

	void deleteParticipants(int pid);

}
