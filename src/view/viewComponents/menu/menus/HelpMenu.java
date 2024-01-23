package view.viewComponents.menu.menus;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import view.context.ContextModel;
import view.viewComponents.Utils.UIUtils;
import view.viewComponents.menu.Menu;
import view.viewComponents.menu.MenuItem;

public class HelpMenu extends Menu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public HelpMenu(ContextModel contextModel) {
		super("Pomoć", contextModel);
		super.setForeground(UIUtils.OFFWHITE);
		super.setBackground(UIUtils.COLOR_BACKGROUND);
		MenuItem about = new MenuItem("O autorima", contextModel);
		about.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/info.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));;
		about.setMnemonic(KeyEvent.VK_I);
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));
		about.setForeground(UIUtils.OFFWHITE);
		about.setBackground(UIUtils.COLOR_BACKGROUND);
		addMenuItem(about);
	}

}
