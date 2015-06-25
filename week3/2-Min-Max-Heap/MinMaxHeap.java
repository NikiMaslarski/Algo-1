public class MinMaxHeap {

	public static class Node {

		public int value;
		public Node left;
		public Node right;
	}

	// Checks if a binary tree is a min/max heap.
	public boolean isMinMax(Node root) {
		return oddLevel(root);
	}

	private boolean oddLevel(Node root) {
		if (root.right != null) {
			if (root.right.value < root.value)
				return false;
			else if (!evenLevel(root.right))
				return false;
		}

		if (root.left != null) {
			if (root.left.value < root.value)
				return false;
			else if (!evenLevel(root.left))
				return false;
		}
		
		return true;
	}

	private boolean evenLevel(Node root) {
		if (root.right != null) {
			if (root.right.value > root.value)
				return false;
			else if (!oddLevel(root.right))
				return false;
		}

		if (root.left != null) {
			if (root.left.value > root.value)
				return false;
			else if (!oddLevel(root.left))
				return false;
		}
		
		return true;
	}
}
