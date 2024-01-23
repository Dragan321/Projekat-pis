/***********************************************************************
 * Module:  Toolbar.java
 * Author:  Korisnik
 * Purpose: Defines the Class Toolbar
 ***********************************************************************/

package view.viewComponents.toolbar;

import model.DbResultSet;
import model.command.Command;
import model.command.applicationCommands.LogoutCommand;
import model.command.applicationCommands.PrintCommand;
import model.command.operationCommands.CreateCommand;
import model.command.operationCommands.DeleteCommand;
import model.command.operationCommands.UpdateCommand;
import observer.Subject;
import view.MainPage;
import view.View;
import view.context.ContextView;
import view.viewComponents.Utils.UIUtils;
import view.viewComponents.ViewComponent;
import view.context.ContextModel;
import view.viewComponents.table.Table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.*;

/** @pdOid e0a869d3-7c9f-45bf-8444-59bd60598aa2 */


public class Toolbar extends JToolBar implements ViewComponent {
	private static final long serialVersionUID = 1L;

	private Vector<AbstractButton> buttons = new Vector<>();

	public Toolbar(ContextModel contextModel, View view) {

		//setRollover(true);
		setBorderPainted(true);
		setFloatable(false);
		setBackground(UIUtils.COLOR_BACKGROUND);

		JButton create = new JButton();
		create.setSize(24, 24);
		create.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/table_row_insert.png")
				.getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)));
		create.setToolTipText("Novi zapis");
		create.setActionCommand("create");
		create.setBackground(UIUtils.COLOR_BACKGROUND);
		create.setBorderPainted(false);
		create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JTable tabela = ((MainPage)(view.getContextViews().get(view.getContextViews().size()-1).getWindow().getViewComponents().get(3))).getTable().getTabela();
				int selectedRow= tabela.getRowCount()-1;
				int colCount = tabela.getColumnCount();
				String[] coloumns = new String[colCount];
				Object[] values = new Object[colCount];

				for (int i = 0; i < colCount; i++) {
					values[i] = tabela.getValueAt(selectedRow, i);
					coloumns[i] = tabela.getColumnName(i);
				}



				DbResultSet resultSet = view.getContextViews().get(view.getContextViews().size()-1).getContextModel().getDataModel().lastElement().resultSet;

				Command insertCommand = new CreateCommand(view.getApplicationModel(), coloumns, values, resultSet);
				insertCommand.execute();
				((MainPage)(view.getContextViews().get(view.getContextViews().size()-1).getWindow().getViewComponents().get(3))).refreshPage();

				selectedRow = tabela.getSelectedRow() - 1;
				for (int i = 0; i < colCount; i++) {
					tabela.setValueAt("",selectedRow, i);
				}

			}
		});



		JButton update = new JButton();
		update.setSize(24, 24);
		update.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/table_edit.png")
				.getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)));
		update.setToolTipText("Ažuriraj zapis");
		update.setActionCommand("update");
		update.setBackground(UIUtils.COLOR_BACKGROUND);
		update.setBorderPainted(false);
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((MainPage)(view.getContextViews().get(view.getContextViews().size()-1).getWindow().getViewComponents().get(3))).refreshPage();
			}
		});




		JButton delete = new JButton();
		delete.setSize(24, 24);
		delete.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/table_row_delete.png")
				.getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)));
		delete.setToolTipText("Izbrisati zapis");
		delete.setActionCommand("delete");
		delete.setBackground(UIUtils.COLOR_BACKGROUND);
		delete.setBorderPainted(false);

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow= ((MainPage)(view.getContextViews().get(view.getContextViews().size()-1).getWindow().getViewComponents().get(3))).getTable().getTabela().getSelectedRow();
				String primaryKey = ((MainPage)(view.getContextViews().get(view.getContextViews().size()-1).getWindow().getViewComponents().get(3))).getTable().getTabela().getValueAt(selectedRow, 0).toString();
				DbResultSet resultSet = view.getContextViews().get(view.getContextViews().size()-1).getContextModel().getDataModel().lastElement().resultSet;


				Command deleteCommand = new DeleteCommand(view.getApplicationModel(), primaryKey, resultSet);
				deleteCommand.execute();

				((MainPage)(view.getContextViews().get(view.getContextViews().size()-1).getWindow().getViewComponents().get(3))).refreshPage();


			}
		});





		JButton first = new JButton();
		first.setSize(24, 24);
		first.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/First.png")
				.getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)));
		first.setToolTipText("Prvi zapis");
		first.setActionCommand("first");
		first.setBackground(UIUtils.COLOR_BACKGROUND);
		first.setBorderPainted(false);

		first.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((MainPage)(view.getContextViews().get(view.getContextViews().size()-1).getWindow().getViewComponents().get(3))).getTable().getTabela().setRowSelectionInterval(0,0);

			}
		});





		JButton prev = new JButton();
		prev.setSize(24, 24);
		prev.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/Prev.png").getScaledInstance(20,
				20, Image.SCALE_AREA_AVERAGING)));
		prev.setToolTipText("Prethodni zapis");
		prev.setActionCommand("prev");
		prev.setBackground(UIUtils.COLOR_BACKGROUND);
		prev.setBorderPainted(false);

		prev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow= ((MainPage)(view.getContextViews().get(view.getContextViews().size()-1).getWindow().getViewComponents().get(3))).getTable().getTabela().getSelectedRow();
				if(selectedRow-1 >=0){
					((MainPage)(view.getContextViews().get(view.getContextViews().size()-1).getWindow().getViewComponents().get(3))).getTable().getTabela().setRowSelectionInterval(selectedRow-1, selectedRow-1);

				}


			}
		});



		JButton next = new JButton();
		next.setSize(24, 24);
		next.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/Next.png").getScaledInstance(20,
				20, Image.SCALE_AREA_AVERAGING)));
		next.setToolTipText("Sledeći zapis");
		next.setActionCommand("next");
		next.setBackground(UIUtils.COLOR_BACKGROUND);
		next.setBorderPainted(false);

		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow= ((MainPage)(view.getContextViews().get(view.getContextViews().size()-1).getWindow().getViewComponents().get(3))).getTable().getTabela().getSelectedRow();
				int rowCount = ((MainPage)(view.getContextViews().get(view.getContextViews().size()-1).getWindow().getViewComponents().get(3))).getTable().getTabela().getRowCount();

				if(selectedRow+1 <rowCount){
					((MainPage)(view.getContextViews().get(view.getContextViews().size()-1).getWindow().getViewComponents().get(3))).getTable().getTabela().setRowSelectionInterval(selectedRow+1, selectedRow+1);
				}


			}
		});


		JButton last = new JButton();
		last.setSize(24, 24);
		last.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/Last.png").getScaledInstance(20,
				20, Image.SCALE_AREA_AVERAGING)));
		last.setToolTipText("Poslednji zapis");
		last.setActionCommand("last");
		last.setBackground(UIUtils.COLOR_BACKGROUND);
		last.setBorderPainted(false);

		last.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int rowCount = ((MainPage)(view.getContextViews().get(view.getContextViews().size()-1).getWindow().getViewComponents().get(3))).getTable().getTabela().getRowCount()-1;
				((MainPage)(view.getContextViews().get(view.getContextViews().size()-1).getWindow().getViewComponents().get(3))).getTable().getTabela().setRowSelectionInterval(rowCount,rowCount);

			}
		});


		/*JButton accept = new JButton();
		accept.setSize(24, 24);
		accept.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/tick-mark (1).png")
				.getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)));
		accept.setToolTipText("Prihvati");
		accept.setActionCommand("accept");
		accept.setBackground(UIUtils.COLOR_BACKGROUND);

		JButton cancel = new JButton();
		cancel.setSize(24, 24);
		cancel.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/multiply (1).png")
				.getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)));
		cancel.setToolTipText("Odustani");
		cancel.setActionCommand("cancel");
		cancel.setBackground(UIUtils.COLOR_BACKGROUND);*/

		JButton report = new JButton();
		report.setSize(24, 24);
		report.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/print.png")
				.getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)));
		report.setToolTipText("Print");
		report.setActionCommand("report");
		report.setBackground(UIUtils.COLOR_BACKGROUND);
		report.setBorderPainted(false);
		report.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Command print = new PrintCommand(((MainPage)(view.getContextViews().get(view.getContextViews().size()-1).getWindow().getViewComponents().get(3))).getTable().getTabela());
				print.execute();
			}
		});

		JButton logOut = new JButton();
		logOut.setSize(24, 24);
		logOut.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/logout-icon.png")
				.getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)));
		logOut.setToolTipText("Odjavi se");
		logOut.setActionCommand("logOut");
		logOut.setBackground(UIUtils.COLOR_BACKGROUND);
		logOut.setBorderPainted(false);


		logOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new LogoutCommand(view.getApplicationModel()).execute();

				for(ContextView contextView: view.getContextViews()) {
					contextView.getWindow().setVisible(false);
				}
				view.getContextViews().removeAllElements();
				view.getContextViews().add(new ContextView(new ContextModel(view.getApplicationModel().getDataModel(),
						view.getApplicationModel().getUserModel()), view));
			}
		});

		/*JButton profile = new JButton();
		profile.setSize(24, 24);
		profile.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/profile-icon.png")
				.getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)));
		profile.setToolTipText("Profil");
		profile.setActionCommand("profile");
		profile.setBackground(UIUtils.COLOR_BACKGROUND);*/

		add(create);
		add(update);
		add(delete);
		addSeparator();
		add(first);
		add(prev);
		add(next);
		add(last);
		addSeparator();
		//add(accept);
		//add(cancel);
		addSeparator();
		add(report);

		add(Box.createHorizontalGlue());
		//add(profile);
		addSeparator();
		add(logOut);

		buttons.add(create);
		buttons.add(update);
		buttons.add(delete);
		buttons.add(create);
		buttons.add(first);
		buttons.add(prev);
		buttons.add(next);
		buttons.add(last);
		//buttons.add(accept);
		//buttons.add(cancel);
		buttons.add(report);
		buttons.add(logOut);
		//buttons.add(profile);

	}

	public Vector<AbstractButton> getButtons() {
		return buttons;
	}

	public void setButtons(Vector<AbstractButton> buttons) {
		this.buttons = buttons;
	}

	@Override
	public void update(Subject subject) {

	}

}