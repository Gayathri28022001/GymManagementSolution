package com.example.gms.persist.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Database {

	private static final Database db = new Database();

	private static Logger logger = LogManager.getLogger(Database.class.getName());

	private Connection connection;

	private Database() {

	}

	public static Database getInstance() {
		return db;
	}

	private void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "gayathri";
			String password = "123456";
			String url = "jdbc:mysql://localhost/zumba";
			connection = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Issue connecting with DB via credentials:" + e);
		}
	}

	public Connection getConnection() {
		if (connection == null || isClosed(connection)) {
			connect();
		}
		return connection;
	}

	private boolean isClosed(Connection connection) {
		try {
			return (connection == null || connection.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
	}

	public int executeUpdate(PreparedStatement preparedStatement) {
		int result = 0;
		try {
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			logger.error("Error in executeUpdate PS call:" + e);
		}
		return result;
	}

	public ResultSet executeQuery(PreparedStatement preparedStatement) {

		ResultSet result = null;
		try {
			result = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO: handle exception
			logger.error("Error in executeQuery PS call:" + e);
		}
		return result;

	}

}
