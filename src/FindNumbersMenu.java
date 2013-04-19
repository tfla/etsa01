package GUI;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.lang.StringBuilder;

@SuppressWarnings("serial")
public class FindNumbersMenu extends JMenuItem implements ActionListener {
	private OperatorGUI gui;
	
	public FindNumbersMenu(OperatorGUI gui) {
		super("Find Number(s)");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
	
	}
}
