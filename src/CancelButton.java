package GUI;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CancelButton extends JButton implements ActionListener {
	private OperatorGUI gui;

	public CancelButton(OperatorGUI gui) {
		super("Cancel");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		gui.changeView(OperatorGUI.DEFAULT_MODE);
	}
}
