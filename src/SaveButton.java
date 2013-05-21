package GUI;

import javax.swing.JButton;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import SYS.Bicycle;

/**
 * This class creates a new JButton with the text "Save", used to add users to the system.
 *
 */
@SuppressWarnings("serial")
public class SaveButton extends JButton implements ActionListener {
	private OperatorGUI gui;

	public SaveButton(OperatorGUI gui) {
		super("Save");
		this.gui = gui;
		addActionListener(this);
	}
	
	/**
	 * Called when the button is pressed, saves the user to the system.
	 */
	public void actionPerformed(ActionEvent e) {
		if (gui.getCurrentMode() == OperatorGUI.EDIT_MODE){
			gui.editUser(gui.nameTextField.getText(), gui.phoneNumTextField.getText(), gui.getCurrentUser());
		} else {
			gui.saveUser(gui.pinTextField.getText(),
							gui.pinCodeTextField.getText(),
							new Bicycle(gui.bicycleTextField.getText()),
							gui.nameTextField.getText(),
							gui.phoneNumTextField.getText());	
		}
	}
}
