import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

	public static class Contact {

		public String name;
		public int number;

		public Contact() {
		};

		public Contact(String name, int number) {
			// TODO Auto-generated constructor stub
			this.name = name;
			this.number = number;
		}
	}

	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(15);
		numbers.add(8);
		
		List<Contact> phoneBook = new ArrayList<Contact>();

		phoneBook.add(new Contact("Stanislav", 1));
		phoneBook.add(new Contact("Rado", 15));
		phoneBook.add(new Contact("Ivan", 6));
		phoneBook.add(new Contact("Ivan", 8));

		List<String> people = lookupNames(phoneBook, numbers);

		for (String i : people)
			System.out.println(i);
	}

	// Find the names of people based on their phone numbers.
	public static List<String> lookupNames(List<Contact> phoneBook,
			List<Integer> numbers) {

		List<String> people = new ArrayList<String>();
		phoneBook = sortContacts(phoneBook);

		for (int number : numbers) {
			people.add(getName(phoneBook, number));
		}
		
		return people;
	}

	private static List<Contact> sortContacts(List<Contact> phoneBook) {
		List<Contact> sortedPhoneBook = phoneBook;

		int j;

		for (int i = 0; i < sortedPhoneBook.size() - 1; ++i) {
			j = i + 1;
			Contact temp = sortedPhoneBook.get(j);
			while (j > 0 && sortedPhoneBook.get(j - 1).number > temp.number) {
				sortedPhoneBook.set(j, sortedPhoneBook.get(--j));
			}
			sortedPhoneBook.set(j, temp);
		}
		return sortedPhoneBook;
	}

	// I will optimise it when I have time
	private static String getName(List<Contact> phoneBook, int number) {
		for (Contact element : phoneBook)
			if (element.number == number)
				return element.name;
		return "NotFound";
	}
}