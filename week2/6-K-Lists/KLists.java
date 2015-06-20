import java.util.ArrayList;
import java.util.List;

public class KLists {

	public class Node {
		public int value;
		public Node next;
	}

	public static void main(String[] args) {
		KLists test = new KLists();
		Node list1 = test.new Node();
		Node list2 = test.new Node();
		Node list3 = test.new Node();
		test.addToList(list1, 3, true);
		test.addToList(list1, 5, false);
		test.addToList(list1, 7, false);
		test.addToList(list1, 9, false);
		test.addToList(list1, 11, false);
		test.addToList(list1, 60, false);
		test.addToList(list2, 2, true);
		test.addToList(list2, 4, false);
		test.addToList(list2, 6, false);
		test.addToList(list2, 8, false);
		test.addToList(list3, 0, false);
		test.addToList(list3, 1, false);

		List<Node> lists = new ArrayList<Node>();
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);

		Node hopeItWorks = test.merge(lists);

		while (hopeItWorks.next != null) {
			System.out.println(hopeItWorks.value);
			hopeItWorks = hopeItWorks.next;
		}
		System.out.println(hopeItWorks.value);
	}

	// Merge K sorted lists.
	public Node merge(List<Node> lists) {
		Node result = new Node();
		int indexOfSmallest;
		int smallestValue;
		boolean flag = true;

		while (!lists.isEmpty()) {
			indexOfSmallest = 0;
			smallestValue = lists.get(0).value;
			for (int i = 0; i < lists.size(); ++i) {
				if (lists.get(i).value < smallestValue) {
					smallestValue = lists.get(i).value;
					indexOfSmallest = i;
				}
			}

			addToList(result, smallestValue, flag);
			flag = false;

			if (lists.get(indexOfSmallest).next != null)
				lists.set(indexOfSmallest, lists.get(indexOfSmallest).next);
			else {
				lists.remove(indexOfSmallest);
			}
		}
		return result.next;
	}

	private void addToList(Node list, int value, boolean first) {
		if (first)
			list.value = value;
		else {
			Node current = list;
			while (current.next != null)
				current = current.next;
			current.next = new Node();
			current.next.value = value;
		}
	}

}