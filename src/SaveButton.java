package GUI;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SYS.Bicycle;

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
	}
}
