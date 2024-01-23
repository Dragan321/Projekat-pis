/***********************************************************************
 * Module:  TextValidator.java
 * Author:  Notebook
 * Purpose: Defines the Class TextValidator
 ***********************************************************************/

package view.viewComponents.form.inputValidators;

public class EmptyValidator extends AbstractInputValidator {

	public boolean validate(String input) {
		if(input.length() > 0) {
			return true;					
		}
		return false;
	}
}