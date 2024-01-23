/***********************************************************************
 * Module:  SelectionButton.java
 * Author:  Notebook
 * Purpose: Defines the Class SelectionButton
 ***********************************************************************/

package view.viewComponents.form.inputs;

import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SelectionButtonInput extends InputBaseDecorator {
	private static final long serialVersionUID = 1L;
	JButton buttonMore = null;
	
	public SelectionButtonInput(Input input) {
		super(input);
		
		Icon icon = new ImageIcon("icons/icons8-more-24.png");
		buttonMore = new JButton(icon);
		buttonMore.setBounds((int)(input.getBounds().getX()+input.getBounds().getWidth())+2,(int)input.getBounds().getY(),(int)input.getBounds().getHeight(),(int)(input.getBounds().getHeight()));
		add(super.getInputLabel());
		add(super.getInputField().getComponent());
		add(buttonMore);

	}

	@Override
	public Rectangle getBounds() {
		Rectangle bounds = new Rectangle((int)input.getBounds().getX(),(int)input.getBounds().getY(),(int)input.getBounds().getWidth()+(int)buttonMore.getBounds().getWidth(),(int)(input.getBounds().getHeight()));
		return bounds;
	}

	@Override
	public InputField getInputField() {
		return super.getInputField();
	}

	@Override
	public InputLabel getInputLabel() {
		return super.getInputLabel();
	}
}