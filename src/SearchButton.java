package GUI;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SearchButton extends JButton implements ActionListener {
	private OperatorGUI gui;

	public SearchButton(OperatorGUI gui) {
		super("Search");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		gui.changeView(3);
		gui.pack();
        gui.setVisible(true);
	}
}
