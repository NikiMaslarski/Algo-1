import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class KLists {

	public class Node {
		public int value;
		public Node next;

	}

	public static void main(String[] args) {
		KLists test = new KLists();
		MyScanner sc = new MyScanner();
		int K = sc.nextInt();
		List<Node> lists = new ArrayList<Node>();
		for (int i = 0, temp; i < K; ++i) {
			temp = sc.nextInt();
			boolean flag = true;
			lists.add(test.new Node());
			while (temp != -1) {
				test.addToList(lists.get(i), temp, flag);
				temp = sc.nextInt();
				flag = false;
			}
		}
		test.merge(lists);
	}

	// Merge K sorted lists.
	public void merge(List<Node> lists) {
		int indexOfSmallest;
		int smallestValue;

		while (!lists.isEmpty()) {
			indexOfSmallest = 0;
			smallestValue = lists.get(0).value;
			for (int i = 0; i < lists.size(); ++i) {
				if (lists.get(i).value < smallestValue) {
					smallestValue = lists.get(i).value;
					indexOfSmallest = i;
				}
			}

			System.out.printf("%d ", smallestValue);

			if (lists.get(indexOfSmallest).next != null)
				lists.set(indexOfSmallest, lists.get(indexOfSmallest).next);
			else {
				lists.remove(indexOfSmallest);
			}
		}
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