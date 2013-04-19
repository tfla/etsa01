package GUI;

import javax.swing.JTextField;

public class SearchForm extends JTextField {
	private OperatorGUI gui;

	public SearchForm(OperatorGUI gui) {
		super("Search ...");
		this.gui = gui;
	}
}
