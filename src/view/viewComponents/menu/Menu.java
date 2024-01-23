
package view.viewComponents.menu;

import observer.Subject;
import view.viewComponents.Utils.UIUtils;
import view.viewComponents.ViewComponent;
import view.context.ContextModel;
import view.viewComponents.menu.Menu;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.*;
import java.util.List;

/** @pdOid 8e9eea59-fe09-4050-adab-9e975cf4d059 */

public class Menu extends JMenu implements ViewComponent {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private ContextModel contextModel;

	private List<MenuItem> menuItems = new Vector<MenuItem>();
	private List<Menu> menus = new Vector<Menu>();

	public Menu(String text) {
		super();
		UIManager.put("PopupMenu.border", new LineBorder(UIUtils.COLOR_BACKGROUND));
		this.setText(text);
	}

	public Menu(String text, ContextModel contextModel) {
		this(text);
		this.contextModel = contextModel;
	}

	public void setContextModel(ContextModel contextModel) {
		this.contextModel = contextModel;
	}

	public Menu addMenuItem(MenuItem menuItem) {
		menuItem.setContextModel(contextModel);
		menuItems.add(menuItem);
		add(menuItem);

		return this;
	}

	public Menu addMenu(Menu menu) {
		menu.setContextModel(contextModel);
		menus.add(menu);
		add(menu);

		return this;
	}

	@Override
	public void update(Subject subject) {
		menuItems.forEach(menuItem -> menuItem.update(subject));
		menus.forEach(menu -> menu.update(subject));
	}

}
