package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class DAO {
	public void insertTrainLog(String reg_dt, String message) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			BasicDataSource bds = DBConnector.getInstance().getBds();
			connection = bds.getConnection();
			statement = connection.prepareStatement(
					"INSERT INTO tb_train_log (reg_dt, message) VALUES (?,?)");
			statement.setString(1, reg_dt);
			statement.setString(2, message);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public void insertTrainManagementLog(String reg_dt, String message) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			BasicDataSource bds = DBConnector.getInstance().getBds();
			connection = bds.getConnection();
			statement = connection.prepareStatement(
					"INSERT INTO tb_train_management_log (reg_dt, message) VALUES (?,?)");
			statement.setString(1, reg_dt);
			statement.setString(2, message);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}	
}
