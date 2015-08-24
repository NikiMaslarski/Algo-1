import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PhoneBook {

	public static class Contact {

		public String name;
		public int number;

		public Contact() {
		};

		public Contact(int number, String name) {
			this.name = name;
			this.number = number;
		}
	}

	public static void main(String[] args) {

		MyScanner sc = new MyScanner();

		int N = sc.nextInt();
		int M = sc.nextInt();

		List<Integer> numbers = new ArrayList<Integer>();
		List<Contact> phoneBook = new ArrayList<Contact>();

		for (int i = 0; i < N; ++i)
			phoneBook.add(new Contact(sc.nextInt(), sc.next()));

		for (int i = 0; i < M; ++i)
			numbers.add(sc.nextInt());

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

	// -------------------------------------------------------------

	public static PrintWriter out;

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	// ------------------------------------------------------------------
}