package SYS;

import java.util.List;

public class BicycleGarageManager {
	private BarcodePrinterDriver printer;
	private ElectronicLockDriver entryLock;
	private ElectronicLockDriver exitLock;
	private PinCodeTerminalDriver terminal;
	private List users;
	private List bikes;

	/*
	 * Creates a new BicycleGarageManager
	 *
	 */
	public BicycleGarageManager(){

	}

	/*
	 * Registers the hardware drivers for the system.
	 * @param printer
	 * @param entryLock
	 * @param exitLock
	 * @param terminal
	 *
	 */
	public void registerHardwareDrivers(BarcodePrinterDriver printer,
										ElectronicLockDriver entryLock,
										ElectronicLockDriver exitLock,
										PinCodeTerminalDriver terminal) {

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
}
