/***********************************************************************
 * Module:  OperationCommand.java
 * Author:  Korisnik
 * Purpose: Defines the Class OperationCommand
 ***********************************************************************/

package view;

import model.ApplicationModel;
import model.command.Command;

/** @pdOid 432176c1-5206-4cde-9dbc-2be4bed69faf */
public abstract class OperationCommand extends Command {
   /** @pdOid c4e6cde5-7266-4bdd-aa46-2deb4783fe48 */
   public ApplicationModel getApplication() {
      // TODO: implement
      return null;
   }
   
   /** @param newApplication
    * @pdOid 098c97d3-6076-42c2-a396-24c3c8fbd574 */
   public void setApplication(ApplicationModel newApplication) {
      // TODO: implement
   }
   
   /** @pdOid 7a22341d-32ab-4b21-a2e3-0da687069069 */
   public void execute() {
      // TODO: implement
   }

}