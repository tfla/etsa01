package GUI;

import javax.swing.JButton;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a JButton with the text "Create user", used to change to "create-mode".
 *
 */
@SuppressWarnings("serial")
public class NewUserButton extends JButton implements ActionListener {
	private OperatorGUI gui;

	/**
	 * Creates a new NewUserButton and sets the text to "Create user".
	 *
	 */
	public NewUserButton(OperatorGUI gui) {
		super("Create user");
		this.gui = gui;
		addActionListener(this);
	}

	/**
	 * Called when the button is pressed, changes the view of OperatorGUI to "create-mode".
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		gui.changeView(OperatorGUI.CREATE_MODE);
	}
}
