import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ClosestCoffeeStore {

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();

		int n = sc.nextInt();
		int[][] adjMatrix = new int[n][n];
		int startingPoint;
		boolean[] isCoffeeStore = new boolean[n];

		for (int i = 0; i < n; ++i)
			for (int j = 0; j < n; ++j)
				adjMatrix[i][j] = sc.nextInt();

		startingPoint = sc.nextInt();

		for (int i = 0; i < n; ++i)
			if (sc.nextInt() == 1)
				isCoffeeStore[i] = true;

		System.out.println(closestCoffeStore(adjMatrix, isCoffeeStore,
				startingPoint));
	}

	private static int closestCoffeStore(int[][] adjMatrix,
			boolean[] isCoffeeStore, int startingPoint) {
		int n = isCoffeeStore.length;
		int currentLevel = 0;
		boolean[] notVisited = new boolean[n]; 
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(startingPoint);
		notVisited[startingPoint] = true;

		boolean switchLevel = true;
		int switchLevelOn = startingPoint;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			if (current == switchLevelOn) {
				switchLevel = true;
				currentLevel++;
			}
			for (int i = 0; i < n; ++i) {
				if (adjMatrix[current][i] == 1 && notVisited[i] == false) {
					if (switchLevel) {
						switchLevelOn = i;
						switchLevel = false;
					}

					if (isCoffeeStore[i])
						return currentLevel;

					queue.add(i);
					notVisited[i] = true;
				}
			}
		}

		return -1;
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

	// ------------------------------------------------------------------
}
