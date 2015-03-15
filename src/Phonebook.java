import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class have the methods of all operations on the contacts.
 * 
 * @author DYAA
 * @version 1.0
 */
public class Phonebook {

	/**
	 * This is a static array where we store contacts as objects.This array have
	 * a length of one element and every once we add new contact its length
	 * becomes bigger with one cell.
	 * 
	 */
	static Contact[] array = new Contact[1];
	/**
	 * This is a static integer variable which represents the index of last
	 * element in the array.
	 */
	static int index = 0;

	/**
	 * This is a method to add new contacts in array .First Name, Last Name and
	 * Phone Number are all required fields. All other fields(the e-mail,the
	 * address and the notes) are optional so when it is called it forces the
	 * user to enter the first name ,the last name and the phone number on the
	 * other hand for the other fields it asks the user if which he wants to add
	 * them or not.If he wants he would enter them . If he doesn't ,the method
	 * sets it "*****". After the method gets all six fields it creates an <b>
	 * object </b> of the class of Contact with these fields, then adds this
	 * contact to the array where we store contacts. <b>But</b>,how to add
	 * contacts in array? every once we add new contact w create another array
	 * with length bigger than the length of the original array and make the
	 * original refer to the new array so the array becomes bigger with one cell
	 * which includes the added contact. Finally the method calls another method
	 * to save the array which contain all contacts in a file.
	 * 
	 * @throws IOException
	 *             if the file is not found.
	 */
	public static void addContact() throws IOException {
		boolean bn = true;
		Scanner br = new Scanner(System.in);
		System.out
				.println("please enter the first name and then press\"Enter\"");
		String firstName = "";
		// while true to force the user to enter the first name because it isn't
		// optional.
		while (true) {
			String s3 = br.nextLine();
			// to handle if the user press "Enter"without typing any characters.
			if (!s3.equals("")) {
				// first name mustn't contain ","
				if (s3.contains(",")) {
					System.out
							.println("The first name mustn't contain \",\" !");
					// ask the user again to enter valid first name.
					System.out
							.println("\nplease enter the first name and then press\"Enter\"");
				} else {
					// here the input is valid so it set it to first name.
					firstName = s3;
					break;
				}

			}

		}

		System.out
				.println("please enter the last name and then press\"Enter\"");
		String lastName = "";
		while (true) {
			String s2 = br.nextLine();
			if (!s2.equals("")) {
				if (s2.contains(",")) {
					System.out.println("The last name mustn't contain \",\" !");
					System.out
							.println("\nplease enter the last name and then press\"Enter\"");
				} else {
					lastName = s2;
					break;
				}

			}

		}

		System.out
				.println("please enter the phone number and then press\"Enter\"");
		String phoneNum = "";
		String s = "";
		// while true to force the user to enter the phone number .
		while (s.equals("")) {

			s = br.nextLine();

			// for loop to check the validation of the phone number.
			for (int i = 0; i < s.length(); i++) {
				// if the phone number is invalid
				if (!((s.charAt(i) >= 48 && s.charAt(i) <= 57)
						|| s.charAt(i) == 43 || s.charAt(i) == 42
						|| s.charAt(i) == 35 || s.charAt(i) == 112 || s
							.charAt(i) == 119)) {
					System.out.println("Please enter valid phone numbers !");

					s = br.nextLine();
					// make the index -1 because it will incremented so it will
					// be 0.
					i = -1;
					phoneNum = "";
				} else {
					phoneNum += s.charAt(i);
				}

			}
		}

		System.out
				.println("Do you want to add the e-mail ? press \"Y\" or \"N\"");
		String email = "";
		String decision;
		bn = true;
		while (bn) {
			decision = br.nextLine();
			// ignoring the case of letters.
			if (decision.equals("y") || decision.equals("Y")) {
				System.out
						.println("please enter the e-mail and then press\"Enter\"");
				// while true (because the user choose to enter the email .it
				// forces the user to enter it.)
				while (true) {
					String emai1 = br.nextLine();
					// calling the method of checking the email at the end of
					// the class
					if (checkEmail(emai1)) {
						// the email is valid
						email = emai1;
						break;
					} else {
						// if the email is invalid it asks him again to enter
						// valid email.
						System.out.println("You enter an invalid email !");
						System.out
								.println("\nplease enter the e-mail and then press\"Enter\"");

					}

				}

				bn = false;
				// if the decision is no it sets the email with"*****"
			} else if (decision.equals("n") || decision.equals("N")) {
				email = "*****";
				bn = false;
			} else {
				// if he types other characters it asks him to enter valid
				// selection
				System.out.println("Sorry!! You've entered wrong choise !");
				System.out
						.println("Do you want to add the e-mail ? press \"Y\" or \"N\"");

			}
		}

		System.out
				.println("Do you want to add the address ? press \"Y\" or \"N\"");

		String address = "";

		bn = true;

		while (bn) {
			decision = br.nextLine();
			if (decision.equals("y") || decision.equals("Y")) {
				System.out
						.println("please enter the address and then press\"Enter\"");
				while (true) {
					String address1 = br.nextLine();
					if (!address1.equals("")) {
						if (address1.contains(",")) {
							System.out
									.println("The address mustn't contain \",\" !");
							System.out
									.println("\nplease enter the address and then press\"Enter\"");
						} else {
							address = address1;
							break;
						}

					}

				}

				bn = false;
			} else if (decision.equals("n") || decision.equals("N")) {
				address = "*****";
				bn = false;
			} else {
				System.out.println("Sorry!! You've entered wrong choise !");
				System.out
						.println("Do you want to add the address ? press \"Y\" or \"N\"");

			}
		}

		System.out
				.println("Do you want to add any notes ? press \"Y\" or \"N\"");

		String note = "";

		bn = true;

		while (bn) {
			decision = br.nextLine();
			if (decision.equals("y") || decision.equals("Y")) {
				System.out
						.println("please enter your notes and then press\"Enter\"");
				while (true) {
					String note1 = br.nextLine();
					if (!note1.equals("")) {
						if (note1.contains(",")) {
							System.out
									.println("The notes mustn't contain \",\" !");
						} else {
							note = note1;
							break;
						}

					}

				}

				bn = false;
			} else if (decision.equals("n") || decision.equals("N")) {
				note = "*****";
				bn = false;
			} else {
				System.out.println("Sorry!! You've entered wrong choise !");
				System.out
						.println("Do you want to add any notes ? press \"Y\" or \"N\"");

			}
		}
		// making an object of these fields.
		Contact theContact = new Contact(firstName, lastName, phoneNum, email,
				address, note);
		if (index >= array.length) {
			// copy the array to another array with bigger size with one cell.
			Contact[] arrayCopy = new Contact[array.length + 1];
			for (int i = 0; i < array.length; i++) {
				arrayCopy[i] = array[i];
			}
			array = arrayCopy;
		} else {

		}

		array[index] = theContact;
		// increment the index of last element
		index++;
		save();
	}

	/**
	 * This method is to save the elements in the array in a file at hard.it
	 * loops on the elements of the array which represent objects and call
	 * getter methods to get the value of all six fields of this contacts and
	 * then write them in a file splitted by ",".
	 * 
	 * @throws IOException
	 *             (if the file is not found).
	 */
	public static void save() throws IOException {
		BufferedWriter wr = new BufferedWriter(new FileWriter("data2"));
		try {
			for (int i = 0; i < index; i++) {

				wr.write(array[i].getFirstName() + "," + array[i].getLastName()
						+ "," + array[i].getPhoneNum() + ","
						+ array[i].getEmail() + "," + array[i].getAddress()
						+ "," + array[i].getNote() + "\n");

				// wr.flush();

			}
			wr.close();

		} catch (IOException e) {
			System.out.print("error");
		}

	}

	/**
	 * This method is to load the contacts written in the file by storing them
	 * again in the array.It reads each line in the file and stores its contents
	 * which separated by "," in an array and creates an object with the
	 * elements of this array and store this contact in the original (static)
	 * array.
	 * 
	 * 
	 * @throws FileNotFoundException
	 */
	public static void load() throws FileNotFoundException {
		BufferedReader re = new BufferedReader(new FileReader("data2"));

		try {

			String line = "";
			index = 0;
			// array to store the contents of one line.
			String[] array1;
			while ((line = re.readLine()) != null) {
				if (index >= array.length) {
					Contact[] arrayCopy = new Contact[array.length + 1];
					for (int i = 0; i < array.length; i++) {
						arrayCopy[i] = array[i];
					}
					array = arrayCopy;
				}
				array1 = line.split(",");

				Contact test = new Contact(array1[0], array1[1], array1[2],
						array1[3], array1[4], array1[5]);
				array[index] = test;

				index++;
			}

		} catch (IOException e) {
			System.out.print("Error");
		}

	}

	/**
	 * This method is to edit a contact in array but firstly,it calls the method
	 * of searching to find the contact which the user wants to edit.Secondly,it
	 * ask the user to choose which field he wants to edit,after that it calls
	 * the setter methods to set the new value the of the chosen field of this
	 * contact.Finally it calls the method of saving to save the array with new
	 * updates. To edit the field (email) it calls another method to check if
	 * the email is valid or not.
	 */
	public static void editContact() {
		Scanner br = new Scanner(System.in);
		System.out.println("To edit a contact :\n");
		int numOfResults;
		while (true) {
			numOfResults = search();
			if (numOfResults != 0) {
				break;
			} else {
				System.out.println("\nTo edit a contact :\n");
			}
		}
		System.out
				.println("\nPlease type the order of the contact you want to edit");
		int orderOfWantedContact;
		while (true) {
			try {
				String s = br.next();
				orderOfWantedContact = Integer.parseInt(s);
				int indexOfWantedContact = orderOfWantedContact - 1;
				if (indexOfWantedContact < array.length) {

					System.out
							.println("Are you sure to edit the following contact ? press \"Y\" or \"N\"\n");
					printContact(array[indexOfWantedContact]);
					String decsion;
					while (true) {
						decsion = br.next();
						if (decsion.equals("y") || decsion.equals("Y")) {
							System.out
									.println("To edit :\nFirst Name : \"1\" , Last Name : \"2\" , Phone Number : \"3\" , E-mail : \"4\" , Address : \"5\" , Notes : \"6\"");

							String choise = br.next();
							switch (choise) {
							case "1":
								Scanner br1 = new Scanner(System.in);
								System.out
										.println("please enter the new first name and then press\"Enter\"");
								while (true) {
									String s3 = br1.nextLine();
									if (!s3.equals("")) {
										if (s3.contains(",")) {
											System.out
													.println("The first name mustn't contain \",\" !");
											System.out
													.println("\nplease enter the first name and then press\"Enter\"");
										} else {
											array[indexOfWantedContact]
													.setFirstName(s3);
											break;
										}

									} else {
										System.out
												.println("please enter the first name and then press\"Enter\"");
									}

								}

								break;
							case "2":
								Scanner br2 = new Scanner(System.in);
								System.out
										.println("please enter the new last name and then press\"Enter\"");
								while (true) {
									String s2 = br2.nextLine();
									if (!s2.equals("")) {
										if (s2.contains(",")) {
											System.out
													.println("The last name mustn't contain \",\" !");
											System.out
													.println("\nplease enter the last name and then press\"Enter\"");
										} else {
											array[indexOfWantedContact]
													.setLastName(s2);
											break;
										}

									} else {
										System.out
												.println("please enter the last name and then press\"Enter\"");
									}
								}

								break;
							case "3":
								Scanner br3 = new Scanner(System.in);
								System.out
										.println("please enter the phone number and then press\"Enter\"");
								String phoneNum = "";
								String s1 = "";
								while (s1.equals("")) {

									s1 = br3.nextLine();
									for (int i = 0; i < s1.length(); i++) {
										if (!((s1.charAt(i) >= 48 && s1
												.charAt(i) <= 57)
												|| s1.charAt(i) == 43
												|| s1.charAt(i) == 42
												|| s1.charAt(i) == 35
												|| s1.charAt(i) == 112 || s1
													.charAt(i) == 119)) {
											System.out
													.println("Please enter valid phone numbers !");
											s1 = br3.nextLine();
											i = -1;
											phoneNum = "";
										} else {
											phoneNum += s1.charAt(i);
										}

									}
								}
								array[indexOfWantedContact].setPhoneNum(s1);

								break;
							case "4":
								Scanner br4 = new Scanner(System.in);
								System.out
										.println("Do you want to edit the e-mail or to remove the e-mail ? press \"E\" or \"R\"");

								String decision;
								boolean bn = true;
								while (bn) {
									decision = br4.next();
									if (decision.equals("E")
											|| decision.equals("e")) {
										System.out
												.println("please enter the e-mail and then press\"Enter\"");
										while (true) {
											Scanner br8 = new Scanner(System.in);
											String email = br8.nextLine();
											if (checkEmail(email)) {

												array[indexOfWantedContact]
														.setEmail(email);
												break;
											} else {
												System.out
														.println("You enter an invalid email !");
												System.out
														.println("\nplease enter the e-mail and then press\"Enter\"");

											}

										}

										bn = false;

									} else if (decision.equals("r")
											|| decision.equals("R")) {
										array[indexOfWantedContact]
												.setEmail("*****");

										bn = false;
									} else {
										System.out
												.println("Sorry!! You've entered wrong choise !");
										System.out
												.println("Do you want to edit the e-mail or to remove it ? press \"E\" or \"R\"");
									}
								}

								break;
							case "5":
								Scanner br5 = new Scanner(System.in);
								System.out
										.println("Do you want to edit the address or to remove it ? press \"E\" or \"R\"");

								bn = true;
								while (bn) {
									decision = br5.next();
									if (decision.equals("E")
											|| decision.equals("e")) {
										System.out
												.println("please enter the new address and then press\"Enter\"");
										String address1;
										while (true) {
											Scanner br7 = new Scanner(System.in);
											address1 = br7.nextLine();
											if (!address1.equals("")) {
												if (address1.contains(",")) {
													System.out
															.println("The address mustn't contain \",\" !");
													System.out
															.println("\nplease enter the address and then press\"Enter\"");
												} else {
													array[indexOfWantedContact]
															.setAddress(address1);
													break;

												}
											}

										}

										bn = false;

									} else if (decision.equals("r")
											|| decision.equals("R")) {
										array[indexOfWantedContact]
												.setAddress("*****");

										bn = false;
									} else {
										System.out
												.println("Sorry!! You've entered wrong choise !");
										System.out
												.println("Do you want to edit the address or to remove it ? press \"E\" or \"R\"");

									}
								}

								break;
							case "6":
								Scanner br6 = new Scanner(System.in);
								System.out
										.println("Do you want to edit the notes or to remove them ? press \"E\" or \"R\"");

								bn = true;
								while (bn) {
									decision = br6.next();
									if (decision.equals("E")
											|| decision.equals("e")) {
										System.out
												.println("please enter the new notes and then press\"Enter\"");
										String note1;
										while (true) {
											Scanner br7 = new Scanner(System.in);
											note1 = br7.nextLine();
											if (!note1.equals("")) {
												if (note1.contains(",")) {
													System.out
															.println("The Notes mustn't contain \",\" !");
													System.out
															.println("\nplease enter the Notes and then press\"Enter\"");
												} else {
													array[indexOfWantedContact]
															.setNote(note1);
													break;

												}
											}

										}

										bn = false;

									} else if (decision.equals("r")
											|| decision.equals("R")) {
										array[indexOfWantedContact]
												.setNote("*****");

										bn = false;
									} else {
										System.out
												.println("Sorry!! You've entered wrong choise !");
										System.out
												.println("Do you want to edit the notes or to remove them ? press \"E\" or \"R\"");
									}
								}
								break;
							default:
								System.out
										.println("Sorry!! You've entered wrong choise !");
								break;
							}

							save();
							System.out
									.println("The contact has already edited !");
							break;
						} else if (decsion.equals("n") || decsion.equals("N")) {
							break;
						} else {
							System.out
									.println("Sorry!! You've entered wrong choise !");
							System.out
									.println("Are you sure to edit the following contact ? press \"Y\" or \"N\"\n");
							printContact(array[indexOfWantedContact]);

						}
					}

					break;
				} else {
					System.out.println("Sorry!! You've entered wrong choise !");
					System.out
							.println("\nPlease type the order of the contact you want to delete");
				}
			} catch (Exception e) {
				System.out.println("Sorry!! You've entered wrong choise !");
				System.out
						.println("\nPlease type the order of the contact you want to edit");
			}
		}

	}

	/**
	 * This method is to delete a contact in array but firstly,it calls the
	 * method of searching to find the contact which the user wants to
	 * delete.Secondly,it ask the user to type the order of the wanted contact
	 * which displays in searching.The order of the contact represents its index
	 * in the array+1,then it loops on the array starting from the index of the
	 * wanted contact and makes shifting (the element =the next element).Finally
	 * it calls the method of saving to save the array with new updates.
	 * 
	 */
	public static void deleteContact() {
		Scanner br = new Scanner(System.in);
		System.out.println("To delete a contact :\n");
		int numOfResults;
		// for if the contact searched for is not found.
		while (true) {
			numOfResults = search();
			if (numOfResults != 0) {
				break;
			} else {
				System.out.println("\nTo delete a contact :\n");
			}
		}
		System.out
				.println("\nPlease type the order of the contact you want to delete");
		int orderOfWantedContact;
		while (true) {
			try {
				orderOfWantedContact = Integer.parseInt(br.next());
				int indexOfWantedContact = orderOfWantedContact - 1;
				if (indexOfWantedContact < array.length) {

					System.out
							.println("Are you sure to delete the following contact ? press \"Y\" or \"N\"");
					printContact(array[indexOfWantedContact]);
					String decsion;
					while (true) {
						decsion = br.next();
						if (decsion.equals("y") || decsion.equals("Y")) {
							for (int i = indexOfWantedContact; i < index - 1; i++) {
								array[i] = array[i + 1];

							}
							Contact[] arrayCopy = new Contact[array.length - 1];
							for (int i = 0; i < arrayCopy.length; i++) {
								arrayCopy[i] = array[i];
							}
							index--;
							array = arrayCopy;

							save();
							System.out
									.println("The contact has already deleted !");
							break;
						} else if (decsion.equals("n") || decsion.equals("N")) {
							break;
						} else {
							System.out
									.println("Sorry!! You've entered wrong choise !");
							System.out
									.println("Are you sure to delete the following contact ? press \"Y\" or \"N\"");
							printContact(array[indexOfWantedContact]);

						}
					}

					break;
				} else {
					System.out.println("Sorry!! You've entered wrong choise !");
					System.out
							.println("\nPlease type the order of the contact you want to delete");
				}
			} catch (Exception e) {
				System.out.println("Sorry!! You've entered wrong choise !");
				System.out
						.println("\nPlease type the order of the contact you want to delete");
			}
		}

	}

	/**
	 * This method is to display all contacts written in the file and stored in
	 * the array by looping on the array and call the method of printing the
	 * contacts with the parameter(array elements).
	 */
	public static void viewAllContacts() {

		System.out
				.println("They are orderd such that: First Name , Last Name , Phone Number , e-mail , Address , notes\n");
		System.out
				.println("---------------------------------------------------------------------");
		for (int i = 0; i < array.length; i++) {
			System.out.print((i + 1) + " : ");
			printContact(array[i]);
			System.out
					.println("---------------------------------------------------------------------");
		}

	}

	/**
	 * This method is to search for a contact by first name ,last name or Phone
	 * number so it asks the user to type his selection then asks him to write
	 * the String he wants to search for related his selection,after that it
	 * loops on the array to search for contact which contains this String
	 * (ignoring letters case) and counts the matched contacts .finally it calls
	 * the method of printing to print all matched results.Also it prints the
	 * number of matched contacts and the order of each contact in the array
	 * which represents (its index+1).
	 * 
	 * @return the number of matched results.
	 */
	public static int search() {
		int count = 0;
		Scanner br = new Scanner(System.in);
		System.out
				.println("You want search by :\nFirst Name : press \"1\"\nLast Name : press\"2\"\nPhoneNumber : press\"3\"");
		String x = br.next();
		boolean bn = true;
		while (bn) {

			switch (x) {
			case "1":
				count = 0;
				Scanner br1 = new Scanner(System.in);
				System.out.println("Enter the First Name : ");
				String s;
				while (true) {
					s = br.nextLine();
					if (!s.equals("")) {

						break;
					}

				}

				System.out
						.println("---------------------------------------------------------------------");

				for (int i = 0; i < index; i++) {
					if ((array[i].getFirstName()).toLowerCase().contains(
							s.toLowerCase())) {
						printContact(array[i]);
						count++;

						System.out.println("Order : " + (i + 1) + "\n");
						System.out
								.println("---------------------------------------------------------------------");

					}

				}
				if (count == 0) {
					System.out.println("This contact is not found !");
				}
				System.out.println("Number of matched results : " + count);
				bn = false;
				break;
			case "2":
				count = 0;
				Scanner br2 = new Scanner(System.in);
				System.out.println("Enter the last Name : ");
				String s1;
				while (true) {
					s1 = br.nextLine();
					if (!s1.equals("")) {

						break;
					}

				}

				System.out
						.println("---------------------------------------------------------------------");

				for (int i = 0; i < index; i++) {
					if (array[i].getLastName().toLowerCase()
							.contains(s1.toLowerCase())) {
						printContact(array[i]);
						count++;
						System.out.println("Order : " + (i + 1) + "\n");
						System.out
								.println("---------------------------------------------------------------------");
					}

				}
				if (count == 0) {
					System.out.println("This contact is not found !");
				}
				System.out.println("Number of matched results : " + count);
				bn = false;
				break;
			case "3":
				count = 0;
				Scanner br3 = new Scanner(System.in);
				System.out.println("Enter the phone number : ");

				String s2 = "";
				while (s2.equals("")) {

					s2 = br.nextLine();
					for (int i = 0; i < s2.length(); i++) {
						if (!((s2.charAt(i) >= 48 && s2.charAt(i) <= 57)
								|| s2.charAt(i) == 43 || s2.charAt(i) == 42
								|| s2.charAt(i) == 35 || s2.charAt(i) == 112 || s2
									.charAt(i) == 119)) {
							System.out
									.println("Please enter valid phone numbers !");
							s2 = br.nextLine();
							i = -1;

						}

					}
				}

				System.out
						.println("---------------------------------------------------------------------");

				for (int i = 0; i < index; i++) {
					if (array[i].getPhoneNum().toLowerCase()
							.contains(s2.toLowerCase())) {
						printContact(array[i]);
						count++;
						System.out.println("Order : " + (i + 1) + "\n");
						System.out
								.println("---------------------------------------------------------------------");
					}

				}
				if (count == 0) {
					System.out.println("This contact is not found !");
				}
				System.out.println("Number of matched results : " + count);
				bn = false;
				break;

			default:
				System.out.println("Sorry!! You've entered wrong choise !\n");
				System.out
						.println("You want search by :\nFirst Name : press \"1\"\nLast Name : press\"2\"\nPhoneNumber : press\"3\"");
				x = br.next();
				break;
			}

		}
		return count;
	}

	/**
	 * This method is to print a contact which represents an object. It calls
	 * the getter methods to get the value of each field of this contact to
	 * print them separated by ",".
	 * 
	 * @param x
	 *            an object which represents a contact.
	 */
	public static void printContact(Contact x) {
		System.out.println(x.getFirstName() + "," + x.getLastName() + ","
				+ x.getPhoneNum() + "," + x.getEmail() + "," + x.getAddress()
				+ "," + x.getNote() + "\n");
	}

	/**
	 * This method is to check the validation of the email by counting the
	 * number of character '@' then check if this number is one and the
	 * emaildoesn't contain any spaces or commas and the email doesn't start
	 * with '@'or '.'.
	 * 
	 * @param email
	 *            the wanted e-mail to check if it's valid or not.
	 * @return true if the email is valid and false if it's invalid.
	 */
	public static boolean checkEmail(String email) {
		boolean bn = false;
		int count = 0;
		for (int i = 0; i < email.length(); i++) {

			if (email.charAt(i) == '@') {
				count++;
			}

		}
		int count1 = 0;
		int x = email.indexOf("@");
		int i = x;
		int y = 0;
		while (i < email.length()) {

			if (email.charAt(i) == '.') {
				y = email.indexOf(".");
				break;
			}
			i++;

		}
		if (count == 1 && !email.contains(" ") && !email.contains(",")
				&& !email.startsWith("@") && !email.endsWith("@")
				&& !email.endsWith(".") && x + 2 <= y) {
			bn = true;
		}

		return bn;
	}

}
