/***********************************************************************
 * Module:  View.java
 * Author:  Korisnik
 * Purpose: Defines the Class View
 ***********************************************************************/

package view;

import model.ApplicationModel;
import model.command.operationCommands.CloseApplicationCommand;
import view.context.ContextModel;
import view.context.ContextView;
import view.viewComponents.menu.MenuBar;

import java.util.*;

/** @pdOid e1cc0227-cbee-4104-a86a-41d4156a072b */
public class View {
   /** @pdOid caf844b7-7fd9-4c5d-a833-b90f870ba692 */
   private ApplicationModel applicationModel;

   private Vector<ContextView> contextViews;
   private ContextModel contextModel;

   /** @pdRoleInfo migr=no name=MenuBar assc=association4 mult=0..1 type=Composition */
   public MenuBar menuBar;

   public Window getWindow() {
      return window;
   }

   /** @pdRoleInfo migr=no name=Window assc=association5 mult=0..1 type=Composition */
   public Window window;
   
   /** @pdOid d2269e6f-b698-4fb0-ac4c-935a8be4949c */
   public ApplicationModel getApplicationModel() {
      return applicationModel;
   }
   public Vector<ContextView> getContextViews() {
      return contextViews;
   }



   public View(ApplicationModel applicationModel) {
      this.applicationModel = applicationModel;

      this.contextModel = new ContextModel(applicationModel.getDataModel(), applicationModel.getUserModel());
      this.contextViews = new Vector<ContextView>();
      contextViews.add(new ContextView(contextModel, this));

      for (ContextView contextView : this.contextViews) {
         Window window = contextView.getWindow();
         if (window.getClass().getName() == Frame.class.getName()) {
            window.setCloseCommandOnListener(new CloseApplicationCommand(applicationModel));
         }
      }

   }

   public void addContextView(ContextView conView) {
      contextViews.add(conView);
      for (ContextView contextView : this.contextViews) {
         Window window = contextView.getWindow();
         if (window.getClass().getName() == Frame.class.getName()) {
            window.setCloseCommandOnListener(new CloseApplicationCommand(applicationModel));
         }
      }
   }

   public void removeContextView(ContextView contextView) {
      contextViews.remove(contextView);
   }


   /** @param newApplicationModel
    * @pdOid 0a1330f7-9f17-443c-bd6e-6b3e6e78b56a */
   public void setApplicationModel(ApplicationModel newApplicationModel) {
      applicationModel = newApplicationModel;
   }

}