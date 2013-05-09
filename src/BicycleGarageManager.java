package SYS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.TreeSet;

public class BicycleGarageManager {
	private BarcodePrinterTestDriver printer;
	private BarcodeReaderTestDriver barcodeReader;
	private BarcodeReaderEntryTestDriver entryBarcodeReader;
	private BarcodeReaderExitTestDriver exitBarcodeReader;
	private ElectronicLockTestDriver entryLock;
	private ElectronicLockTestDriver exitLock;
	private PinCodeTerminalTestDriver terminal;
	private GUI.OperatorGUI gui;
	private TreeSet<User> users;
	private TreeSet<Bicycle> bikes;
	
	private String pinCode;
	private boolean asterix;

	/**
	 * Creates a new BicycleGarageManager
	 *
	 */
	public BicycleGarageManager(){
		users = new TreeSet<User>();
		bikes = new TreeSet<Bicycle>();
		gui = new GUI.OperatorGUI(this);
		registerHardwareDrivers(new BarcodePrinterTestDriver(),
                                new BarcodeReaderExitTestDriver(),
								new BarcodeReaderEntryTestDriver(),
                                new ElectronicLockTestDriver("Entry"),
                                new ElectronicLockTestDriver("Exit"),
                                new PinCodeTerminalTestDriver());
		openGarage();
	}

	/**
	 * Registers the hardware drivers for the system.
	 * @param printer The BarcodePrinterDriver to register.
	 * @param exitBarcodeReader The BarcodeReaderDriver to register for exit.
	 * @param entryBarcodeReader The BarcodeReaderDriver to register for entrance.
	 * @param entryLock The ElectronicLockDriver to register for entrance.
	 * @param exitLock The ElectronicLockDriver to register for exit.
	 * @param terminal The PinCodeTerminalDriver to register.
	 *
	 */
	public void registerHardwareDrivers(BarcodePrinterTestDriver printer,
										BarcodeReaderExitTestDriver exitBarcodeReader,
										BarcodeReaderEntryTestDriver entryBarcodeReader,
										ElectronicLockTestDriver entryLock,
										ElectronicLockTestDriver exitLock,
										PinCodeTerminalTestDriver terminal) {
		this.printer = printer;
		this.entryBarcodeReader = entryBarcodeReader;
		this.exitBarcodeReader = exitBarcodeReader;
		exitBarcodeReader.register(this);
		entryBarcodeReader.register(this);
		this.entryLock = entryLock;
		this.exitLock = exitLock;
		this.terminal = terminal;
		terminal.register(this);
	}

	/**
	 * Unlocks the entrance lock and makes the PIN-Code terminal LED light green for 15 seconds if bicycleID is known by the system.
	 * @param bicycleID The barcode that needs to be checked.
	 * 
	 */
	public void entryBarcode(String bicycleID) {
		for (Bicycle b : bikes) {
			if (b.getBarcode().equals(bicycleID)) {
				entryLock.open(15);
				if (!b.inGarage()) {
					b.setInGarage(true);
				}
				terminal.lightLED(terminal.GREEN_LED, 15);
				return;
			}
		}
		terminal.lightLED(terminal.RED_LED, 15);
	}

	public boolean openGarage(){
		/** reads info from file on form 'pin,pincode,Barcode,name,phonenum' */ 
		try {
			Scanner scan = new Scanner(new File("storage.csv"));
			while (scan.hasNext()){
				users.add(new User(scan.next(),scan.next(),new Bicycle(scan.next()),scan.next(),scan.next())); 
			}
			return true;
		} catch (Exception ex){
			System.out.println("Couldn't");
			return false;
		}
		
	}
	
	public boolean saveGarage(){
		/** saves to file on the form 'pin, pincode, Barcode, name, phonenum' */
		 
		try {
			PrintStream outprint = new PrintStream(new File("storage.csv"));
			for(User us: users){
				outprint.println(us.getPIN() + " " + us.getPinCode() + " " + us.getBicycle().getBarcode() + " " + us.getPhone() + " " + us.getName());
			}
			
		}catch (Exception ex){
			return false;
		}
		
		
		return true; 
	}
	
	/**
	 * Unlocks the exit lock and makes the PIN-Code terminal LED light green for 15 seconds if bicycleID is known by the system.
     * @param bicycleID The barcode that needs to be checked.
	 *
	 */
	public void exitBarcode(String bicycleID) {
		for (Bicycle b : bikes) {
			if (b.getBarcode().equals(bicycleID)) {
				entryLock.open(15);
				if (b.inGarage()) {
					b.setInGarage(false);
				}
				terminal.lightLED(terminal.GREEN_LED, 15);
				return;
			}
		}
		terminal.lightLED(terminal.RED_LED, 15);
	}

	/**
	 * Unlocks the entrance lock and makes the PIN-Code terminal LED light green for 15 seconds if a valid PIN-Code has been entered.
	 * @param c The character that needs to be checked.
	 */
	public void entryCharacter(char c) {
		if (c == '*') {
			asterix = true;
			pinCode = "";
		}
		if (c == '#' && asterix) {
			if (pinCode.length() == 5) {
				for (User u : users) {
					if (u.getPinCode().equals(pinCode)) {
						entryLock.open(15);
						terminal.lightLED(terminal.GREEN_LED, 15);
						return;
					}
				}
				terminal.lightLED(terminal.RED_LED, 15);
			}
			else {
				terminal.lightLED(terminal.RED_LED, 15);
			}
		}
		if (c != '*' && c != '#' && asterix) {
			pinCode += c;
		}
	}

	/**
	 * Returns the Bicycle that has barcode barcode, null if there is no bike with taht barcode.
	 * @param barcode The barcode to check for.
	 */
	public Bicycle getBicycle(String barcode) {
		if (bikes != null) {
			if (bikes.size() > 0) {
				for (Bicycle b : bikes) {
					if (b.getBarcode().equals(barcode)) {
						return b;
					}
				}
			}
		}
		return null;
	}

	public User getUser(String pin) {
		return null;
	}

	public void addNewUser(String pin, String pinCode, Bicycle bicycle, String name, String phoneNum) {
		if (users.size() <= 10000) {
			if (users.add(new User(pin, pinCode, bicycle, name, phoneNum))) {
				gui.showMessageDialog("User was successfully added.");
			}
			else {
				gui.showErrorDialog("The Personal Identity Number is entered on an incorrect form and/or is already registered to another biker.");
			}
		}
		else {
			gui.showErrorDialog("The system biker limit has been reached.");
		}
		saveGarage();
	}

	public TreeSet<User> searchUsers(String searchString) {
		return null;
	}

	public void printBarcode(String barcode) {
		printer.printBarcode(barcode);		
	}
	
}
