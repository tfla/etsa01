package SYS;

import java.io.File;
<<<<<<< HEAD
>>>>>>> 34b7eb0a39ad59cf1a53ebce9417c22a8371b60c
import java.io.PrintStream;
import java.util.Scanner;
import java.util.TreeSet;
import GUI.OperatorGUI;

/**
<<<<<<< HEAD
 * This class links the drivers to the system and connects the GUI operations to actions on Bicycles and/or Users.
 *
>>>>>>> 34b7eb0a39ad59cf1a53ebce9417c22a8371b60c
 */
public class BicycleGarageManager {
	private BarcodePrinterTestDriver printer;
	@SuppressWarnings("unused")
	private BarcodeReaderEntryTestDriver entryBarcodeReader;
	@SuppressWarnings("unused")
	private BarcodeReaderExitTestDriver exitBarcodeReader;
	private ElectronicLockTestDriver entryLock;
	@SuppressWarnings("unused")
	private ElectronicLockTestDriver exitLock;
	private PinCodeTerminalTestDriver terminal;
	private OperatorGUI gui;
	private TreeSet<User> users;
	private TreeSet<Bicycle> bikes;
	private String pinCode;
	private boolean asterix;

	/**
	 * Creates a new BicycleGarageManager
	 * 
	 */
	public BicycleGarageManager() {
		users = new TreeSet<User>();
		bikes = new TreeSet<Bicycle>();
		openGarage(null);
		gui = new GUI.OperatorGUI(this);
		registerHardwareDrivers(new BarcodePrinterTestDriver(),
<<<<<<< HEAD
				new BarcodeReaderExitTestDriver(),
				new BarcodeReaderEntryTestDriver(),
				new ElectronicLockTestDriver("Entry"),
				new ElectronicLockTestDriver("Exit"),
				new PinCodeTerminalTestDriver());
>>>>>>> 34b7eb0a39ad59cf1a53ebce9417c22a8371b60c
	}

	/**
	 * Registers the hardware drivers for the system.
<<<<<<< HEAD
	 * @param printer The BarcodePrinterDriver to register.
	 * @param exitBarcodeReader The BarcodeReaderDriver to register for exit.
	 * @param entryBarcodeReader The BarcodeReaderDriver to register for entrance.
	 * @param entryLock The ElectronicLockDriver to register for entrance.
	 * @param exitLock The ElectronicLockDriver to register for exit.
	 * @param terminal The PinCodeTerminalDriver to register.
	 *
>>>>>>> 34b7eb0a39ad59cf1a53ebce9417c22a8371b60c
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

<<<<<<< HEAD
	/** 
	 * Reads info from the storage file on the form 'pin pinCode barcode name phoneNum', newline represents a new object.
	 * @param f The file to open.
	 * @return true if no exceptions were thrown.
	 */ 
	public boolean openGarage(File f){
>>>>>>> 34b7eb0a39ad59cf1a53ebce9417c22a8371b60c
		Scanner scan;
		try {
			if (f != null) {
				scan = new Scanner(f);
<<<<<<< HEAD
			} else {
				scan = new Scanner(new File("storage.csv"));
			}
			users.clear();
			bikes.clear();
			scan.useDelimiter(",");
			while (scan.hasNext()) {
				users.add(new User(scan.next(), scan.next(), new Bicycle(scan
						.next()), scan.next(), scan.next()));
>>>>>>> 34b7eb0a39ad59cf1a53ebce9417c22a8371b60c
				for (User u : users) {
					bikes.add(u.getBicycle());
				}
			}
<<<<<<< HEAD
			scan.close();
			return true;
		} catch (Exception ex) {
			return false;
		}

	}

	/**
	 * Saves info to the storage file on the form 'pin pinCode, barcode, name,
	 * phoneNum', newline represents a new object.
	 * 
	 * @param f
	 *            The file to save to.
	 * @return true if no exceptions were thrown.
	 */
	public boolean saveGarage(File f) {
>>>>>>> 34b7eb0a39ad59cf1a53ebce9417c22a8371b60c
		PrintStream outprint;
		try {
			if (f != null) {
				outprint = new PrintStream(f);
<<<<<<< HEAD
			} else {
				outprint = new PrintStream(new File("storage.csv"));
			}
			for (User us : users) {
				outprint.println(us.getPIN() + "," + us.getPinCode() + ","
						+ us.getBicycle().getBarcode() + "," + us.getName()
						+ "," + us.getPhoneNum() + ",");
			}
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * Unlocks the entrance lock and makes the PIN-Code terminal LED light green
	 * for 15 seconds if bicycleID is known by the system.
	 * 
	 * @param bicycleID
	 *            The barcode that needs to be checked.
>>>>>>> 34b7eb0a39ad59cf1a53ebce9417c22a8371b60c
	 * 
	 */
	public void entryBarcode(String bicycleID) {
		for (Bicycle b : bikes) {
			if (b.getBarcode().equals(bicycleID)) {
				entryLock.open(15);
				if (!b.inGarage()) {
					b.setInGarage(true);
				}
<<<<<<< HEAD
				terminal.lightLED(PinCodeTerminal.GREEN_LED, 15);
				if (gui.getCurrentMode() == OperatorGUI.DEFAULT_MODE) {
					gui.changeView(OperatorGUI.DEFAULT_MODE);
				}
				return;
			}
		}
		terminal.lightLED(PinCodeTerminal.RED_LED, 15);
>>>>>>> 34b7eb0a39ad59cf1a53ebce9417c22a8371b60c
	}
	
	/**
<<<<<<< HEAD
	 * Unlocks the exit lock and makes the PIN-Code terminal LED light green for 15 seconds if bicycleID is known by the system.
     * @param bicycleID The barcode that needs to be checked.
	 *
>>>>>>> 34b7eb0a39ad59cf1a53ebce9417c22a8371b60c
	 */
	public void exitBarcode(String bicycleID) {
		for (Bicycle b : bikes) {
			if (b.getBarcode().equals(bicycleID)) {
				entryLock.open(15);
				if (b.inGarage()) {
					b.setInGarage(false);
				}
<<<<<<< HEAD
				terminal.lightLED(PinCodeTerminal.GREEN_LED, 15);
				if (gui.getCurrentMode() == OperatorGUI.DEFAULT_MODE) {
					gui.changeView(OperatorGUI.DEFAULT_MODE);
				}
				return;
			}
		}
		terminal.lightLED(PinCodeTerminal.RED_LED, 15);
	}

	/**
	 * Unlocks the entrance lock and makes the PIN-Code terminal LED light green
	 * for 15 seconds if a valid PIN-Code has been entered.
	 * 
	 * @param c
	 *            The character that needs to be checked.
>>>>>>> 34b7eb0a39ad59cf1a53ebce9417c22a8371b60c
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
<<<<<<< HEAD
						terminal.lightLED(PinCodeTerminal.GREEN_LED, 15);
						return;
					}
				}
				terminal.lightLED(PinCodeTerminal.RED_LED, 15);
			} else {
				terminal.lightLED(PinCodeTerminal.RED_LED, 15);
>>>>>>> 34b7eb0a39ad59cf1a53ebce9417c22a8371b60c
			}
		}
		if (c != '*' && c != '#' && asterix) {
			pinCode += c;
		}
	}

	/**
<<<<<<< HEAD
	 * Returns the Bicycle that has barcode barcode, null if there is no Bicycle with that barcode.
	 * @param barcode The barcode to check for.
>>>>>>> 34b7eb0a39ad59cf1a53ebce9417c22a8371b60c
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
<<<<<<< HEAD
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
	 * Adds a new User to the system and saves the garage to the default file.
<<<<<<< HEAD
	 * @param pin The PIN of the new user.
	 * @param pinCode The PIN-Code of the new user.
	 * @param bicycle The Bicycle of the new user.
	 * @param name The name of the new user.
	 * @param phoneNum The telephone number of the new user.
	 *
	 */
	public void addNewUser(String pin, String pinCode, Bicycle bicycle, String name, String phoneNum) {
		/** Checks the format of the Personal Identification Number (PIN). */
		if (!pin.matches("[0-9]{2,2}?(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])[-+][0-9]{4,4}?")) {		
			gui.showErrorDialog("One or more of the required fields are missing and/or are filled in erroneously.");
            return;
		}

		/** Checks the format of the PIN-Code (nnnnn). */
		if (!pinCode.matches("[0-9]{5,5}?")) {
            gui.showErrorDialog("One or more of the required fields are missing and/or are filled in erroneously.");
            return;
        }

		/** Checks the format of the barcode (nnnnn). */
		if (!bicycle.getBarcode().matches("[0-9]{5,5}?")) {
            gui.showErrorDialog("One or more of the required fields are missing and/or are filled in erroneously.");
            return;
        }

		/** Checks the Telephone Number. */
        //if (phoneNum != "Telephone Number") {
        //    if ( (!s.matches("07[036]{1,1}?[0-9]{6,6}?"))) {
        //        gui.showErrorDialog("Telephone number not on a valid format.");
        //    }
        //}

		if (users.size() <= 10000) {
			for (User u : users) {
				if (u.getPinCode() == pinCode) {
					gui.showErrorDialog("The PIN-Code is already registered to another User.");
					return;
				}
				if (u.getPIN() == pin) {
					gui.showErrorDialog("The Personal Identification Number (PIN) is already registered to another user.");
					return;
				}
				if (u.getBicycle().getBarcode() == bicycle.getBarcode()) {
					gui.showErrorDialog("The Bicycle with that barcode is already registered to another user.");
					return;
>>>>>>> 34b7eb0a39ad59cf1a53ebce9417c22a8371b60c
				}
			}
			if (users.add(new User(pin, pinCode, bicycle, name, phoneNum))) {
				gui.showMessageDialog("User was successfully added.");
				bikes.add(bicycle);
			}
<<<<<<< HEAD
		} else {
			gui.showErrorDialog("The system user limit has been reached.");
			return false;
		}
		saveGarage(null);
		return true;
	}
	/**
	 * Edits the User u in the system.
	 * 
	 * @param u
	 *            The User to edit.
	 * @return True if the User was successfully edited.
	 */
	public boolean editUser(String name, String phoneNum, User u) {
		u.setName(name);
		u.setPhone(phoneNum);
		saveGarage(null);
		return true;
	}

	/**
	 * Deletes the User u from the system.
	 * 
	 * @param u
	 *            The User to delete.
	 * @return True if the User was successfully deleted.
	 */
	public boolean deleteUser(User u) {
		return users.remove(u);
	}

	/**
	 * Returns a TreeSet<Bicycle> with all the Bicycles that are currently in
	 * the garage.
	 * 
	 * @return A TreeSet<Bicycle> containing all Bicycles currently in the
	 *         garage.
	 */
	public TreeSet<Bicycle> bicyclesInGarage() {
		TreeSet<Bicycle> result = new TreeSet<Bicycle>();
		for (Bicycle b : bikes) {
			if (b.inGarage()) {
				result.add(b);
			}
		}
		return result;
	}

	/**
	 * Returns a TreeSet<User> of search results for the searchString.
	 * 
	 * @param searchString
	 *            The string to search for.
>>>>>>> 34b7eb0a39ad59cf1a53ebce9417c22a8371b60c
	 * @return A TreeSet<User> containing the search results.
	 */
	public TreeSet<User> searchUsers(String searchString) {
		TreeSet<User> result = new TreeSet<User>();
		if (searchString.equals("*") || searchString.equals("")) {
			return users;
		}
		for (User user : users) {
<<<<<<< HEAD
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
>>>>>>> 34b7eb0a39ad59cf1a53ebce9417c22a8371b60c
	}

	/**
	 * Returns the number of Users registered to the system.
<<<<<<< HEAD
>>>>>>> 34b7eb0a39ad59cf1a53ebce9417c22a8371b60c
	 * @return The number of Users registered to the system.
	 */
	public int getUserCount() {
		return users.size();
	}

	/**
	 * Prints a barcode.
<<<<<<< HEAD
	 * @param barcode The barcode to print.
>>>>>>> 34b7eb0a39ad59cf1a53ebce9417c22a8371b60c
	 */
	public void printBarcode(String barcode) {
		printer.printBarcode(barcode);
	}

}
