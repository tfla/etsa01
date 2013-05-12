package GUI;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SYS.Bicycle;

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
		if (!s.matches("[0-9]{6,6}?-[0-9]{4,4}?")) {
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

		gui.saveUser(gui.pinTextField.getText(),
						gui.pinCodeTextField.getText(),
						new Bicycle(gui.bicycleTextField.getText()),
						gui.nameTextField.getText(),
						gui.phoneNumTextField.getText());
	}
}
