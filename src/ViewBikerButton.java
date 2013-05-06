package GUI;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewBikerButton extends JButton implements ActionListener {
	private OperatorGUI gui;
	private JFileChooser fc;

	public ViewBikerButton(OperatorGUI gui) {
		super("View");
		this.gui = gui;
		fc = new JFileChooser();
		fc.setDialogTitle("Select and edit an existing biker.");
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		gui.changeView(4);
	}
}
