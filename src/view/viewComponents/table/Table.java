/***********************************************************************
 * Module:  Table.java
 * Author:  Korisnik
 * Purpose: Defines the Class Table
 ***********************************************************************/

package view.viewComponents.table;

import observer.Subject;
import view.context.ContextModel;
import view.viewComponents.Utils.UIUtils;
import view.viewComponents.ViewComponent;


import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/** @pdOid 7bc3be78-73c7-4340-a99d-e24a9db31e14 */

public class Table extends JScrollPane implements ViewComponent {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private JTable tabela = null;
	private JTable fiksnaTabela = null;
	private ListSelectionModel listSelectionModel = null;
	private TableModel tableModel = null;

	public Table(ContextModel contextModel) {
		tabela = new JTable() {
			private static final long serialVersionUID = 1L;

			@Override
			public void setRowSelectionInterval(int index0, int index1) {

				int rowCount = super.getRowCount();
				if (rowCount > 0) {
					if (index0 > (rowCount - 1)) {
						super.setRowSelectionInterval(rowCount - 1, rowCount - 1);
					} else if (index0 < 0) {
						super.setRowSelectionInterval(0, 0);
					} else {
						super.setRowSelectionInterval(index0, index1);
					}
				}
			}
		};

		tabela.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
		tabela.setColumnSelectionAllowed(false);
		tabela.setRowSelectionAllowed(true);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
/*

		fiksnaTabela = new JTable() {
			private static final long serialVersionUID = 1L;

			@Override
			public void setRowSelectionInterval(int index0, int index1) {

				int rowCount = super.getRowCount();
				if (rowCount > 0) {
					if (index0 > (rowCount - 1)) {
						super.setRowSelectionInterval(rowCount - 1, rowCount - 1);
					} else if (index0 < 0) {
						super.setRowSelectionInterval(0, 0);
					} else {
						super.setRowSelectionInterval(index0, index1);
					}
				}
			}
		};
		fiksnaTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		setCorner(JScrollPane.UPPER_LEFT_CORNER, fiksnaTabela.getTableHeader());
		setRowHeaderView(fiksnaTabela);

		getRowHeader().setPreferredSize(new Dimension(20, getRowHeader().getPreferredSize().height));
*/

		ListSelectionListener lsListener = new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int nr = ((DefaultListSelectionModel) e.getSource()).getAnchorSelectionIndex();

				if (nr == -1) {
					tabela.setRowSelectionInterval(tabela.getSelectedRow(), tabela.getSelectedRow());
					//fiksnaTabela.setRowSelectionInterval(tabela.getSelectedRow(), tabela.getSelectedRow());

				} else {
					tabela.setRowSelectionInterval(nr, nr);
					//fiksnaTabela.setRowSelectionInterval(nr, nr);
				}
			}

		};

		tabela.getSelectionModel().addListSelectionListener(lsListener);
		/*fiksnaTabela.getSelectionModel().addListSelectionListener(lsListener);
		JTableHeader fiksniJTableHeader  = fiksnaTabela.getTableHeader();
		fiksniJTableHeader.setBackground(UIUtils.COLOR_INTERACTIVE_DARKER);
		fiksniJTableHeader.setForeground(Color.BLACK);
		fiksnaTabela.setSelectionBackground(UIUtils.COLOR_INTERACTIVE_DARKER);
		fiksnaTabela.setSelectionForeground(UIUtils.OFFWHITE);
		fiksnaTabela.setBackground(UIUtils.COLOR_BACKGROUND);
		fiksnaTabela.setForeground(UIUtils.OFFWHITE);
		fiksnaTabela.setFillsViewportHeight(true);
*/
		JTableHeader jTableHeader = tabela.getTableHeader();
		jTableHeader.setBackground(UIUtils.COLOR_INTERACTIVE_DARKER);
		setViewportView(tabela);
		setTableModel(new DatabaseTableModel(contextModel.getDataModel().get(0).getResultSet()));
		getViewport().setBackground(UIUtils.COLOR_BACKGROUND);
		super.setBorder(BorderFactory.createLineBorder(UIUtils.COLOR_OUTLINE));


	}

	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}

	public JTable getFiksnaTabela() {
		return fiksnaTabela;
	}

	public void setFiksnaTabela(JTable fiksnaTabela) {
		this.fiksnaTabela = fiksnaTabela;
	}

	public ListSelectionModel getListSelectionModel() {
		return listSelectionModel;
	}

	public void setListSelectionModel(ListSelectionModel listSelectionModel) {
		this.listSelectionModel = listSelectionModel;
	}

	public TableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(TableModel tableModel) {
		this.tabela.setModel(tableModel);
		//this.fiksnaTabela.setModel(((DatabaseTableModel) tableModel).getFixedColumn());
		this.tableModel = tableModel;
		this.tabela.setRowSelectionInterval(0, 0);
	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub

	}

}
