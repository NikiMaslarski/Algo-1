import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Quadruplets {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		int N = sc.nextInt();
		int[] a1, a2, a3, a4;
		a1 = new int[N];
		a2 = new int[N];
		a3 = new int[N];
		a4 = new int[N];
		for (int i = 0; i < N; ++i)
			a1[i] = sc.nextInt();
		for (int i = 0; i < N; i++)
			a2[i] = sc.nextInt();
		for (int i = 0; i < N; i++)
			a3[i] = sc.nextInt();
		for (int i = 0; i < N; i++)
			a4[i] = sc.nextInt();

		System.out.println(zeroQuadrupletsCount(a1, a2, a3, a4));

	}

	public static int zeroQuadrupletsCount(int[] arr1, int[] arr2, int[] arr3,
			int[] arr4) {

		int[] bigArr1 = new int[arr1.length * arr2.length];
		int[] bigArr2 = new int[arr3.length * arr4.length];

		for (int i = 0; i < arr1.length; ++i)
			for (int j = 0; j < arr2.length; ++j)
				bigArr1[j + arr1.length * i] = arr1[i] + arr2[j];

		for (int i = 0; i < arr3.length; ++i)
			for (int j = 0; j < arr4.length; ++j)
				bigArr2[j + arr3.length * i] = arr3[i] + arr4[j];

		return twoSumProblem(bigArr1, bigArr2);
	}

	private static int twoSumProblem(int[] arr1, int[] arr2) {
		int counter = 0;

		for (int i = 0; i < arr1.length; ++i) {
			for (int j = 0; j < arr2.length; ++j) {
				if (arr1[i] + arr2[j] == 0)
					counter++;
			}
		}
		return counter;
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