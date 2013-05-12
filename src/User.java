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
	public String getPinCode() {
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
	 * Returns the Bicycle of a user.
	 * @return The Bicycle of a user.
	 */
	public Bicycle getBicycle() {
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

	/**
     * Compares a User to another.
     * @param u The User to compare to.
     * @return A negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
	public int compareTo(User u) {
		String s = "";
		String t = "";
		for (int i = 0; i < 6; i++) {
			s += pin.charAt(i);
			t += u.getPIN().charAt(i);
			System.out.println(s + " " + t);
		}
		for (int i = 7; i < 11; i++) {
			s += pin.charAt(i);
			t += u.getPIN().charAt(i);
			System.out.println(s + " " + t);
		}
		return (int) (Double.parseDouble(s) - Double.parseDouble(t));
	}
    
	/**
     * Returns the Telephone Number of the User.
     * @return The Telephone Number of the User.
     */
	public String getPhoneNum() {
		return phoneNum;
	}
}
