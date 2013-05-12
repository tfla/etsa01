package GUI;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SYS.User;

public class EditBikerButton extends JButton implements ActionListener {
	private OperatorGUI gui;

	public EditBikerButton(OperatorGUI gui) {
		super("Edit biker");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String pin = JOptionPane.showInputDialog(null, "Enter the bikers Personal Identification Number (PIN).");
		User u = gui.getUser(pin);
		if (u != null) {
			gui.setCurrentBiker(u);
			gui.changeView(OperatorGUI.EDIT_MODE);
		}
	}
}
