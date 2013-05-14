package GUI;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SYS.Bicycle;

/**
 * This class creates a new JButton with the text "Save", used to add bikers to the system and save the storage file to its default location with its default name.
 *
 */
public class SaveButton extends JButton implements ActionListener {
	private OperatorGUI gui;
	private String s;

	public SaveButton(OperatorGUI gui) {
		super("Save");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// Check the format of the Personal Identification Number (mmddyy-xxxx).
		s = gui.pinTextField.getText();
		if (!s.matches("[0-9]{2,2}?(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])[-+][0-9]{4,4}?")) {
			gui.showErrorDialog("One or more of the required fields are missing and/or are filled in erroneously.");
			return;
		}

		// Check the format of the PIN-Code (nnnnn).
		s = gui.pinCodeTextField.getText();
		if (!s.matches("[0-9]{5,5}?")) {
			gui.showErrorDialog("One or more of the required fields are missing and/or are filled in erroneously.");
			return; 
		}

		// Check the format of the barcode (nnnnn).
		s = gui.bicycleTextField.getText();
		if (!s.matches("[0-9]{5,5}?")) {
			gui.showErrorDialog("One or more of the required fields are missing and/or are filled in erroneously.");
			return; 
		}

		s = gui.phoneNumTextField.getText();
		if (s != "Telephone Number") {
			if ( (!s.matches("07[036]{1,1}?[0-9]{6,6}?"))) {
				gui.showErrorDialog("Telephone number not on a valid format.");
			}
		}

		gui.saveUser(gui.pinTextField.getText(),
						gui.pinCodeTextField.getText(),
						new Bicycle(gui.bicycleTextField.getText()),
						gui.nameTextField.getText(),
						gui.phoneNumTextField.getText());
	}
}
