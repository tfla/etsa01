package SYS;

import java.util.SortedSet;
import java.util.TreeSet;

public class BicycleGarageManager {
	private BarcodePrinterTestDriver printer;
	private BarcodeReaderEntryTestDriver entryBarcodeReader;
	private BarcodeReaderExitTestDriver exitBarcodeReader;
	private ElectronicLockTestDriver entryLock;
	private ElectronicLockTestDriver exitLock;
	private PinCodeTerminalTestDriver terminal;
	private TreeSet<User> users;
	private TreeSet<Bicycle> bikes;
	
	/*
	 * Creates a new BicycleGarageManager
	 *
	 */
	public BicycleGarageManager(){
		users = new TreeSet<User>();
		bikes = new TreeSet<Bicycle>();
		
	}

	/*
	 * Registers the hardware drivers for the system.
	 * @param printer
	 * @param entryLock
	 * @param exitLock
	 * @param terminal
	 *
	 */
	public void registerHardwareDrivers(BarcodePrinterTestDriver printer,
										BarcodeReaderEntryTestDriver entryBarcodeReader,
										BarcodeReaderExitTestDriver exitBarcodeReader,
										ElectronicLockTestDriver entryLock,
										ElectronicLockTestDriver exitLock,
										PinCodeTerminalTestDriver terminal) {
		this.printer = printer;
		this.entryLock = entryLock;
		this.exitLock = exitLock;
		this.terminal = terminal;	
	}

	/*
	 * Whenever a barcode is read at the entrance.
	 * 
	 */
	public void entryBarcode(String bicycleID) {
		
	}

	/*
	 * Whenever a barcode is read at the exit.
	 *
	 */
	public void exitBarcode(String bicycleID) {

	}

	/*
	 * Reads the characters entered at the PIN-code terminal.
	 *
	 */
	public void entryCharacter(char c) {

	}

	public Bicycle getBicycle(String barcode) {
		return null;
	}

	public User getUser(String pin) {
		return null;
	}

	public void addNewUser(String name, String pinCode, String pin, String phoneNum, String barcode) {

	}

	public SortedSet<User> searchUsers(String searchString) {
		return null;
	}

	
}
