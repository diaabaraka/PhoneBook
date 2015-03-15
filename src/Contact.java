/**
 * This class implements a single contact entry
 * 
 * @author DYAA
 * @version 1.0
 * 
 */
public class Contact {
	// instance variables//
	/**
	 * the first name of the contact
	 */
	private String firstName;
	/**
	 * the last name of the contact
	 */
	private String lastName;
	/**
	 * the phone number of the contact
	 */
	private String phoneNum;
	/**
	 * the e-mail of the contact
	 */
	private String email;
	/**
	 * the address of the contact
	 */
	private String address;
	/**
	 * the notes of the contact
	 */
	private String note;

	/**
	 * This constructs a contact with a first name,a last name,a phone number,
	 * an e-mail,an address,notes.
	 * 
	 * @param firstName
	 *            the first name of the contact
	 * @param lastName
	 *            the last name of the contact
	 * @param phoneNum
	 *            the phone number of the contact
	 * @param email
	 *            the e-mail of the contact
	 * @param address
	 *            the address of the contact
	 * @param note
	 *            the notes of the contact
	 */
	public Contact(String firstName, String lastName, String phoneNum,
			String email, String address, String note) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.email = email;
		this.address = address;
		this.note = note;
	}

	// setters//

	/**
	 * This is a setter method which sets the value of the parameter(fistName).
	 * 
	 * @param firstName
	 *            the first name of this contact.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * This is a setter method which sets the value of the parameter(lastName).
	 * 
	 * @param lastName
	 *            the last name of this contact.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * This is a setter method which sets the value of the parameter(phoneNum).
	 * 
	 * @param phoneNum
	 *            the phone number of this contact.
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * This is a setter method which sets the value of the parameter(email).
	 * 
	 * @param email
	 *            the e-mail of this contact.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This is a setter method which sets the value of the parameter(address).
	 * 
	 * @param address
	 *            the address of this contact.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * This is a setter method which sets the value of the parameter(note).
	 * 
	 * @param note
	 *            the notes about this contact.
	 */
	public void setNote(String note) {
		this.note = note;
	}

	// getters//

	/**
	 * This is a getter method which returns the value of the first name of this
	 * contact.
	 * 
	 * @return the first name of this contact.
	 */

	public String getFirstName() {
		return firstName;
	}

	/**
	 * This is a getter method which returns the value of the last name of this
	 * contact.
	 * 
	 * @return the last name of this contact.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * This is a getter method which returns the value of the phone number of
	 * this contact.
	 * 
	 * @return the phone number of this contact.
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * This is a getter method which returns the value of the e-mail of this
	 * contact.
	 * 
	 * @return the e-mail of this contact.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This is a getter method which returns the value of the address of this
	 * contact.
	 * 
	 * @return the address of this contact.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * This is a getter method which returns the value of the notes about this
	 * contact.
	 * 
	 * @return the notes about this contact.
	 */
	public String getNote() {
		return note;
	}

}
