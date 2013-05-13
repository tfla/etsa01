package GUI;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a JButton with the text "Create biker", used to change to "create-mode".
 *
 */
public class NewBikerButton extends JButton implements ActionListener {
	private OperatorGUI gui;

	/**
	 * Creates a new NewBikerButton and sets the text to "Create biker".
	 *
	 */
	public NewBikerButton(OperatorGUI gui) {
		super("Create biker");
		this.gui = gui;
		addActionListener(this);
	}

	/**
	 * Called when the button is pressed, changes the view of OperatorGUI to "create-mode".
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		gui.changeView(OperatorGUI.CREATE_MODE);
	}
}
