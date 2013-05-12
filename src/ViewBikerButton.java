package GUI;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewBikerButton extends JButton implements ActionListener {
	private OperatorGUI gui;
	private JFileChooser fc;
	private SYS.User biker;

	public ViewBikerButton(OperatorGUI gui, SYS.User biker) {
		super("View");
		this.gui = gui;
		this.biker = biker;
		fc = new JFileChooser();
		fc.setDialogTitle("Select and edit an existing biker.");
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		gui.setCurrentBiker(biker);
		gui.changeView(OperatorGUI.VIEW_MODE);
	}
}
