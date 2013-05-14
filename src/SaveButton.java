package GUI;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SYS.Bicycle;

/**
 * This class creates a new JButton with the text "Save", used to add bikers to the system.
 *
 */
public class SaveButton extends JButton implements ActionListener {
	private OperatorGUI gui;

	public SaveButton(OperatorGUI gui) {
		super("Save");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		gui.saveUser(gui.pinTextField.getText(),
						gui.pinCodeTextField.getText(),
						new Bicycle(gui.bicycleTextField.getText()),
						gui.nameTextField.getText(),
						gui.phoneNumTextField.getText());
		gui.changeView(OperatorGUI.DEFAULT_MODE);
	}
}
