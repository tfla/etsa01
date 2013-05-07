package GUI;

import java.util.Random;
import java.lang.StringBuilder;
import java.util.LinkedList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main {
	public static void main(String[] args) {	
		//File f = new File(args[0]);

		new OperatorGUI();
		SYS.BicycleGarageManager bgm = new SYS.BicycleGarageManager();
		bgm.registerHardwareDrivers(new SYS.BarcodePrinterTestDriver(),
									new SYS.BarcodeReaderEntryTestDriver(),
									new SYS.BarcodeReaderExitTestDriver(),
									new SYS.ElectronicLockTestDriver("Entry"),
									new SYS.ElectronicLockTestDriver("Exit"),
									new SYS.PinCodeTerminalTestDriver());
	}
}
