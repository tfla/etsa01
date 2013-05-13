package GUI;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a new JButton with the text "View", used to view a selected biker's information.
 *
 */
public class ViewBikerButton extends JButton implements ActionListener {
	private OperatorGUI gui;
	private JFileChooser fc;
	private SYS.User biker;

	/**
	 * Creates a new ViewBikerButton and sets the text to "View".
	 *
	 */
	public ViewBikerButton(OperatorGUI gui, SYS.User biker) {
		super("View");
		this.gui = gui;
		this.biker = biker;
		fc = new JFileChooser();
		fc.setDialogTitle("Select and edit an existing biker.");
		addActionListener(this);
	}

	/**
	 * Called when the button is pressed, sets the currentBiker and changes the view of OperatorGUI to "view-mode".
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		gui.setCurrentBiker(biker);
		gui.changeView(OperatorGUI.VIEW_MODE);
	}
}
