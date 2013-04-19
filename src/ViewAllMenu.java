package GUI;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ViewAllMenu extends JMenuItem implements ActionListener {
	private OperatorGUI gui;
	
	public ViewAllMenu(OperatorGUI gui) {
		super("View All");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {

	}
}
