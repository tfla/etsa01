package GUI;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EditBikerButton extends JButton implements ActionListener {
	private OperatorGUI gui;
	private JFileChooser fc;

	public EditBikerButton(OperatorGUI gui) {
		super("Edit biker");
		this.gui = gui;
		fc = new JFileChooser();
		fc.setDialogTitle("Select and edit an existing biker.");
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		gui.changeView(OperatorGUI.EDIT_MODE);
	}
}
