package GUI;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class OpenMenu extends JMenuItem implements ActionListener {
	private OperatorGUI gui;

	public OpenMenu(OperatorGUI gui) {
		super("Open");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
			
	}
}
