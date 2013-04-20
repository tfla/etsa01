package GUI;

import javax.swing.*;
import java.awt.event.*;

public class SaveMenu extends JMenuItem implements ActionListener {
	private OperatorGUI gui;
	
	public SaveMenu(OperatorGUI gui) {
		super("Save");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
