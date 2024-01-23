/***********************************************************************
 * Module:  InputField.java
 * Author:  Notebook
 * Purpose: Defines the Class InputField
 ***********************************************************************/

package view.viewComponents.form.inputs;

import java.awt.Component;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.JPanel;

import view.viewComponents.form.inputValidators.AbstractInputValidator;

public abstract class InputField{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Vector<AbstractInputValidator> validators;
	protected String name;
	protected boolean required;
	protected boolean enabled;
	protected String startValue;

	public InputField() {
		validators = new Vector<AbstractInputValidator>();
	}

	public abstract boolean validateField();

	public void setRequired(boolean required) {
		this.required = required;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;

	}

	public void setStartValue(String value) {
		this.startValue = value;
	}
	
	public abstract Rectangle getBounds();

	public abstract Component getComponent();
	public abstract void setStartPosition(int x, int y, int height);
}