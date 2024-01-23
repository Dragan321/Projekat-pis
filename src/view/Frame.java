/***********************************************************************
 * Module:  Frame.java
 * Author:  Korisnik
 * Purpose: Defines the Class Frame
 ***********************************************************************/

package view;

import java.awt.*;

import javax.swing.*;

import view.context.ContextModel;
import view.viewComponents.Utils.Separator;
import view.viewComponents.Utils.UIUtils;
import view.viewComponents.ViewComponent;
import view.viewComponents.applicationBrowser.ApplicationBrowser;
import view.viewComponents.toolbar.Toolbar;
import view.viewComponents.statusBar.StatusBar;
import view.viewComponents.menu.MenuBar;


/** @pdOid b4768159-50bc-44ce-87c7-bf2d31f76954 */
public class Frame extends Window {
    private static final long serialVersionUID = 1L;
    private Container contentPane = null;

    public Frame(ContextModel contextModel, View view) {
        super(contextModel);
        Dimension screenSize;
        Dimension frameSize;
        Point location;

        // Osnovna podšavanja
        setTitle("Net Market");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Podesavanja dimenzija i lokacije
        screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        frameSize = new Dimension(screenSize);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // setSize(frameSize);

        location = new Point((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        setLocation(location);
        setMinimumSize(screenSize);

        // Postavljanje komponenti pogleda
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());




        addViewComponent(new MenuBar(contextModel));
        addViewComponent(new Toolbar(contextModel, view));
        addViewComponent(new StatusBar());
        addViewComponent(new MainPage(contextModel));
        addViewComponent(new ApplicationBrowser(contextModel, (MainPage)getViewComponents().lastElement()));
        //TODO: Dodaj jos???
        for (ViewComponent viewComponent : getViewComponents()) {
            if (viewComponent.getClass().getName() == StatusBar.class.getName()) {
                contentPane.add(((StatusBar) viewComponent), BorderLayout.SOUTH);
            } else if (viewComponent.getClass().getName() == MenuBar.class.getName()) {
                setJMenuBar((JMenuBar) viewComponent);
            } else if (viewComponent.getClass().getName() == Toolbar.class.getName()) {
                contentPane.add(((Toolbar) viewComponent), BorderLayout.NORTH);
            } else if (viewComponent.getClass().getName() == ApplicationBrowser.class.getName()) {
                //((ApplicationBrowser) viewComponent).setPreferredSize(new Dimension(300,0));
                contentPane.add(((ApplicationBrowser) viewComponent), BorderLayout.WEST);
            } else if (viewComponent.getClass().getName() == MainPage.class.getName()) {
                contentPane.add(((MainPage) viewComponent), BorderLayout.CENTER);
            }
        }


        contentPane.setBackground(UIUtils.COLOR_BACKGROUND);

        setVisible(true);
    }


}