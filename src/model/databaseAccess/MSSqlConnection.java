/***********************************************************************
 * Module:  MSSqlConnection.java
 * Author:  Notebook
 * Purpose: Defines the Class MSSqlConnection
 ***********************************************************************/

package model.databaseAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MSSqlConnection extends DBConnection {

	@Override
	public Connection getConnection(DBConfiguration dbConfiguration) {
		this.dbConfiguration = dbConfiguration;

		this.dbConfiguration.setDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		if(this.dbConfiguration.getPort() != null) {
			this.dbConfiguration.setFullAddress(this.dbConfiguration.getAddress()+ ":" + this.dbConfiguration.getPort());
		}
		else {
			this.dbConfiguration.setFullAddress(this.dbConfiguration.getAddress());
		}

		this.dbConfiguration.setUrl("jdbc:sqlserver://" + this.dbConfiguration.getFullAddress() + ";");

		if(!isConnectionOpen()) {
			this.dbConfiguration.setUrl(this.dbConfiguration.getUrl() + "databaseName=" +this.dbConfiguration.getDbName());

			System.out.println(this.dbConfiguration.getUrl());
			try {
				Class.forName(this.dbConfiguration.getDriver());

				Properties properties = new Properties();
				properties.put("user", this.dbConfiguration.getUser());
				properties.put("password", this.dbConfiguration.getPassword());
				properties.put("charset", "UTF-8");

				conn = DriverManager.getConnection(this.dbConfiguration.getUrl(),properties);

			}

			catch (ClassNotFoundException e)
			{
				ErrorHandlerFunction(null, e.getMessage());
			}
			catch (SQLException e)
			{
				ErrorHandlerFunction(null, e.getMessage());
			}

		}
		return conn;
	}


}