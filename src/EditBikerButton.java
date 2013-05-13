package GUI;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SYS.User;
/**
 * This class creates a JButton with the text "Edit biker", used to edit bikers.
 *
 */
public class EditBikerButton extends JButton implements ActionListener {
	private OperatorGUI gui;

	/**
	 * Creates a new EditBikerButton and sets the text to "Edit biker".
	 *
	 */
	public EditBikerButton(OperatorGUI gui) {
		super("Edit biker");
		this.gui = gui;
		addActionListener(this);
	}

	/**
	 * Called when the button is pressed, sets the currentBiker with the help of a showInputDialog then changes the view of OperatorGUI to "edit-mode".
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		String pin = JOptionPane.showInputDialog(null, "Enter the bikers Personal Identification Number (PIN).");
		User u = gui.getUser(pin);
		if (u != null) {
			gui.setCurrentBiker(u);
			gui.changeView(OperatorGUI.EDIT_MODE);
		}
	}
}
