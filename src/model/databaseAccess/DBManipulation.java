/***********************************************************************
 * Module:  DBManipulation.java
 * Author:  Notebook
 * Purpose: Defines the Class DBManipulation
 ***********************************************************************/

package model.databaseAccess;

import java.sql.Connection;
import java.util.Vector;

public class DBManipulation {
	public static Vector<DBManipulation> dbManip = new Vector<>();
	private DBConnection connection = null;

	private DBManipulation(DBConfiguration configuration) {
		if (connection == null) {
			if (configuration.getDbType() == DbType.MsSQL_JTDS) {
				connection = new MSSqlConnection();
			}

			connection.getConnection(configuration);
		}
	}

	public static DBManipulation createConnection(DBConfiguration configuration) {

		if (!(dbManip.size() > 0)) {
			DBManipulation dbManipulation = new DBManipulation(configuration);
			dbManip.addElement(dbManipulation);

			return dbManipulation;
		} else {
			for (DBManipulation manip : dbManip) {
				if (manip.dataExist(configuration.getDbType(), configuration.getAddress(), configuration.getPort(),
						configuration.getDbName(), configuration.getUser(), configuration.getPassword())) {
					if (manip.isConnectionValid(5)) {
						return manip;
					} else {
						manip.closeConnection();

						DBManipulation dbManipulation = new DBManipulation(configuration);
						dbManip.addElement(dbManipulation);

						return dbManipulation;
					}
				} else {
					DBManipulation dbManipulation = new DBManipulation(configuration);
					dbManip.addElement(dbManipulation);

					return dbManipulation;
				}
			}
		}

		return null;
	}

	private boolean dataExist(DbType connType, String adress, String port, String dbName, String dbUser,
			String dbPass) {
		if (connection.dbConfiguration.getDbType().equals(connType)
				&& connection.dbConfiguration.getAddress().equals(adress.trim())
				&& connection.dbConfiguration.getPort() == port
				&& connection.dbConfiguration.getDbName().equals(dbName.trim())
				&& connection.dbConfiguration.getUser().equals(dbUser.trim())
				&& connection.dbConfiguration.getPassword().equals(dbPass.trim())) {
			return true;
		}
		return false;
	}

	public Connection getConnection() {
		int index = dbManip.indexOf(this);

		if (dbManip.size() > 0 && index != -1) {
			connection = dbManip.elementAt(index).getDbConnection();
		}

		if (connection != null) {
			return connection.getConnection();
		}
		return null;
	}

	public void closeConnection() {
		int index = dbManip.indexOf(this);

		if (dbManip.size() > 0 && index != -1) {
			connection = dbManip.elementAt(index).getDbConnection();
		}

		if (connection != null) {
			connection.closeConnection();

			if (index != -1) {
				dbManip.removeElementAt(index);
			}
		}
	}

	public Boolean isConnectionOpen() {
		return false;
	}

	public Boolean isConnectionValid(int timeout) {
		int index = dbManip.indexOf(this);

		if (dbManip.size() > 0 && index != -1) {
			connection = dbManip.elementAt(index).getDbConnection();
		} else {
			return false;
		}
		if (connection != null) {
			return true;
		}

		return false;
	}

	public DBConnection getDbConnection() {
		return connection;
	}

	public void closeAllConnection() {
		for (DBManipulation manip : dbManip) {
			manip.closeConnection();
		}
	}
}
