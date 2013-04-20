package GUI;
import javax.swing.*;
import java.util.List;
import java.util.Set;
import java.util.Locale;
import java.awt.BorderLayout;

public class OperatorGUI extends JFrame {
	private JTextArea messageArea;
	private boolean repaint;
	private JPanel centerPanel;
	private JPanel southPanel;

	public OperatorGUI() {
		super("Operator Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Locale.setDefault(new Locale("en"));
		/* To avoid hardcoded Swedish text on OptionPane dialogs */
		UIManager.put("OptionPane.cancelButtonText","Cancel");
		
		setLayout(new BorderLayout());
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu fileMenu = new JMenu("File");
		menubar.add(fileMenu);
		fileMenu.add(new OpenMenu(this));
		fileMenu.add(new SaveMenu(this));
		fileMenu.add(new SaveAsMenu(this));
		JMenu viewMenu = new JMenu("View");
		menubar.add(viewMenu);
		viewMenu.add(new ViewAllMenu(this));
		
		southPanel = new JPanel();
		southPanel.add(new NewBikerButton(this));
		southPanel.add(new EditBikerButton(this));
		southPanel.add(new SearchForm(this));
		southPanel.add(new SearchButton(this));
				
		centerPanel = new JPanel();
		messageArea = new JTextArea(50,100);
		messageArea.setEditable(false);
		centerPanel.add(messageArea);
		centerPanel.add(new JScrollPane(messageArea));

		add(southPanel, BorderLayout.PAGE_END);		
		add(centerPanel, BorderLayout.CENTER);

		pack();
		setVisible(true);
		repaint = true;
	}

	public void changeView(int mode) {
		centerPanel = new JPanel();
		JTextField pin, tfn, bar, nam;
		switch (mode) {
			case 1:
				pin = new JTextField("Personal Identity Number");
				tfn = new JTextField("Telephone Number");
				bar = new JTextField("Barcode");
				nam = new JTextField("Name");
				centerPanel.add(pin);
				centerPanel.add(tfn);
				centerPanel.add(bar);
				centerPanel.add(nam);
				centerPanel.add(new SaveButton(this));
				centerPanel.add(new CancelButton(this));
				break;
			case 2:
				String bpin = "850213-1234"; 	//biker.getPin();
				String btfn = "070-1234567"; 	//biker.getTfn();
				String bbar = "12345"; 			//biker.getBar();
				String bnam = "Sven Svensson"; 	//biker.getNam();
				pin = new JTextField(bpin);
                tfn = new JTextField(btfn);
                bar = new JTextField(bbar);
                nam = new JTextField(bnam);
                centerPanel.add(pin);
                centerPanel.add(tfn);
                centerPanel.add(bar);
                centerPanel.add(nam);
                centerPanel.add(new SaveButton(this));
                centerPanel.add(new CancelButton(this));
				centerPanel.add(new DeleteBikerButton(this));
				break;
			case 3:
				/*
                 * search-mode 
                 * 
                 * 
                 */

				break;
			default:
				break;
		}
		add(centerPanel, BorderLayout.CENTER);
		if (repaint) {
			pack();
			setVisible(true);
		}
	}
}
