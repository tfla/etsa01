package GUI;

import javax.swing.*;
import java.util.List;
import java.util.Set;
import java.util.Locale;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class OperatorGUI extends JFrame {
	private JTextArea bikeArea;
	private JTextArea bikerArea;
	private JTextArea resultArea;

	private JPanel startPanel;
	private JPanel bp;

	private JTextField pin;
	private JTextField tfn;
	private JTextField bar;
	private JTextField nam;

	public OperatorGUI() {
		super("Operator Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Locale.setDefault(new Locale("en"));
		setPreferredSize(new Dimension(600, 500));
		/* To avoid hardcoded Swedish text on OptionPane dialogs */
		UIManager.put("OptionPane.cancelButtonText","Cancel");
		
		/*
		 * Create and populate the MenuBar.
		 */
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
		
		/*
		 * Create and populate the ButtonPanel.
		 */
		bp = new JPanel();
		bp.add(new NewBikerButton(this));
		bp.add(new EditBikerButton(this));
		bp.add(new SearchForm(this));
		bp.add(new SearchButton(this));

		/*
		 * Create and populate the StartPanel (default view).
		 */
		startPanel = new JPanel();
		changeView(0);
	}

	public void changeView(int mode) {
		switch (mode) {
			case 1:
				/*
				 * Mode: Create New Biker.
				 */
				startPanel.removeAll();
				dispose();
				pin = new JTextField("Personal Identity Number");
				tfn = new JTextField("Telephone Number");
				bar = new JTextField("Barcode");
				nam = new JTextField("Name");
				startPanel.add(pin);
				startPanel.add(tfn);
				startPanel.add(bar);
				startPanel.add(nam);
				startPanel.add(new SaveButton(this));
				startPanel.add(new CancelButton(this));
				break;
			case 2:
				/*
				 * Mode: Edit Existing Biker.
				 */
				startPanel.removeAll();
				dispose();
				String bpin = "910112-1234";    //biker.getPin(); typ JNåntingDialog
				String btfn = "070-1234567";    //biker.getTfn();
		        String bbar = "12345";          //biker.getBar();
		        String bnam = "Sven Svensson";  //biker.getNam();
		        pin = new JTextField(bpin);
		        tfn = new JTextField(btfn);
		        bar = new JTextField(bbar);
		        nam = new JTextField(bnam);
		        startPanel.add(pin);
		        startPanel.add(tfn);
		        startPanel.add(bar);
		        startPanel.add(nam);
		        startPanel.add(new SaveButton(this));
		        startPanel.add(new CancelButton(this));
    		    startPanel.add(new DeleteBikerButton(this));
				break;
			case 3:
				/*
                 * Mode: Search. 
                 */
				startPanel.removeAll();
				dispose();
				resultArea = new JTextArea(20, 40);
				resultArea.setEditable(false);
				startPanel.add(resultArea);
				startPanel.add(new JScrollPane(resultArea));
				/*
				 * Some code that fills the result-area with results...
				 */
				break;
			default:
				/*
				 * Mode: Default-view.
				 */
				startPanel.removeAll();
				dispose();
				bikerArea = new JTextArea(20,20);
				bikerArea.setEditable(false);
				startPanel.add(bikerArea);
				startPanel.add(new JScrollPane(bikerArea));

				bikeArea = new JTextArea(20,20);
				bikeArea.setEditable(false);
				startPanel.add(bikeArea);
				startPanel.add(new JScrollPane(bikeArea));

				// for (Biker b : bikersInGarage) {
				//}
				bikerArea.append("Bikers currently in garage\n");
				for (int i = 0; i < 10; i++) {
					bikerArea.append("Sven Svensson");
					bikerArea.append("\n");
				}
				// for (Bike bi : bikesInGarage) {
				//}
				bikeArea.append("Bikes currently in garage:\n");
				for (int i = 0; i < 50; i++) {
					bikeArea.append("91932");
					bikeArea.append("\n");
				}
				break;
		}
		add(bp, BorderLayout.PAGE_END);
		add(startPanel, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
}
