package view.viewComponents.form.inputs;


import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;

import view.viewComponents.form.inputValidators.AbstractInputValidator;
import view.viewComponents.form.inputValidators.EmptyValidator;

public class PasswordInputField extends InputField {

	JPasswordField passwordField = null;
	private int width;
	
	public PasswordInputField(int width,int maxLength, String name) {
		passwordField = new JPasswordField();
		this.name = name;
		this.required = false;
		this.enabled = true;
		this.width = width;

		passwordField.setName(name);
		
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				String value = passwordField.getText();
				if (value.length() > maxLength - 1) {
					e.consume();
				}
			}
		});

	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	@Override
	public boolean validateField() {
		for (AbstractInputValidator validator : validators) {
			if (validator.validate(passwordField.getText()) == false) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void setStartValue(String value) {
		super.setStartValue(value);
		passwordField.setText(startValue);

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
		passwordField.setEnabled(enabled);
	}

	@Override
	public Rectangle getBounds() {
		return passwordField.getBounds();
	}
	
	@Override
	public void setStartPosition(int x, int y, int height) {
		passwordField.setBounds(x,y,width,height);
	}

	@Override
	public Component getComponent() {
		return passwordField;
	}

}
