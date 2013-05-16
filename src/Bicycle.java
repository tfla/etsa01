package SYS;

/**
 * This class defines a Bicycle within the system.
 *
 */
public class Bicycle implements Comparable<Bicycle> {
	private boolean inGarage;
	private String barcode;

	/**
	 * Creates a new Bicycle and sets it to "not in garage".
	 * @param barcode The barcode of the new Bicycle.
	 */
	public Bicycle(String barcode) {
		this.barcode = barcode;
		inGarage = false;
	}

	/**
	 * Returns the status of a Bicycle (true/false).
	 * @return The status of a Bicycle (true/false).
	 */
	public boolean inGarage() {
		return inGarage;
	}

	/**
	 * Returns the barcode of a bike.
	 * @return The barcode of a bike.
	 */
	public String getBarcode() {
		return barcode;
	}

	/**
	 * Sets the barcode of a bike to barcode.
	 * @param barcode The new barcode of a bike.
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	/**
	 * Sets the status of a bike (true/false) to status.
	 * @param status The new status of a bike (true/false).
	 */
	public void setInGarage(boolean status) {
		inGarage = status;
	}

	/**
	 * Compares a Bicycle to another.
	 * @param b The Bicycle to compare to.
	 * @return A negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
	 */
	public int compareTo(Bicycle b) {
		return Integer.parseInt(barcode) - Integer.parseInt(b.getBarcode());
	}
}
