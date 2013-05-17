package GUI;

import javax.swing.JMenuItem;
import javax.swing.JFileChooser;



import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a JMenuItem with the text "Save as ...", used to save the storage file to a new location and/or with a new name.
 *
 */
@SuppressWarnings("serial")
public class SaveAsMenu extends JMenuItem implements ActionListener {
	private OperatorGUI gui;
	private JFileChooser fc;

	/**
	 * Creates a new SaveAsMenu and sets the text to "Save as ...".
	 *
	 */
	public SaveAsMenu(OperatorGUI gui) {
		super("Save as ...");
		this.gui = gui;
		fc = new JFileChooser();
		fc.setDialogTitle("Select a path to save the file on.");
		addActionListener(this);
	}

	/**
	 * Called when the menu-item is pressed, launches a JFileChooserDialog and saves the storage file to the path specified, if any.
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		int i = fc.showSaveDialog(null);
		if (i == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			gui.saveGarage(f);
		}
	}
}
