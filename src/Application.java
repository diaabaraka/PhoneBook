import java.io.IOException;
import java.util.Scanner;

/**
 * This class contains the main method to run the application and interact with
 * the user.
 * 
 * @author DYAA
 * @version 1.0
 */
public class Application {
	/**
	 * This is the main method to run the application and interact with the
	 * user.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Phonebook.load();
		System.out.println("\t\t\t\t------------------------------------");
		System.out.println("\t\t\t\t| Welcome in PhoneBook Application !|");
		System.out.println("\t\t\t\t------------------------------------");

		System.out
				.println("\n\nPlease enter the operation you want :\n Add : \"1\"   Edit : \"2\"   Delete : \"3\"   View "
						+ "all existing contacts :"
						+ " \"4\"   Search : \"5\"   Exit : \"6\"");

		Scanner re = new Scanner(System.in);
		boolean b = true;
		String line1;
		while (b) {
			line1 = re.nextLine();

			switch (line1) {
			case "1":
				Phonebook.addContact();
				System.out
						.println("\n\nPlease enter the operation you want :\n Add : \"1\"   Edit : \"2\"   Delete : \"3\"   View "
								+ "all existing contacts :"
								+ " \"4\"   Search : \"5\"   Exit : \"6\"");

				break;
			case "2":
				Phonebook.editContact();
				System.out
						.println("\n\nPlease enter the operation you want :\n Add : \"1\"   Edit : \"2\"   Delete : \"3\"   View "
								+ "all existing contacts :"
								+ " \"4\"   Search : \"5\"   Exit : \"6\"");
				break;
			case "3":

				Phonebook.deleteContact();
				System.out
						.println("\n\nPlease enter the operation you want :\n Add : \"1\"   Edit : \"2\"   Delete : \"3\"   View "
								+ "all existing contacts :"
								+ " \"4\"   Search : \"5\"   Exit : \"6\"");

				break;

			case "4":
				Phonebook.viewAllContacts();
				System.out
						.println("\n\nPlease enter the operation you want :\n Add : \"1\"   Edit : \"2\"   Delete : \"3\"   View "
								+ "all existing contacts :"
								+ " \"4\"   Search : \"5\"   Exit : \"6\"");

				break;
			case "5":

				Phonebook.search();
				System.out
						.println("\n\nPlease enter the operation you want :\n Add : \"1\"   Edit : \"2\"   Delete : \"3\"   View "
								+ "all existing contacts :"
								+ " \"4\"   Search : \"5\"   Exit : \"6\"");

				break;
			case "6":
				b = false;
				System.out
						.println("\nYou've closen the application!\n\tGoodBye!\n\nTo reopen it press ctrl +F11 : ");
				break;

			default:
				System.out.println("Sorry!! You've entered wrong choise !");
				System.out
						.println("\n\nPlease enter the operation you want :\n Add : \"1\"   Edit : \"2\"   Delete : \"3\"   View "
								+ "all existing contacts :"
								+ " \"4\"   Search : \"5\"   Exit : \"6\"");

				break;

			}

		}

	}

}
