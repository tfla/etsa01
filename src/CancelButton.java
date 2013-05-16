package GUI;

import javax.swing.JButton;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a JButton with the text "Cancel", used to go back to "default-mode".
 *
 */
@SuppressWarnings("serial")
public class CancelButton extends JButton implements ActionListener {
	private OperatorGUI gui;

	/**
	 * Creates a new CancelButton and sets the text to "Cancel".
	 *
	 */
	public CancelButton(OperatorGUI gui) {
		super("Cancel");
		this.gui = gui;
		addActionListener(this);
	}
	
	/**
	 * Called when the button is pressed, changes the view of OperatorGUI to "default-mode".
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		gui.changeView(OperatorGUI.DEFAULT_MODE);
	}
}
