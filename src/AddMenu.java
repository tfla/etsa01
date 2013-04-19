package GUI;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AddMenu extends JMenuItem implements ActionListener {
	private OperatorGUI gui;

	public AddMenu(OperatorGUI gui) {
		super("Add");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
	
	}
}
