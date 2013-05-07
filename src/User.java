package SYS;

public class User implements Comparable<User> {
	private String name;
	private String barcode;
	private String pinCode;
	private String phoneNum;
	private String pin;

	/*
	 * Creates a new biker.
	 *
	 */
	public User(String pin, String pinCode, String barcode) {
		this.barcode = barcode;
		this.pinCode = pinCode;
		this.pin = pin;
		this.name = "Name";
		this.phoneNum = "Telephone Number";
	}

	public User(String pin, String pinCode, String barcode, String s) {
		this.barcode = barcode;
		this.pinCode = pinCode;
		this.pin = pin;
		if (s.contains(" ")) {
			name = s;
			this.phoneNum = "Telephone Number";
		}
		else {
			this.name = "Name";
			phoneNum = s;
		}
	}

	public User(String pin, String pinCode, String barcode, String name, String phoneNum) {
		this.pin = pin;
		this.pinCode = pinCode;
		this.barcode = barcode;
		this.name = name;
		this.phoneNum = phoneNum;
	}

	/*
	 * Returns the PIN-code of a user.
	 * @return The PIN-code of a user.
	 */
	public String getPINCode() {
		return pinCode;
	}

	/*
	 * Returns the Personal Identity Number (PIN) of a user.
	 * @return The Personal Identity Numer (PIN) of a user.
	 */
	public String getPIN() {
		return pin;
	}

	/*
	 * Returns the name of a user.
	 * @return The name of a user.
	 */
	public String getName() {
		return name;
	}

	/*
	 * Returns the barcode of a user.
	 * @return The barcode of a user.
	 */
	public String getBarcode() {
		return barcode;
	}

	/*
	 * Sets the name of a user to name.
	 * @param name The new name for the user.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * Sets the phone number of a user to phoneNum.
	 * @param phoneNum The new phone number of a user.
	 */
	public void setPhone(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/*
	 * Sets the barcode of a user to barcode.
	 * @param barcode The new barcode of a user.
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public int compareTo(User u) {
		return Integer.parseInt(pin) - Integer.parseInt(u.getPIN());
	}
}
