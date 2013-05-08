package GUI;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SaveButton extends JButton implements ActionListener {
	private OperatorGUI gui;

	public SaveButton(OperatorGUI gui) {
		super("Save");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		gui.saveUser(gui.PIN_TEXT_FIELD.getText(),
						gui.PINCODE_TEXT_FIELD.getText(),
						gui.BARCODE_TEXT_FIELD.getText(),
						gui.NAME_TEXT_FIELD.getText(),
						gui.PHONENUM_TEXT_FIELD.getText());
	}
}
