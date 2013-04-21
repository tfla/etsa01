package GUI;

import javax.swing.*;
import java.util.List;
import java.util.Set;
import java.util.Locale;
import java.awt.BorderLayout;

public class OperatorGUI extends JFrame {
	private JTextArea messageArea;
	private JPanel startPanel;
	private JPanel southPanel;
	private JPanel bp;

	private JTextField pin;
	private JTextField tfn;
	private JTextField bar;
	private JTextField nam;

	public OperatorGUI() {
		super("Operator Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Locale.setDefault(new Locale("en"));
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
		messageArea = new JTextArea(50,100);
		messageArea.setEditable(false);
		startPanel.add(messageArea);
		startPanel.add(new JScrollPane(messageArea));

		/*
		 * Put things where they belong, pack and paint.
		 */
		add(bp, BorderLayout.PAGE_END);		
		add(startPanel, BorderLayout.CENTER);
		pack();
		setVisible(true);
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
				add(bp, BorderLayout.PAGE_END);
				add(startPanel, BorderLayout.CENTER);
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
				add(bp, BorderLayout.PAGE_END);
				add(startPanel, BorderLayout.CENTER);
				break;
			case 3:
				/*
                 * Mode: Search. 
                 */

				break;
			default:
				break;
		}
		pack();
		setVisible(true);
	}
}
