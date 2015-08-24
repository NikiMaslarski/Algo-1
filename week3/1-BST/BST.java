import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BST {

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		int N = sc.nextInt();
		int arr[] = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		if (isBST(0, arr))
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	public static boolean isBST(int root, int arr[]) {
		return isBST(root, arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBST(int root, int arr[], int min, int max) {
		if (root >= arr.length || arr[root] == 0)
			return true;

		if (arr[root] > min
				&& arr[root] < max
				&& isBST(getLeftChild(root), arr, min, Math.min(max, arr[root]))
				&& isBST(getRightChild(root), arr, Math.max(min, arr[root]),
						max)) {
			return true;
		} else
			return false;
	}

	private static int getLeftChild(int root) {
		return 2 * root + 1;
	}

	private static int getRightChild(int root) {
		return 2 * root + 2;
	}

	// Works with Nodes
	// Checks if a binary tree is a binary search tree.
	// public static class Node {
	//
	// public int value;
	// public Node left;
	// public Node right;
	// }
	// public boolean isBST(Node root) {
	// return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	// }
	//
	// private boolean isValidBST(Node node, int MIN, int MAX) {
	// if(node == null)
	// return true;
	// if(node.value > MIN
	// && node.value < MAX
	// && isValidBST(node.left, MIN, Math.min(node.value,MAX))
	// && isValidBST(node.right, Math.max(node.value,MIN), MAX))
	// return true;
	// else
	// return false;
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
