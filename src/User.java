package SYS;

public class User implements Comparable<User> {
	private String name;
	private Bicycle bicycle;
	private String pinCode;
	private String phoneNum;
	private String pin;

	/**
	 * Creates a new user.
	 * @param pin The PIN of the user.
	 * @param pinCode The PIN-code of the user.
	 * @param barcode The barcode of the user.
	 * @param name The name of the user.
	 * @param phoneNum The telephone number of the user.
	 */
	public User(String pin, String pinCode, Bicycle bicycle, String name, String phoneNum) {
		this.pin = pin;
		this.pinCode = pinCode;
		this.bicycle = bicycle;
		this.name = name;
		this.phoneNum = phoneNum;
	}

	/**
	 * Returns the PIN-code of a user.
	 * @return The PIN-code of a user.
	 */
	public String getPINCode() {
		return pinCode;
	}

	/**
	 * Returns the Personal Identity Number (PIN) of a user.
	 * @return The Personal Identity Numer (PIN) of a user.
	 */
	public String getPIN() {
		return pin;
	}

	/**
	 * Returns the name of a user.
	 * @return The name of a user.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the barcode of a user.
	 * @return The barcode of a user.
	 */
	public Bicycle getBarcode() {
		return bicycle;
	}

	/**
	 * Sets the name of a user to name.
	 * @param name The new name for the user.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the phone number of a user to phoneNum.
	 * @param phoneNum The new phone number of a user.
	 */
	public void setPhone(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * Sets the barcode of a user to barcode.
	 * @param barcode The new barcode of a user.
	 */
	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	public int compareTo(User u) {
		return Integer.parseInt(pin) - Integer.parseInt(u.getPIN());
	}
}
