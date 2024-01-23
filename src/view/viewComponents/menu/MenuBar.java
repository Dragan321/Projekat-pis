/***********************************************************************
 * Module:  MenuBar.java
 * Author:  Korisnik
 * Purpose: Defines the Class MenuBar
 ***********************************************************************/

package view.viewComponents.menu;

import observer.Subject;
import view.context.ContextModel;
import view.viewComponents.Utils.UIUtils;
import view.viewComponents.ViewComponent;
import view.viewComponents.menu.menus.EditMenu;
import view.viewComponents.menu.menus.FileMenu;
import view.viewComponents.menu.menus.HelpMenu;
import view.viewComponents.menu.menus.LanguageMenu;

import javax.swing.*;
import java.util.*;

/** @pdOid 954e005a-d544-4a1c-a1a4-611d6d6503db */

public class MenuBar extends JMenuBar implements ViewComponent {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private ContextModel contextModel;

    private List<Menu> menus = new Vector<Menu>();

    public MenuBar(ContextModel contextModel) {
        this.contextModel = contextModel;

        //addMenu(new FileMenu(contextModel));
        //addMenu(new EditMenu(contextModel));
        addMenu(new LanguageMenu(contextModel));
        addMenu(new HelpMenu(contextModel));
        setBackground(UIUtils.COLOR_BACKGROUND);
    }

    public void addMenu(Menu menu) {
        menu.setContextModel(contextModel);
        menus.add(menu);
        add(menu);
    }

    @Override
    public void update(Subject subject) {
        // TODO Auto-generated method stub

    }
}