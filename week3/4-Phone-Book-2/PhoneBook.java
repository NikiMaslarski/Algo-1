import java.util.Scanner;

public class PhoneBook {

	public static class Contact {

		public String name;
		public int number;
	}

	private class BST {

		private class Node {
			Contact contact;
			Node left;
			Node right;

			Node(Contact contact) {
				this.contact = contact;
			}
		}

		Node root;

		public void insert(Contact contact) {
			root = insertR(contact, root);
		}

		private Node insertR(Contact contact, Node current) {
			if (current == null)
				current = new Node(contact);
			else if (current.contact.name.compareTo(contact.name) > 0)
				current.left = insertR(contact, current.left);
			else if (current.contact.name.compareTo(contact.name) < 0)
				current.right = insertR(contact, current.right);

			return current;

		}

		public void find(String name) {
			Node current = root;

			while (current != null) {
				if (current.contact.name.compareTo(name) > 0)
					current = current.left;
				else if (current.contact.name.compareTo(name) < 0)
					current = current.right;
				else if (current.contact.name.compareTo(name) == 0) {
					System.out.println(current.contact.number);
					return;
				}
			}
			System.out.println("NOT FOUND!");
		}

		public void print() {
			this.print(root);
		}

		private void print(Node root) {
			if (root.left != null)
				print(root.left);

			System.out
					.printf("%s %s\n", root.contact.name, root.contact.number);

			if (root.right != null)
				print(root.right);
		}

		public void remove(String name) {
			root = removeR(name, root);
		}
		
		private Node removeR(String name, Node current){
			if(current == null)
				return null;
			if (current.contact.name.compareTo(name) > 0)
				current.left = removeR(name, current.left);
			if (current.contact.name.compareTo(name) < 0)
				current.right = removeR(name, current.right);
			else{
				if(current.right == null)
					return current.left;
				if(current.left == null)
					return current.right;
				
				current = getMin(current.right);
				current.right  = deleteMin(current.right);
					
			}
			return current;
		}
		
		private Node getMin(Node current){
			if(current.left == null)
				return current;
			return getMin(current.left);
		}
		
		private Node deleteMin(Node current){
			current = getMin(current);
			return current.right;
		}
	}

	private BST contacts;

	public PhoneBook() {
		contacts = new BST();
	}

	public static void main(String[] args) {
		PhoneBook test = new PhoneBook();
		System.out.println("test");
		Scanner sc = new Scanner(System.in);
		String option;
		do {
			option = sc.next();

			switch (option) {
			case "insert":
				Contact person = new Contact();
				person.number = sc.nextInt();
				person.name = sc.next();
				test.insert(person);
				break;
			case "lookup":
				test.lookup(sc.next());
				break;
			case "list":
				test.list();
				break;
			case "remove":
				test.remove(sc.next());
				break;

			default:
				System.out.println("Invalid option");
				break;
			}
		} while (sc.hasNext());
		sc.close();
	}

	// inserts a new contact
	public void insert(Contact contact) {
		contacts.insert(contact);
	}

	// lookup a name and print its phone number
	public void lookup(String name) {
		contacts.find(name);
	}

	// list all records in an alphabetical order
	public void list() {
		contacts.print();
	}

	// remove a record for a given name
	public void remove(String name) {
		contacts.remove(name);
	}
}
