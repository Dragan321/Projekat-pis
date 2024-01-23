/***********************************************************************
 * Module:  ApplicationModel.java
 * Author:  Korisnik
 * Purpose: Defines the Class ApplicationModel
 ***********************************************************************/
package Projekat;

import java.util.*;

/** @pdOid 59e4006d-1e76-463c-a454-2a2bb067dee9 */
public class ApplicationModel {
   /** @pdRoleInfo migr=no name=ApplicationState assc=association1 type=Aggregation */
   public ApplicationState applicationState;
   /** @pdRoleInfo migr=no name=XMLModel assc=association3 type=Aggregation */
   public XMLModel xMLModel;

}