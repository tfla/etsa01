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
		File f = new File(args[0]);

		new OperatorGUI();		
	}
}
