
package observer;

import java.util.*;

public interface Subject {
   void notifyObservers();

   void attachObserver(Observer observer);
   void deatachObserver(Observer observer);

}