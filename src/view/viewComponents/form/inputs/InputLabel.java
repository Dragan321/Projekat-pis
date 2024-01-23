/***********************************************************************
 * Module:  InputLabel.java
 * Author:  Korisnik
 * Purpose: Defines the Class InputLabel
 ***********************************************************************/

package view.viewComponents.form.inputs;

import javax.swing.*;
import java.util.*;

/** @pdOid 15f24dd3-f9eb-4ec9-b5b4-3a2a9c8ea5dc */
public class InputLabel extends JLabel {
    private static final long serialVersionUID = 1L;
    int width;

    public InputLabel(int width, String label) {
        this.setText(label);
        this.width = width;
    }

    public void setStartPosition(int x, int y, int height) {
        this.setBounds(x, y,width,height);

    }
}