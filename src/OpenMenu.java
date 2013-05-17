package GUI;

import javax.swing.JMenuItem;
import javax.swing.JFileChooser;



import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a JMenuItem with the text "Open", used to open other storage files.
 *
 */
@SuppressWarnings("serial")
public class OpenMenu extends JMenuItem implements ActionListener {
	private OperatorGUI gui;
	private JFileChooser fc;

	/**
	 * Creates a new OpenMenu and sets the text to "Open".
	 *
	 */
	public OpenMenu(OperatorGUI gui) {
		super("Open");
		this.gui = gui;
		fc = new JFileChooser();
		fc.setDialogTitle("Select a file to open.");
		addActionListener(this);
	}

	/**
	 * Called when the menu-item is pressed, opens another storage file.
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		int i = fc.showOpenDialog(null);
		if (i == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			gui.openGarage(f);
		}
		gui.changeView(OperatorGUI.DEFAULT_MODE);
	}
}
