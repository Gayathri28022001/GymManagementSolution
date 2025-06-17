package com.example.gms.adminanduser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.gms.model.Batch;
import com.example.gms.persist.database.Database;

public class BatchDAOImpl implements IBatchDAO {

	// fields
	private Database db = Database.getInstance();

	private static final Logger logger = LogManager.getLogger(BatchDAOImpl.class.getName());

	@Override
	public Batch get(long id) {
		// TODO Auto-generated method stub
		String readBatchSql = "Select * FROM Batch where batchID = ?";

		Batch batch = new Batch();

		try (Connection connection = db.getConnection();
				PreparedStatement ps = connection.prepareStatement(readBatchSql)) {
			ps.setInt(1, (int) id);

			ResultSet batchResultSet = db.executeQuery(ps);

			batch.setBid(batchResultSet.getInt("bid"));
			batch.setBatchName(batchResultSet.getString("batchName"));

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("error occurred in Retrieve Batch DB: " + e);
		}
		return null;
	}

	@Override
	public List<Batch> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Batch object) {
		// TODO Auto-generated method stub

		// SQL Query Placeholder
		String insertBatchSql = "INSERT INTO batch (batch_name, time_slot, trainer_name) VALUES (?, ?, ?)";

		try (Connection connection = db.getConnection();
				PreparedStatement ps = connection.prepareStatement(insertBatchSql)) {

			ps.setString(1, object.getBatchName());
			ps.setString(2, object.getTimeSlot());
			ps.setString(3, object.getTrainerName());

			int successOrFail = db.executeUpdate(ps);

			if (successOrFail > 0) {
				logger.info("successfully proccessed " + object + "to the DB");
			} else {
				logger.info("check DB for issues");
			}

		} catch (SQLException e) {
			// TODO: handle exception
			logger.error("SQL Exception occurred in save Batch method:" + e);
		}

	}

	@Override
	public void update(Batch object) {
		// TODO Auto-generated method stub

		String updateBatchSql = "UPDATE batch SET batch_name = ?, time_slot = ?, trainer_name = ?, WHERE bid = ?";

		try (Connection connection = db.getConnection();
				PreparedStatement ps = connection.prepareStatement(updateBatchSql)) {

			ps.setString(1, object.getBatchName());
			ps.setString(2, object.getTimeSlot());
			ps.setString(3, object.getTrainerName());
			ps.setInt(4, object.getBid());

			int successOrFail = db.executeUpdate(ps);

			if (successOrFail > 0) {
				System.out.println("Successfully updated " + object + "in the DB");
			} else {
				System.out.println("Update failed, check DB for issues or if the record exists");
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("SQL Exception occurred in update Batch method: " + e);
		}

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
