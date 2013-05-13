package GUI;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a new JButton with the text "Search", used to query the system for information.
 *
 */
public class SearchButton extends JButton implements ActionListener {
	private OperatorGUI gui;

	/**
	 * Creates a new SearchButton with the text "Search".
	 *
	 */
	public SearchButton(OperatorGUI gui) {
		super("Search");
		this.gui = gui;
		addActionListener(this);
	}

	/**
	 * Called when the button is pressed, changes the view of OperatorGUI to "search-mode".
	 *
	 */
	public void actionPerformed(ActionEvent e) {
		gui.changeView(OperatorGUI.SEARCH_MODE);
	}
}
