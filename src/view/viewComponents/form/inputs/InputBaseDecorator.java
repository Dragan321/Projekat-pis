/***********************************************************************
 * Module:  InputBaseDecorator.java
 * Author:  Notebook
 * Purpose: Defines the Class InputBaseDecorator
 ***********************************************************************/

package view.viewComponents.form.inputs;

import java.awt.Component;
import java.awt.Container;
import java.awt.Rectangle;

public abstract class InputBaseDecorator extends Container implements Input {
	private static final long serialVersionUID = 1L;
	protected Input input;

	public InputBaseDecorator(Input input) {
		this.input = input;
	}
	
	public abstract Rectangle getBounds();
	
	@Override
	public Component getComponent() {
		return input.getComponent();
	}
	
	@Override
	public InputField getInputField() {
		return input.getInputField();
	}

	@Override
	public InputLabel getInputLabel() {
		return input.getInputLabel();
	}

}