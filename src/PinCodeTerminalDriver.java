package SYS;

public class PinCodeTerminalDriver implements PinCodeTerminal {
	public static final int RED_LED = 0, GREEN_LED = 1;

	/*
	 * Creates a new PinCodeTerminalDriver.
	 *
	 */
	public PinCodeTerminalDriver() {

	}

	/*
	 * Register bicycle garage manager so 
	 * that the pin code terminal knows 
	 * which manager to call when a user has 
	 * pressed a key.
	 * @param manager The manager to register.
	 */
	public void register(BicycleGarageManager manager) {

	}

	/*
	 * Turn on LED for lightTime seconds. 
	 * Colour: 
	 * colour = RED_LED = 0 => red 
	 * colour = GREEN_LED = 1 => green
	 * @param colour The colour to use (1 == GREEN, 0 == RED).
	 * @param lightTime The amount of seconds the LED shall be lit.
	 */
	public void lightLED(int colour, int lightTime) {

	}
}
