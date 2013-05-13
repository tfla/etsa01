package GUI;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a JButton with the text "Print barcode", used to print barcodes.
 *
 */
public class PrintBarcodeButton extends JButton implements ActionListener {
	private OperatorGUI gui;

	/**
	 * Creates a new PrintBarcodeButton and sets the text to "Print Barcode".
	 *
	 */
	public PrintBarcodeButton(OperatorGUI gui) {
		super("Print Barcode");
		this.gui = gui;
		addActionListener(this);
	}

	/**
	 * Called when the button is pressed, prints the barcode.
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		gui.printBarcode(gui.bicycleTextField.getText());		
	}
}
