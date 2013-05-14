package GUI;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SYS.User;
/**
 * This class creates a JButton with the text "Edit user", used to edit users.
 *
 */
public class EditUserButton extends JButton implements ActionListener {
	private OperatorGUI gui;

	/**
	 * Creates a new EditUserButton and sets the text to "Edit user".
	 *
	 */
	public EditUserButton(OperatorGUI gui) {
		super("Edit user");
		this.gui = gui;
		addActionListener(this);
	}

	/**
	 * Called when the button is pressed, sets the currentUser with the help of a showInputDialog then changes the view of OperatorGUI to "edit-mode".
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		String pin = JOptionPane.showInputDialog(null, "Enter the users Personal Identification Number (PIN).");
		User u = gui.getUser(pin);
		if (u != null) {
			gui.setCurrentUser(u);
			gui.changeView(OperatorGUI.EDIT_MODE);
		}
	}
}
