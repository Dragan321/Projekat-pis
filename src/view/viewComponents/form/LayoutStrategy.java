/***********************************************************************
 * Module:  LayoutStrategy.java
 * Author:  Notebook
 * Purpose: Defines the Class LayoutStrategy
 ***********************************************************************/

package view.viewComponents.form;

import java.awt.*;

public class LayoutStrategy {
    LayoutManager layoutManager;

    public LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

}