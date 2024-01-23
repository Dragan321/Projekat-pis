package view.viewComponents.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import model.command.Command;

import observer.Subject;
import view.context.ContextModel;
import view.viewComponents.ViewComponent;

public class MenuItem extends JMenuItem implements ViewComponent {

	private static final long serialVersionUID = 1L;

	private ContextModel contextModel;

	public void setContextModel(ContextModel contextModel) {
		this.contextModel = contextModel;
	}

	public MenuItem(String text, ContextModel contextModel) {
		super();
		setText(text);
		this.contextModel = contextModel;
	}

	public MenuItem(String text, ContextModel contextModel, Command command) {
		this(text, contextModel);
		setCommandOnListener(command);
	}

	private void setCommandOnListener(Command command) {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				command.execute();
			}
		});
	}

	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub

	}

}
