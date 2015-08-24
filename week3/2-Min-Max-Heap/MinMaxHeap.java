import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class MinMaxHeap {

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		int N = sc.nextInt();
		int arr[] = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		if (isMMH(0, arr))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	public static boolean isMMH(int root, int[] arr) {
		return oddLevel(root, arr);
	}

	private static boolean oddLevel(int root, int[] arr) {
		
		if (rightChild(root) < arr.length) {
			if (arr[rightChild(root)] < arr[root])
				return false;
			else if (!evenLevel(rightChild(root), arr))
				return false;
		}

		if (leftChild(root) < arr.length) {
			if (arr[leftChild(root)] < arr[root])
				return false;
			else if (!evenLevel(leftChild(root), arr))
				return false;
		}
		
		return true;

	}
	
	private static boolean evenLevel(int root, int[] arr) {
		
		if (rightChild(root) < arr.length) {
			if (arr[rightChild(root)]  > arr[root])
				return false;
			else if (!oddLevel(rightChild(root), arr))
				return false;
		}

		if (leftChild(root) < arr.length) {
			if (arr[leftChild(root)] > arr[root])
				return false;
			else if (!oddLevel(leftChild(root), arr))
				return false;
		}

		return true;
	}

	private static int leftChild(int root) {
		return 2 * root + 1;
	}

	private static int rightChild(int root) {
		return 2 * root + 2;
	}

	// public static class Node {
	//
	// public int value;
	// public Node left;
	// public Node right;
	// }
	//
	// // Checks if a binary tree is a min/max heap.
	// public boolean isMinMax(Node root) {
	// return oddLevel(root);
	// }
	//
	// private boolean oddLevel(Node root) {
	// if (root.right != null) {
	// if (root.right.value < root.value)
	// return false;
	// else if (!evenLevel(root.right))
	// return false;
	// }
	//
	// if (root.left != null) {
	// if (root.left.value < root.value)
	// return false;
	// else if (!evenLevel(root.left))
	// return false;
	// }
	//
	// return true;
	// }
	//
	// private boolean evenLevel(Node root) {
	// if (root.right != null) {
	// if (root.right.value > root.value)
	// return false;
	// else if (!oddLevel(root.right))
	// return false;
	// }
	//
	// if (root.left != null) {
	// if (root.left.value > root.value)
	// return false;
	// else if (!oddLevel(root.left))
	// return false;
	// }
	//
	// return true;
	// }

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
