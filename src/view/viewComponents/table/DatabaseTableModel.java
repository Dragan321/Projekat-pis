package view.viewComponents.table;

import model.DbResultSet;
import model.command.operationCommands.UpdateCommand;

import javax.swing.table.AbstractTableModel;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

public class DatabaseTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private DbResultSet resultSet = null;
	private AbstractTableModel fixedColumn = null;

	public DatabaseTableModel(DbResultSet resultSet) {

		this.resultSet = resultSet;

		setFixedColumn(new AbstractTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public Object getValueAt(int row, int col) {
				return resultSet.getRedniBrojevi().elementAt(row) + ".";
			}

			@Override
			public int getRowCount() {
				return resultSet.getRedniBrojevi().size();
			}

			@Override
			public int getColumnCount() {
				return 1;
			}

			@Override
			public String getColumnName(int column) {
				return "#";
			}
		});
	}

	@Override
	public Class<?> getColumnClass(int col) {
		try {
			switch (resultSet.getRsmd().getColumnClassName(col + 1)) {
				case "VARCHAR":
					return String.class;
				case "CHARACTER":
					return String.class;
				case "LONGVARCHAR":
					return String.class;
				case "NUMERIC":
					return BigDecimal.class;
				case "DECIMAL":
					return BigDecimal.class;
				case "BIT":
					return Boolean.class;
				case "TINYINT":
					return Integer.class;
				case "SMALLINT":
					return Integer.class;
				case "INTEGER":
					return Integer.class;
				case "BIGINT":
					return Long.class;
				case "REAL":
					return Float.class;
				case "FLOAT":
					return Double.class;
				case "DOUBLE PRECISION":
					return Double.class;
				case "BINARY":
					return byte[].class;
				case "VARBINARY":
					return byte[].class;
				case "LONGVARBINARY":
					return byte[].class;
				case "DATE":
					return Date.class;
				case "TIME":
					return Time.class;
				case "TIMESTAMP":
					return Timestamp.class;
				default:
					return Object.class;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Object.class;
	}

	@Override
	public String getColumnName(int col) {
		try {
			return resultSet.getRsmd().getColumnName(col + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.getColumnName(col);
	}

	@Override
	public int getColumnCount() {
		try {
			int count = resultSet.getRsmd().getColumnCount();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getRowCount() {
		try {
			resultSet.getRs().beforeFirst();
			resultSet.getRs().last();
			return resultSet.getRs().getRow() + 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Object getValueAt(int row, int col) {
		try {
			resultSet.getRs().beforeFirst();
			resultSet.getRs().last();
			if (resultSet.getRs().getRow() == row) {
				return resultSet.getEditableCells().elementAt(col);
			}
			resultSet.getRs().absolute(row + 1);

			return resultSet.getRs().getObject(col + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return  true;
	}


	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

		try {
			int colCount = resultSet.getRsmd().getColumnCount();
			resultSet.getRs().last();
			int rowCount =resultSet.getRowCount();
			if(rowIndex>rowCount-1){
				resultSet.getEditableCells().remove(columnIndex);
				resultSet.getEditableCells().add(columnIndex, aValue);
			}
			else{
				String[] coloumns = new String[colCount];
				Object[] values = new Object[colCount];
				resultSet.getRs().first();
				while (rowIndex>0){
					rowIndex--;
					resultSet.getRs().next();
				}

				for (int i = 1; i <= colCount; i++) {
					coloumns[i-1] = resultSet.getRsmd().getColumnName(i);
					values[i-1] =resultSet.getRs().getObject(i);
				}
				values[columnIndex] = aValue;
				if(aValue!="") {
					UpdateCommand updateCommand = new UpdateCommand( coloumns, values, resultSet);
					updateCommand.execute();
				}
				/*
				values[columnIndex] = aValue;
				resultSet.update(coloumns, values);*/
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public AbstractTableModel getFixedColumn() {
		return fixedColumn;
	}

	public void setFixedColumn(AbstractTableModel fixedColumn) {
		this.fixedColumn = fixedColumn;
	}



}
