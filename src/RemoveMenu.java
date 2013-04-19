package GUI;

import javax.swing.*;
import java.awt.event.*;

public class RemoveMenu extends JMenuItem implements ActionListener {
	private OperatorGUI gui;
	
	public RemoveMenu(OperatorGUI gui) {
		super("Remove");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
