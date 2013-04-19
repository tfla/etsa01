package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.lang.StringBuilder;

@SuppressWarnings("serial")
public class FindNamesMenu extends JMenuItem implements ActionListener {
	private OperatorGUI gui;
	
	public FindNamesMenu(OperatorGUI gui) {
		super("Find Name(s)");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
	
	}
}
