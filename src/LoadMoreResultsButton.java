package GUI;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a new JButton with the text "Load more results", used to load more results in "search-mode".
 *
 */
@SuppressWarnings("serial")
public class LoadMoreResultsButton extends JButton implements ActionListener {
    private OperatorGUI gui;

    public LoadMoreResultsButton(OperatorGUI gui) {
        super("Load more results");
        this.gui = gui;
        addActionListener(this);
    }

    /**
     * Called when the button is pressed, loads more results in search-mode.
     */
    public void actionPerformed(ActionEvent e) {
		if (gui.increaseSearchSize()) {
			gui.changeView(OperatorGUI.SEARCH_MODE);
		} else {
			gui.showErrorDialog("Already at limit.");
		}
	}
}
