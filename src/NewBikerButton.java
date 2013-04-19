package GUI;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NewBikerButton extends JButton implements ActionListener {
	private OperatorGUI gui;

	public NewBikerButton(OperatorGUI gui) {
		super("New biker");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
	
	}
}
