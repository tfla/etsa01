package GUI;

import javax.swing.*;
import java.util.List;
import java.util.Set;
import java.util.Locale;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Component;

public class OperatorGUI extends JFrame {
	private JTextArea bikeArea;
	private JTextArea bikerArea;

	private JPanel startPanel;
	private JPanel bp;
	private JPanel searchResultPanel;
	private JPanel panel;

	private JTextField pin;
	private JTextField pinc;
	private JTextField tfn;
	private JTextField bar;
	private JTextField nam;

	private String bpin;
	private String bpinc;
	private String btfn;
	private String bnam;
	private String bbar;

	public OperatorGUI() {
		super("Operator Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Locale.setDefault(new Locale("en"));
		setPreferredSize(new Dimension(600, 600));
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
		startPanel.removeAll();
		if (searchResultPanel != null) {
			searchResultPanel.removeAll();
		}
		if (panel != null) {
			panel.removeAll();
		}
		dispose();
		switch (mode) {
			case 1:
				/*
				 * Mode: Create New Biker.
				 */
				pin = new JTextField("Personal Identity Number (PIN)");
				pinc = new JTextField("PIN-code");
				tfn = new JTextField("Telephone Number");
				bar = new JTextField("Barcode");
				nam = new JTextField("Name");
				startPanel.add(pin);
				startPanel.add(pinc);
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
				bpin = "910112-1234";    //biker.getPin(); typ JNåntingDialog
				bpinc = "02034";
				btfn = "070-1234567";    //biker.getTfn();
		        bbar = "12345";          //biker.getBar();
		        bnam = "Sven Svensson";  //biker.getNam();
		        pin = new JTextField(bpin);
				pinc = new JTextField(bpinc);
		        tfn = new JTextField(btfn);
		        bar = new JTextField(bbar);
		        nam = new JTextField(bnam);
				pin.setEditable(false);
				pinc.setEditable(false);
				bar.setEditable(false);
		        startPanel.add(pin);
				startPanel.add(pinc);
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
				searchResultPanel = new JPanel();
				setContentPane(searchResultPanel);
				searchResultPanel.setLayout(null);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(32, 32, 500, 400);
				searchResultPanel.add(scrollPane);

				panel = new JPanel();
				scrollPane.setViewportView(panel);
				panel.setLayout(new GridLayout(100, 1));

				/*
				 * Some code that fills the result-area with results...
				 */
				for(int i = 0; i < 100; i++) {
					JPanel panel_1 = new JPanel();
					JTextField jtf = new JTextField("Sven Svensson");
					jtf.setEditable(false);
					panel_1.add(jtf);
					panel_1.add(new ViewBikerButton(this));
					if(i % 2 == 0) {
						panel_1.setBackground(SystemColor.inactiveCaptionBorder);
					}
					panel.add(panel_1);
				}
				searchResultPanel.add(new CancelButton(this));
				break;
			case 4:
				/*
				 * Mode: View.
				 */
				bpin = "910112-1234";    //biker.getPin(); typ JNåntingDialog
				bpinc = "02034";
				btfn = "070-1234567";    //biker.getTfn();
				bbar = "12345";          //biker.getBar();
				bnam = "Sven Svensson";  //biker.getNam();
				pin = new JTextField(bpin);
				pinc = new JTextField(bpinc);
				tfn = new JTextField(btfn);
				bar = new JTextField(bbar);
				nam = new JTextField(bnam);
				pin.setEditable(false);
				pinc.setEditable(false);
				bar.setEditable(false);
				tfn.setEditable(false);
				nam.setEditable(false);
				startPanel.add(pin);
				startPanel.add(pinc);
				startPanel.add(tfn);
				startPanel.add(bar);
				startPanel.add(nam);
				startPanel.add(new SaveButton(this));
				startPanel.add(new CancelButton(this));
				startPanel.add(new DeleteBikerButton(this));
				startPanel.add(new PrintBarcodeButton(this));
				break;
			default:
				/*
				 * Mode: Default-view.
				 */
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
