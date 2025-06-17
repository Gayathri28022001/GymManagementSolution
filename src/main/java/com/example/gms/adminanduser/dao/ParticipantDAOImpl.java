package com.example.gms.adminanduser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.gms.model.Participants;
import com.example.gms.persist.database.Database;

public class ParticipantDAOImpl implements IParticipantDAO {

	// fields
	private Database db = Database.getInstance();

	private static final Logger logger = LogManager.getLogger(ParticipantDAOImpl.class.getName());

	@Override
	public Participants get(long id) {
		// TODO Auto-generated method stub
		String readParticipantsSql = "Select * FROM Participants where participantID = ?";

		Participants participant = new Participants();

		try (Connection connection = db.getConnection();
				PreparedStatement ps = connection.prepareStatement(readParticipantsSql)) {
			ps.setInt(1, (int) id);

			ResultSet participantResultSet = db.executeQuery(ps);

			participant.setPid(participantResultSet.getInt("participantId"));
			participant.setName(participantResultSet.getString("participantName"));
			participant.setPhone(participantResultSet.getString("participantPhone"));

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("error occurred in Retrieve Participants DB: " + e);
		}

		return null;
	}

	@Override
	public List<Participants> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Participants object) {
		// TODO Auto-generated method stub

		// SQL Query Placeholder
		String insertParticipantsSql = "INSERT INTO participants (participantName, participantPhone, participantEmail, participantBid) VALUES (?, ?, ?, ?)";

		try (Connection connection = db.getConnection();
				PreparedStatement ps = connection.prepareStatement(insertParticipantsSql)) {

			ps.setString(1, object.getName());
			ps.setString(2, object.getPhone());
			ps.setString(3, object.getEmail());
			ps.setInt(4, object.getBid());

			int successOrFail = db.executeUpdate(ps);

			if (successOrFail > 0) {
				logger.info("successfully proccessed " + object + "to the DB");
			} else {
				logger.info("check DB for issues");
			}

		} catch (SQLException e) {
			// TODO: handle exception
			logger.error("SQL Exception occurred in save Participant method: " + e);
		}

	}

	@Override
	public void update(Participants object) {
		// TODO Auto-generated method stub

		String updateParticipantsSql = "UPDATE participants SET participantName = ?, participantPhone = ?, participantEmail = ?, participantBid = ?  WHERE participantId = ?";

		try (Connection connection = db.getConnection();
				PreparedStatement ps = connection.prepareStatement(updateParticipantsSql)) {

			ps.setString(1, object.getName());
			ps.setString(2, object.getPhone());
			ps.setString(3, object.getEmail());
			ps.setInt(4, object.getBid());
			ps.setInt(5, object.getPid());

			int successOrFail = db.executeUpdate(ps);

			if (successOrFail > 0) {
				System.out.println("Successfully updated " + object + " in the DB");
			} else {
				System.out.println("Update failed, check DB for issues or if the record exists");
			}

		} catch (SQLException e) {
			System.out.println("SQL Exception occurred in update Participant method: " + e);
		}

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
