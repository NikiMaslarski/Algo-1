import java.util.List;

public class KLists {

	public class Node {
		public int value;
		public Node next;
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