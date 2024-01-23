/***********************************************************************
 * Module:  TableBaseDecorator.java
 * Author:  Notebook
 * Purpose: Defines the Class TableBaseDecorator
 ***********************************************************************/

package view.viewComponents.table;

import view.context.ContextModel;

public abstract class TableBaseDecorator extends Table {
   protected Table table;

   private static final long serialVersionUID = 1L;

   public TableBaseDecorator(Table table, ContextModel contextModel) {
      super(contextModel);
   }


}