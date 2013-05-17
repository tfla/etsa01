package SYS;

/**
* This class defines a User within the system.
*
*/
public class User implements Comparable<User> {
private String name;
private Bicycle bicycle;
private String pinCode;
private String phoneNum;
private String pin;

	/**
 	* Creates a new User.
	 * @param pin The PIN of the User.
	 * @param pinCode The PIN-code of the User.
	 * @param barcode The barcode of the User.
	 * @param name The name of the User.
	 * @param phoneNum The telephone number of the User.
	 */
	public User(String pin, String pinCode, Bicycle bicycle, String name, String phoneNum) {
		this.pin = pin;
		this.pinCode = pinCode;
		this.bicycle = bicycle;
		this.name = name;
		this.phoneNum = phoneNum;
	}

	/**
	 * Returns the PIN-code of a User.
	 * @return The PIN-code of a User.
	 */
	public String getPinCode() {
		return pinCode;
	}

	/**
	* Returns the Personal Identity Number (PIN) of a User.
	* @return The Personal Identity Numer (PIN) of a User.
	*/
	public String getPIN() {
		return pin;
	}

	/**
	* Returns the name of a User.
	* @return The name of a User.
	*/
	public String getName() {
		return name;
	}

	/**
	 * Returns the Bicycle of a User.
	 * @return The Bicycle of a User.
	 */
	public Bicycle getBicycle() {
		return bicycle;
	}

	/**
     * Returns the Telephone Number of the User.
     * @return The Telephone Number of the User.
     */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * Sets the name of a user to name.
	 * @param name The new name for the User.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the phone number of a User to phoneNum.
	 * @param phoneNum The new phone number of a User.
	 */
	public void setPhone(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * Sets the barcode of a User to barcode.
	 * @param barcode The new barcode of a User.
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
		}
		for (int i = 7; i < 11; i++) {
			s += pin.charAt(i);
			t += u.getPIN().charAt(i);
		}
		return (int) (Double.parseDouble(s) - Double.parseDouble(t));
	}
}
