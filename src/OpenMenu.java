package GUI;

import javax.swing.*;
import java.awt.event.*;

/**
 * This class creates a JMenuItem with the text "Open", used to open other storage files.
 *
 */
@SuppressWarnings("serial")
public class OpenMenu extends JMenuItem implements ActionListener {
	private OperatorGUI gui;

	/**
	 * Creates a new OpenMenu and sets the text to "Open".
	 *
	 */
	public OpenMenu(OperatorGUI gui) {
		super("Open");
		this.gui = gui;
		addActionListener(this);
	}

	/**
	 * Called when the menu-item is pressed, opens another storage file.
	 *
	 */
	public void actionPerformed(ActionEvent e) {
			
	}
}
