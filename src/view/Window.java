/***********************************************************************
 * Module:  Window.java
 * Author:  Korisnik
 * Purpose: Defines the Class Window
 ***********************************************************************/

package view;

import model.command.Command;
import view.viewComponents.Utils.UIUtils;
import view.viewComponents.ViewComponent;
import view.viewComponents.menu.MenuBar;
import view.viewComponents.statusBar.StatusBar;
import view.context.ContextModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

/** @pdOid 3486900f-b1a9-42ce-a28d-6fc99c2d49ac */
public class Window extends JFrame {
   /** @pdRoleInfo migr=no name=ViewComponent assc=association6 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   private Vector<ViewComponent> viewComponents;

   private static final long serialVersionUID = 1L;
   protected Container contentPane = null;
   private view.viewComponents.menu.MenuBar menuBar;
   public MenuBar getMenu() {
      return menuBar;
   }


   public Vector<ViewComponent> getViewComponents() {
      return viewComponents;
   }
   
   /** @pdGenerated default iterator getter */

   
   /** @pdGenerated default setter
     * @param newViewComponents */
   public void setViewComponents(java.util.Collection<ViewComponent> newViewComponents) {
      removeAllViewComponents();
      for (java.util.Iterator iter = newViewComponents.iterator(); iter.hasNext();)
         addViewComponent((ViewComponent)iter.next());
   }
   public void addViewComponent(ViewComponent viewComponent) {
      viewComponents.add(viewComponent);
   }



   public void removeViewComponent(ViewComponent viewComponent) {
      viewComponents.remove(viewComponent);
   }


   /** @pdGenerated default removeAll */
   public void removeAllViewComponents() {
      if (viewComponents != null)
         viewComponents.clear();
   }

   public Container getContent() {
      return contentPane;
   }
   public void setContent(Container cp) {
      this.contentPane = cp;
   }

   public Window(ContextModel contextModel) {
      // Podesavanja ikonice
      Image icon = java.awt.Toolkit.getDefaultToolkit().getImage("icons/logomini.png").getScaledInstance(600, 600, Image.SCALE_SMOOTH);
      viewComponents = new Vector<ViewComponent>();
      setIconImage(icon);


   }

   public void setCloseCommandOnListener(Command command) {
      this.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            StatusBar.terminateTimerThread();
            command.execute();
            StatusBar.startTimerThread();

         }
      });
   }



}