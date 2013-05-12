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

	/** 
	 * Reads info from the storage file on the form 'pin pinCode barcode name phoneNum', newline represents a new object.
	 * @return true if no exceptions were thrown.
	 */ 
	public boolean openGarage(){
		try {
			Scanner scan = new Scanner(new File("storage.csv"));
			while (scan.hasNext()){
				users.add(new User(scan.next(),scan.next(),new Bicycle(scan.next()),scan.next(),scan.next())); 
			}
			return true;
		}
		catch (Exception ex){
			return false;
		}
		
	}
	
	/** 
	 * Saves info to the storage file on the form 'pin pinCode, barcode, name, phoneNum', newline represents a new object.
	 * @return true if no exceptions were thrown.
	 */
	public boolean saveGarage(){
		try {
			PrintStream outprint = new PrintStream(new File("storage.csv"));
			for(User us: users){
				outprint.println(us.getPIN() + " " + us.getPinCode() + " " + us.getBicycle().getBarcode() + " " + us.getPhoneNum() + " " + us.getName());
			}
			return true; 
		}
		catch (Exception ex){
			return false;
		}	
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
	 * Returns the Bicycle that has barcode barcode, null if there is no Bicycle with that barcode.
	 * @param barcode The barcode to check for.
	 * @return The Bicycle with that barcode, if it exists.
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

	/**
	 * Returns the User that has PIN pin, null if there is no User with that PIN.
	 * @param pin The PIN to check for.
	 * @return The User with that PIN, if it exists.
	 */
	public User getUser(String pin) {
		if (users != null) {
			if (users.size() > 0) {
				for (User u : users) {
					if (u.getPIN().equals(pin)) {
						return u;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Adds a new User to the system.
	 * @param pin The PIN of the new user.
	 * @param pinCode The PIN-Code of the new user.
	 * @param bicycle The Bicycle of the new user.
	 * @param name The name of the new user.
	 * @param phoneNum The telephone number of the new user.
	 *
	 */
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

	/**
	 * Returns a TreeSet<User> of search results for the searchString.
	 * @param searchString The string to search for.
	 * @return A TreeSet<User> containing the search results.
	 */
	public TreeSet<User> searchUsers(String searchString) {
		TreeSet<User> result = new TreeSet<User>();
		for (User user : users) {
            String name = user.getName();
            String phoneNum = user.getPhoneNum();
            String pinCode = user.getPinCode();
            String pin = user.getPIN();
            String barcode = user.getBicycle().getBarcode();
            if (name.indexOf(searchString) >= 0) {
                result.add(user);
            } else if (phoneNum.equals(searchString)) {
                result.add(user);
            } else if (pinCode.equals(searchString)) {
                result.add(user);
            } else if (pin.equals(searchString)) {
                result.add(user);
            } else if (barcode.equals(searchString)) {
                result.add(user);
            }
        }
        return result;
	}

	/**
	 * Prints a barcode.
	 * @param barcode The barcode to print.
	 */
	public void printBarcode(String barcode) {
		printer.printBarcode(barcode);		
	}
	
}
