
package model.command;

import model.ApplicationModel;

import java.util.*;

/** @pdOid ddc8bb2a-c5a3-4f1d-90b0-7101515300be */
public abstract class Command {
   /** @pdOid 8c111c4c-6dbb-4962-a245-45f3464a3d3e */
   private ApplicationModel application;
   
   /** @pdRoleInfo migr=no name=ApplicationModel assc=association8 mult=0..1 type=Aggregation */
   public ApplicationModel applicationModel;
   
   /** @pdOid cba45a5d-2fdb-4839-9816-089807f8c0ec */
   public ApplicationModel getApplication() {
      return application;
   }
   
   /** @param newApplication
    * @pdOid 9abd5650-f34e-486c-a881-fcf91a21ff58 */
   public void setApplication(ApplicationModel newApplication) {
      application = newApplication;
   }
   
   /** @pdOid ed16e2af-09b7-47f4-9d2e-4edd94891ef6 */
   public void execute() {
      // TODO: implement
   }


}