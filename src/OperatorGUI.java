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
	private SYS.BicycleGarageManager bgm;
	private JTextArea bikeArea;
	private JTextArea bikerArea;

	private JPanel startPanel;
	private JPanel bp;
	private JPanel searchResultPanel;
	private JPanel panel;

	public JTextField PIN_TEXT_FIELD;
	public JTextField PINCODE_TEXT_FIELD;
	public JTextField PHONENUM_TEXT_FIELD;
	public JTextField BICYCLE_TEXT_FIELD;
	public JTextField NAME_TEXT_FIELD;

	private String bpin;
	private String bpinc;
	private String btfn;
	private String bnam;
	private String bbar;

	public static final int DEFAULT_MODE = 0;
	public static final int CREATE_MODE = 1;
	public static final int EDIT_MODE = 2;
	public static final int SEARCH_MODE = 3;
	public static final int VIEW_MODE = 4;

	public OperatorGUI(SYS.BicycleGarageManager bgm) {
		super("Operator Interface");
		
		this.bgm = bgm;

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
		changeView(DEFAULT_MODE);
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
			case CREATE_MODE:
				PIN_TEXT_FIELD = new JTextField("Personal Identity Number (PIN)");
				PINCODE_TEXT_FIELD = new JTextField("PIN-code");
				PHONENUM_TEXT_FIELD = new JTextField("Telephone Number");
				BICYCLE_TEXT_FIELD = new JTextField("Bicycle");
				NAME_TEXT_FIELD = new JTextField("Name");
				startPanel.add(PIN_TEXT_FIELD);
				startPanel.add(PINCODE_TEXT_FIELD);
				startPanel.add(PHONENUM_TEXT_FIELD);
				startPanel.add(BICYCLE_TEXT_FIELD);
				startPanel.add(NAME_TEXT_FIELD);
				startPanel.add(new SaveButton(this));
				startPanel.add(new CancelButton(this));
				break;
			case EDIT_MODE:
				bpin = "910112-1234";    //biker.getPin(); typ JNåntingDialog
				bpinc = "02034";
				btfn = "070-1234567";    //biker.getTfn();
		        bbar = "12345";          //biker.getBar();
		        bnam = "Sven Svensson";  //biker.getNam();
		        PIN_TEXT_FIELD = new JTextField(bpin);
				PINCODE_TEXT_FIELD = new JTextField(bpinc);
		        PHONENUM_TEXT_FIELD = new JTextField(btfn);
		        BICYCLE_TEXT_FIELD = new JTextField(bbar);
		        NAME_TEXT_FIELD = new JTextField(bnam);
				PIN_TEXT_FIELD.setEditable(false);
				PINCODE_TEXT_FIELD.setEditable(false);
				BICYCLE_TEXT_FIELD.setEditable(false);
		        startPanel.add(PIN_TEXT_FIELD);
				startPanel.add(PINCODE_TEXT_FIELD);
		        startPanel.add(PHONENUM_TEXT_FIELD);
		        startPanel.add(BICYCLE_TEXT_FIELD);
		        startPanel.add(NAME_TEXT_FIELD);
		        startPanel.add(new SaveButton(this));
		        startPanel.add(new CancelButton(this));
    		    startPanel.add(new DeleteBikerButton(this));
				break;
			case SEARCH_MODE:
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
			case VIEW_MODE:
				bpin = "910112-1234";    //biker.getPin(); typ JNåntingDialog
				bpinc = "02034";
				btfn = "070-1234567";    //biker.getTfn();
				bbar = "12345";          //biker.getBar();
				bnam = "Sven Svensson";  //biker.getNam();
				PIN_TEXT_FIELD = new JTextField(bpin);
				PINCODE_TEXT_FIELD = new JTextField(bpinc);
				PHONENUM_TEXT_FIELD = new JTextField(btfn);
				BICYCLE_TEXT_FIELD = new JTextField(bbar);
				NAME_TEXT_FIELD = new JTextField(bnam);
				PIN_TEXT_FIELD.setEditable(false);
				PINCODE_TEXT_FIELD.setEditable(false);
				BICYCLE_TEXT_FIELD.setEditable(false);
				PHONENUM_TEXT_FIELD.setEditable(false);
				NAME_TEXT_FIELD.setEditable(false);
				startPanel.add(PIN_TEXT_FIELD);
				startPanel.add(PINCODE_TEXT_FIELD);
				startPanel.add(PHONENUM_TEXT_FIELD);
				startPanel.add(BICYCLE_TEXT_FIELD);
				startPanel.add(NAME_TEXT_FIELD);
				startPanel.add(new SaveButton(this));
				startPanel.add(new CancelButton(this));
				startPanel.add(new DeleteBikerButton(this));
				startPanel.add(new PrintBarcodeButton(this));
				break;
			default:
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

	public void printBarcode(String bicycleID) {
		bgm.printBarcode(bicycleID);
	}

	public void saveUser(String pin, String pinCode, SYS.Bicycle bicycle, String name, String phoneNum) {
		bgm.addNewUser(pin, pinCode, bicycle, name, phoneNum);
	}

	public void showMessageDialog(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
	}

	public void showErrorDialog(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
