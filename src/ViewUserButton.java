package GUI;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import SYS.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a new JButton with the text "View", used to view a selected user's information.
 *
 */
@SuppressWarnings("serial")
public class ViewUserButton extends JButton implements ActionListener {
	private OperatorGUI gui;
	private JFileChooser fc;
	private SYS.User user;

	/**
	 * Creates a new ViewUserButton and sets the text to "View".
	 *
	 */
	public ViewUserButton(OperatorGUI gui, SYS.User user) {
		super("View");
		this.gui = gui;
		this.user = user;
		fc = new JFileChooser();
		fc.setDialogTitle("Select and edit an existing user.");
		addActionListener(this);
	}

	/**
	 * Called when the button is pressed, sets the currentUser and changes the view of OperatorGUI to "view-mode".
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		gui.setCurrentUser(user);
		gui.changeView(OperatorGUI.VIEW_MODE);
	}
}
