package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class DAO {
	public void insertTrainLog(String seat_no, int train_no, int bus_no, int seat_state, String reg_dt) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			BasicDataSource bds = DBConnector.getInstance().getBds();
			connection = bds.getConnection();
			statement = connection.prepareStatement(
					"INSERT INTO TB_TR_SEAT_MASTER (seat_no, train_no, bus_no, seat_state, reg_dt) VALUES (?,?,?,?,?)");
			statement.setString(1, seat_no);
			statement.setInt(2, train_no);
			statement.setInt(3, bus_no);
			statement.setInt(4, seat_state);
			statement.setString(5, reg_dt);
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
