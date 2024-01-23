package view.viewComponents.menu.menus;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import view.context.ContextModel;
import view.viewComponents.menu.Menu;
import view.viewComponents.menu.MenuItem;

public class EditMenu extends Menu {
	private static final long serialVersionUID = 1L;

	public EditMenu(ContextModel contextModel) {
		super("Uređivanje", contextModel);
		
		MenuItem first = new MenuItem("Prvi", contextModel);
		first.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/First.png")));
		first.setMnemonic(KeyEvent.VK_KP_UP);
		first.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_KP_UP, KeyEvent.ALT_DOWN_MASK));
		addMenuItem(first);
		
		MenuItem next = new MenuItem("Sledeći", contextModel);
		next.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/Next.png")));
		next.setMnemonic(KeyEvent.VK_KP_RIGHT);
		next.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_KP_RIGHT, KeyEvent.ALT_DOWN_MASK));
		addMenuItem(next);
		
		MenuItem previous = new MenuItem("Prethodni", contextModel);
		previous.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/Prev.png")));
		previous.setMnemonic(KeyEvent.VK_KP_LEFT);
		previous.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_KP_LEFT, KeyEvent.ALT_DOWN_MASK));
		addMenuItem(previous);
		
		MenuItem last = new MenuItem("Poslednji", contextModel);
		last.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/Last.png")));
		last.setMnemonic(KeyEvent.VK_KP_DOWN);
		last.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_KP_DOWN, KeyEvent.ALT_DOWN_MASK));
		addMenuItem(last);

		addSeparator();
		
		MenuItem newItem = new MenuItem("Novi zapis", contextModel);
		newItem.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/table_row_insert.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		newItem.setMnemonic(KeyEvent.VK_N);
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		addMenuItem(newItem);
		
		MenuItem edit = new MenuItem("Uredi", contextModel);
		edit.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/table_edit.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		edit.setMnemonic(KeyEvent.VK_E);
		edit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
		addMenuItem(edit);
		
		MenuItem delete = new MenuItem("Obriši", contextModel);
		delete.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/table_row_delete.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		delete.setMnemonic(KeyEvent.VK_DELETE);
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,KeyEvent.CTRL_DOWN_MASK));
		addMenuItem(delete);
	
		addSeparator();
		
		MenuItem accept = new MenuItem("Prihvati", contextModel);
		accept.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/tick-mark (1).png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		accept.setMnemonic(KeyEvent.VK_ENTER);
		accept.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,KeyEvent.CTRL_DOWN_MASK));
		addMenuItem(accept);
		
		MenuItem cancel = new MenuItem("Odustani", contextModel);
		cancel.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/multiply (1).png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		cancel.setMnemonic(KeyEvent.VK_ESCAPE);
		cancel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,KeyEvent.CTRL_DOWN_MASK));
		addMenuItem(cancel);
		
		addSeparator();
		
		MenuItem report = new MenuItem("Izvještaj", contextModel);
		report.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/call-report-icon-3.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		report.setMnemonic(KeyEvent.VK_P);
		report.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
		addMenuItem(report);
		
		
	}
}
