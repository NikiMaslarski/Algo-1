import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class LowCostFlights {

	private static int N;

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();

		N = sc.nextInt();

		int[][] neighbourMatrix = new int[N][N];

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j)
				neighbourMatrix[i][j] = Integer.MAX_VALUE;
			neighbourMatrix[i][i] = 0;
		}

		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				neighbourMatrix[i][j] = sc.nextInt();
		int M = sc.nextInt();

		int start, end;
		for (int i = 0; i < M; ++i) {
			start = sc.nextInt();
			end = sc.nextInt();
			int[] temp = dijkstra(neighbourMatrix, start);
			if (temp[end] != Integer.MAX_VALUE)
				System.out.println(temp[end]);
			else
				System.out.println("NO WAY");
		}

	}

	public static int[] dijkstra(int[][] matrix, int root) {
		int[] prices = new int[N];
		boolean[] used = new boolean[N];
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(root);
		used[root] = true;

		for (int i = 0; i < N; ++i)
			prices[i] = Integer.MAX_VALUE;
		prices[root] = 0;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int i = 0; i < N; ++i) {
				if (current != i && matrix[current][i] != 0
						&& prices[current] + matrix[current][i] < prices[i]) {
					prices[i] = prices[current] + matrix[current][i];
					queue.add(i);

				}
			}
		}
		return prices;
	}

	// -------------------------------------------------------------

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
}

// ------------------------------------------------------------------