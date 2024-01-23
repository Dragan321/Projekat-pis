/***********************************************************************
 * Module:  BoxLayoutStrategy.java
 * Author:  Notebook
 * Purpose: Defines the Class BoxLayoutStrategy
 ***********************************************************************/

package view.viewComponents.form;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutStrategy extends LayoutStrategy {
    public BoxLayoutStrategy(Container target, int axis) {
        this.layoutManager =  new BoxLayout(null, 0);
    }

}