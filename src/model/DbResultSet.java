/***********************************************************************
 * Module:  ResultSet.java
 * Author:  Notebook
 * Purpose: Defines the Class ResultSet
 ***********************************************************************/

package model;

import java.sql.*;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.microsoft.sqlserver.jdbc.SQLServerResultSet;
import model.databaseAccess.DBConfiguration;
import model.databaseAccess.DBManipulation;
import model.databaseModel.CRUDOperationModel;

public class DbResultSet {

	DBManipulation DBM = null;
	Connection conn = null;

	CRUDOperationModel crud = null;

	Statement stmt = null;

	PreparedStatement prepStmt = null;

	CallableStatement procStmt = null;

	ResultSet rs = null;
	ResultSetMetaData rsmd = null;

	Vector<Integer> redniBrojevi = new Vector<>();
	Vector<Object> editableCells = new Vector<>();

	public int getRowCount() {
		return rowCount;
	}

	private  int rowCount;

	private String tableName;

	public String getTableName() {
		return tableName;
	}

	public DbResultSet(DBConfiguration configuration) {
		DBM = DBManipulation.createConnection(configuration);
		conn = DBM.getConnection();
	}

	public DbResultSet(DBConfiguration configuration, CRUDOperationModel crud) {
		this.crud = crud;

		DBM = DBManipulation.createConnection(configuration);
		conn = DBM.getConnection();
	}

	public DbResultSet(DBConfiguration configuration, CRUDOperationModel crud, String tableName) {
		this.crud = crud;
		this.tableName = tableName;

		DBM = DBManipulation.createConnection(configuration);
		conn = DBM.getConnection();
	}

	public Vector<Integer> getRedniBrojevi() {
		return redniBrojevi;
	}

	public void setRedniBrojevi(Vector<Integer> redniBrojevi) {
		this.redniBrojevi = redniBrojevi;
	}

	public Vector<Object> getEditableCells() {
		return editableCells;
	}

	public void setEditableCells(Vector<Object> editableCells) {
		this.editableCells = editableCells;
	}

	public DBManipulation getDBM() {
		return DBM;
	}

	public void setDBM(DBManipulation dBM) {
		DBM = dBM;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public CRUDOperationModel getCrud() {
		return crud;
	}

	public void setCrud(CRUDOperationModel crud) {
		this.crud = crud;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public CallableStatement getProcStmt() {
		return procStmt;
	}

	public void setProcStmt(CallableStatement procStmt) {
		this.procStmt = procStmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public ResultSetMetaData getRsmd() {
		return rsmd;
	}

	public void setRsmd(ResultSetMetaData rsmd) {
		this.rsmd = rsmd;
	}

	public int retrieveAll() {
		try {
			procStmt = conn.prepareCall("{ call " + crud.getRetrieveSProc() + "}", SQLServerResultSet.TYPE_SCROLL_INSENSITIVE,
					SQLServerResultSet.CONCUR_READ_ONLY);


			rs = procStmt.executeQuery();
			rsmd = rs.getMetaData();

			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				editableCells.add(new String());

			}

			rs.last();
			rowCount = rs.getRow();
			for (int i = 0; i < rs.getRow(); i++) {
				redniBrojevi.add(i + 1);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQLException Retrieve", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return 0;
	}

	public int login(String[] columns, Object[] values) {
		try {
			String arguments = "(";

			for (int i = 0; i < columns.length; i++) {
				arguments += "?";

				if (i != columns.length - 1) {
					arguments += ",";
				}
			}

			arguments += ")";

			procStmt = conn.prepareCall("{ call " + "std_Login" + arguments + "}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			for (int i = 0; i < values.length; i++) {
				procStmt.setObject(i + 1, values[i]);
			}

			rs = procStmt.executeQuery();
			rsmd = rs.getMetaData();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQLException Retrieve", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Ubacuje nove podatke u bazu kroz stored proceduru pomocu metode
	 **/
	public int insert(String[] columns, Object[] values) {
		try {
			String arguments = "(";

			for (int i = 0; i < columns.length; i++) {
				arguments += "?";

				if (i != columns.length - 1) {
					arguments += ",";
				}
			}

			arguments += ")";

			procStmt = conn.prepareCall("{ call " + crud.getCreateSProc() + arguments + "}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			for (int i = 0; i < values.length; i++) {
				if(values[i]=="")
					procStmt.setObject(i+1, null);
				else
					procStmt.setObject(i + 1, values[i]);
			}

			procStmt.execute();
			rowCount++;
			return 1;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQLException Retrieve", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return 0;
	}

	public int update(String[] columns, Object[] values) {
		try {
			String arguments = "(";

			for (int i = 0; i < columns.length; i++) {
				arguments += "?";

				if (i != columns.length - 1) {
					arguments += ",";
				}
			}

			arguments += ")";

			procStmt = conn.prepareCall("{ call " + crud.getUpdateSProc() + arguments + "}",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			for (int i = 0; i < values.length; i++) {
				if(values[i]=="")
					procStmt.setObject(i+1, null);
				else
					procStmt.setObject(i + 1, values[i]);
			}

			procStmt.execute();

			return 1;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQLException Update", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return 0;
	}



	public int delete(String id) {
		try {
			procStmt = conn.prepareCall("{ call " + crud.getDeleteSProc() + "(?) }", ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			//TODO: testirati ovaj kod
			try {
				procStmt.setInt(1,Integer.parseInt(id));
			} catch (NumberFormatException e) {
				procStmt.setString(1, id);
			}




			int result = procStmt.executeUpdate();

			if (result > 0) {
				retrieveAll();
			}

			procStmt.close();

			return result;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQLException Delete", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return 0;
	}







}





