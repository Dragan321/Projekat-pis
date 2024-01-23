package view.viewComponents.menu.menus;


import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import view.context.ContextModel;
import view.viewComponents.menu.Menu;
import view.viewComponents.menu.MenuItem;

public class FileMenu extends Menu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public FileMenu(ContextModel contextModel) {
		super("Fajl", contextModel);
	
		MenuItem insertXML = new MenuItem("Izaberi XML", contextModel);
		insertXML.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/xml.png")));
		addMenuItem(insertXML);
		
		MenuItem changeXML = new MenuItem("Izmjeni XML", contextModel);
		changeXML.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/change-xml.png")));
		addMenuItem(changeXML);
		
		addSeparator();
		
		MenuItem close = new MenuItem("Zatvori aplikaciju", contextModel);
		close.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/close.png")));
		close.setMnemonic(KeyEvent.VK_ESCAPE);
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, KeyEvent.ALT_DOWN_MASK));
		addMenuItem(close);
		
	}

}
