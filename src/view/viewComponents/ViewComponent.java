/***********************************************************************
 * Module:  ViewComponent.java
 * Author:  Korisnik
 * Purpose: Defines the Interface ViewComponent
 ***********************************************************************/

package view.viewComponents;

import observer.Subject;

import java.util.*;

/** @pdOid 4940067a-aad3-42eb-b0dc-7ecbc89bfbfa */
public interface ViewComponent extends observer.Observer {
    void update(Subject subject);

}