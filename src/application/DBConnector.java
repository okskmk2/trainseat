package application;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBConnector {
	private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/traindb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String DB_USER = "trainseat";
	private static final String DB_PASSWORD = "1234";
	private static final int CONN_POOL_SIZE = 5;

	private BasicDataSource bds = new BasicDataSource();

	private DBConnector() {
		bds.setDriverClassName(DRIVER_CLASS_NAME);
		bds.setUrl(DB_URL);
		bds.setUsername(DB_USER);
		bds.setPassword(DB_PASSWORD);
		bds.setInitialSize(CONN_POOL_SIZE);
	}

	private static class DataSourceHolder {
		private static final DBConnector INSTANCE = new DBConnector();
	}

	public static DBConnector getInstance() {
		return DataSourceHolder.INSTANCE;
	}

	public BasicDataSource getBds() {
		return bds;
	}

	public void setBds(BasicDataSource bds) {
		this.bds = bds;
	}


}
