package com.example.gms.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.gms.model.Batch;

public interface BatchDAO {

	void createConnection();

	void closeConnection();

	void createBatch(Batch batch) throws SQLException;

	void updateBatch(Batch batch) throws SQLException;

	public ResultSet retrieveBatch(int bid) throws SQLException;

	void deleteBatch(int bid);

}
