/***********************************************************************
 * Module:  DatabaseAccess.java
 * Author:  Korisnik
 * Purpose: Defines the Class DatabaseAccess
 ***********************************************************************/
package Projekat;

import java.util.*;

/** @pdOid 456c5633-7266-444d-bb7c-73eeb6cc56be */
public class DatabaseAccess {
   /** @pdRoleInfo migr=no name=DatabaseConnection assc=association10 type=Aggregation */
   public DatabaseConnection databaseConnection;
   /** @pdRoleInfo migr=no name=DatabaseAccess assc=association12 type=Aggregation */
   public DatabaseAccess databaseAccessB;

}