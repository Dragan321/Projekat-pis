
package model;

import java.util.*;

import model.state.IdleState;
import observer.Observer;
import model.state.ApplicationState;

/** @pdOid 6519ae14-2ab2-4ef4-a912-2825ea8ec684 */

public class ApplicationModel implements observer.Subject {
   /** @pdOid 008e7f36-a85c-444f-89a0-8bbd9ec7a8ff */
   private ApplicationState applicationState;
   
   /** @pdRoleInfo migr=no name=XMLModel assc=association1 mult=0..1 */
   public XMLModel xmlModel;
   /** @pdRoleInfo migr=no name=DataModel assc=association2 mult=0..1 type=Aggregation */
   public DataModel dataModel;
   /** @pdRoleInfo migr=no name=ApplicationState assc=association7 mult=0..1 type=Aggregation */
   public ApplicationState appState;


   private UserModel userModel;
   private java.util.Vector<Observer> observers;



   /** @pdOid 4b5cbb55-f085-44f0-8bda-62d89bcb710d */
   public ApplicationState getApplicationState() {
      return applicationState;
   }
   
   /** @param newApplicationState
    * @pdOid 57ecc3ac-67b3-4e47-bf27-d4923d412b55 */
   public void setApplicationState(ApplicationState newApplicationState) {
      applicationState = newApplicationState;
   }

   public DataModel getDataModel() {
      return dataModel;
   }

   public UserModel getUserModel() {
      return userModel;
   }

   public void setUserModel(UserModel userModel) {
      this.userModel = userModel;
   }





   public ApplicationModel() {
      this.applicationState = new IdleState();
      this.xmlModel = new XMLModel("resources/sema.xml");
      this.dataModel = new DataModel(new DbResultSet(xmlModel.getDbConfiguration()), xmlModel);
      this.observers = new Vector<Observer>();
   }





   @Override
public void notifyObservers() {
   for (Observer observer : observers) {
      observer.update(this);
   }
	
}

@Override
public void attachObserver(Observer observer) {
   observers.add(observer);
	
}


@Override
public void deatachObserver(Observer observer) {
   observers.remove(observer);
	
}

}