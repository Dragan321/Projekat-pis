/***********************************************************************
 * Module:  DBConnection.java
 * Author:  Notebook
 * Purpose: Defines the Class DBConnection
 ***********************************************************************/

package model.databaseAccess;

import java.awt.Component;
import java.io.Console;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public abstract class DBConnection {
	protected DBConfiguration dbConfiguration = null;

	protected static Connection conn = null;

	public abstract Connection getConnection(DBConfiguration configuration);

	public Connection getConnection() {
		if (conn != null)
		{
			return conn;
		}

		return null;
	}

	public void closeConnection() {
		if(conn == null) {
			return;
		}
		
		try {
			conn.close();
		}
		catch (SQLException e) {
			ErrorHandlerFunction(null, e.getMessage());
		}
		finally {
			conn = null;
		}
	}
	
	public Boolean isConnectionOpen()
	{
		if (conn != null)
		{
			return true;
		}

		return false;
	}
	
	public Boolean isConnectionValid(int timeout)
	{
		if (conn != null)
		{
			try
			{
				return conn.isValid(timeout);
			}
			catch (SQLException e)
			{
				ErrorHandlerFunction(null, e.getMessage());
			}
		}

		return false;
	}
	
	protected void ErrorHandlerFunction(Component comp, String errorMessage)
	{
		JOptionPane.showMessageDialog(comp, errorMessage, "Error", 0);
	}


}