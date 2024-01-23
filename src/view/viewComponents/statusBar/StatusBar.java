/***********************************************************************
 * Module:  StatusBar.java
 * Author:  Korisnik
 * Purpose: Defines the Class StatusBar
 ***********************************************************************/

package view.viewComponents.statusBar;

import model.ApplicationModel;
import model.UserModel;
import model.state.ActiveState;
import model.state.ApplicationState;
import model.state.EditingState;
import model.state.IdleState;
import observer.Subject;
import view.viewComponents.Utils.UIUtils;
import view.viewComponents.ViewComponent;

import javax.swing.*;
import java.awt.*;

/** @pdOid 66e2e8a9-2e90-4dbe-87f4-7c7f72c1a0c9 */
public class StatusBar extends JPanel implements ViewComponent {

	private static final long serialVersionUID = 1L;

	protected JPanel leftPanel;
	protected JPanel centerPanel;
	protected JPanel rightPanel;

	private static TimerThread timerThread = null;

	public static void terminateTimerThread() {
		if (timerThread != null)
			timerThread.setRunning(false);
	}
	public static void startTimerThread() {
		timerThread.setRunning(true);
	}

	public StatusBar() {
		createPartControl();
		JLabel leftLabel = null;
		setBackground(UIUtils.COLOR_BACKGROUND);
		setForeground(UIUtils.OFFWHITE);
		leftLabel = new JLabel("<html><b style=\"color:gray\">Net Market je uspješno pokrenut.</b></html>");
		this.setLeftComponent(leftLabel);

		final JLabel dateLabel = new JLabel();
		dateLabel.setHorizontalAlignment(JLabel.CENTER);
		dateLabel.setForeground(UIUtils.OFFWHITE);

		this.addRightComponent(dateLabel);

		final JLabel timeLabel = new JLabel();
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setForeground(UIUtils.OFFWHITE);
		this.addRightComponent(timeLabel);


		timerThread = new TimerThread(dateLabel, timeLabel);
		timerThread.start();
	}

	/** Metoda za rasporeðivanje dijelova statusne linije **/
	protected void createPartControl() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(getWidth(), 23));

		leftPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 3));
		leftPanel.setOpaque(false);
		add(leftPanel, BorderLayout.WEST);

		centerPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 3));
		centerPanel.setOpaque(false);
		add(centerPanel, BorderLayout.CENTER);

		rightPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING, 5, 3));
		rightPanel.setOpaque(false);
		add(rightPanel, BorderLayout.EAST);
	}

	public void setLeftComponent(JComponent component) {
		// Lijeva komponenta se restartuje prije postavljanja nove...
		leftPanel.removeAll();
		leftPanel.add(component);
	}

	public void setCenterComponent(JComponent component) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 0));
		panel.add(new SeparatorPanel(UIUtils.COLOR_OUTLINE, UIUtils.COLOR_OUTLINE));
		panel.add(component);

		centerPanel.removeAll();
		centerPanel.add(panel);
	}

	public void addRightComponent(JComponent component) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 0));
		panel.add(new SeparatorPanel(UIUtils.COLOR_OUTLINE, UIUtils.COLOR_OUTLINE));
		panel.add(component);
		panel.setBackground(UIUtils.COLOR_BACKGROUND);
		rightPanel.add(panel);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int y = 0;
		g.setColor(UIUtils.COLOR_OUTLINE);
		g.drawLine(0, y, getWidth(), y);
		y++;

		g.setColor(UIUtils.COLOR_OUTLINE);
		g.drawLine(0, y, getWidth(), y);
		y++;

		g.setColor(UIUtils.COLOR_OUTLINE);
		g.drawLine(0, y, getWidth(), y);
		y++;

		g.setColor(UIUtils.COLOR_OUTLINE);
		g.drawLine(0, y, getWidth(), y);
		y = getHeight() - 3;

		g.setColor(UIUtils.COLOR_OUTLINE);
		g.drawLine(0, y, getWidth(), y);
		y++;

		g.setColor(UIUtils.COLOR_OUTLINE);
		g.drawLine(0, y, getWidth(), y);
		y++;

		g.setColor(UIUtils.COLOR_OUTLINE);
		g.drawLine(0, y, getWidth(), y);
	}

	@Override
	public void update(Subject subject) {
		ApplicationModel applicationModel = ((ApplicationModel) subject);

		UserModel user = applicationModel.getUserModel();
		String textUser = "";
		JLabel labelUser = new JLabel();

		ApplicationState applicationState = applicationModel.getApplicationState();
		String textState = "";
		JLabel labelState = new JLabel();

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 5, 0));

		if (user == null) {
			textUser = "<html><b style=\"color:gray\">Za pristup sistemu unesite vaše kredencijale.</b></html>";
		} else {
			textUser = "<html><b style=\"color:gray\">Prijavljeni ste kao: " + user.getForename() + " " + user.getSurname()
					+ " sa ulogom " + user.getRole() + ".</b></html>";
		}

		if (applicationState.getClass() == IdleState.class) {
			textState = "<html><b style=\"color:gray\">Neaktivno</b></html>";
		} else if (applicationState.getClass()  == ActiveState.class) {
			textState = "<html><b style=\"color:gray\">Aktivno</b></html>";
		} else if (applicationState.getClass()  == EditingState.class) {
			textState = "<html><b style=\"color:gray\">Uređivanje</b></html>";
		}


		labelUser.setText(textUser);
		labelState.setText(textState);

		panel.add(labelUser);
		panel.add(new SeparatorPanel(UIUtils.COLOR_OUTLINE, UIUtils.COLOR_OUTLINE));
		panel.add(labelState);

		this.setLeftComponent(panel);
		//TODO: Promjeni
		this.setCenterComponent(new JLabel("<html><b style=\"color:gray\"> red 192</b></html>"));

		this.updateUI();
	}

}