package GUI;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PrintBarcodeButton extends JButton implements ActionListener {
	private OperatorGUI gui;

	public PrintBarcodeButton(OperatorGUI gui) {
		super("Print Barcode");
		this.gui = gui;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		gui.printBarcode(gui.BARCODE_TEXT_FIELD.getText());		
	}
}
