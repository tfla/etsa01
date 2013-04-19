package GUI;
import javax.swing.*;
import java.util.List;
import java.util.Set;
import java.util.Locale;
import java.awt.BorderLayout;

public class OperatorGUI extends JFrame {
	private JTextArea messageArea;

	public OperatorGUI() {
		super("Operator Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Locale.setDefault(new Locale("en"));
		/* To avoid hardcoded Swedish text on OptionPane dialogs */
		UIManager.put("OptionPane.cancelButtonText","Cancel");
		
		setLayout(new BorderLayout());
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu editMenu = new JMenu("Edit");
		menubar.add(editMenu);
		editMenu.add(new AddMenu(this));
		editMenu.add(new RemoveMenu(this));
		JMenu findMenu = new JMenu("Find");
		menubar.add(findMenu);
		findMenu.add(new FindNamesMenu(this));
		findMenu.add(new FindNumbersMenu(this));
		JMenu viewMenu = new JMenu("View");
		menubar.add(viewMenu);
		viewMenu.add(new ViewAllMenu(this));
		
		JPanel centerPanel = new JPanel();
		messageArea = new JTextArea(50,100);
		messageArea.setEditable(false);
		centerPanel.add(new JScrollPane(messageArea));

		JPanel southPanel = new JPanel();
		southPanel.add(new NewBikerButton(this));
		southPanel.add(new EditBikerButton(this));
		southPanel.add(new SearchForm(this));
		southPanel.add(new SearchButton(this));

		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.PAGE_END);		

		pack();
		setVisible(true);
	}
}
