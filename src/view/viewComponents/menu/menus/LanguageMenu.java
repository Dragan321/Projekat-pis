package view.viewComponents.menu.menus;

import java.awt.Image;

import javax.swing.ImageIcon;

import view.context.ContextModel;
import view.viewComponents.Utils.UIUtils;
import view.viewComponents.menu.Menu;
import view.viewComponents.menu.MenuItem;

public class LanguageMenu extends Menu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public LanguageMenu(ContextModel contextModel) {
		super("Jezik", contextModel);
		super.setForeground(UIUtils.OFFWHITE);
		super.setBackground(UIUtils.COLOR_BACKGROUND);
		MenuItem serbian = new MenuItem("Srpski", contextModel);
		serbian.setForeground(UIUtils.OFFWHITE);
		serbian.setBackground(UIUtils.COLOR_BACKGROUND);
		serbian.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/language.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		addMenuItem(serbian);
		
		MenuItem bosnian = new MenuItem("Bošnjački", contextModel);
		bosnian.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/language.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		bosnian.setForeground(UIUtils.OFFWHITE);
		bosnian.setBackground(UIUtils.COLOR_BACKGROUND);
		addMenuItem(bosnian);
		
		MenuItem croatian = new MenuItem("Hrvatski", contextModel);
		croatian.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/language.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		croatian.setForeground(UIUtils.OFFWHITE);
		croatian.setBackground(UIUtils.COLOR_BACKGROUND);
		addMenuItem(croatian);
			
	}

}
