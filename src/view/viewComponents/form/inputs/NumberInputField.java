
package view.viewComponents.form.inputs;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

import view.viewComponents.form.inputValidators.AbstractInputValidator;
import view.viewComponents.form.inputValidators.EmptyValidator;

public class NumberInputField extends InputField {

	private JTextField textField = null;
	private int width;
	/**
	 * 
	 * @param x         - x position of a textField
	 * @param y         - y position of a textField
	 * @param width     - width of a textField
	 * @param height    - height of a textField
	 * @param name      - name of a textField
	 * @param maxLength - maxLength of a textField
	 */
	public NumberInputField(int width, int maxLength, String name) {
		textField = new JTextField();
		this.name = name;
		this.required = false;
		this.enabled = true;
		this.width = width;

		textField.setName(name);

		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String value = textField.getText();
				if (!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || value.length() > maxLength - 1) {
					e.consume();
				}
			}
		});
	}

	public JTextField getTextField() {
		return textField;
	}
	
	public Rectangle getBounds() {
		return textField.getBounds();
	}

	@Override
	public boolean validateField() {
		for (AbstractInputValidator validator : validators) {
			if (validator.validate(textField.getText()) == false) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void setStartValue(String value) {
		super.setStartValue(value);
		textField.setText(startValue);

	}

	@Override
	public void setRequired(boolean required) {
		super.setRequired(required);
		if (required) {
			validators.add(new EmptyValidator());
		}
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		textField.setEnabled(enabled);
	}

	@Override
	public void setStartPosition(int x, int y, int height) {
		textField.setBounds(x,y,width,height);
	}

	@Override
	public Component getComponent() {
		return textField;
	}
}