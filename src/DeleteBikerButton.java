package GUI;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import SYS.User;

/**
 * This class creates a JButton with the text "Delete", used to delete a biker from the system.
 *
 */
public class DeleteBikerButton extends JButton implements ActionListener {
	private OperatorGUI gui;
	private JFileChooser fc;

	/**
	 * Creates a new DeleteBikerButton and sets the text to "Delete".
	 *
	 */
	public DeleteBikerButton(OperatorGUI gui) {
		super("Delete");
		this.gui = gui;
		fc = new JFileChooser();
		fc.setDialogTitle("Select and edit an existing biker.");
		addActionListener(this);
	}

	/**
	 * Called when the button is pressed, deleted the biker from the system.
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		String pin = gui.pinTextField.getText();
		User u = gui.getUser(pin);
		if (u != null) {
			if (gui.deleteUser(u)) {
				gui.showMessageDialog("User successfully removed.");
			}
		}
		gui.changeView(gui.DEFAULT_MODE);
	}
}
