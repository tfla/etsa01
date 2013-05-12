package GUI;

import javax.swing.JMenuItem;
import javax.swing.JFileChooser;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveAsMenu extends JMenuItem implements ActionListener {
	private OperatorGUI gui;
	private JFileChooser fc;

	public SaveAsMenu(OperatorGUI gui) {
		super("Save as ...");
		this.gui = gui;
		fc = new JFileChooser();
		fc.setDialogTitle("Select a path to save the file on");
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		int i = fc.showSaveDialog(null);
		if (i == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			gui.saveGarage(f);
		}
	}
}
