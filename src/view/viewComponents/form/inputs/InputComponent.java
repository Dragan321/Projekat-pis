/***********************************************************************
 * Module:  InputComponent.java
 * Author:  Notebook
 * Purpose: Defines the Class InputComponent
 ***********************************************************************/

package view.viewComponents.form.inputs;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Rectangle;


public class InputComponent extends Container implements Input {
	private InputField inputField;
	private InputLabel inputLabel;
	int height;
	int x;
	int y;
	
	public InputComponent(int x, int y, int width, int height, InputField inputField, InputLabel inputLabel) {
		this.inputField = inputField;
		this.inputLabel = inputLabel;
		this.height = height;
		this.x = x;
		this.y = y;
				
		inputLabel.setStartPosition(x,y,height);
		inputField.setStartPosition(x+(int)inputLabel.getBounds().getWidth(),y,height);
		
		this.setBackground(Color.blue);

		add(inputLabel);
		add(inputField.getComponent());

		
	}

	public InputField getInputField() {
		return inputField;
	}

	public InputLabel getInputLabel() {
		return inputLabel;
	}

	@Override
	public Rectangle getBounds() {
		Rectangle bounds = new Rectangle(x,y,(int)inputLabel.getBounds().getWidth()+(int)inputField.getBounds().getWidth(),height);
		return bounds;
	}

	@Override
	public Component getComponent() {
		return this;
	}

	
}