package GUI;

import javax.swing.*;
import java.awt.event.*;

/**
 * This class creates a JMenuItem with the text "Save", used to save the storage file to its default location with its default name.
 *
 */
@SuppressWarnings("serial")
public class SaveMenu extends JMenuItem implements ActionListener {
	private OperatorGUI gui;

	/**
	 * Creates a new SaveMenu and sets the text to "Save".
	 *
	 */
	public SaveMenu(OperatorGUI gui) {
		super("Save");
		this.gui = gui;
		addActionListener(this);
	}

	/**
	 * Called when the menu-item is pressed, saves the storage file to its default location with its default name.
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		gui.saveGarage(null);
	}
}
