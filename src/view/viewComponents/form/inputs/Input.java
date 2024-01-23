/***********************************************************************
 * Module:  Input.java
 * Author:  Korisnik
 * Purpose: Defines the Class Input
 ***********************************************************************/

package view.viewComponents.form.inputs;

import java.awt.Component;
import java.awt.Rectangle;


/** @pdOid 0b25f642-c636-465c-bb03-060b426c0f0e */
public interface Input {
    public Rectangle getBounds();
    public Component getComponent();
    public InputField getInputField();
    public InputLabel getInputLabel();
}